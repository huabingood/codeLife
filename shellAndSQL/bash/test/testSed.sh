#!/usr/bin/env bash

# 修改自己的自己，将name的值替换为age的值

age="18"
name="huabingood"

sed -i "s/${name}/${age}/g" $0