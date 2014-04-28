<?php
//includes 
require 'db_link.php';

//vars 
$course_id = $_REQUEST['cid'];
$student_id = $_REQUEST['sid'];

//add the student to the course
$add_student_to = mysql_query("INSERT INTO tbl_student_courses(student_id, course_id) VALUES('$student_id','$course_id')");

//check if it worked 
if(!$add_student_to)
{
	die('could not insert student to course '.mysql_error());
}
else {
	echo 'done!';
}

?>