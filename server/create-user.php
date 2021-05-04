<?php

include('conection.php');

$nombre = $_GET['nombre'];
$cedula = $_GET['cedula'];
$correo = $_GET['correo'];
$telefono = $_GET['telefono'];
$username = $_GET['username'];
$password = $_GET['contrasena'];

$insertQuery = "INSERT INTO usuario (cedula, nombre, username, correo, contrasena, telefono, tienda) values ('$cedula','$nombre','$username','$correo','$password','$telefono', NULL)";

$result = mysqli_query($conection,$insertQuery);

$insertQuery2 = "INSERT INTO usuario_rol (usuario, rol) values ('$cedula',2)";

$result2 = mysqli_query($conection,$insertQuery2);

if($result){
    echo "Operación exitosa";
}

mysqli_close($conection);
?>