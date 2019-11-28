#! /bin/bash
DIR="$( cd "$( dirname "$0"  )" && pwd  )"
if [ ! -f "$DIR/app.pid" ]; then
 echo "service is not running"
 exit 1
fi
pid="$( cat "$DIR"/app.pid )"
#or kill -9 $pid
kill $pid
rm -rf $DIR/app.pid
ps -ef |grep $pid