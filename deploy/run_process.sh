#!/bin/bash
echo 'run process'
cd /home/ec2-user/coinpc
nohup java -jar coinpc-0.0.1-SNAPSHOT.jar > /home/ec2-user/coinpc/springboot.log 2>&1 &
echo 'run process done'