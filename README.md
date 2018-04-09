# Homepage
Soon to be codebase behind https://inniger.be

## Build and Run
1. Install and run Docker
2. Use docker-compose to start up `docker-compose.yml`, this DB needs to run for Flyway to run, after which jOOQ can do its proper code generation
3. Run `./gradlew clean build` or `./gradlew bootRun` to either test or start the application
    * Tests will depend on Docker running, but not the docker-compose (though it does not hurt) and uses TestContainers in the background
    * An actual Application run depends on `docker-compose.yml` running proper for DB access

## TODO
* Expand upon this README with proper links and better info
* Split Build and Run perhaps
* ...
