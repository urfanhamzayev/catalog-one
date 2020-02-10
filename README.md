# Catalog One Monitoring

## Scenario:
Monitoring service tracks microservices unavailability.
- Monitoring service is implemented as a spring-boot application. No other 3rd party libraries are to be used.
- Monitoring service has a REST API allowing to register/deregister the microservices to be monitored
- Monitoring service has a REST API showing the list of registered MSs with the current availability status
- Monitoring service has a REST API which provides the total amount of time the selected microservice was unavailable since beginning and for the last minute
- Monitoring service has a REST API to reset the unavailability information for a selected MS
- There might be hundreds of microservices to be monitored
- Monitoring service stores all the necessary information in a simple in-memory data structure (data gets purged if the monitoring service restarted). No 3rd party libraries here.
- The solution has to come along with the integration tests where the monitored microservices are to be stubbed
## Requirements
1. Web GUI (Single Page Application Framework/Platform).
 - An overview of all vehicles should be visible on one page (full-screen display), together with their status.
 - It should be able to filter, to only show vehicles for a specific customer.
 - It should be able to filter, to only show vehicles that have a specific status.
2. Random simulation to vehicles status sending.
3. If database design will consume a lot of time, use data in-memory representation.
4. Unit Testing.
5. .NET Core, Java or any native language.
6. Complete analysis for the problem.
 - Full architectural sketch to solution.
 - Analysis behind the solution design, technologies,....
 - How the solution will make use of cloud.
 - Deployment steps.


# Solution Architecture


![Alt text](images/architecture.png?raw=true "Micoservice architecture")

## Technologies


The mentioned technologies are used in the implementation of this project into the below modules.
- **Api-Gateway** : build over Eureka to service forwarding request to other microservice.Hystrix also implemented to check heart beat connection with other microservices.
- **Eureka-server** : build over Eureka server to register all microservice. 
- **Billing-service** : Spring boot (web, Data), return sample mock data .
- **Monitoring-service** :  Spring boot (web, Data) , h2-database, Swagger 

## Deployment (Development env)

first of all you need to build the mentioned projects (each project has it's own pipeline):

1. Api-Gateway
   ```shell
   cd Api-Gateway
   mvn package
   ```
2. Eureka-server
   ```shell
   cd Eureka-server
   mvn package
   ```
3. Billing-service
   ```shell
   cd Billing-service
   mvn package
   ```
4. Monitoring-service
   ```shell
   cd Monitoring-service
   mvn package
   ```
   
 **now** got to the workspace root to run the whole environment locally using **docker-compose**
 ```shell
 docker-compose build
 docker-compose up
 ```
 or 
 
 ```shell
 docker-compose up --build
 ```
 
 Check up the components
 
  
 - **h2-db** : check the in memory database  http://localhost:8012/h2/login.do
 
 - **hystrix-stream** : check the in heart beat connection with all micro service  http://localhost:8010/hystrix.stream
 
 - **vehicle service** : check the swagger of the customer service  http://http://localhost:8012/swagger-ui.html#
   ![Alt text](images/swagger.png?raw=true "Monitoring's API swagger")
 - **eureka-serice** : check the *Eureka* dashboard http://localhost:8761/admin/#/
   ![Alt text](images/AdminMonitoring.png?raw=true "Eureka dashboard ")
## Deployment (Production env)
 **Not implemented**


## CI/CD
 
**Not implemented**

  

 
 
 
 










