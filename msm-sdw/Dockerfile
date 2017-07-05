FROM anapsix/alpine-java:8

COPY build/libs/msm-sdw-0.1.0.jar .

ENV KAFKA_ADDR kafka:9092
ENV ETCD_ADDR etcd:2379

CMD java -jar msm-sdw-0.1.0.jar
