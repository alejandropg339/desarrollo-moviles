<?php

include('conection.php');

$id = $_GET['id'];
$nombre = $_GET['nombre'];
$tamano = $_GET['tamano'];
$descripcion = $_GET['descripcion'];
$costo = $_GET['costo'];
$precio = $_GET['precio'];

$queryUpdate = "UPDATE producto SET nombre='$nombre', tamano='$tamano', descripcion='$descripcion', costo='$costo', precio='$precio' where id = '$id'";
$result = mysqli_query($conection,$queryUpdate);

if($result){
    echo "Operación exitosa";
}

mysqli_close($conection);
?>