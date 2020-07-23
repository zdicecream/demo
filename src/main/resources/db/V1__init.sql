/*
-- 默认用户名密码root/root
 mysql -u root -p
-- 连接
 mysql -h192.168.43.252 -uroot -p111111

-- 建库
 create database test;

-- 查看用户
select host,user,password,grant_priv,Super_priv from mysql.user;
-- 新建用户
CREATE USER  'test'@'localhost'  IDENTIFIED BY  '123456';
-- 删除用户
drop user 'test'@'host';
-- 授权用户
grant all on test.* to 'test'@'localhost' IDENTIFIED BY  '123456';

USE test;
*/
create table t_button (id integer not null auto_increment, button_code varchar(255), button_desc varchar(255), button_name varchar(255), menu_id integer not null, primary key (id)) engine=MyISAM;
create table t_department (id integer not null auto_increment, department_code varchar(255), department_desc varchar(255), department_name varchar(255), parent_department_id integer , primary key (id)) engine=MyISAM;
create table t_menu (id integer not null auto_increment, menu_name varchar(255), url varchar(255), primary key (id)) engine=MyISAM;
create table t_right (id integer not null auto_increment, right_desc varchar(255), button_id integer, menu_id integer, primary key (id)) engine=MyISAM;
create table t_role (id integer not null auto_increment, create_time datetime, role_desc varchar(255), role_name varchar(255), parent_role_id integer , primary key (id)) engine=MyISAM;
create table t_role_right (role_id integer not null, right_id integer not null, primary key (role_id, right_id)) engine=MyISAM;
create table t_user (id integer not null auto_increment, create_time datetime, email varchar(255), last_login_time datetime, login_count integer, login_name varchar(255), name varchar(255), password varchar(255), phone varchar(255), department_id integer not null, primary key (id)) engine=MyISAM;
create table t_user_role (user_id integer not null, role_id integer not null, primary key (user_id, role_id)) engine=MyISAM;
alter table t_right drop index UK_q5eykleu4xfv8m2ffv14034e6;
alter table t_right add constraint UK_q5eykleu4xfv8m2ffv14034e6 unique (button_id);
alter table t_right drop index UK_n74iun7prjf1k9lfy6l4pm5ur;
alter table t_right add constraint UK_n74iun7prjf1k9lfy6l4pm5ur unique (menu_id);
alter table t_button add constraint FKru3w8ksh649bxxfoesiloelpv foreign key (menu_id) references t_menu (id);
alter table t_department add constraint FKhqeqhd32itm7vegn766cy69tg foreign key (parent_department_id) references t_department (id);
alter table t_right add constraint FK7gupj891bqk8k8eyh6f7hm1lm foreign key (button_id) references t_button (id);
alter table t_right add constraint FKpvdi8maqht9cwrjcjquqduhps foreign key (menu_id) references t_menu (id);
alter table t_role add constraint FK417k0qm3hs2ygsnm90rrcuj83 foreign key (parent_role_id) references t_role (id);
alter table t_role_right add constraint FKltidwtbcjuhnrloxjg1vh4tv0 foreign key (right_id) references t_right (id);
alter table t_role_right add constraint FK1xnksbhrufwbswkwbjf0a482y foreign key (role_id) references t_role (id);
alter table t_user add constraint FKs1rnm14ev9cb4bbxcspqmcto3 foreign key (department_id) references t_department (id);
alter table t_user_role add constraint FKa9c8iiy6ut0gnx491fqx4pxam foreign key (role_id) references t_role (id);
alter table t_user_role add constraint FKq5un6x7ecoef5w1n39cop66kl foreign key (user_id) references t_user (id);