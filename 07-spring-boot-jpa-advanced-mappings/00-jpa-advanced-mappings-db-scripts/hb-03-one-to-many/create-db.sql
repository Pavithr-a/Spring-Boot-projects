drop schema if exists `hb-03-one-to-many` ;

create schema `hb-03-one-to-many` ;

use `hb-03-one-to-many` ;

set FOREIGN_KEY_CHECKS=0;

drop table if exists `instructor_detail`;

create table `instructor_detail` (
	`id` int not null auto_increment,
    `youtube_channel` varchar(128) default null,
    `hobby` varchar(45) default null,
    primary key (`id`)
    ) engine=InnoDB auto_increment=1 default charset=latin1;
    
create table `instructor` (
		`id` int not null auto_increment,
        `first_name` varchar(45) default null,
        `last_name` varchar(45) default null,
        `email` varchar(45) default null,
        `instructor_detail_id` int default null,
        primary key(`id`),
        key `FK_DETAIL_idx` (`instructor_detail_id`),
        constraint `FK_DETAIL` 
        foreign key (`instructor_detail_id`) 
        references `instructor_detail` (`id`) 
        on delete no action on update no action
        ) engine=InnoDB auto_increment=1 default charset=latin1;
        
drop table if exists `course`;

create table `course` (
	`id` int not null auto_increment,
    `title` varchar(128) default null,
    `instructor_id` int default null,
    primary key (`id`),
	unique key `TITLE_UNIQUE` (`title`),
     key `FK_INSTRUCTOR_idx` (`instructor_id`),
     constraint `FK_INSTRUCTOR` 
     foreign key (`instructor_id`) 
     references `instructor` (`id`) 
     on delete no action on update no action
    ) engine=InnoDB auto_increment=1 default charset=latin1;
    
        
        set FOREIGN_KEY_CHECKS=1;