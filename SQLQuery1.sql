use master
drop database coffee
create database coffee
use coffee
create table category(
 id int identity(1,1) primary key,
 name nvarchar(100) not null,
 mausac varchar(100) 
)
go
UPDATE category SET name ='capuchino' , mausac='#ffffff' WHERE id=5
select * from category
create table product(
 id int identity(1,1) primary key,
 name nvarchar(100) not null,
cat_id int foreign key references category(id),
price float not null,
create_at DateTime DEFAULT GETDATE(),
[status] int DEFAULT 1
UPDATE product SET name ='trhtrh' ,cat_id='2', price=22,status=0,create_at=GETDATE() WHERE id=1
SELECT *,FORMAT( create_at, 'dd-MM-yyyy hh:mm:ss tt') AS 'create' from product
SELECT * FROM category WHERE name LIKE '%cafe%'
INSERT INTO product(name,cat_id,price,status) VALUES('tggt',11,30,1)
go
create table coffee_table(
id int identity(1,1) primary key,
name nvarchar(100) not null,
[status] int
)
go
select * from coffee_table
UPDATE coffee_table SET name = 'bàn10',status='0' where id =1
create table [admin](
id int identity(1,1) primary key,
username varchar(30),
[password] varchar(30)
)
go
drop table employee
create table employee(
id int identity(1,1) primary key,
name nvarchar(255) not null,
username varchar(30) not null,
[password] varchar(30) not null,
gender bit not null,
[card] bigint not null,
birthday date,
phone varchar(30),
email varchar(100),
[address] ntext

)
go
select * from employee
INSERT INTO employee VALUES('chien','nhanvien1','123456',1,98765432123454,'2000-01-01','0988005510','chien123@gamil.com',N'hà nội')
UPDATE employee SET name = ?,username=?,password=?,gender=?,card=?,birthday=?,phone=?,email=?,address=? where id =1
create table [order](
id int identity(1,1) primary key,
discount float,
table_id int foreign key references coffee_table(id),
emp_id int Foreign key references employee(id),
create_at datetime,
total_price float,
[status] int
)
go
create table order_details(
id int identity(1,1) primary key,
order_id int foreign key references [order](id),
pro_id int foreign key references [product](id),
quantity int ,
price float
)
go
create table customer(
id int identity(1,1) primary key,
name nvarchar(255) not null,
table_id int Foreign key references coffee_table(id),
phone int,
email varchar(100),
create_at datetime default getdate(),
quantity int
)