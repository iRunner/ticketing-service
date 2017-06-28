# Ticketing Service

A simple ticket service that facilitates the discovery, temporary hold, and final reservation of seats within a high-demand performance venue.

### Example Stage:
```aidl
        ----------[[  STAGE  ]]----------
        ---------------------------------
        sssssssssssssssssssssssssssssssss
        sssssssssssssssssssssssssssssssss
        sssssssssssssssssssssssssssssssss
        sssssssssssssssssssssssssssssssss
        sssssssssssssssssssssssssssssssss
        sssssssssssssssssssssssssssssssss
        sssssssssssssssssssssssssssssssss
        sssssssssssssssssssssssssssssssss
        sssssssssssssssssssssssssssssssss
```

### Features 

1. Find the number of seats available within the venue
⋅⋅⋅Note: available seats are seats that are neither held nor reserved.
2. Find and hold the best available seats on behalf of a customer
⋅⋅⋅Note: each ticket hold should expire within a set number of seconds.
3. Reserve and commit a specific group of held seats for a customer


## Build

#### Basic Test Process

`./gradlew test`

#### Basic Build Process

`./gradlew build`

#### After Build Runnable

`java -jar build/libs/ticket-service-*.jar`


## Docker

#### Build

`./gradlew buildDocker`

#### Run docker image

`docker run -e "SPRING_PROFILES_ACTIVE=prod" -p 8080:8080 -t ticket-service`

`docker run -e "SPRING_PROFILES_ACTIVE=dev" -p 8080:8080 -t ticket-service`

##### For Javadocs

`./gradlew javadoc`
`cd build/docs/javadoc/`
`serve` (from `npm install serve` replace with local server example could best )
`python -m SimpleHTTPServer 8000`

Or I guess just open the file.. you do you...
