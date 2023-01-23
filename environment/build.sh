#!/bin/bash

TAG=${1-latest}

docker build --rm -t "todo-db:$TAG" .