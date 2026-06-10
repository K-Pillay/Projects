<?php
//displays error messages for debugging purposses
error_reporting(E_ALL);
ini_set('display_errors', 1);

$host = 'localhost';
$user = 'newuser';
$pass = 'newpass';
$db   = 'ecommerce';

$conn = mysqli_connect($host, $user, $pass, $db);

if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}else{
    echo ("Connection successful");
}
?>