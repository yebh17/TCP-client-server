#!/bin/bash

if type -p java; then
    echo found java executable in PATH
    _java=java
elif [[ -n "$JAVA_HOME" ]] && [[ -x "$JAVA_HOME/bin/java" ]];  then
    echo Found Java executable in JAVA_HOME     
    _java="$JAVA_HOME/bin/java"
else
    echo "No Java found! Please install Java using 'sudo apt install default-jre'"
fi

if [[ "$_java" ]]; then
    version=$("$_java" -version 2>&1 | awk -F '"' '/version/ {print $2}')
    echo version "$version"
    if [[ "$version" > "1.5" ]]; then
        echo version is more than 1.5
    else         
        echo version is less than 1.5
    fi
fi

if type -p javac; then
    echo found javac executable in PATH
else
    echo "No Javac found! Please Install Javac using 'sudo apt install default-jdk'"
fi
