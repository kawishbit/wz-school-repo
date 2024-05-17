using LspCertification.Data;
using LspCertification.Interfaces;
using LspCertification.Services;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllersWithViews();
builder.Services.AddDbContext<WebDbContext>(
    options =>
        options.UseSqlite(builder.Configuration
                                 .GetConnectionString("DefaultConnection")
        )
);

builder.Services.AddScoped<DapperContext>();

builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

builder.Services.AddScoped<IDistributorService, DistributorService>();
builder.Services.AddScoped<ISpectacleService, SpectacleService>();

builder.Services.AddRouting(options => options.LowercaseUrls = true);




var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
    app.UseHsts();
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();
app.UseStaticFiles();
app.UseRouting();

app.MapGet("api/test", () => new { Test = "Hello everyone its me" });

app.MapControllerRoute(
    name: "default",
    pattern: "{controller}/{action=Index}/{id?}");

app.MapFallbackToFile("index.html");
;

app.Run();