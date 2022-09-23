#!/bin/bash
echo 'run process'
cd /home/ec2-user/test
sudo nohup java -jar coinpc-0.0.1-SNAPSHOT.jar > /home/ec2-user/test/springboot.log 2>&1 &
echo 'run process done'