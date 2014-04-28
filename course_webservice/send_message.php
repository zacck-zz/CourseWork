<?php 
//includes
require_once 'db_link.php';


//vars
$from_id = $_REQUEST['from'];
$time = $_REQUEST['time'];
$message = $_REQUEST['msg'];
$to_id = $_REQUEST['to'];

//add the message to the sent list 
$send_message = mysql_query("INSERT INTO tbl_messages (message,time,uid_from, uid_to) VALUES('$message','$time', '$from','$to')");

//check if worked 
if(!$send_message)
{
	die("Could not send message due to ".mysql_error());
	
}



?>