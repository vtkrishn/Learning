<?php

include('config.php');

$enc_pass=$_GET['passkey'];
// table name
$tbl_name=rsl_user;
$password=$_POST['confirmpassword'];
$encrypted_password = md5($password);

session_start();
$mail = $_SESSION['forgot'];
if(isset($mail)){
 // Update data into database
$sql="UPDATE $tbl_name SET user_pass='$encrypted_password' WHERE user_pass='$enc_pass'";
$result=mysql_query($sql);

// if suceesfully inserted data into database, send confirmation link to email
if($result){
    
    header("location:login.php");
}   
}

