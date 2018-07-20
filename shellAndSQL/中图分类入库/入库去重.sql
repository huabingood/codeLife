
################ 最终在生产上使用的代码是 ##################
-- 创建表
create table t_clc(chinatype varchar(50) primary key comment '中图分类',
                   description varchar(200) comment '中图分类法的中文含义')default charset =utf8;

-- 清除chinatype中的部分脏数据
update books set chinatype=null where chinatype in ('海洋出版社','张淑兰','逆水寒（套装共3册）','任杰主编','刘国忠 著','1$$aP548.22$$v3');



############## 测试验证 ##################################
use my_test;
show tables;

#
use my_test;
update books set qiniu_image='http://baidu.com' where isbn='9787010000008';



-- 创建中图分类法的表
CREATE TABLE `t_zt_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `code` varchar(50) NOT NULL COMMENT '中图分类编码',
  `type_name` varchar(200) NOT NULL COMMENT '中图分类名称',
  `rejected` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否禁止回收，同时看出版时间',
  `publishing_year_limit` int(11) DEFAULT NULL COMMENT '出版时间限制',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除标志',
  `version` bigint(20) NOT NULL DEFAULT '0' COMMENT '版本号',
  `created_by` varchar(20) DEFAULT NULL COMMENT '创建人',
  `created_date` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `updated_by` varchar(20) DEFAULT NULL COMMENT '更新人',
  `updated_date` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;







show create table t_clc;

load data local infile '/home/huabingood/result/zhongTuFenLei.csv' into table my_test.t_clc character set utf8 fields terminated by ',';

# 查看导入的中图分类是否正常
select * from t_clc;

-- 清空表
drop table my_test.t_clc;
truncate my_test.t_clc;



################### 验证书查查的中图分类与下载的中图分类的区别 #########################
select title,t1.chinatype,t2.description
from books as t1
  left join t_clc as t2 on t1.chinatype=t2.chinatype
where t2.chinatype is null ;
-- 不重复的共多少行

select t1.chinatype
from books as t1
  left join t_clc as t2 on t1.chinatype=t2.chinatype
where t2.chinatype is null
group by t1.chinatype;

select count(1) from books where chinatype='';
select count(1) from books where chinatype is null;


-- 分析
-- 对不上的总行数：114017
-- 为 '' 共 64979 行
-- 为 null 共 11433 行
-- 有两个中图分类的共 35041 行
-- 对照中图网址：http://ztflh.xhma.com/
-- 异常值： 0 海洋出版社 张淑兰  逆水寒（套装共3册） 任杰主编  刘国忠 著 1$$aP548.22$$v3 以及纯数字
-- .F249.212  只有F249.21
-- A-01 不存在
-- A102 A103 A111 A123-49 不存在
-- B.290  B0-03  B226.22 B948-51 不存在
-- C912-1 C960 C933-4 C924.244.4 D-44 D2-05 不存在

-- 有两个标签的共有多少行 35041
select count(isbn) from books where chinatype like '%;%';
-- 有两个标签的图书有多少个两个chinatype都关联不上的情况
select chinatype,substring_index(chinatype,';',1),substring_index(chinatype,';',-1) from books where chinatype like "%;%";


-- 共有 6821 行
select t1.chinatype
from books as t1
  left join t_clc as t2 on t2.chinatype=substring_index(t1.chinatype,';',1)
where t1.chinatype like '%;%' and t2.chinatype is null group by t1.chinatype ;

-- 共有 16151 行
select t1.chinatype
from books as t1
  left join t_clc as t2 on t2.chinatype=substring_index(t1.chinatype,';',-1)
where t1.chinatype like '%;%' and t2.chinatype is null ;

-- 两个同事没有join上的
-- 随机15个验证，是都没有
-- 共 3491
select t1.chinatype from (select t1.chinatype
                          from books as t1
                            left join t_clc as t2 on t2.chinatype=substring_index(t1.chinatype,';',1)
                          where t1.chinatype like '%;%' and t2.chinatype is null
                          group by t1.chinatype) as t1
  join (select t1.chinatype
        from books as t1
          left join t_clc as t2 on t2.chinatype=substring_index(t1.chinatype,';',-1)
        where t1.chinatype like '%;%' and t2.chinatype is null
        group by t1.chinatype) as t2
  on t1.chinatype=t2.chinatype;

-- 进行跟新，将都没有join上的chinatype置为空
-- 共 4455 行进行更新
update books as t1 join(select t1.chinatype from (select t1.chinatype
                                                  from books as t1
                                                    left join t_clc as t2 on t2.chinatype=substring_index(t1.chinatype,';',1)
                                                  where t1.chinatype like '%;%' and t2.chinatype is null
                                                  group by t1.chinatype) as t1
  join (select t1.chinatype
        from books as t1
          left join t_clc as t2 on t2.chinatype=substring_index(t1.chinatype,';',-1)
        where t1.chinatype like '%;%' and t2.chinatype is null
        group by t1.chinatype) as t2
    on t1.chinatype=t2.chinatype) as t2 on t1.chinatype=t2.chinatype set t1.chinatype=null  ;

-- 验证结果是否正确
-- 没有结果，意味着我们选的这几个被清空了，可以认为正确
select * from books where chinatype in ('Z424.8;K248.06' ,'Z425;K294.5' ,'Z427;CG314' ,'Z427;F270-53' ,'TU82-64;TU832-64' ,'TP391.12;TP391.13;TP391.412','R78-61;R78-61');
-- 验证chinatype is null 是否多了4455行
-- 15894 , 为null的多出了 4461
-- 因为我们已经将6行设置为空，所以正常
select count(isbn) from books where chinatype is null;





-- 处理
-- 无法处理：因为-的正常值也存才，无法简单的替换
-- 好像中间带-的只要去前面的都是存在的
-- 带-的正常值共有 616 个
-- A41-7 其中A41是存在的；A45-61 其中A45是存在的；但是-是中图分类法中的字符，比如：B-4
select count(chinatype) from t_clc where chinatype like '%-%';

-- 将chinatype中的中文置成null
update books set chinatype=null where chinatype in ('海洋出版社','张淑兰','逆水寒（套装共3册）','任杰主编','刘国忠 著','1$$aP548.22$$v3');



-- t_clc 表中存在如下问题
-- 1.存在重复问题：Z84
-- 2.存在缺失问题：Z84下的两个都没有




select chinatype,description from t_clc where chinatype='Z84';


-- 找出重复的值
create table t_clc_test(chinatype varchar(50) comment '中图分类',
                   description varchar(200) comment '中图分类法的中文含义')default charset =utf8;
load data local infile '/home/huabingood/result/zhongTuFenLei.csv' into table my_test.t_clc_test character set utf8 fields terminated by ',';

select chinatype from t_clc_test group by chinatype  having count(chinatype)>1;

select * from t_clc_test where chinatype='Z843/847';

-- 相差128，说明去重后迁移没有问题
select count(chinatype) from t_clc_test
union all
select count(chinatype) from t_clc;



truncate t_clc;
