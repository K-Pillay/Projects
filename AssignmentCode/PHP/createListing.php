<?php
include 'db.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
  $name = $_POST['product_name'];
  $age = $_POST['product_age'];
  $price = $_POST['price'];
  $condition = $_POST['condition'];
  $methods = $_POST['payment_methods'];
  $location = $_POST['location'];
  $desc = $_POST['description'];

  // Insert product
  $stmt = $conn->prepare("INSERT INTO products (name, age, price, product_condition, payment_methods, location, description) VALUES (?, ?, ?, ?, ?, ?, ?)");
  $stmt->bind_param("sdsssss", $name, $age, $price, $condition, $methods, $location, $desc);
  $stmt->execute();
  $product_id = $stmt->insert_id;

  // Handle image uploads
  foreach ($_FILES['images']['tmp_name'] as $i => $tmpName) {
    $filename = basename($_FILES['images']['name'][$i]);
    $target = "uploads/" . $filename;
    move_uploaded_file($tmpName, $target);

    $imgStmt = $conn->prepare("INSERT INTO product_images (product_id, image_path) VALUES (?, ?)");
    $imgStmt->bind_param("is", $product_id, $target);
    $imgStmt->execute();
  }

  //redirect to payment gateway after order info is stored in database
  header("Location: payment_gateway.html");
exit();
}
?>