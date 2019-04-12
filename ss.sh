#!/bin/bash
BASE_HOME="/data/webapps/dubbo"


cd $BASE_HOME
work=$1
APP_START_DT=`date +"%Y%m%d"`
APP_JAR=`ls dubbo-provider.jar`
JAVA_CMD="/usr/local/jdk1.8/bin/java"
CONFIG_ACTIVE="--spring.profiles.active=prod"

JAVA_OPTS=" -server \
-Xms4096m -Xmx4096m  \
-XX:PermSize=512M \
-XX:MaxPermSize=1024m \
-Xss2m \
-Xmn256m \
-XX:+AggressiveOpts \
-XX:+UseBiasedLocking \
-XX:+CMSParallelRemarkEnabled \
-XX:+UseConcMarkSweepGC \
-XX:ParallelGCThreads=2 \
-XX:SurvivorRatio=2 \
-verbose:gc \
-XX:+PrintGCDetails \
-XX:+PrintGCDateStamps \
-XX:+PrintHeapAtGC \
-XX:+HeapDumpOnOutOfMemoryError \
-Denv=PRO"

JAVA_OPTIONS=$JAVA_OPTS

JETTY_PID="/data/logs/jetty.pid"


function status {
	 test -n   "`ps -ef |grep "$APP_JAR" |grep -v grep `"  && echo 1  || echo 0
}

function start {
	if [ "`status`" == "1"  ] ; then
		echo "app jetty is woring,do nothing!"
		exit 1
	fi

	 $JAVA_CMD   $JAVA_OPTS  -jar   $BASE_HOME/$APP_JAR $CONFIG_ACTIVE >> /dev/null   2>&1   &
	 echo "started $APP_JAR"
}

function stop {
	pid=` ps -ef |grep java | grep "$BASE_HOME/$APP_JAR" |awk '{print $2}'`
	if [ -n "$pid"  ] ; then
		kill -9 $pid
	fi
	echo "stoped $APP_JAR"
}


case "$work" in
	"start" ) 
		start ;
		exit 0;
		;;
	"status")
		echo `status`;
		exit 0;
		;;
	"stop" )
		stop;
		exit 0;
		;;
	"restart" )
		stop 
		sleep 5
		start;
		exit 0
		;;
	* ) 
		echo "unknow command !"
		exit 0;
		;;
esac

