<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        index page
        
        <a href="signup.php">Sign up</a>
        <?php
        session_start(); 
        $var = $_SESSION["myusername"];
        if (isset($var)){
            print "welcome,$var";
            print "<a href=\"profile.php\">My Account</a>";
         print "<a href=\"logout.php\">Logout</a>";   
        }
        else{
         print "<a href=\"login.php\">Sign In</a>";   
        }
        
        // put your code here
        include('config.php');

    // Passkey that got from link
    if(isset($_POST['confirmation'])){
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
       
print "confirmation mail sent";
    }
        ?>
    </body>
</html>
