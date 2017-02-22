<?php

include('config.php');

$tbl_name="rsl_user";
$mail = $_POST['mymail'];

// Retrieve data from table where row that match this passkey
$sql="SELECT * FROM $tbl_name WHERE user_email ='$mail'";
$result=mysql_query($sql);

// Mysql_num_row is counting table row
$count=mysql_num_rows($result);

$rows=mysql_fetch_array($result);
$enc_pass=$rows['user_pass'];

if($count == 1){
    
    session_start();
    $_SESSION['forgot']=$mail;
// Update data into database
//$sql="UPDATE $tbl_name SET user_pass='$confirm_code' WHERE user_email='$mail'";
//$result=mysql_query($sql);

//if($result){
    // ---------------- SEND MAIL FORM ----------------
print "sent mail $confirm_code";
// send e-mail to ...
$to=$email;

// Your subject
$subject="Your reset password link here - guno.com";

// From
$header="from: Guno Admin admin@guno.com";

// Your message
$message="Your Reset Password link \r\n";
$message.="Click on this link to reset your password \r\n";
$message.="http://localhost/SimpleApplication/reset_password.php?passkey=$enc_pass";

// send email
$sentmail=mail($to,$subject,$message,$header);
//}
//else{
  //  print "Could not find user with that email address";
//}
}
else{
    print "Could not find user with that email address";
}