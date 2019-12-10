<?php
define('DB_HOST','localhost');
define('DB_USER','root');
define('DB_PASS','');
define('DB_NAME','booked_events');

$conn=new mysqli(DB_HOST,DB_USER,DB_PASS,DB_NAME);
 
if(mysqli_connect_errno())
{
    die('Unable to connect'.mysqli_connect_err());
}

$stmt=$conn->prepare("SELECT Name,Description,Date,Time FROM event_booking_list");
$stmt->execute();
$stmt->bind_result($name,$description,$date,$time);

$booking_history_data=array();

while($stmt->fetch())
{
   $temp=array();
   $temp['name']=$name;
   $temp['description']=$description;
   $temp['date']=$date;
   $temp['time']= $time;

   array_push($booking_history_data,$temp);
}

echo json_encode($booking_history_data);
?>