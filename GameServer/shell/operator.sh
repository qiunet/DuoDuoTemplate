#! /bin/bash
# qiunet
# qiunet@gmail.com
# 2018-01-18 12:08:50
#
#---------------BODY-----------------
cd `dirname $0`
GAME_HOME=`pwd`
GAME_LOGS=${GAME_HOME}/logs
if [[ ! -d ${GAME_LOGS} ]];then mkdir -p ${GAME_LOGS} ; fi

JAVA_OPTS="-server\
 -Xmx512m -Xms512m\
 -Xmn300m -Xss256k\
 -XX:MaxDirectMemorySize=1g\
 -XX:+UseParallelGC\
 -XX:+UseParallelOldGC\
 -XX:-OmitStackTraceInFastThrow\
 -XX:+HeapDumpOnOutOfMemoryError\
 -XX:HeapDumpPath=dumps/"

CLASSPATH=.:"${GAME_HOME}/lib/*
CLASSPATH=${CLASSPATH}:${GAME_HOME}/resources

BOOTSTRAP_CLASS="com.game.server.GameBootstrap"


start(){
        nohup java ${JAVA_OPTS}  -classpath ${CLASSPATH} ${BOOTSTRAP_CLASS} start 2>1 &
        cd -
}

other(){
        java -classpath ${CLASSPATH} ${BOOTSTRAP_CLASS} "$1"
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
