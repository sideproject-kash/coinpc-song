#!/bin/bash
echo 'kill process'
PID=$(lsof -t -i:9918)
if [ ! -z "$PID" ]; then
  echo 'kill' $PID
  kill $PID
fi

echo 'kill process done'