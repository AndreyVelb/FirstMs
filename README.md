# First microservice
### To run the application:
1. Clone this project and SecondMs project from this github
2. Change path to Docker file of SecondMs project in docker-compose.yml
3. Create artifacts of applications by command in terminal ```mvn clean package -P local```
4. Run docker-compose.yml file by command ```docker-compose up -d```

### Api
1. POST: http://localhost:8086/api/v1/first/call-second 
```
{
    "message":"someMessage",
    "number":1234
}
```
*First microservice call second, and this save data in second database*

2. POST: http://localhost:8088/api/v1/second/call-first
```
{
    "lastName":"lastName",
    "firstName":"firstName",
    "phoneNumber":"phoneNumber"
}
```
*Second microservice call first, and this save data in first database*
