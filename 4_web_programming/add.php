<?php
require("database.php");

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    if (addSource($_POST)) {

        header("Location: {$reqUrl}index.php");
        die();
    } else {
        echo "Process Failed";
    }
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Kawish's Web</title>
    <link rel="stylesheet" href="./style.css" />
</head>

<body>
    <h1 style="margin: 40px auto 0 auto;">Tambah Item</h1>
    <div class="centered-wrapper">

        <form action="add.php" method="post">
            <fieldset>
                <legend>source_name :</legend>
                <input type="text" placeholder="Masukkan name" name="source_name" />
            </fieldset>
            <fieldset>
                <legend>segment_total :</legend>
                <input type="text" placeholder="Masukkan seg_total" name="segment_total" />
            </fieldset>
            <fieldset>
                <legend>progress_point :</legend>
                <input type="text" placeholder="Masukkan prog" name="progress_point" />
            </fieldset>
            <fieldset>
                <legend>source_cover :</legend>
                <input type="text" placeholder="Masukkan cover" name="source_cover" />
            </fieldset>
            <fieldset>
                <legend>notes :</legend>
                <input type="text" placeholder="Masukkan note" name="notes" />
            </fieldset>
            <button type="submit">Submit</button>
        </form>
    </div>
    <footer>&copy; 2022 - KAWISH BEHZAD MAZHAR (200401075)</footer>
</body>

</html>