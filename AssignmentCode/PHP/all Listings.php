<?php
include 'db.php';

$sql = "SELECT p.id, p.name, p.price, p.location, pi.imagePath
        FROM products p
        LEFT JOIN (
          SELECT product_id, MIN(imagePath) as imagePath
          FROM product_images
          GROUP BY product_id
        ) pi ON p.id = pi.product_id
        ORDER BY p.id DESC";

$result = $conn->query($sql);
?>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>All Listings</title>
  <link rel="stylesheet" href="allListings.css">
</head>
<body>
  <div class="container">
    <h2>All Listings</h2>
    
    <?php if ($result->num_rows > 0): ?>
      <?php while($row = $result->fetch_assoc()): ?>
        <div class="listing-card">
          <img src="<?= $row['image_path'] ?: 'placeholder.jpg' ?>" alt="Product Image">
          <div class="info">
            <h3><?= htmlspecialchars($row['name']) ?></h3>
            <p><strong>Price:</strong> R<?= htmlspecialchars($row['price']) ?></p>
            <p><strong>Location:</strong> <?= htmlspecialchars($row['location']) ?></p>
          </div>
        </div>
      <?php endwhile; ?>
    <?php else: ?>
      <p>No listings found.</p>
    <?php endif; ?>
  </div>
</body>
</html>