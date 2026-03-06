package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, Object>> getDashboard() {
        Map<String, Object> data = new LinkedHashMap<>();

        // Enrolled Courses
        List<Map<String, String>> courses = new ArrayList<>();
        courses.add(Map.of("name", "Mathematics", "instructor", "Prof. Smith", "progress", "72%"));
        courses.add(Map.of("name", "Physics", "instructor", "Prof. Johnson", "progress", "58%"));
        courses.add(Map.of("name", "Computer Science", "instructor", "Prof. Lee", "progress", "89%"));
        courses.add(Map.of("name", "English Literature", "instructor", "Prof. Davis", "progress", "65%"));
        data.put("courses", courses);

        // Upcoming Assignments
        List<Map<String, String>> assignments = new ArrayList<>();
        assignments.add(Map.of("title", "Calculus Problem Set #5", "subject", "Mathematics", "dueDate", "2026-03-10", "status", "Pending"));
        assignments.add(Map.of("title", "Lab Report — Optics", "subject", "Physics", "dueDate", "2026-03-12", "status", "In Progress"));
        assignments.add(Map.of("title", "Algorithm Design Project", "subject", "Computer Science", "dueDate", "2026-03-15", "status", "Pending"));
        assignments.add(Map.of("title", "Essay: Victorian Era", "subject", "English Literature", "dueDate", "2026-03-18", "status", "Not Started"));
        data.put("assignments", assignments);

        // Grades
        List<Map<String, String>> grades = new ArrayList<>();
        grades.add(Map.of("subject", "Mathematics", "grade", "A-", "score", "88/100"));
        grades.add(Map.of("subject", "Physics", "grade", "B+", "score", "82/100"));
        grades.add(Map.of("subject", "Computer Science", "grade", "A", "score", "95/100"));
        grades.add(Map.of("subject", "English Literature", "grade", "B", "score", "78/100"));
        data.put("grades", grades);

        // Schedule (today)
        List<Map<String, String>> schedule = new ArrayList<>();
        schedule.add(Map.of("time", "9:00 AM", "subject", "Mathematics", "room", "Room 101"));
        schedule.add(Map.of("time", "11:00 AM", "subject", "Physics", "room", "Lab 3"));
        schedule.add(Map.of("time", "2:00 PM", "subject", "Computer Science", "room", "Room 204"));
        schedule.add(Map.of("time", "4:00 PM", "subject", "English Literature", "room", "Room 105"));
        data.put("todaySchedule", schedule);

        // Stats
        Map<String, Object> stats = new LinkedHashMap<>();
        stats.put("gpa", "3.6");
        stats.put("attendancePercent", 92);
        stats.put("completedAssignments", 18);
        stats.put("totalAssignments", 22);
        data.put("stats", stats);

        return ResponseEntity.ok(data);
    }
}
