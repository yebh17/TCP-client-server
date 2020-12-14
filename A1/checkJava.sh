#!/bin/bash

if type -p java; then
    echo OK, found java executable in PATH
    _java=java
elif [[ -n "$JAVA_HOME" ]] && [[ -x "$JAVA_HOME/bin/java" ]];  then
    echo OK, found Java executable in JAVA_HOME     
     _java="$JAVA_HOME/bin/java"
else
    echo "ERROR, no Java found! Please Install 'default-jdk' Java"
fi
