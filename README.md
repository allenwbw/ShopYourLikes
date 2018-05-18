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
    
    
## Running Units Tests

The purpose of the unit test is a level of software testing where individual units/components of a software 
are tested.<br/>
#####Mockito Test Framwork <br/>
We use Mocktio framework pattern to write units test for our service application. It allows us
to create mock object when we have multiple object dependency inside one method. This really allows
us to focus testing the behavior of our service application. <br/>

To understand more about Behavior-driven development:
* [BDD](https://en.wikipedia.org/wiki/Behavior-driven_development) - Behavior-driven development
* [Mockito](http://static.javadoc.io/org.mockito/mockito-core/2.18.3/org/mockito/BDDMockito.html)

```
    // creating a mock object of ConnexityService
    @Mock
    private ConnexityService connexityService;

    
    // initialize the mock envrionment
    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
    }
    
    // test the mock object creation
    @Test
    public void testMockCreation() {
        assertNotNull(connexityService);
    }

    @Test
    public void testCreateLinks() {
    // creating raw data 
        User user = new User();
        user.setUserId(1000);
        user.setApiKey("10000");
        List<String> testUrls =  new ArrayList<>();
        testUrls.add("www.macys.com");
        List<GenerateLinkResponse> linkResponses =  new ArrayList<>();
        GenerateLinkResponse generateLinkResponse = new GenerateLinkResponse();
        generateLinkResponse.setEcpc(2);
        generateLinkResponse.setLink("www.targets.com");
        generateLinkResponse.setMatchType("food");
        generateLinkResponse.setMerchantName("targets");
        generateLinkResponse.setPublisherId("1000");
        generateLinkResponse.setOriginalUrl("www.target.com");
        linkResponses.add(generateLinkResponse);
    
    // manipulating the return object 
        when(connexityService.createLinks(user, testUrls)).thenReturn(linkResponses);
    
    // assert the expected result with our actual result  
        assertEquals(linkResponses,connexityService.createLinks(user,testUrls));
    ...............................
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
* **Robert Posada** 

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

