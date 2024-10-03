use `employee_directory`;

drop table if exists `roles`;
drop table if exists `members`;

--
-- Table structure for table `members`
--

create table `members` (
	`user_id` varchar(50) not null,
    `pw` varchar(68) not null,
    `active` tinyint not null,
    primary key (`user_id`)
)engine=InnoDB default charset=latin1;

--
-- Inserting data for table `members`
--
-- Note: the passwords are encrypted using Bcrypt
--
-- A generation tool is avail at: https://luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: fun123

insert into `members`
values
('john','{bcrypt}$2a$10$.C3GAKfM4igfFm/MGrkylusuLI5Z1roHE4RaN5qi12VIqQUwmVbRW',1),
('mary','{bcrypt}$2a$10$.C3GAKfM4igfFm/MGrkylusuLI5Z1roHE4RaN5qi12VIqQUwmVbRW',1),
('susan','{bcrypt}$2a$10$.C3GAKfM4igfFm/MGrkylusuLI5Z1roHE4RaN5qi12VIqQUwmVbRW',1);

--
-- Table structure for table `roles`
--

create table `roles` (
	`user_id` varchar(50) not null,
    `role` varchar(50) not null,
    unique key `authorities_idx_1` (`user_id`,`role`),
    constraint `authorities_idfk_1` foreign key (`user_id`) references `members` (`user_id`)
    )engine=InnoDB default charset=latin1;
    
--
-- Inserting data for table `roles`
--

insert into `roles`
values
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_MANAGER'),
('susan','ROLE_ADMIN');
    



