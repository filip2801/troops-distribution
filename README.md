# Troops distribution service

Service for distributing troops. Implemented as Goodgame Studio interview task. More [info](./Solution%20Challenge.pdf).

## Problem
Every player in Empire has a castle. To let players attack another player’s castle, we need you to create armies of randomly distributed
troops (a troop is a formation of soldiers with the same skill, such as Spearmen, Swordsmen, Archers, etc.)
For example, we'll call your code telling it we need a random army that's 167 men strong. Assuming our available unit types to be, for
example, Spearmen, Swordsmen and Archers, what we want from you is that you tell us what such a random army would look like, e.g.

## Tech stack
Spring boot application written in Java.

Technologies
* jdk11
* gradle 7.2
* spring-boot 2.6.0
* groovy & spock - for testing

## Running unit and integration tests
Requirements: JDK 11

Run `./gradlew clean check`

## Building docker image
Requirements: docker

Run `docker build -t troops-distribution .`

## Running app
Requirements: docker and built docker image

Run `docker run -d -p 8081:8081 troops-distribution`

## Endpoints
### Troops distributions
To distribute troops run
```
curl -X POST http://localhost:8081/troop-distributions \
   -H 'Content-Type: application/json' \
   -d '{"numberOfSoldiers": 100}'
```
