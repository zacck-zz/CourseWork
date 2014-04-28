<?php

require_once 'db_link.php';

//vars
$username = $_REQUEST['uname'];
$passphrase = $_REQUEST['pphrase'];
$uid = 0;

//select user
$select_user = mysql_query("SELECT _id FROM tbl_users WHERE username = '$username'  AND passphrase = '$passphrase'");

if (!$select_user) {
	die("Could not select user due to " . mysql_error()." ".mysql_errno() ."</br>" );
} else {
	if (mysql_num_rows($select_user) != 1) {
		echo "user not existent";

	} else {
		while ($row = mysql_fetch_array($select_user)) {
			$uid = $row['_id'];
			echo $uid;
		}
	}
}
?>