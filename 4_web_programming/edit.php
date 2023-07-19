<?php
require("database.php");
$id = $_GET['id'];

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    if (editSource($id, $_POST)) {

        header("Location: {$reqUrl}index.php");
        die();
    } else {
        echo "Process Failed";
    }
}

$source = getSource($id);
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Kawish's Web</title>
    <link rel="stylesheet" href="./style.css" />
</head>

<body>
    <h1 style="margin: 40px auto 0 auto;">Edit Item</h1>
    <div class="centered-wrapper">

        <form action="edit.php<?= "?id={$id}" ?>" method="post">
            <input type="hidden" value="<?= $id ?>" name="id" />
            <fieldset>
                <legend>source_name :</legend>
                <input type="text" value="<?= $source['source_name'] ?>" placeholder=" Masukkan source_name anda" name="source_name" />
            </fieldset>
            <fieldset>
                <legend>segment_total :</legend>
                <input type="text" value="<?= $source['segment_total'] ?>" placeholder=" Masukkan segment_total anda" name="segment_total" />
            </fieldset>
            <fieldset>
                <legend>progress_point :</legend>
                <input type="text" value="<?= $source['progress_point'] ?>" placeholder=" Masukkan progress_point anda" name="progress_point" />
            </fieldset>
            <fieldset>
                <legend>source_cover :</legend>
                <input type="text" value="<?= $source['source_cover'] ?>" placeholder=" Masukkan source_cover anda" name="source_cover" />
            </fieldset>
            <fieldset>
                <legend>notes :</legend>
                <input type="text" value="<?= $source['notes'] ?>" placeholder=" Masukkan notes anda" name="notes" />
            </fieldset>
            <button type="submit">Submit</button>
        </form>
    </div>
    <footer>&copy; 2022 - KAWISH BEHZAD MAZHAR (200401075)</footer>
</body>

</html>