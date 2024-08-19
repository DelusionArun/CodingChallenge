This is a default template for a challenge written in Spring Boot with Java + Maven

Please check the TODOs on the values to update

Basic flow

1. Coordinator calls our evaluate endpoint
2. Our application receives details such as the team url and callback url
3. Our application generates test cases and their expected solutions
4. Our application sends the list of test cases to the participants server and expects a list of team solutions to be returned
5. Our application evaluates the list of team solutions and sends an evaluation response to the coordinator, with the final score and messages