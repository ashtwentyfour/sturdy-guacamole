# Simple Spring REST API

## Build & Package

- Build:

```
mvn clean package -e
```

- Build image:

```
mvn spring-boot:build-image -Dspring-boot.build-image.imageName=ashbourne1990/spring-sample-restful-service:latest
```

## Deploy

- Create a new Cloud SQL instance for MySQL and create a database called 'census_db' - https://cloud.google.com/sql/docs/mysql

- Create a new user and note the password

- Create a secret with the MySQL credentials:

```
kubectl create secret -n census generic db-credentials \
  --from-literal=user=<USER> \
  --from-literal=password=<PASSWORD> \
  --from-literal=host=<SERVER_HOST>
```

- Deploy the service:

```
kubectl apply -f deployment/deployment.yml
```

## Test

- To list all the records:

```
curl http://${LB_IP}/data/census/all
```

- To add a census record:

```
curl -v -X POST http://${LB_IP}/data/census/add -d county=Autauga -d state=AL -d population=620010 -d populationmen=310000 -d tractId=2308092614 -d year=2017
```

- To retrieve a record by Tract ID:

```
curl http://${LB_IP}/data/census/${TRACT_ID}
```
