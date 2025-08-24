# springboot-mongodb-docker
Deploying Spring Boot and MongoDB as Containers Using Docker and Docker Compose

**Steps & Commands**

Setting up Mongo DB in a Container:
- [x] pull mongo image from docker hub **`docker pull mongo:latest`**
- [x] run mongo image **`docker run -d -p 27017:27017 --name gsraomongodb mongo:latest`**

Setting up Spring Boot Application in a Container:
- [x] Dockerize spring boot application **`docker build -t springboot-mongodb-docker:1.0 .`**
- [x] Run spring boot docker image and link that container to mongo container
  **`docker run -p 8080:8080 --name springboot-mongodb-docker --link gsraomongodb:mongo -d springboot-mongodb-docker:1.0`**
- [x] check docker running containers  **`docker ps`** it should display two container ids
- [x] check logs of spring boot image **`docker logs springboot-mongodb`**
- [x] if all good access your apis as below:
  - [x] Spring Boot Application health check up **`http://localhost:8080/book/hello`**
  - [x] Spring Boot Application health check up **`http://localhost:8080/book/hello`**
  - [x] Add Book **`http://localhost:8080/book/save`**  (POST)
  - [x] Get All Books **`http://localhost:8080/book/`**  (GET)
 
```
- [x] login to mongo terminal to verify records: **`docker exec -it gsraomongodb bash`**
- type mongosh and enter
- show dbs
- use book
- show collections
- db.book.find().pretty()
```

**Use Docker Compose**
- [x] Show all current running Containers: **docker ps**
- [x] Kill running container: **docker rm -f containerId**




#### docker-compose.yml

```yaml
version: "3"
services:
  gsraomongodb:
    image: mongo:latest
    container_name: "gsraomongodb"
    ports:
      - 27017:27017
  springboot-mongodb-docker:
    image: springboot-mongodb-docker:1.0
    container_name: springboot-mongodb-docker
    ports:
      - 8080:8080
    links:
      - gsraomongodb
```
- [x] Navigate to resources folder nd run below command to start both containers using docker compose:```

```
D:\DEVWORK\INTELLIJ-PROJECTS\springboot-mongodb-docker\src\main\resources>docker-compose up
```
- [x] To stop and remove containers, networks, and volumes defined in the docker-compose file, run: **`docker-compose down`**
- [x] To stop the containers without removing them, run: **`docker-compose stop`**
- [x] To start the containers again, run: **`docker-compose start`**
- [x] To view the logs of the containers, run: **`docker-compose logs`**
- [x] To view the logs of a specific service, run: **`docker-compose logs <service_name>`**
- [x] To rebuild the images and recreate the containers, run: **`docker-compose up --build`**
- [x] To run the containers in detached mode (in the background), add the `-d` flag: **`docker-compose up -d`**
- [x] To view the status of the containers, run: **`docker-compose ps`**
- [ ] To remove stopped containers, run: **`docker-compose rm`**
- [x] To scale a service (e.g., run multiple instances), use the `--scale` option: **`docker-compose up --scale <service_name>=<number_of_instances>`**
- [x] To view the configuration of the services defined in the docker-compose file, run: **`docker-compose config`**
- [x] To view the version of Docker Compose, run: **`docker-compose --version`**
- [x] To view the help information for Docker Compose, run: **`docker-compose --help`**
- [x] To view the logs of a specific service in real-time, run: **`docker-compose logs -f <service_name>`**
- [x] To remove all stopped containers, networks, and volumes, run: **`docker-compose down --volumes`**
- [x] To remove all stopped containers and networks, run: **`docker-compose down --rmi all`**
- [x] To remove all stopped containers, networks, and images, run: **`docker-compose down --rmi local`**
- [x] To view the logs of all services in real-time, run: **`docker-compose logs -f`**
- [x] To view the logs of a specific service with timestamps, run: **`docker-compose logs -t <service_name>`**
- [x] To view the logs of all services with timestamps, run: **`docker-compose logs -t`**
- [x] To view the logs of a specific service with a specific number of lines, run: **`docker-compose logs --tail=<number_of_lines> <service_name>`**
- [x] To view the logs of all services with a specific number of lines, run: **`docker-compose logs --tail=<number_of_lines>`**
- [x] To view the logs of a specific service with timestamps and a specific number of lines, run: **`docker-compose logs -t --tail=<number_of_lines> <service_name>`**
- [x] To view the logs of all services with timestamps and a specific number of lines, run: **`docker-compose logs -t --tail=<number_of_lines>`**
- [x] To view the logs of a specific service with timestamps, a specific number of lines, and in real-time, run: **`docker-compose logs -f -t --tail=<number_of_lines> <service_name>`**