<?php

include('conection.php');

$newPass = $_GET['newPass'];
$user = $_GET['username'];
$password = $_GET['password'];

$queryUpdate = "UPDATE usuario SET contrasena='$newPass' where username = '$user' AND contrasena = '$password'";

$result = mysqli_query($conection,$queryUpdate);

if($result){
    echo "operación exitosa";
}

mysqli_close($conection);
?>