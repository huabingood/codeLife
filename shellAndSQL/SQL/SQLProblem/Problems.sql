use my_bigdata;

## 查询课程编号为“01”的课程比“02”的课程成绩高的所有学生的学号。
select *
from (select s_id,s_score from Score where c_id = "01") as t01
       join (select s_id,s_score from Score where c_id = "02") as t02
            on t01.s_id = t02.s_id
where t01.s_score > t02.s_score;

# 查询平均成绩大于60分的学生的学号和平均成绩
# Having 相当与聚合函数的where
select s_id,avg(s_score) as avg_score
from Score
group by s_id
having avg(s_score) > 60;

# 查询所有学生的学号、姓名、选课数、总成绩
select *
from (select s_id,s_name from Student) as st
       join (select s_id, count(c_id) as 选课数,sum(s_score) as 总成绩 from Score group by s_id) as sc
            on st.s_id = sc.s_id;

# 查询没学过“张三”老师课的学生的学号、姓名
select st.s_id,st.s_name,t2.s_id
from Student as st
       left join (
    select distinct Score.s_id
    from Score
           join
           (select c_id
            from Course
                   join (select t_id from Teacher where t_name = "张三") as t on t.t_id = Course.t_id) as t1
           on Score.c_id = t1.c_id) as t2
                 on st.s_id = t2.s_id
where t2.s_id is null;

# 查询所有课程成绩小于60分的学生的学号、姓名
select st.s_id,st.s_name from Student as st
left join (select distinct s_id from Score where s_score<60) as sc
on st.s_id=sc.s_id where sc.s_id is not null;

# 查询没有学全所有课的学生的学号、姓名
# 这里count(s_score)=3 和 count(s_score)<3 的结果是不一样的；count是不会统计不存在的数据的
select st.s_id,st.s_name from Student as st
left join (select s_id from Score group by s_id having count(s_score)=3) as t1
on st.s_id = t1.s_id where t1.s_id is null;

# 查询和“01”号同学所学课程完全相同的其他同学的学号
# 完全相同的含义是：课程名相同，课程数相同
select s_id from Score
where c_id in (select c_id from Score  where s_id='01') and s_id!="01"
group by s_id
having count(c_id)=(select count(c_id) from Course);

# 按平均成绩从高到低显示所有学生的“数据库”（c_id='04'）、“企业管理”（c_id='01'）、“英语”（c_id='06'）三门的课程成绩，按如下形式显示：学生ID，数据库，企业管理，英语，有效课程数，有效平均分
select s_id,case when c_id="04" then s_score else 0 end as 数据库,
       case when c_id="01" then s_score else 0 end as 企业管理,
       case when c_id="06" then s_score else 0 end as 英语,
       count(c_id) as 有效课程数,avg(s_score) as 有效平均分
from Score group by s_id order by avg(s_score) desc;

# 查询各科成绩最高和最低的分： 以如下的形式显示：课程ID，最高分，最低分
select c_id,max(s_score),min(s_score) from Score group by c_id;

# 按各科平均成绩从低到高和及格率的百分数从高到低排列，以如下形式显示：课程号,课程名,平均成绩,及格百分数
# 获取 平均成绩,及格百分数
select c_id,count(case when s_score>=60 then 1 end) as num1 , count(*) as total,avg(s_score) as average from Score group by c_id;

select co.c_id,co.c_name,average,num1/total from Course as co
join (select c_id,count(case when s_score>=60 then 1 end) as num1 , count(1) as total,avg(s_score) as average from Score group by c_id) as t1
on co.c_id=t1.c_id
order by average,num1/total desc;

# 查询学生平均成绩及其名次
# Mysql中是没有这个函数
select s_id,avg(s_score) as average ,rank() over(partition by s_id order by avg(s_score)) as a from Score;

# 查询各科成绩前三名的记录
# Mysql中是没有这个函数的
select s.* from Score as s
join (select s_id,c_id,row_number() over(partition by c_id order by s_score desc) as r1 from Score) t1
on s.c_id =t1.c_id and s.s_id= t1.s_id
where t1.r1<=3

# 查询同名同姓学生名单并统计同名人数
select s_name,count(s_id) from Student group by s_name having count(s_id)>1;



