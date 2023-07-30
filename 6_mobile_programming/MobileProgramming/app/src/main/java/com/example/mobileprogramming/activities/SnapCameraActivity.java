package com.example.mobileprogramming.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.lifecycle.LifecycleOwner;

import com.example.mobileprogramming.BuildConfig;
import com.example.mobileprogramming.R;
import com.google.common.util.concurrent.ListenableFuture;

import java.io.File;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class SnapCameraActivity extends AppCompatActivity {
    private PreviewView viewFinder;
    private ImageCapture imageCapture;
    private File imageFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_snap_camera);

        viewFinder = findViewById(R.id.viewFinder);

        ListenableFuture<ProcessCameraProvider> cameraProviderFuture = ProcessCameraProvider.getInstance(this);

        cameraProviderFuture.addListener(() -> {
            try {
                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();

                imageCapture = new ImageCapture.Builder().build();

                Preview preview = new Preview.Builder().build();
                preview.setSurfaceProvider(viewFinder.getSurfaceProvider());

                CameraSelector cameraSelector = new CameraSelector.Builder()
                        .requireLensFacing(CameraSelector.LENS_FACING_BACK).build();

                cameraProvider.unbindAll();
                cameraProvider.bindToLifecycle((LifecycleOwner) SnapCameraActivity.this, cameraSelector, preview, imageCapture);
            } catch (ExecutionException | InterruptedException e) {
                // Handle any errors
            }
        }, ContextCompat.getMainExecutor(this));

        findViewById(R.id.captureImg).setOnClickListener(v -> takePhoto());

        findViewById(R.id.shareBtn).setOnClickListener(v -> shareImage());
    }

    private void takePhoto() {
        imageFile = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "capturedImage.jpg");

        ImageCapture.OutputFileOptions outputFileOptions =
                new ImageCapture.OutputFileOptions.Builder(imageFile).build();

        imageCapture.takePicture(outputFileOptions,
                ContextCompat.getMainExecutor(this), new ImageCapture.OnImageSavedCallback() {
                    @Override
                    public void onImageSaved(@NonNull ImageCapture.OutputFileResults outputFileResults) {
                        // Image saved successfully
                        Toast.makeText(SnapCameraActivity.this, "Image captured.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(@NonNull ImageCaptureException exception) {
                        // Error while capturing the image
                        Toast.makeText(SnapCameraActivity.this, "Failed to capture image.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void shareImage() {
        if (imageFile != null && imageFile.exists()) {
            Uri uriToImage = FileProvider.getUriForFile(Objects.requireNonNull(getApplicationContext()),
                    BuildConfig.APPLICATION_ID + ".provider", this.imageFile);
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("image/jpeg");
            shareIntent.putExtra(Intent.EXTRA_STREAM, uriToImage);
            startActivity(Intent.createChooser(shareIntent, "Share image"));
        } else {
            Toast.makeText(SnapCameraActivity.this, "No image to share.", Toast.LENGTH_SHORT).show();
        }
    }
}