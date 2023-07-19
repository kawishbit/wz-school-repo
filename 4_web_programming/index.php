<?php
require("database.php");


if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $id = $_POST['delete_id'];
    if ($id != "" && deleteSource($id)) {
        header("Location: {$reqUrl}index.php");
        die();
    } else {
        echo "Process Failed";
    }
}

$sources = getAllSources();

?>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Kawish's Web</title>
    <link rel="stylesheet" href="./style.css" />
</head>

<body>

    <section class="wrapper">
        <div class="action">
            <a class="button" href="<?= $reqUrl ?>add.php">Tambah</a>
        </div>
        <table>
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Action</th>
                    <th>Source Name</th>
                    <th>Cover</th>
                    <th>Progress</th>
                    <th>Notes</th>
                    <th>Created At</th>
                    <th>Updated At</th>
                </tr>
            </thead>
            <tbody>
                <?php for ($i = 0; $i < count($sources); $i++) : ?>
                    <tr>
                        <td><?= $i + 1 ?></td>
                        <td><a class="button" href="<?= $reqUrl . 'edit.php?id=' . $sources[$i]['source_id'] ?>">Ubah</a>&nbsp;&nbsp;<span class="button" onClick="deleteItem(<?= $sources[$i]['source_id'] ?>)">Hapus</a></td>
                        <td><?= $sources[$i]['source_name'] ?></td>
                        <td><img src="<?= $reqUrl . $sources[$i]['source_cover'] ?>" style="width: 100px; height: auto; max-width: 100%; margin: 0 auto" /></td>
                        <td><?= round($sources[$i]['progress_point'] / $sources[$i]['segment_total'] * 100) . "%" ?></td>
                        <td><?= $sources[$i]['notes'] ?></td>
                        <td><?= date_format(date_create($sources[$i]['created_at']), "Y/m/d H:i:s"); ?></td>
                        <td><?= date_format(date_create($sources[$i]['updated_at']), "Y/m/d H:i:s"); ?></td>
                    </tr>
                <?php endfor; ?>
            </tbody>
    </section>

    <form action="index.php" method="POST" style="display:none;">
        <input type="hidden" name="delete_id" />
        <button type="submit" id="submit_delete" style="display:none" />
    </form>

    <script type="text/javascript">
        function deleteItem(id) {
            if (confirm("Yakin?") == true) {

                let a = document.querySelector('[name="delete_id"]');
                a.value = id;

                let submit = document.querySelector("#submit_delete");
                submit.click();
            }

        }
    </script>
</body>

</html>