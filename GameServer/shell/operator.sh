#! /bin/bash
# qiunet
# qiunet@gmail.com
# 2018-01-18 12:08:50
#
#---------------BODY-----------------
cd `dirname $0`

JAVA_OPTS="-server -Xmx512m -Xms512m -Xmn300m -Xss256k -XX:MaxDirectMemorySize=1g -XX:+UseParallelGC -XX:+UseParallelOldGC -XX:-OmitStackTraceInFastThrow -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=logs/"
# 服务监听端口
port=29001
# 钩子服务监听端口
hookPort=1314

start(){
        if [ ! -d 'logs' ];then mkdir logs ; fi
        cd classes
        nohup java ${JAVA_OPTS}  -classpath .:../lib/* com.game.template.server.GameBootstrap --port=${port} --hookPort=${hookPort} start 2>1 &
        cd -
}

other(){
        cd classes
        java -classpath .:../lib/* com.interest.game.pet.server.BootStrap --port=${port} --hookPort=${hookPort} "$1"
        cd -
        sleep 3
}


case "$1" in
        start)
                start
        ;;
        stop)
                other "$1"
        ;;
        reload)
                other "$1"
        ;;
        *)
               other "$1"
        ;;
esac
