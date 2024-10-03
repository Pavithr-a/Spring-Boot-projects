CREATE DATABASE IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP table IF EXISTS `employee`;

create table `employee` (
`id` int NOT NULL auto_increment,
`first_name` varchar(45) default null,
`last_name` varchar(45) default null,
`email` varchar(45) default null,
primary key (`id`)
) engine=InnoDB auto_increment=1 default charset=latin1;

--
-- Data for table `employee`
--

insert into `employee` values
	(1,'Leslie','Andrews','leslie@luv2code.com'),
    (2,'Emma','Baumgarten','emma@luv2code.com'),
    (3,'Avani','Gupta','avani@luv2code.com'),
    (4,'Yuri','Petrov','yuri@luv2code.com'),
    (5,'Juan','Vega','juan@luv2code.com');





