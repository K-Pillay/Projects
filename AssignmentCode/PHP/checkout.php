<?php
include 'db.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
  $name = $_POST['fullname'];
  $email = $_POST['email'];
  $address = $_POST['address'];
  $city = $_POST['city'];
  $postal = $_POST['postal_code'];
  $payment = $_POST['payment_method'];

  $stmt = $conn->prepare("INSERT INTO orders (name, email, address, city, postal_code, payment_method) VALUES (?, ?, ?, ?, ?, ?)");
  $stmt->bind_param("ssssss", $name, $email, $address, $city, $postal, $payment);
  $stmt->execute();

  echo <script>alert('Order placed successfully!'); window.location.href='homepage.php';</script>;
}
?>
