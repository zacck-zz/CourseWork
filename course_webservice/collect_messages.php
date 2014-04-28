<?php
//include files 
require_once('db_link.php');


//variables to collect message 
$collector_id = $_REQUEST['id'];
$time = $_REQUEST['last_collect_time'];


//get the messages that came after given time 
$get_mesages = mysql_query("SELECT * FROM tbl_messages WHERE uid_to = ".$collector_id." AND time >".$time);

if(!$get_mesages)
{
	die('could not connect Messages due to '.mysql_error());
}

?>