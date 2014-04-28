<?php
//include the database link
require_once 'db_link.php';

//variables to reg user
$user_name = $_REQUEST['uname'];
$account_type = $_REQUEST['atype'];
$student = $_REQUEST['scode'];
$passphrase = $_REQUEST['pphrase'];

//now post the vars to the database

$reg_user = mysql_query("INSERT INTO tbl_users(username, atype,student,passphrase)
 VALUES('$user_name', '$account_type','$student','$passphrase')");
 
if(!$reg_user)
{
	die("couldnt insert user".mysql_error());
}
else 
	{
		echo mysql_insert_id();
	}
?>