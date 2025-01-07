#!/bin/bash

export JAVA_HOME=`/usr/libexec/java_home -v 11`; java -version

mvn clean package

docker build -t x-lighthouse .

docker run --rm -p "8080:8080" x-lighthouse