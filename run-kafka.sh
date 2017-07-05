#!/usr/bin/env bash

docker run --name kafka --network msm -d -p 2181:2181 -p 9092:9092 \
  --env ADVERTISED_HOST=192.168.15.7 \
  --env ADVERTISED_PORT=9092 \
  spotify/kafka
