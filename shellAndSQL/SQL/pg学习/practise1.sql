
-- 查看版本号
select version();

create table weather(
city varchar(80),
temp_lo int,   -- 最低气温
temp_hi int,   -- 最高温度
prce real,     -- 湿度
date date,     -- 日期
location point -- 城市
);

insert into weather values('shanghai','-1','3','60','2019-01-09','(123.2,33.3)');

insert into weather(city,temp_hi) values('haikou',21);


select * from weather;

select city from weather where city like 'hai%';

update weather set temp_lo=15 where city='haikou';

delete from weather where city='beijing';

-- pg中的继承表
CREATE TABLE cities (
  name       text,
  population real,
  altitude   int     -- (in ft)
);

CREATE TABLE capitals (
  state      char(2)
) INHERITS (cities);

-- 查看继承表的特点





SELECT col_description(a.attrelid,a.attnum) as comment,a.attname as name,
format_type(a.atttypid,a.atttypmod) as type,a.attnotnull as notnull
  FROM pg_class as c,pg_attribute as a
  where c.relname = 'weather' and a.attrelid = c.oid and a.attnum>0




SELECT a.attnum,a.attname AS field,t.typname AS type,a.attlen AS length,col_description(a.attrelid,a.attnum) as comment,a
.atttypmod AS lengthvar,a.attnotnull AS notnull from pg_class c,pg_attribute a,pg_type t where c.relname='weather' and a.attnum>0 and a.attrelid=c.oid and a.atttypid=t.oid