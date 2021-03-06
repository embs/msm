This is a Java implementation for msm sidecar.

### Built with

- Java 8
- Spring Framework
- Gradle

### Depends on

- Kafka
- msm-sdf

Check out msm top level (or others msm components) README for guidance on
providing components dependencies through Docker.

### Build

    $ gradle build

### Run

    $ gradle bootRun

Or as a jar:

    $ java -jar build/libs/msm-jsc-0.1.0.jar

### Docker

Build image (make sure you've already built the project for generating the jar)

    $ docker build -t embs/msm-jsc .

Create msm network if you haven't already:

    $ docker network create msm

Run

    $ docker run --name msm-jsc --network msm -d -p 9001:8080 embs/msm-jsc

### Config Kafka broker address

Set a `KAFKA_ADDR` envar. For instance (set `custom` host on port `1234`):

    $ KAFKA_ADDR=custom:1234 gradle bootRun 

Default address is localhost:9092.

### Config msm-sdf address

As with Kafka address, just set the `SDF_ADDR` envar:

    $ SDF_ADDR=custom:6547 gradle bootRun
