#!/bin/bash

TIME_STAMP=`date +%Y%m%d%H%M`
WHO=`whoami`
if [ "$WHO" != 'root' ]; then
	echo 'current user is not kirk'
	echo 'exit'
	exit
fi

USER_HOME=/home/kirk/
PROJECT_NAME=question-bank

cd $USER_HOME/$PROJECT_NAME

pid=`ps -ef |grep $PROJECT_NAME |grep -v "grep" |awk '{print $2}'`
if [ $pid ]; then  
    echo "Question Bank APP  is  running  and pid=$pid"
    echo 'exit'
    exit
fi
nohup java -jar $USER_HOME/$PROJECT_NAME/$PROJECT_NAME-0.0.1-SNAPSHOT.jar > /dev/null 2>&1 &

