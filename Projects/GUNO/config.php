<?php
// Parse without sections

$ini_array = parse_ini_file('configuration.config');

//db properties
$host=$ini_array['host']; // Host name
$username="fusion"; // Mysql username
$password="fusion"; // Mysql password
$db_name=$ini_array['db_name']; // Database name 

//Connect to server and select database.
mysql_connect("$host", "$username", "$password")or die("cannot connect to server");
mysql_select_db("$db_name")or die("cannot select DB");

?>
