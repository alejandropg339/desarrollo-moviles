<?php

include_once('conection.php');

$consulta = "SELECT id, nombre, tamano, descripcion, costo, precio FROM producto";

$result= mysqli_query($conection, $consulta);

while($fila = mysqli_fetch_array($result)){
    $almacenados[] = array_map('utf8_encode', $fila); 
}

echo json_encode($almacenados);

mysqli_close($conection);

?>