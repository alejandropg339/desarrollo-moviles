<?php

$host= 'mysql';
$user = 'root';
$pass = 'password';
$db = 'spmn_db';


$conection = mysqli_connect($host, $user, $pass, $db) or die('Conection failed');
mysqli_set_charset($conection, 'utf8');