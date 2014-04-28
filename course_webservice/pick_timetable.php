<?php
//includes 
require 'db_link.php';

//variables 
$student_id = $_REQUEST['id'];
$tt = array();



//do the simple join that looks complex 

$q = "SELECT tbl_courses.course_name, tbl_timetable.day FROM tbl_courses JOIN tbl_student_courses
 ON tbl_courses.course_id = tbl_student_courses.course_id 
 JOIN tbl_timetable ON tbl_student_courses.course_id = tbl_timetable.course_id 
 WHERE tbl_student_courses.student_id = ".$student_id;
 
$timetable = mysql_query($q);

if(!$timetable)
{
	die("could not get the time table due to ".mysql_error());
} 
else
{
	while($row = mysql_fetch_assoc($timetable))
	{
		$tt[]= $row;
				
	}
	$lessons = array('lessons'=>$tt);
	echo str_ireplace('\\', '', str_ireplace('\r\n', '', json_encode($tt)));
	
}


?>