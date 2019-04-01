#! /bin/bash
opp="-Xmx256m -Xss256k"
main_class=org.test.Bootstrap


DIR="$( cd "$( dirname "$0"  )" && pwd  )"
if [ -f "$DIR/app.pid" ]; then
 echo "service is running now"
 exit 1
fi
pid=$DIR/app.pid

nohup java $opp -cp $DIR/classes:$DIR/libs/* $main_class &> /dev/null & echo $! > $pid
awk '{print "start successful,pid:"$1}' $pid