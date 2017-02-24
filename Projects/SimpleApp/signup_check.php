<?php

include('config.php');

// table name
$tbl_name=rsl_user;

// Random confirmation code
$confirm_code=md5(uniqid(rand()));

// values sent from form
$login=$_POST['login'];
$password=$_POST['password'];
$encrypted_password = md5($password);
$email=$_POST['email'];

// Insert data into database
$sql="INSERT INTO $tbl_name(user_login,  user_pass,user_status, user_email)VALUES('$login', '$encrypted_password', '$confirm_code', '$email')";
$result=mysql_query($sql);

// if suceesfully inserted data into database, send confirmation link to email
if($result){
 // ---------------- SEND MAIL FORM ----------------

// send e-mail to ...
$to=$email;

// Your subject
$subject="Your confirmation link here - guno.com";

// From
$header="from: Guno Admin admin@guno.com";

// Your message
$message="Your Comfirmation link \r\n";
$message.="Click on this link to activate your account \r\n";
$message.="http://localhost/SimpleApplication/confirmation.php?passkey=$confirm_code";

// send email
$sentmail=mail($to,$subject,$message,$header);
}
else{
echo "$email already exists";
}

// if your email succesfully sent
if($sentmail){
echo "Your Confirmation link Has Been Sent To Your Email Address.";
}
else {
echo "Cannot send Confirmation link to your e-mail address";
}
print "<a href=\"index.php\">Index</a>"; 

