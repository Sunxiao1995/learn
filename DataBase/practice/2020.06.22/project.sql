create database ProjectManageSys;  -- 创建数据库

use ProjectManageSys;  -- 进入数据库

-- 创建表单

create table project(
projectNumber int,
projectName varchar(32)
);

create table BuildingWorker(
projectNumber int,
workerID int,
workTime int
);

create table staff(
staffID int,
staffName varchar(20),
gender varchar(4),
duty varchar(20)
);

create table wage(
duty varchar(20),
hourlyWageRate int
);

create table workTime(
projectNumber int,
staffId int,
workTime int
);

-- 为表单插入数据

insert into project (projectNumber,projectName) values (01,'花园小区');
insert into project (projectNumber,projectName) values (02,'城东小区');
insert into project values (03,'南京路');

insert into BuildingWorker values (01,01,24);
insert into BuildingWorker values (01,02,22);
insert into BuildingWorker values (01,03,24);
insert into BuildingWorker values (02,04,29);
insert into BuildingWorker values (02,05,24);
insert into BuildingWorker values (03,06,23);
insert into BuildingWorker values (03,07,43);
insert into BuildingWorker values (03,08,52);

insert into staff values (1,'张三','男','项目经理'),(2,'李四','男','总工程师'),(3,'王五','男','施工员'),(4,'沈六','男','技术员'),(5,'李明','女','资料员');

insert into staff values (6,'张三2','男','项目经理'),(7,'李四2','男','总工程师'),(8,'王五2','男','施工员'),(9,'沈六2','男','技术员'),(10,'李明2','女','资料员');

insert into wage values ('项目经理',100),('总工程师',60),('施工员',30),('技术员',30),('资料员',30);


insert into workTime values (1,1,240);
insert into workTime values (1,2,300);
insert into workTime values (1,3,320);
insert into workTime values (1,4,320);
insert into workTime values (1,5,320);

insert into workTime values (2,6,240);
insert into workTime values (2,7,300);
insert into workTime values (2,8,320);
insert into workTime values (2,9,320);
insert into workTime values (2,10,320);




-- 蠕虫复制 先创建一个和表结构一样的表 此时为一个空表
create table wage2 like wage;

-- 在将原表中的数据存入到新表中
insert into wage2 select * from wage;

-- 如果只是复制一个表中部分列的数据 此时没有数据的位置为null
create table wage3 like wage;
insert into wage3 (duty) select duty from wage;

/*更新表记录 不带条件修改数据 会修改所有的行 这里在修改的时候会报错 安全模式不允许修改所有的行
-- set sql_safe_updates=0; 
如果where 是主键的话就不受影响
*/

update wage3 set duty='test'; 

update wage3 set hourlyWageRate=100 where duty='项目经理';

delete from wage2;

delete from wage3 where duty='项目经理';  -- 会删除这一整行 包括主键项目经理

truncate table wage3;   -- 删除表的结构 内容全部清空

-- 单表查询

-- 使用*表示所有的列
select * from project;

-- 查询指定的列
select staffID,duty from staff;

-- 使用别名进行查询
select staffID as 编号,duty as 职位 from staff as 员工表;

-- 查询指定列并且不出现重复
select distinct duty from staff;

-- 查询的结果参与运算































