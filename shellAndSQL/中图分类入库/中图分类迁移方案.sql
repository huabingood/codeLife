################### 最终在生产上执行的代码 ####################




################### 测试经过 ################################
-- 重命名表
alter table books rename to t_scc_book;

-- 1.将 books dump 到本地
mysqldump -uroot -p --opt --databases my_test --tables t_scc_book >/home/huabingood/t_scc_book.sql


-- 2.将 t_clc dump到本地
mysqldump -uroot -p --opt --databases my_test --tables t_clc >/home/huabingood/t_clc.sql


-- 3.将books加载到mysql
-- 16:00 开始 到16:37 结束
source ${path}/books.sql;





drop table luka_test.books;









####################### 验证脚本是否正常 ##########################
-- 验证上传七牛云的图片是否正常
-- 个数 sync字段 抽样对照isbn和图片
select count(isbn) from books where qiniu_image !='' or qiniu_image is not null;

select count( distinct qiniu_image) from books where qiniu_image like "%pandabox%";

select isbn,qiniu_image from books where qiniu_image!='';

select count(isbn) from books where sync=10;

-- 验证表结构
-- 添加 qiniu_image 字段 ，添加chinatype索引，删除三个tag索引
show create table books;


-- author 异常字段清洗
select author from books where author!='';

-- publisher
select publisher from books where publisher!='' order by publisher;

-- pubdate
select pubdate from books where isbn='9787532429196' ;

-- pages
select pages from books where pages like '%册%';

-- format
select format from books where format like "%６%";

-- t_zt_type 验证行数是否正确
-- 相差128
select count(chinatype) from t_clc_test
union all
select count(code) from t_zt_type;
