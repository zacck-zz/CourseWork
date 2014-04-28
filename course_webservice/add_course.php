<?php
//add Includes 

require_once 'db_link.php';

//vars to add 
$course_name = $_REQUEST['cname'];

//add the course to the db 
$add_course = mysql_query("INSERT INTO tbl_courses(course_name) VALUES('$course_name')");

//check if insert worked
if(!$add_course)
{
	die('this could not happen due to </br>'.mysql_error());
}
else {
	echo mysql_insert_id();
}


?>