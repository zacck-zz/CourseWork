<?php

$host = "localhost";
$user = "semasoft_course";
$database = "semasoft_coursework";
$pass = "prawesh";

$conn = mysql_connect($host, $user, $pass);

if(!$conn)
{
	die('Could not connect due to '.mysql_error());
	
}

$select_db = mysql_select_db($database, $conn);

if(!$select_db)
{
	die('Could not select the db due to '.mysql_error());
}

?>
