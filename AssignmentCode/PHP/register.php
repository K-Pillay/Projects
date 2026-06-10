<?php
require_once 'db.php'; // Connect to database

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    // Retrieve user input from form
    $firstname = $_POST['firstname'];
    $dob = $_POST['dob'];
    $email = $_POST['Email'];
    $password = $_POST['Password'];
    $confirm = $_POST['Confirm-Password'];

    // Password validation
    if ($password !== $confirm) {
        die("Passwords do not match!");
    }

    // Hash password for security
    $hashed_password = password_hash($password, PASSWORD_DEFAULT);

    // Insert user information into the database using prepared statements
    $stmt = $conn->prepare("INSERT INTO users (firstname, dob, email, password) VALUES (?, ?, ?, ?)");
    if ($stmt) {
        $stmt->bind_param("ssss", $firstname, $dob, $email, $hashed_password);

        if ($stmt->execute()) {
            echo "Registration successful!";
            header("Location: ../HTML/homepage.html");
            exit();
        } else {
            echo "Failed to register! Please check your account info. Error: " . $stmt->error;
        }
        $stmt->close();
    } else {
        echo "Failed to prepare the statement.";
    }

    $conn->close();
}
?>
