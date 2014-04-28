<?php
//include connection file
require_once 'db_link.php';

//vars to add progress
$student = $_REQUEST['student'];
$course = $_REQUEST['course'];
$progress = $_REQUEST['status'];

//upload prog
$upload_prog = mysql_query("INSERT INTO tbl_course_progress (course, progress, student) 
VALUES('$course','$progress','$student')");

//check if upload worked 
if(!$upload_prog)
{
	die('Could not upload Progress due to '.mysql_error());
}
?>