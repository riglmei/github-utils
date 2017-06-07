# GitHub Utility

This application provides a basic client to query the GitHub REST API, being possible to get the list of users that
have the specified location in their profile. Additionally, the result will be brought ordered by the number of 
user repositories and it is possible to specify the number of desired results. 

## Structure of the application

* actions : Package with the use cases ( getting the list of users)
* app: Main class of the SpringBoot applications , plus de the Spring Configuration
* domain: It contains the classes representing the domain of the application
* infrastructure: vertical layer used by the others for external interactions. In this case it provides a REST client to
performs queries against the GitHub API
* rest: Rest Controllers

## Authentication

For the sake of the exercise a pretty basic http authentication has been implemented. It relies
in Spring Security wih an in memory authentication:

* user1 password1
* user2 password2


## How to execute the application

Once it is built using maven a jar file is generated in the target folder . Just execute it with a 
java -jar command. 

For linux users 

`curl -u user1:password1 http://localhost:8080/api/users/location/Barcelona?per_page=5`

or just put the url directly in the browser

`http://localhost:8080/api/users/location/Barcelona?per_page=5` 

(it will request  the user and password)


The per_page parameter is optional, and if not provided the default value will be 10


## Improvements

* The main improvement would be the authentication. An http basic authentication, were the password comes in clear text , 
should not be accepted at all in any real application. It could be used a claim based authentication  such as JWT instead
 
* The results perhaps are not very meaningful. The users are filtered by location and ordered by number of repositories, 
  but any of this information is displayed. Anyways it can be checked by following the links of the User Profile. 
  
  
  