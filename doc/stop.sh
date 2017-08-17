#!/usr/bash
TIME_STAMP=`date +%Y%m%d%H%M`  
WHO=`whoami`  
if [ "$WHO" != 'www' ]; then  
        echo 'current user is not www'  
        echo 'exit'  
        exit  
fi  
CODE_HOME=/home/kirk/question-bank 
PROJECTNAME=question-bank
cd $CODE_HOME/$PROJECTNAME  
pid=`ps -ef |grep $PROJECTNAME |grep -v "grep" |awk '{print $2}' `   
if [ $pid ]; then  
    echo "App  is  running  and pid=$pid"  
    kill -9 $pid  
    if [[ $? -eq 0 ]];then   
       echo "sucess to stop $PROJECTNAME "   
    else   
       echo "fail to stop $PROJECTNAME "  
     fi  
fi  
