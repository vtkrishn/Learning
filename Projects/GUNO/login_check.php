<?php

include('config.php');
$tbl_name="rsl_user"; // Table name

// username and password sent from form
$myusername=$_POST['myusername'];
$mypassword=$_POST['mypassword'];

// To protect MySQL injection (more detail about MySQL injection)
$myusername = stripslashes($myusername);
$mypassword = stripslashes($mypassword);
$encrypted_pass = md5($mypassword);
$myusername = mysql_real_escape_string($myusername);
$mypassword = mysql_real_escape_string($mypassword);

$sql="SELECT * FROM $tbl_name WHERE user_login='$myusername' and user_pass='$encrypted_pass'";
$result=mysql_query($sql);

// Mysql_num_row is counting table row
$count=mysql_num_rows($result);

// If result matched $myusername and $mypassword, table row must be 1 row

if($count==1){

// Register $myusername, $mypassword and redirect to file "home.php"
session_register("myusername");
session_register("mypassword");
header("location:home.php");
}
else if (count == 0){
echo "No user exists!";
}
else {
echo "Wrong Username or Password";
}
?>