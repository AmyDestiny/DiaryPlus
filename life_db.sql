create database life;
use life;
create table `diary`(
	`id` int(11) primary key not null auto_increment,
	`date` datetime not null,
	`intro` varchar(100) not null,
	`version` varchar(20),
	`more` text,
	`imgpath` varchar(100),
	`isHighLight` int(2)
)default charset=utf8;

insert into diary(date,intro,version,more,imgpath,isHighLight)
	values('2012-12-12 11:22:33','我是intro','我是version','我是更多内容','images/upload/abc.jpg',1);
insert into diary(date,intro,version,more,imgpath,isHighLight)
	values('2016-7-12 13:32:33','今天没有吃饭','1.0','饭太贵了，吃不起饭了，所以现在非常饿','images/upload/abc.jpg',0);
insert into diary(date,intro,version,more,imgpath,isHighLight)
	values('2016-6-12 13:32:33','今天吃饭了','1.0','饭太便宜了','images/upload/abc.jpg',0);
insert into diary(date,intro,version,more,imgpath,isHighLight)
	values('2016-7-11 13:32:33','终于把这个工程完成了','1.0','哈哈。好开心啊。累死了。一会先去吃个饭','images/upload/abc.jpg',0);


create table leaveword(
	`id` int(11) primary key auto_increment,
	`publisher` varchar(100) not null default '匿名',
	`content` text,
	`createtime` timestamp not null default NOW(),
	`status` int(2) default 0 -- 状态：0：不显示  1：显示
)default charset=utf8;
insert into leaveword(publisher,content,status) values('alisa','i am content,ni zhe zuo de tai lan le',1);
insert into leaveword(publisher,content,status) values('nickname','i am content',1);
