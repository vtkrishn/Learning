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

$sql="SELECT * FROM $tbl_name WHERE user_email='$myusername' and user_pass='$encrypted_pass'";
$result=mysql_query($sql);

// Mysql_num_row is counting table row
$count=mysql_num_rows($result);

// If result matched $myusername and $mypassword, table row must be 1 row

if($count==1){

    
    if ($result) {
            
        
        $row = mysql_fetch_array($result);


        //check if the user is active
          if($row['user_status'] == 'active'){   
            // Register $myusername, $mypassword and redirect to file "home.php"
            session_start(); 
            $_SESSION['myusername'] = $myusername;
            header("location:index.php");
          }
          else{
              echo "The user is not activated";
              //print "<a href=\"index.php?confirm=send\">Send Confirmation Again</a>";
              print "<form action=\"index.php\" method=\"post\">";
               print "<input type=\"submit\" value=\"Send Confirmation Again\"/>";
              print "<input type=\"hidden\" name=\"confirmation\" value=\"1\"/>";
              print "</form>";
          }
    }
    else {
      echo mysql_error();
    }
    

}


else if (count == 0){
echo "No user exists!";
}
else {
echo "Wrong Username or Password";
}
