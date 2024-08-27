**Movie Ticket Booking System
**

This project is a movie ticket booking system built using Java, Spring Boot, and MySQL. The system allows users to browse available movies, select showtimes, book seats, and manage their bookings. The project is designed to support multiple movies and showtimes, and it tracks seat availability for each show.

Features:
Movie Initialization: Define a list of available movies with details such as title, genre, and show timings.
User Booking: Users can book tickets for a specific movie and showtime. The system tracks the number of available seats for each show.
Seat Allocation: Seats are automatically allocated to users upon booking, with the system selecting the next available seat.
Ticket Cancellation: Users can cancel their booked tickets, making the canceled seats available for future bookings.
Booking Confirmation: After booking, users receive a confirmation with details such as movie title, showtime, and seat number.
Multiple Movies and Shows: The system supports multiple movies, each with different showtimes.

Technologies Used
Java 17
Spring Boot 3.0
MySQL
Hibernate/JPA
Lombok

Database Schema
The following entities are used in this project:

User: Represents a user of the system.

Movie: Represents a movie, with details like title and genre.

MovieShow: Represents a specific showtime for a movie.

Seat: Represents a seat in a movie theater.

Booking: Represents a booking made by a user.

Setup Instructions:

Prerequisites:
Java 17
MySQL
Maven

Steps to Run
Clone the repository:

git clone https://github.com/your-username/movie-ticket-booking-system.git
cd movie-ticket-booking-system
Create a MySQL Database:
CREATE DATABASE movie_booking_system;

Configure Database Connection:
Update the application.properties file located in src/main/resources with your MySQL database credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/movie_booking_system
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
Build and Run the Application:

mvn clean install
mvn spring-boot:run

Access the API:
Once the application is running, you can access the API endpoints via http://localhost:8080/api.

Get All Movies: GET /api/movies
Book a Ticket: POST /api/book?movieId={movieId}&showId={showId}&userId={userId}
Cancel a Booking: DELETE /api/cancel/{bookingId}
Get All Users: GET /api/users
Get Shows for a Movie: GET /api/shows/{movieId}

Example Usage
Book a Ticket:
To book a ticket for a specific movie and showtime, make a POST request to the /api/book endpoint:

curl -X POST "http://localhost:8080/api/book?movieId=1&showId=2&userId=3"

Cancel a Booking:
To cancel a booking, make a DELETE request to the /api/cancel/{bookingId} endpoint:

curl -X DELETE "http://localhost:8080/api/cancel/1"





**1. Get API for list of available movies**

curl --location --request GET 'localhost:8081/api/movies' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userName": "pankaj_tekle",
    "email": "pankaj.tekle@gmail.com",
    "password": "Password@123"
}'


**2. Get API list of shows for particular movie
**
curl --location 'localhost:8081/api/shows/1'

**3. POST API to book a ticket
**
curl --location --request POST 'localhost:8081/api/book?movieId=1&showId=1&userId=1'

**4. DELETE API to cancel ticket
**   
curl --location --request DELETE 'localhost:8081/api/cancel/2'

**5. POST API to register user
**
curl --location 'localhost:8081/api/user/register' \
--header 'Content-Type: application/json' \
--data '{
    "userName": "Modi Ji"
}'

**6. GET API to get all users
**curl --location 'localhost:8081/api/user/all'
