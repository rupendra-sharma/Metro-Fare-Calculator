# Metro-Fare-Calculator
The api takes a CSV string and calculates the fare using a drools rule engine. 

It calculates the fare using the following rules in consideration:
1. Journey start line
2. Journey end line
3. Peak / Non-peak hours for Day of week
4.  Max day fare
5. Max week fare


**Installation**

To run this project, you will need to have Java 11 or higher installed on your system.

Clone this repository to your local machine.
Open a terminal in the project directory.
Run ./mvnw spring-boot:run (on Unix-based systems) or mvnw.cmd spring-boot:run (on Windows) to start the application.




**API:**
Test the API using the cURL request:

```bash
curl --location 'http://localhost:8080/calculate' \
--header 'Content-Type: text/plain' \
--data '"Green, Green, 2021-03-24T07:58:30"'


**Future considrations:**

*Desired high level architecture:*
![image](https://user-images.githubusercontent.com/894924/229403748-6c90ca80-f179-4c10-a441-af670177259b.png)

