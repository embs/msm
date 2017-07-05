FROM anapsix/alpine-java:8

COPY build/libs/msm-jsc-0.1.0.jar .

ENV KAFKA_ADDR kafka:9092

CMD java -jar msm-jsc-0.1.0.jar
