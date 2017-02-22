<?php

include('config.php');

// Passkey that got from link
$passkey=$_GET['passkey'];

$tbl_name="rsl_user";

// Retrieve data from table where row that match this passkey
$sql="SELECT * FROM $tbl_name WHERE user_status ='$passkey'";
$result=mysql_query($sql);

// If successfully queried
if($result){

// Count how many row has this passkey
$count=mysql_num_rows($result);

// if found this passkey in our database, retrieve data from table "temp_members_db"
if($count==1){
$sql2 = "UPDATE $tbl_name SET user_status = 'active' WHERE user_status = '$passkey'";
$result2=mysql_query($sql2);
}

// if not found passkey, display message "Wrong Confirmation code"
else {
echo "Wrong Confirmation code";
}

if($result2){

$table_user_metadata = "rsl_user_metadata";

$rows=mysql_fetch_array($result);
$user_id=$rows['user_id'];

$sql3="INSERT INTO $table_user_metadata(user_id)VALUES('$user_id')";
$result3=mysql_query($sql3);

echo "Your account has been activated";
}

}

