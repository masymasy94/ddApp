# ddApp
An example of a RESTful WebServer developed using SpringBoot 3 and Java 23.

I created this web server with the intention of using it as a support for d&d 5e games.

I intend to put functionalities that are helpful to masters and players,
like generation of store/cities/npcs/loot/encounters/ect for masters, and the possibility to store characters/treasures/equip/spells in an efficient and practical way for players.

I would like to implement a one-way communication from master to players too, making possible to show players things/maps/messages and more in a selective way.


## Dependencies
There are a number of third-party dependencies used in the project. Browse the Maven pom.xml file for details of libraries and versions used.

## Building the project
You will need:

*	Java JDK 23 or higher
*	Maven 3.8.1 or higher
*	Git

Clone the project and use Maven to build and run the application with this command:

	$ mvn clean verify spring-boot:run



## Browser URL
Open your browser at the following URL for Swagger UI (giving REST interface details):
http://localhost:8085/swagger-ui.html


Open your browser at the following URL for H2 database UI  (giving database data details):
Use the jdbc string "jdbc:h2:./h2db/ddapp;AUTO_SERVER=TRUE" to connect, setting the datasource as H2 Embedded.
Or you can use http://localhost:8085/h2-console (user 'sa' and password 'password').