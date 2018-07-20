-- 如下值存在重复
A
B
B-4
B0
B1
B2
B3
B4
B5
B6
B7
B80
B81
B82
B83
B84
B9
B91
B92
B93
B94
B95
B96
B97
B98
B99
C
C0
C1
C2
C3
C4
C5
C6
C8
C91
C92
C93
C95
C96
C97
C970
C975
C976.1
C976.7
D
D0
D1
D2
D33/37
D4
D5
D6
D73/77
D8
D9
DF
DF0
DF1
DF2
DF3
DF4
DF5
DF6
DF7
DF792
DF793
DF794
DF795
DF8
DF9
DF90
DF92
DF93
DF94
DF95
DF959
DF96
DF969
DF97
DF979
DF98
DF991
DF992
E
F
G
H
I
J
K
N
O
P
Q
R
S
T
U
V
X
Z
Z1
Z2
Z3
Z4
Z5
Z6
Z8
Z81
Z82
Z83
Z84
Z85
Z86
Z87
Z88
Z89
[C7]
[C94]
[C971]
[C972]
[C973]
[C974]
[C976.2]
[C976.8]
[C979]
{DF79}


-- 已发现没有的分类
Z842 综合性图书图书目录、文摘、索引私家藏书目录中国
Z843/847 综合性图书图书目录、文摘、索引私家藏书目录各国

insert into t_clc_test values('Z842','综合性图书图书目录、文摘、索引私家藏书目录中国'),
('Z843/847','综合性图书图书目录、文摘、索引私家藏书目录各国');



--
truncate t_clc;

insert into my_test.t_zt_type(code,type_name) select chinatype,description from my_test.t_clc_test group by chinatype,description;



