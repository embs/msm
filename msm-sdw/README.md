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

### Build

    $ gradle build

### Run

    $ gradle bootRun

Or as a jar:

    $ java -jar build/libs/msm-sdw-0.1.0.jar
