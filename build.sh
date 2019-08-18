#! /usr/bin/env bash
javac -sourcepath ./src/main src/main/Runner.java -d ./target/;
java -classpath target/ Runner;
