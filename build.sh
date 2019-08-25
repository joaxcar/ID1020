#! /usr/bin/env bash
javac-algs4 -sourcepath ./src/main src/main/Runner.java -d ./target/;
java-algs4 -classpath target/ Runner;
