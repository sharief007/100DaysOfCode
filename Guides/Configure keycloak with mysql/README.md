
[Medium Tutorial](https://medium.com/codex/using-mysql-as-production-ready-database-to-run-keycloak-locally-using-docker-3939aba8a2b8)

``` bash

docker pull mysql:latest

docker run -p 3306:3306 --name mysql -d --net keycloak-network -e MYSQL_DATABASE=keycloak -e MYSQL_USER=keycloak -e MYSQL_PASSWORD=password -e MYSQL_ROOT_PASSWORD=root_password mysql:latest

```


- The option --name followed by a string (mysql) allows us to assign a specific name for our running container.
- The parameter --net allows us to connect the running container to an existing user-defined bridge, in our case keycloak-network.
- The option -d indicates docker to run the container in the background or “detached” mode. If -d is not used the container run in the default foreground mode.
- The option -e is used to pass environment variables to the container.In this particular case we define the following variables: MYSQL_DATABASE (indicates the container to create a new database when starting up, in our case keycloak), MYSQL_USER (the container creates a user with the name of the passed value), MYSQL_PASSWORD (the password for the just created user) and finally MYSQL_ROOT_PASSWORD (this variable is requested by the image to run properly and it will be assigned to the root password of MySQL).
- Finally, we provide docker with the version of the image to use (in our case is the latest available but you can indicate a specific version like mysql:8.0.1).


``` bash
docker run -d -p 8000:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin --name keycloak --net keycloak-network quay.io/keycloak/keycloak:17.0.0 start-dev
```