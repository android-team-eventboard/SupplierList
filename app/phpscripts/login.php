<?php

if ($_SERVER['REQUEST_METHOD']=='POST') {

    $email = $_POST['email'];
    $password = $_POST['password'];

    require_once 'connect.php';

    $sql = "SELECT * FROM users_table WHERE email='$email'";

    $response = mysqli_query($conn, $sql);

    $result = array();
    $result['login'] = array();
    
    if ( mysqli_num_rows($response) === 1 ) {
        
        $row = mysqli_fetch_assoc($response);
        if ( $password === $row['password']) {
            
            $index['name'] = $row['name'];
            $index['email'] = $row['email'];
            $index['id'] = $row['id'];
            $index['type']=$row['signup_type'];

            array_push($result['login'], $index);

            $result['success'] = "1";
            $result['message'] = "success";
            echo json_encode($result);

            mysqli_close($conn);

        } else {

            $result['success'] = "0";
            $result['message'] = "error";
            echo json_encode($result);
            echo json_encode($row);
            echo json_encode($password);
            echo json_encode($response);
            mysqli_close($conn);

        }

    }

}

?>