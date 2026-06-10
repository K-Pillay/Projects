<?php
session_start();

// if (!isset($_SESSION['is_admin'])) { header("Location: ../login.php"); exit; }

include "../PHP/db.PHP"; 
?>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Admin Dashboard</title>
  <link rel="stylesheet" href="adminDashboard.css">
</head>
<body>

<div class="admin-container">
  <h1>Admin Dashboard</h1>
  <div class="nav">
    <a href="#products">Manage Products</a>
    <a href="#orders">View Orders</a>
    <a href="#users">Manage Users</a>
    <a href="../HTML/homepage.php">View Website</a>
    <a href="../logout.php" class="logout">Logout</a>
  </div>

  <section id="products">
    <h2>Products</h2>
    <a class="button" href="addProduct.php">Add New Product</a>
    <table>
      <tr><th>ID</th><th>Name</th><th>Price</th><th>Action</th></tr>
      <?php
        $res = mysqli_query($conn, "SELECT * FROM products");
        while ($row = mysqli_fetch_assoc($res)) {
          echo "<tr>
                  <td>{$row['id']}</td>
                  <td>{$row['name']}</td>
                  <td>R{$row['price']}</td>
                  <td>
                    <a href='editProduct.php?id={$row['id']}'>Edit</a> |
                    <a href='deleteProduct.php?id={$row['id']}'>Delete</a>
                  </td>
                </tr>";
        }
      ?>
    </table>
  </section>

  <section id="orders">
    <h2>Recent Orders</h2>
    <table>
      <tr><th>Order ID</th><th>User</th><th>Total</th><th>Status</th></tr>
      <?php
        $orders = mysqli_query($conn, "SELECT * FROM orders ORDER BY id DESC LIMIT 10");
        while ($order = mysqli_fetch_assoc($orders)) {
          echo "<tr>
                  <td>{$order['id']}</td>
                  <td>{$order['user_id']}</td>
                  <td>R{$order['total']}</td>
                  <td>{$order['status']}</td>
                </tr>";
        }
      ?>
    </table>
  </section>

  <section id="users">
    <h2>Users</h2>
    <table>
      <tr><th>ID</th><th>Email</th><th>Registered</th></tr>
      <?php
        $users = mysqli_query($conn, "SELECT * FROM users LIMIT 10");
        while ($user = mysqli_fetch_assoc($users)) {
          echo "<tr>
                  <td>{$user['id']}</td>
                  <td>{$user['email']}</td>
                  <td>{$user['created_at']}</td>
                </tr>";
        }
      ?>
    </table>
  </section>
</div>

</body>
</html>