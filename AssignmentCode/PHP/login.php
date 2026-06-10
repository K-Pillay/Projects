<?php
// Database connection
require_once 'db.php';

if ($_SERVER["REQUEST_METHOD"]==="POST"){
    $email = $_POST["Email"];
    $pass = $_POST["Password"];


    //prepare statement that checks for the matching emial in database
       $stmt=$conn->prepare("SELECT id, password FROM users WHERE email = ?");
    $stmt->bind_param("s", $email);
    $stmt->execute();

    //get result from the database
    $result = $stmt -> get_result();

    if($result -> num_rows === 1){
        $user = $result->fetch_assoc();

        if (password_verify($password, $user["password"])){
            session_start(); // will strat session on website if password mathces

            $_SESSION["user_id"] = $user["id"];

            header("Location: ../HTML/homepage.php"); //redirects to homepage after successfull login
            exit;
        }else{
            echo "Invalid Password";
        }else{
            echo "No user found with email entered"
        }

        $stmt -> close();
        $conn -> close ();

    }else {
        echo "Invalid request method"
    }
    }
?>