#!/usr/bin/env bash

#################################################
##  输入：
#       99  《与罗摩相会
#       100  《方尖碑之
#       人物 类  30
#       1  《高兴死了》
#       2  《开心坏了》
#       3  《最后的演讲》
## 输出：
#       "与罗摩相会","方尖碑之门","高兴死了","开心坏了","最后的演讲"
## 注意：
#       1.中间的空行不要，不是书名的不要
## @Author huabingood@qq.com
## @Version 1.0
## @Create 20180910
#################################################

filePath=""

while read line
do
    if [  -n "${line}" ];then
        neme=$(echo "${line}" | awk -F "[《》]" '{print $2}')
        newLine="${name}"","
    fi
done < "${filePath}"

echo "${newLine}"