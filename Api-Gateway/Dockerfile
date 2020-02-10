FROM java:8-jre
MAINTAINER Urfan Hamzayev <urfan.hamzayev@gmail.com>

ADD ./target/com-catalog-one-apigateway-0.0.1-SNAPSHOT.jar /app/com-catalog-one-apigateway-0.0.1-SNAPSHOT.jar

EXPOSE 8010

CMD java -jar -Xmx200m -Dspring.profiles.active=docker -Dserver.port=8010 -Dservice.instance.name=Api-Gateway /app/com-catalog-one-apigateway-0.0.1-SNAPSHOT.jar