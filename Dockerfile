FROM java:8-jdk-alpine

RUN apk --update add openjdk8-jre
COPY pairingBrackets/pairingBracket.java /usr/app/
WORKDIR /usr/app

RUN javac pairingBracket.java

ENTRYPOINT ["java", "pairingBracket"]