# springCloud

### 用户表
```SQL
create table user(
	id int primary key,
	name varchar(30) not null,
	password varchar(16) not null
);
```
### 新闻表
```SQL
create table news(
	nid int primary key,
	title varchar(30) not null,
	content text not null,
	uid int not null
);
```
### 评论表
```SQL
create table comment(
	cid int primary key,
	content varchar(255) not null,
    	nid int not null,
    	uid int not null
)
```
![微服务基本架构图](/springCloud.jpg)
