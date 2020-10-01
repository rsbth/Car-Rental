FROM tomcat:8-jdk8-corretto
MAINTAINER Santosh

EXPOSE 8080
RUN rm -rf /usr/local/tomcat/webapps/*

WORKDIR /usr/local/tomcat/webapps
ADD target/app.war .
