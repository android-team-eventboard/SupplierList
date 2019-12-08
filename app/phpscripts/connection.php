<?php
define('DB_HOST','localhost');
define('DB_USER','root');
define('DB_PASS','');
define('DB_NAME','event_booking_data');

$conn=new mysqli(DB_HOST,DB_USER,DB_PASS,DB_NAME);
 
if(mysqli_connect_errno())
{
    die('Unable to connect'.mysqli_connect_err());
}

$stmt=$conn->prepare("SELECT id,name,description,date,time,rsvp FROM ebdata");
$stmt->execute();
$stmt->bind_result($id,$name,$desc,$date,$time,$rsvp);

$data=array();

while($stmt->fetch())
{
   $temp=array();
   $temp['id']=$id;
   $temp['name']=$name;
   $temp['desc']=$desc;
   $temp['date']= $date;
   $temp['time']=$time;
   $temp['rsvp']=$rsvp;

   array_push($data,$temp);
}

echo json_encode($data);
?>