<?php

    $connect = mysqli_connect("localhost", "DBusername", "DBpassword", "DBname");
    
    $connect->set_charset("utf8"); 

    $num1 = $_POST['num1'];  
    
    $num2 = $_POST['num2'];
  
    $statement = mysqli_prepare($connect, " INSERT INTO TableName (num1,num2) VALUES ( '$num1' , '$num2' ) ");
       
    mysqli_stmt_bind_param($statement, "ss", $num1 , $num2 );
    
    mysqli_stmt_execute($statement);    
    
    mysqli_close($connect);
?>
