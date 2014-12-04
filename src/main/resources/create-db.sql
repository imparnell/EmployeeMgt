create database augdb;
create user 'aug'@'localhost' identified by 'aug@dm1n';
create user 'aug'@'127.0.0.1' identified by 'aug@dm1n';

grant all privileges on *.* to 'aug'@'localhost' with grant option;
grant all privileges on *.* to 'aug'@'127.0.0.1' with grant option;