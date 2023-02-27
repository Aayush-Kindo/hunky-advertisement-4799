# hunky-advertisement-4799
This is a Java application that allows you to manage students, courses, and batches using JDBC and DAO pattern.

#Prerequisites
Java 8 or higher
MySQL Server
MySQL Connector/J
Any Java IDE (e.g., Eclipse, IntelliJ IDEA, NetBeans)
#Getting Started
Clone the repository to your local machine.
Open the project in your Java IDE.
Set up the MySQL database and create the necessary tables. You can use the SQL scripts in the src/main/resources/sql folder.
Update the database connection properties in the DBUtil.java file located in src/main/java/com/example/studentmanagement/utils.
Run the application.
#Features
Register a student with their name, email, and password.
Register a course with its name and fees.
Create a batch for a course with the start and end dates, total seats, and available seats.
Allocate a student to a batch.
Update the fees of a course.
#Technologies Used
Java
JDBC
DAO Pattern
MySQL
#License
This project is licensed under the MIT License - see the LICENSE file for details.