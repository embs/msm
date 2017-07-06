A fictitious bank accounts service.

### Built with

- Java 8
- Spring Framework
- Gradle

### Build

    $ gradle build

### Run

    $ gradle bootRun

Or as a jar:

    $ java -jar build/libs/bank-accountsservice-0.1.0.jar

### Docker

Build image (make sure you've already built the project for generating the jar)

    $ docker build -t embs/bank-accountsservice .

Create msm network if you haven't already:

    $ docker network create msm

Run

    $ docker run --name bank_accountsservice_msm-jsc --network msm -d embs/msm-jsc
    $ docker run --name bank_accountsservice --network msm -d -p 9090:8080 embs/bank-accountsservice
