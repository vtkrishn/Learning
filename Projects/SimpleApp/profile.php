<?php

include('config.php');
$tbl_name="rsl_user"; // Table name


session_start(); 
        $var = $_SESSION["myusername"];
        if (isset($var)){
            print "welcome,$var";
            print "<a href=\"profile.php\">My Account</a>";
         print "<a href=\"logout.php\">Logout</a>";   
        }
        else{
         print "You are not logged in. Please <a href=\"login.php\">Sign In</a> or <a href=\"signup.php\">Sign up</a>";   
        }