# Automated Student Management System
This is a Java application that allows you to manage students, courses, and batches using JDBC and DAO pattern.

#Prerequisites
<br>
- Java 8 or higher
- MySQL Server
- MSQL Connector/J
- Any Java IDE (e.g., Eclipse, IntelliJ IDEA, NetBeans)
<br>
#Getting Started
<br>

- Clone the repository to your local machine.
- Open the project in your Java IDE.
- Set up the MySQL database and create the necessary tables. You can use the SQL scripts in the src/main/resources/sql folder.
- Update the database connection properties in the DBUtil.java file located in src/main/java/com/example/studentmanagement/utils.
- Run the application.
<br>

#Features
<br>

- Register a student with their name, email, and password.
- Register a course with its name and fees.
- Create a batch for a course with the start and end dates, total seats, and available seats.
- Allocate a student to a batch.
- Update the fees of a course.
- 
<br>
#Technologies Used
<br>

- Java
- JDBC
- DAO Pattern
- MySQL
- 
<br>
--

## Flowchart

---
<a href='https://www.linkpicture.com/view.php?img=LPic640ab304854482018380037'><img src='https://www.linkpicture.com/q/Stusent_registration_system_flow_chart-hunky.jpg' type='image'></a>


## E-R Digram of Application 
<a href='https://www.linkpicture.com/view.php?img=LPic6408dff7489781872951077'><img src='https://www.linkpicture.com/q/Student_Registration_Portal_Database_Digram_page-00012.jpg' type='image'></a>

<!-- <a href="https://docs.google.com/presentation/d/1RYZl2LMi145-N6QlpuCRUKROo7vEhpJO/edit?usp=sharing&ouid=115573521711169005136&rtpof=true&sd=true">**PPT Link** </a> -->

#License
<br>
This project is licensed under the MIT License - see the LICENSE file for details.
