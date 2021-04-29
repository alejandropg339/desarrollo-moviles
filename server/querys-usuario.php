<?php

include_once('conection.php');

$user = $_GET['user'];
$password = $_GET['password'];

$consulta = "SELECT * FROM `usuario` INNER JOIN usuario_rol on usuario.username = usuario_rol.usuario AND usuario.contrasena = '$password' AND usuario.username =  '$user'";


$result= mysqli_query($conection, $consulta);

/*
$resultadoFinal = mysqli_fetch_row($resultado);

$longitud = count($resultadoFinal);

for($i = 0 ; $i< $longitud ;$i++){
    echo $resultadoFinal[$i]." / ";
}*/

/*while($fila = mysqli_fetch_array($resultado)){
    $almacenados[] = array_map('utf8_encode', $fila); 
}*/

/*$status;
$fila = mysqli_fetch_row($resultado);

if($fila[0] != null){
    $status = true;
    echo $status."funciono";
}else{
    $status = false;
    echo $status."No funciono";
}*/

while($fila = mysqli_fetch_array($result)){
    $almacenados[] = array_map('utf8_encode', $fila); 
}

//$josnstring = json_encode($json);
echo json_encode($almacenados);

//echo json_encode($almacenados);

mysqli_close($conection);

//TODO: