FROM anapsix/alpine-java:8

COPY build/libs/msm-sdf-0.1.0.jar .

ENV ETCD_ADDR etcd:2379

CMD java -jar msm-sdf-0.1.0.jar
