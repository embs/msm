FROM anapsix/alpine-java:8

COPY build/libs/bank-accountsservice-0.1.0.jar .

ENV SC_ADDR bank-accountsservice-sc:8080

CMD java -jar bank-accountsservice-0.1.0.jar
