<?php

if ($_SERVER['REQUEST_METHOD'] =='POST'){

    $name=$_POST['name'];
    $email = $_POST['email'];
    $password = $_POST['password'];
    $type=$_POST['type'];  
    $pass=$password;

    require_once 'connect.php';

    $sql = "INSERT INTO users_table (name,email,password,signup_type) VALUES ('$name', '$email', '$pass','$type')";

    if ( mysqli_query($conn, $sql) ) {
        $result["success"] = "1";
        $result["message"] = "success";

        echo json_encode($result);
        mysqli_close($conn);

    } else {

        $result["success"] = "0";
        $result["message"] = "error";

        echo json_encode($result);
        mysqli_close($conn);
    }
}

?>