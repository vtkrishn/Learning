<html>
    <head>
        <meta charset="UTF-8">
        <title>Logout</title>
    </head>
    <body>
        You are successfully logged out.
      <a href="index.php">Go Home</a>
    </body>
    <?php
session_start();
session_unset();
session_destroy();
$_SESSION = array();
ob_start();
ob_end_flush(); 
exit();
?>
</html>

