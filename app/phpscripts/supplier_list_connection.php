<?php
define('DB_HOST','localhost');
define('DB_USER','root');
define('DB_PASS','');
define('DB_NAME','supplier_list');

$conn=new mysqli(DB_HOST,DB_USER,DB_PASS,DB_NAME);
 
if(mysqli_connect_errno())
{
    die('Unable to connect'.mysqli_connect_err());
}

$stmt=$conn->prepare("SELECT id,name,contact,email FROM supplierdetails");
$stmt->execute();
$stmt->bind_result($id,$name,$contact,$email);

$supplier_data=array();

while($stmt->fetch())
{
   $temp=array();
   $temp['id']=$id;
   $temp['name']=$name;
   $temp['contact']=$contact;
   $temp['email']= $email;

   array_push($supplier_data,$temp);
}

echo json_encode($supplier_data);
?>