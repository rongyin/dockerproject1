FROM java:8

MAINTAINER yin/13916555119@163.com

VOLUME ["/tmp/java"]

EXPOSE 8848

COPY ./target/demo-0.0.1-SNAPSHOT.jar app1.jar

ENTRYPOINT ["java","-jar","/app1.jar"]