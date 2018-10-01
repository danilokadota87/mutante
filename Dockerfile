FROM redspark/oracle-jdk:1.8
MAINTAINER kadota <dockkadota@gmail.com>

ADD build/libs/mutantes.jar /opt/mutantes.jar


EXPOSE 8080

CMD java  -Duser.timezone=America/Sao_Paulo -jar /opt/mutantes.jar
