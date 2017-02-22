show databases;
use guno;
CREATE TABLE `rsl_user` (
  `user_id` int(11) NOT NULL auto_increment,
  `user_login` varchar(20) NOT NULL,
  `user_pass` varchar(32) NOT NULL,
  `user_status` varchar(32) NOT NULL,
  `user_email` varchar(20) NOT NULL,
  PRIMARY KEY  (`user_id`),
  UNIQUE KEY `user_login` (`user_login`,`user_email`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;
CREATE TABLE `rsl_user_metadata` (
  `user_metadata_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) NOT NULL,
  `display_name` varchar(100) default NULL,
  `age` int(11) default NULL,
  `sex` varchar(10) default NULL,
  `country` varchar(10) default NULL,
  PRIMARY KEY  (`user_metadata_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

