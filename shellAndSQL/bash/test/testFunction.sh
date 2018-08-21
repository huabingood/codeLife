#!/usr/bin/env bash

######################################
## 使用ls -al 获取/tmp下的所有文件
## 输出获取的文件夹
######################################



command="ls -al /tmp"

# 判断是否是文件夹
function isDir(){
    file="/tmp/${1}"
    if [ -d ${file} ];then
        echo "$1"
    fi
}

# 获取所有路径，并判断是否是文件
function getFileName(){
    # 执行如遇
    result=$( ${command} )

    # 验证上面的语句是否执行成功
    if [ $? -ne 0 ];then
        echo "出错了！"
        exit 1
    fi

    # 执行成功的话，就将文件输出
    for i in "${result}"
    do
        # 这种写法会将整个ls获取的内容当成一个整体
        fileName=$(echo "${i}" | awk -F " " '{print $9}')

        for j in ${fileName}
        do
            isDir "${j}"
        done
    done
}



# 执行命令
getFileName