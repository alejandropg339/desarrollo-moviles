<?php

include('conection.php');
$min =1;
$max= 999999;

$id = rand ($min, $max);
$nombre = $_GET['nombre'];
$tamano = $_GET['tamano'];
$descripcion = $_GET['descripcion'];
$costo = $_GET['costo'];
$precio = $_GET['precio'];

$insertQuery = "INSERT INTO producto (id, nombre, tamano, presentacion, unidad_medida, descripcion, costo, precio) values ('$id', '$nombre','$tamano', NULL,NULL,'$descripcion','$costo', '$precio')";

$result = mysqli_query($conection,$insertQuery);

if($result){
    echo "Operación exitosa";
}

mysqli_close($conection);
?>