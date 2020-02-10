FROM java:8-jre
MAINTAINER Urfan Hamzayev <urfan.hamzayev@gmail.com>

ADD ./target/com.catalog.one.billing-0.0.1-SNAPSHOT.jar /app/com.catalog.one.billing-0.0.1-SNAPSHOT.jar

EXPOSE 8011

CMD java -jar -Xmx200m -Dspring.profiles.active=docker -Dserver.port=8011 -Dservice.instance.name=Billing-Service /app/com.catalog.one.billing-0.0.1-SNAPSHOT.jar