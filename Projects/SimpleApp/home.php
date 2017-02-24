<html>
    <head>
        <meta charset="UTF-8">
        <title>Home page</title>
    </head>
    <body>
        welcome 
        <?php
        session_start(); 
        $var = $_SESSION["myusername"];
        print "$var";
        ?>
      <a href="profile.php">My Account</a>
      <a href="logout.php">Exit</a>
      
    </body>
    
</html>