create table goods
(
	id INT(11) primary key auto_increment,
    name varchar(255)
);
insert into goods(name) value('adidas运动鞋');
insert into goods(name) value('NIKE篮球鞋');
insert into goods(name) value('安踏休闲裤');
insert into goods(name) value('阿玛尼钱包');
insert into goods(name) value('darry钻戒');
insert into goods(name) value('LV背包');
insert into goods(name) value('apple笔记本');
insert into goods(name) value('小米手机');
insert into goods(name) value('李宁文化衫');
insert into goods(name) value('洗碗机器人');

select * from goods;

alter table goods add address varchar(255);
alter table goods add price varchar(255);
alter table goods add photo varchar(255);

update goods set address='美国',price='800' where id=1;
update goods set address='莆田',price='1200' where id=2;
update goods set address='福建',price='200' where id=3;
update goods set address='浙江温州',price='600' where id=4;
update goods set address='香港',price='12300' where id=5;
update goods set address='英国',price='10800' where id=6;
update goods set address='洛杉矶',price='14000' where id=7;
update goods set address='深圳',price='599' where id=8;
update goods set address='海南',price='300' where id=9;
update goods set address='中国',price='20000' where id=10;

update goods set  photo='01.jpg' where id=1;
update goods set photo='02.jpg' where id=2;
update goods set photo='03.jpg' where id=3;
update goods set photo='04.jpg' where id=4;
update goods set photo='05.jpg' where id=5;
update goods set photo='06.jpg' where id=6;
update goods set photo='07.jpg' where id=7;
update goods set photo='08.jpg' where id=8;
update goods set photo='09.jpg' where id=9;
update goods set photo='10.jpg' where id=10;

select * from goods where 1=0;
select * from goods1 where 1=0;

create table goods1 as select * from goods where 1=0;

drop table goods1;

/*
创建用户表，包含姓名，总金额，创建时间等
*/
create table account_info
(
	id int not null  primary key auto_increment,
    account varchar(255) not null,
    amount double(18,2) not null default 0,
    create_at datetime not null default now()
);

insert into account_info(account,amount)  values('张三',1400);
insert into account_info(account,amount)  values('boss李',0);

select * from account_info;

create table trans_info
(
	id int not null  primary key auto_increment,
	source_id int not null ,
    source_account varchar(255) not null,
    destination_id int not null ,
    destination_account varchar(255) not null,
    amount double(18,2) not null default 0,
    create_at datetime not null default now()
);

select * from trans_info where 1=0;
select * from trans_info ;
select * from account_info where id=1;
select * from account_info ;

delimiter //
create procedure getAccount(IN sp_id int)
begin
	select * from account_info where id = sp_id;
end//
delimiter ;

delimiter //
create procedure insertTransInfo(IN sp_source_id int,IN sp_source_account varchar(255),
IN sp_destination_id int,IN sp_destination_account varchar(255),IN sp_amount double)
begin
	INSERT INTO trans_info(source_id,source_account,destination_id,destination_account,amount)  
    VALUES (sp_source_id,sp_source_account,sp_destination_id,sp_destination_account,sp_amount);
end//
delimiter ;

call getAccount(1);
update account_info set amount=1300 WHERE id=1;
update account_info set amount=00.0 WHERE id=2;

call insertTransInfo(1,'张三',2,'boss李',200);