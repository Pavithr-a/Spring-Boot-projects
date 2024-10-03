use `employee_directory`;

drop table if exists `authorities`;
drop table if exists `users`;

--
-- Table structure for table `users`
--

create table `users` (
	`username` varchar(50) not null,
    `password` varchar(50) not null,
    `enabled` tinyint not null,
    primary key (`username`)
)engine=InnoDB default charset=latin1;

--
-- Inserting data for table `users`
--

insert into `users`
values
('john','{noop}test123',1),
('mary','{noop}test123',1),
('susan','{noop}test123',1);

--
-- Table structure for table `authorities`
--

create table `authorities` (
	`username` varchar(50) not null,
    `authority` varchar(50) not null,
    unique key `authorities_idx_1` (`username`,`authority`),
    constraint `authorities_idfk_1` foreign key (`username`) references `users` (`username`)
    )engine=InnoDB default charset=latin1;
    
--
-- Inserting data for table `authorities`
--

insert into `authorities`
values
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_MANAGER'),
('susan','ROLE_ADMIN');
    







