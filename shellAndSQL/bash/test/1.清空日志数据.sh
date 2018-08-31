#!/usr/bin/env bash

#########################################################
## 清空指定文件夹下日志中的数据
## @author huabingood@qq.com
## @date 20180831
## @version 1.0
#########################################################

# env
log_path="/home/huabingood"
root_uid=0    # 只用当前用户是root用户，其UID就是0

exit_root_code=1    # 因为当前用户是root用户退出的异常码
exit_no_file=2



# 判断当前用户是否是root用户，是root用户就退出
if [ "${UID}" -eq "${root_uid}" ] ; then
    echo "当前用户是root用户，权限过高，故退出。"
    exit ${exit_root_code}
fi

cd ${log_path}
log_name="${log_path}/error.log"
# 验证当前文件是否为正常文件
if [ ! -f "${log_name}" ];then
    echo "日志文件路径异常，请检查原因！"
    exit ${exit_no_file}
fi

# 将空数据写到error.log中
cat /dev/null > "${log_path}/error.log"

exit    # 如果不跟返回码的话，默认上一句的返回码