<?php
$host     = '127.0.0.1';
$dbName      = 'kawish_075';
$user     = 'root';
$password = 'Kawish@1234';
$port     = 3306;
$charset  = 'utf8mb4';

mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT);
$db = new mysqli($host, $user, $password, $dbName, $port);
$db->set_charset($charset);
$db->options(MYSQLI_OPT_INT_AND_FLOAT_NATIVE, 1);


$reqUrlTemp = strtok($_SERVER['REQUEST_URI'], '?');
preg_match('/(.*\/).*/', $reqUrlTemp, $re);


$reqUrl = $re[1];

function addSource($post)
{
    global $db;

    $name = $post['source_name'] ?? "test title";
    $seg_total = $post['segment_total'] ?? 100;
    $prog = $post['progress_point'] ?? 0;
    $cover = $post['source_cover'] ?? "anon.png";
    $note = $post['notes'] ?? "test note";

    $query = $db->prepare(
        "INSERT INTO reading_tracker (source_name,segment_total,progress_point,source_cover,notes, created_at, updated_at) VALUES (?,?,?,?,?, NOW(), NOW())"
    );
    $query->bind_param("siiss", $name, $seg_total, $prog, $cover, $note);

    return $query->execute();
}

function editSource($id, $post)
{
    global $db;
    $name = $post['source_name'] ?? "test title";
    $seg_total = $post['segment_total'] ?? 100;
    $prog = $post['progress_point'] ?? 0;
    $cover = $post['source_cover'] ?? "anon.png";
    $note = $post['notes'] ?? "test note";

    $query = $db->prepare("UPDATE reading_tracker SET source_name = ?, segment_total = ?, progress_point = ?, source_cover= ?, notes = ?, updated_at = NOW() WHERE source_id = ?");
    $query->bind_param("siissi", $name, $seg_total, $prog, $cover, $note, $id);
    return $query->execute();
}
function deleteSource($id)
{
    global $db;
    $query = $db->prepare("DELETE FROM reading_tracker WHERE source_id = ?");
    $query->bind_param("i", $id);
    return $query->execute();
}

function getAllSources()
{
    global $db;
    $rows = [];
    $query = $db->prepare("SELECT * FROM reading_tracker");
    $query->execute();
    $result = $query->get_result();
    while ($row = $result->fetch_assoc()) {
        $rows[] = $row;
    }

    return $rows;
}

function getSource($id)
{
    global $db;
    $query = $db->prepare("SELECT * FROM reading_tracker WHERE source_id = ?");
    $query->bind_param("i", $id);
    $query->execute();
    $result = $query->get_result();
    return $result->fetch_assoc();
}
