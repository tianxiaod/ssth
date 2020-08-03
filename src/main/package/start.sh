#!/usr/bin/env bash
##/bin/bash

##JAVA_OPTS
JAVA_OPTS="-Xms512m -Xmx512m -Xmn256m -Djava.awt.headless=true -XX:MaxPermSize=128m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./rule.hprof"

##JDK PATH
##JAVA_HOME="/opt/jdk1.6.0_17"
## Find the java binary
if [ -n "${JAVA_HOME}" ]; then
  RUNNER="${JAVA_HOME}/bin/java"
else
  if [ `command -v java` ]; then
    RUNNER="java"
  else
    echo "JAVA_HOME is not set" >&2
    exit 1
  fi
fi

#APP_HOME
APP_HOME="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
echo "${APP_HOME}"

cd ${APP_HOME}

##CLASSPATH JAR
CLASSPATH="."
#for i in $APP_HOME/lib/*.jar; do
#        CLASSPATH="$CLASSPATH":"$i"
##echo "$i"
#done

#Log file
LogDir="$APP_HOME/logs"
LogFile="$LogDir/iease_log_`date +%Y%m%d`.log"
if [ ! -d "$LogDir" ]; then
        mkdir "$LogDir"
fi

echo "kill iease-partner-settle-rule"
#ps -ef| grep "$APP_HOME/config/logback-spring.xml iease-partner-settle-rule.jar"| grep -v 'grep'| awk -F' ' '{print $2}'|kill `xargs`
kill -s 9 `ps -aux | grep "$APP_HOME/config/logback-spring.xml iease-partner-settle-rule.jar" | awk '{print $2}'`


echo -n "Starting $MAINCLASS ..."
echo "" > $LogFile
#nohup $RUNNER $JAVA_OPTS -classpath $CLASSPATH $MAINCLASS "$@" >> $LogFile 2>&1 &
nohup $RUNNER $JAVA_OPTS -jar -Dlogging.config=$APP_HOME/config/logback-spring.xml iease-partner-settle-rule.jar "$@" >> $LogFile 2>&1 &
#touch $APP_HOME/logs/cloud_log_`date +%Y%m%d`.log

#tail -100f $LogFile
#print log,close after printing is complete
tail -fn 0 --pid=`ps uxh|grep 'sed[[:space:]]\/Started'|awk '{print $2}'|sort -nr|head -1` $LogFile|sed /Started[[:space:]]SettleRuleApplication[[:space:]]in/Q
