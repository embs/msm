msm **S**ervice **D**iscovery **W**riter (sdw): a service who listens to Kafka
services registering topic info and writes them to etcd.

### Built with

- Java 8
- Spring Boot
- Gradle

### Depends on

- Kafka
- etcd

Check out msm top level README for guidance on providing components dependencies
through Docker.

_A note on jetcd client:_ msm-sdw uses the [jetcd][jetcd] Java etcd client for
interacting with etcd. At this moment, their code is not available as an
artifact from code repositories. So it's necessary to download and install it
locally.

### Build

    $ gradle build

### Run

    $ gradle bootRun

Or as a jar:

    $ java -jar build/libs/msm-sdw-0.1.0.jar

### Docker

Build image (make sure you've already built the project for generating the jar)

    $ docker build -t embs/msm-sdw .

Run (make sure msm bridge network already exists):

    $ docker run --name msm-sdw --network msm -d -p 9002:8080 embs/msm-sdw

### Configuring dependencies addresses

You may configure Kafka and etcd addresses through envars. E.g.:

    $ KAFKA_ADDR=custom:1234 ETCD_ADDR=etcd:8788 gradle bootRun

[jetcd]: https://github.com/coreos/jetcd
