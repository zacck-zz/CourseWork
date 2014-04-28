<?php
//includes
require_once 'db_link.php';

$uid = $_REQUEST['u_id'];
$uaddress = $_REQUEST['u_address'];
$uname = $_REQUEST['u_name'];
$utel = $_REQUEST['u_tel'];


//insert query 
$upload_details = mysql_query("INSERT INTO tbl_user_details(u_id, u_address,u_name, u_tel)
VALUES('$uid','$uaddress','$uname','$utel')");

if(!$upload_details)
{
	die('Could not upload details due to '.mysql_error());
}

?>