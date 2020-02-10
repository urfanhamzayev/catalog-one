FROM java:8-jre
MAINTAINER Urfan Hamzayev <urfan.hamzayev@gmail.com>

ADD ./target/com-catalog-one-eureka-0.0.1-SNAPSHOT.jar /app/com-catalog-one-eureka-0.0.1-SNAPSHOT.jar

EXPOSE 8761

CMD java -jar -Xmx200m -Dspring.profiles.active=docker -Dserver.port=8761 -Dservice.instance.name=Eureka-server /app/com-catalog-one-eureka-0.0.1-SNAPSHOT.jar