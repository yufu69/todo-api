#!/bin/bash

TAG=${1-latest}

docker rm -f todo-db
docker run --name todo-db -e POSTGRES_PASSWORD=postgres -p 5433:5432 todo-db:${TAG}