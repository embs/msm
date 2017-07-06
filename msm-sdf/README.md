msm **S**ervice **D**iscovery **F**inder: a service for fetching services
addresses from etcd services registry.

### Built with

- Java 8
- Spring Framework
- Gradle

### Depends on

- etcd

Check out msm top level README for guidance on providing components dependencies
through Docker.

### Build

    $ gradle build

### Run

    $ gradle bootRun

Or as a jar:

    $ java -jar build/libs/msm-sdf-0.1.0.jar

### Docker

Build image (make sure you've already built the project for generating the jar)

    $ docker build -t embs/msm-sdf .

Create msm network if you haven't already:

    $ docker network create msm

Run

    $ docker run --name msm-sdf --network msm -d -p 9003:8080 embs/msm-sdf

### Config etcd node address

Set a `ETCD_ADDR` envar. For instance (set `custom` host on port `1234`):

    $ ETCD_ADDR=custom:1234 gradle bootRun
