# CSM-Logbook is a part of
# Construction Site Management Application

## This application is a part of multi-microservice project for managing civil engineering construction sites
## of my own idea and design.

At this moment this application uses following microservices:
1. CSM-Login
2. CSM-Users
3. CSM-Roles
4. CSM-Works
5. CSM-Reservation
6. CSM-Logbook
7. CSM-CloudServer

# It is still in development

Use to build docker image:

    $ docker build -f ./Dockerfile -t csm-logbook .

Use to run container from image:

    $ docker run --name csm-logbook -p 8320:8320 -d csm-logbook