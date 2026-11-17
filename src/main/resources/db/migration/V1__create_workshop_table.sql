# create database workshop_hub;
#
# create user 'workshop_user'@'localhost' identified by 'workshop123';
#
# grant all privileges on workshop.* to 'workshop_user'@'localhost';

CREATE TABLE workshop (
      id               BIGINT       AUTO_INCREMENT PRIMARY KEY,
      title            VARCHAR(100) NOT NULL,
      category         VARCHAR(40)  NOT NULL,
      presenter        VARCHAR(100) NOT NULL,
      duration_minutes INT          NOT NULL,
      capacity         INT          NOT NULL
);