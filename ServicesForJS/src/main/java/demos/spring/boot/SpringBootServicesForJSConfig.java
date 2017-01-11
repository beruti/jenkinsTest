package demos.spring.boot;

import demos.spring.boot.services.courses.data.Course;
import demos.spring.boot.services.flights.data.Flight;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static demos.spring.boot.services.courses.data.CourseDifficulty.ADVANCED;
import static demos.spring.boot.services.courses.data.CourseDifficulty.BEGINNER;
import static demos.spring.boot.services.courses.data.CourseDifficulty.INTERMEDIATE;

@Configuration
public class SpringBootServicesForJSConfig {
    @Bean(name = "schedule")
    public List<Flight> buildSchedule() {
        List<Flight> flights = new ArrayList<Flight>();
        flights.add(new Flight(101, "Belfast City", "London Gatwick", new Date(), new Date()));
        flights.add(new Flight(102, "Belfast City", "London Gatwick", new Date(), new Date()));
        flights.add(new Flight(103, "Belfast City", "London Gatwick", new Date(), new Date()));
        flights.add(new Flight(104, "Belfast City", "London Gatwick", new Date(), new Date()));
        flights.add(new Flight(105, "Belfast City", "London Gatwick", new Date(), new Date()));
        flights.add(new Flight(201, "Belfast City", "Birmingham", new Date(), new Date()));
        flights.add(new Flight(202, "Belfast City", "Birmingham", new Date(), new Date()));
        flights.add(new Flight(203, "Belfast City", "Birmingham", new Date(), new Date()));
        flights.add(new Flight(204, "Belfast City", "Birmingham", new Date(), new Date()));
        flights.add(new Flight(205, "Belfast City", "Birmingham", new Date(), new Date()));
        flights.add(new Flight(301, "Dublin", "Edinburgh", new Date(), new Date()));
        flights.add(new Flight(302, "Dublin", "Edinburgh", new Date(), new Date()));
        flights.add(new Flight(303, "Dublin", "Edinburgh", new Date(), new Date()));
        flights.add(new Flight(304, "Dublin", "Edinburgh", new Date(), new Date()));
        flights.add(new Flight(305, "Dublin", "Edinburgh", new Date(), new Date()));
        flights.add(new Flight(401, "Dublin", "Manchester", new Date(), new Date()));
        flights.add(new Flight(402, "Dublin", "Manchester", new Date(), new Date()));
        flights.add(new Flight(403, "Dublin", "Manchester", new Date(), new Date()));
        flights.add(new Flight(404, "Dublin", "Manchester", new Date(), new Date()));
        flights.add(new Flight(405, "Dublin", "Manchester", new Date(), new Date()));
        return flights;
    }

    @Bean(name = "portfolio")
    public Map<String, Course> buildPortfolio() {
        HashMap<String, Course> portfolio = new HashMap<String, Course>();
        addCourseToMap(new Course("AB12", "Intro to Scala", BEGINNER, 4), portfolio);
        addCourseToMap(new Course("CD34", "JEE Web Development", INTERMEDIATE, 3), portfolio);
        addCourseToMap(new Course("EF56", "Meta-Programming in Ruby", ADVANCED, 2), portfolio);
        addCourseToMap(new Course("GH78", "OO Design with UML", BEGINNER, 3), portfolio);
        addCourseToMap(new Course("IJ90", "Database Access with JPA", INTERMEDIATE, 3), portfolio);
        addCourseToMap(new Course("KL12", "Design Patterns in C#", ADVANCED, 2), portfolio);
        addCourseToMap(new Course("MN34", "Relational Database Design", BEGINNER, 4), portfolio);
        addCourseToMap(new Course("OP56", "Writing MySql Stored Procedures", INTERMEDIATE, 1), portfolio);
        addCourseToMap(new Course("QR78", "Patterns of Parallel Programming", ADVANCED, 2), portfolio);
        addCourseToMap(new Course("ST90", "C++ Programming for Beginners", BEGINNER, 5), portfolio);
        addCourseToMap(new Course("UV12", "UNIX Threading with PThreads", INTERMEDIATE, 2), portfolio);
        addCourseToMap(new Course("WX34", "Writing Linux Device Drivers", ADVANCED, 3), portfolio);

        return portfolio;
    }

    private void addCourseToMap(Course course, Map<String, Course> courses) {
        courses.put(course.getId(), course);
    }
}
