#! /bin/bash
# qiunet
# qiunet@gmail.com
# 2018-01-18 12:08:50
#
#---------------BODY-----------------
cd `dirname $0`
GAME_HOME=$(dirname $(pwd))
# 玩家行为日志目录
GAME_LOGS=${GAME_HOME}/logs
# 系统打印的日志
GAME_SYS_LOGS=${GAME_HOME}/sysLogs
# 热更新目录
GAME_SWAP=${GAME_HOME}/classes

if [[ ! -d ${GAME_LOGS} ]];then mkdir -p ${GAME_LOGS} ; fi
if [[ ! -d ${GAME_SWAP} ]];then mkdir -p ${GAME_SWAP} ; fi
if [[ ! -d ${GAME_SYS_LOGS} ]];then mkdir -p ${GAME_SYS_LOGS} ; fi

JAVA_OPTS="-server\
 -Xmx512m -Xms512m\
 -Xmn300m -Xss256k\
 -XX:MaxDirectMemorySize=1g\
 -XX:+UseParallelGC\
 -XX:+UseParallelOldGC\
 -Dlog.dir=${GAME_LOGS}\
 -DhotSwap.dir=${GAME_SWAP}\
 -DsysLogs.dir=${GAME_SYS_LOGS}\
 -XX:-OmitStackTraceInFastThrow\
 -XX:+HeapDumpOnOutOfMemoryError\
 -XX:HeapDumpPath=dumps/"

CLASSPATH="."
CLASSPATH="${CLASSPATH}:${JAVA_HOME}/lib/tools.jar"
CLASSPATH="${CLASSPATH}:${GAME_HOME}/lib/*"
CLASSPATH=${CLASSPATH}:"${GAME_HOME}/conf"

BOOTSTRAP_CLASS="com.game.server.GameBootstrap"


start(){
        java ${JAVA_OPTS}  -classpath ${CLASSPATH} ${BOOTSTRAP_CLASS} start &
        cd -
}

other(){
        java ${JAVA_OPTS} -classpath ${CLASSPATH} ${BOOTSTRAP_CLASS} "$1"
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
        hotswap)
                other "$1"
        ;;
        *)
               other "$1"
        ;;
esac
