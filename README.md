# Simple ASCII based TCP client/server application

## About the Project

A simple ASCII based TCP client/server application using [sockets] (https://docs.oracle.com/javase/tutorial/networking/sockets/definition.html)

## System Requirements

The components and libraries involved in the application are,

-	Java 8
-	Java socket library
-	lsof  
-	Shell

## Getting Started

Follow the below steps to run the application.

###### Prerequisites

Install the *Java version 8* for running the application.

-	[Java8] (https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html#A1097144)

## Steps

-	`git clone https://github.com/yebh17/TCP-client-server.git`
-	`cd A1`
-	`make clean; make`

**# Server Terminal**
-	`./server ipto_listenon:port`

**# Client Terminal**
-	`./client referenceIP:referencePort`
