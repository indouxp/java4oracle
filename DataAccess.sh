#!/bin/sh

export ORACLE_HOME=/home/indou/app/product/12.2.0/client_1
export CLASSPATH=$CLASSPATH:$ORACLE_HOME/jdbc/lib/ojdbc8.jar:$ORACLE_HOME/jlib:.

javac ./DataAccess.java

java -Djava.security.egd=file:/dev/urandom DataAccess
