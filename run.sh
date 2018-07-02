#!/bin/sh

export ORACLE_HOME=/home/indou/app/product/12.2.0/client_1
export CLASSPATH=$CLASSPATH:$ORACLE_HOME/jdbc/lib/ojdbc8.jar:$ORACLE_HOME/jlib:.
#export PATH=$ORACLE_HOME/jdk/bin:$PATH

which javac
which java

java -version

#javac ./Access.java
#javac ./DataAccess.java
javac ./DataAccess2.java

#java Access jdbc:oracle:thin:@172.17.0.2:1521:orclcdb system oracle
#java Access jdbc:oracle:thin:@//172.17.0.2:1521/orclpdb1 system oracle
#java Access "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=172.17.0.2)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=orclpdb1)))" system oracle

java -Djava.security.egd=file:/dev/urandom DataAccess2
