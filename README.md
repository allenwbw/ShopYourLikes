# Shop Your Likes Journal Server

The back-end RESTful api server for the Shop Your Likes Journal web application.

The front-end application is maintained at <https://github.com/allenwbw/shopyourlikes-frontend>

You can find a live demo of the application here <http://cs130.syljournel.com>

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

You need JDK version 10 and MySQL to run and build this application. 

### Setting up MySQL
1. **Create MySQL database**

    ```
    create database SHOPYOURLIKES;
    ```

2. **Change MySQL username and password as per your MySQL installation (root account)**

    + open `src/main/resources/application.properties`
    + change `spring.datasource.username` and `spring.datasource.password` properties as per your mysql installation


### Running the app
You can run the back-end app by using the following command under the root directory of the app

    mvn spring-boot:run

The server will start on port 5000.
    
    
## Running the tests


### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Build the app with the following command

```
mvn package
```

The built jar file will be in the directory `target/ShopYourLikes-0.0.1-SNAPSHOT.jar`

The jar file will be deployable to any machine with JDK 10 installed.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

* [Spring Boot](https://projects.spring.io/spring-boot/) - Spring application boostrapper

## Authors

* **Bowei Wang** 
* **Alex Gold** 
* **Qinhao Xu** 

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

