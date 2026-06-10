<?php
include 'db.php'; // connects to MariaDB
?>
<!DOCTYPE html>
<html>
<head>
  <title>Home - MyShop</title>
  <link rel = "stylsheet" href = "../CSS/homepage.css">
</head>
<body>

<h1>Welcome to Ecommerce Platform</h1>

<div class="section">
  <h2>Featured</h2>
  <?php
  $result = mysqli_query($conn, "SELECT * FROM products WHERE is_featured = 1 LIMIT 6");
  while ($row = mysqli_fetch_assoc($result)) {
      echo "<div class='product'>
              <h4>{$row['name']}</h4>
              <p>\${$row['price']}</p>
            </div>";
  }
  ?>
</div>

<div class="section">
  <h2>Recommended</h2>
  <!-- Selects top rated or randim products in nthe database-->
  <?php
  $result = mysqli_query($conn, "SELECT * FROM products ORDER BY RAND() LIMIT 4");
  while ($row = mysqli_fetch_assoc($result)) {
      echo "<div class='product'>
              <h4>{$row['name']}</h4>
              <p>\${$row['price']}</p>
            </div>";
  }
  ?>
</div>

<div class="section">
  <h2>Recently Viewed</h2>
  <!-- Session tracks any viewed items or displays nothing -->
  <?php
  session_start();
  if (!empty($_SESSION['recent'])) {
      $ids = implode(',', $_SESSION['recent']);
      $result = mysqli_query($conn, "SELECT * FROM products WHERE id IN ($ids)");
      while ($row = mysqli_fetch_assoc($result)) {
          echo "<div class='product'>
                  <h4>{$row['name']}</h4>
                  <p>\${$row['price']}</p>
                </div>";
      }
  } else {
      echo "No recent items.";
  }
  ?>
</div>

</body>
</html>