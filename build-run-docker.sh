#!/bin/bash
set -eu

mvn clean package

sudo docker run --rm \
    -p 8080:8080 \
    -v $(pwd)/target/cars.war:/glassfish/domains/domain1/autodeploy/cars.war \
    oracle/glassfish:5.0