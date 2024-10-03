-- Drop user first if they exist
DROP USER if exists 'springemployee'@'%';

-- Now create user with prop privileges
CREATE USER 'springemployee'@'%' IDENTIFIED BY 'spring';

GRANT ALL PRIVILEGES ON * . * TO 'springemployee'@'%';