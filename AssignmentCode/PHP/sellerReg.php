<?php
include 'db.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
  $name = $_POST['seller_name'];
  $location = $_POST['location'];

  //stores seller information in database
  $stmt = $conn->prepare("INSERT INTO sellers (name, location) VALUES (?, ?)");
  $stmt->bind_param("ss", $name, $location);
  //executes the statement
  $stmt->execute();


  //Redirects user back to homepage after successful registration
  echo <script>alert('Seller registered successfully.'); window.location.href='homepage.php';</script>;
}
?>