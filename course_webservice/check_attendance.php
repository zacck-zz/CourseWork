<?php
//include 
require_once 'db_link.php';

$student_id = $_REQUEST['s_id'];

//select the record
$select_record = mysql_query("SELECT * FROM tbl_attendance WHERE student =".$student_id);

//check if the pick worked 
if(!$select_record)
{
	die('Could not collecr record due to '. mysql_error());
}

?>