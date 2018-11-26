需求：
订单数据表t_order：
id	date	pid	amount
1001	20150710	P0001	2
1002	20150710	P0001	3
1002	20150710	P0002	3

商品信息表t_product
id	pname	category_id	price
P0001	小米5	1000	2000
P0002	锤子T1	1000	3000


-- SQL实现
select o.id,o.date,p.pname,p.price from t_order as o
join t_product as p
on o.pid=p.id

-- 详细需求
1.将两个表上传至HDFS，以逗号作为分割符
2.求每个订单的交易编号，时间，手机型号，价格
3.使用MR完成



-- HDFS上的数据
t_order.txt
1001,20150710,P0001,2
1002,20150711,P0001,3
1002,20150712,P0002,3

t_product.txt
P0001,小米5,1000,2000
P0002,锤子T1	,1000,3000



-- 实现原理
将关联条件作为map输出的key,将两表满足join条件的数据携带来源文件信息，发往同一个task，并在reduce中进行数据串联
1.null的序列化的值为NullWritable,给NullWritable赋值使用NullWritable.get()
2.hadoop在序列化的过程中，Bean的成员变量中不能有空值，否则会报空指针异常
3.在reduce进行join的过程中，不知为什么ArrayList中的数据会不停的变化。
4.如何从map中获取当前处理文件分片的文件名