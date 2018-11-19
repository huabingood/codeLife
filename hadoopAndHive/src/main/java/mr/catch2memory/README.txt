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

-- 分析
1.将t_product分发到各个节点的内存中，然后直接在map端进行join，不再对reduce端做出处理；这样就减少了因shuffle带来的各种内存问题
2.在hive中这种小于！100M的数据通常在join会自动分发到各个节点（必须开启设置）
3.这个跟Sparkd的分发很类似
4.分发数据到各个节点的设置如下：DistributedCache.addCacheFile(new URI("hdfs://ns1/input/t_product.txt"),conf);
5.map中专门写相关的代码来读取分发到内存中的数据。通常我们在map处理过程中的cleanup()是对map进行初始化设置的，可以理解为构造代码块





-- cleanup和setup
setup()
此方法被MapReduce框架仅且执行一次，在执行Map任务前，进行相关变量或者资源的集中初始化工作。若是将资源初始化工作放在方法map()中，导致Mapper任务在解析每一行输入时都会进行资源初始化工作，导致重复，程序运行效率不高！
cleanup()
此方法被MapReduce框架仅且执行一次，在执行完毕Map任务后，进行相关变量或资源的释放工作。若是将释放资源工作放入方法map()中，也会导致Mapper任务在解析、处理每一行文本后释放资源，而且在下一行文本解析前还要重复初始化，导致反复重复，程序运行效率不高！

所以，建议资源初始化及释放工作，分别放入方法setup()和cleanup()中进行