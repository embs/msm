This is a Java implementation for msm sidecar.

### Built with

- Java 8
- Spring Framework
- Gradle

### Depends on

- msm-(j)sc

Check out msm top level (or others msm components) README for guidance on
providing components dependencies through Docker.

### Build

    $ gradle build

### Run

    $ gradle bootRun

Or as a jar:

    $ java -jar build/libs/bank-gateway-0.1.0.jar

### Docker

Build image (make sure you've already built the project for generating the jar)

    $ docker build -t embs/bank-gateway .

Create msm network if you haven't already:

    $ docker network create msm

Run

    $ docker run --name bank_gateway_msm-jsc --network msm -d embs/msm-jsc
    $ docker run --name bank_gateway --network msm -d -p 9091:8080 embs/bank-gateway
