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
	values('2012-12-12 11:22:33','我是intro','我是version','我是更多内容',null,1);


insert into diary(date,intro,version,more,imgpath,isHighLight)
	values('2016-7-12 13:32:33','今天没有吃饭','1.0','饭太贵了，吃不起饭了，所以现在非常饿',null,0);
insert into diary(date,intro,version,more,imgpath,isHighLight)
	values('2016-6-12 13:32:33','今天吃饭了','1.0','饭太便宜了',null,0);
select id,date,intro,version,more,imgpath,isHighLight from diary
	WHERE intro like CONCAT('%','version','%') or more like CONCAT('%','version','%')


insert into diary(date,intro,version,more,imgpath,isHighLight)
	values('2016-7-11 13:32:33','终于把这个工程完成了','1.0','哈哈。好开心啊。累死了。一会先去吃个饭',null,0);

update diary set imgpath = 'images/upload/abc.jpg';