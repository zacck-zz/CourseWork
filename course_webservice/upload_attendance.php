<?php
//include 
require_once 'db_link.php';

//vars 
$stud = $_REQUEST['stud'];
$day = $_REQUEST['day'];
$record = $_REQUEST['record'];

//upload record 
$upload_att = mysql_query("INSERT INTO tbl_attendance (student, day, attended) VALUES('$stud', '$day', '$record')");

//check if was successfull
if(!$upload_att)
{
	die('could not upload record '.mysql_error());
}

?>