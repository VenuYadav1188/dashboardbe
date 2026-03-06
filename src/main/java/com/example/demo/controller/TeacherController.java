package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, Object>> getDashboard() {
        Map<String, Object> data = new LinkedHashMap<>();

        // My Classes
        List<Map<String, Object>> classes = new ArrayList<>();
        classes.add(Map.of("name", "Mathematics 101", "students", 32, "room", "Room 101", "schedule", "Mon/Wed/Fri 9:00 AM"));
        classes.add(Map.of("name", "Advanced Calculus", "students", 24, "room", "Room 203", "schedule", "Tue/Thu 11:00 AM"));
        classes.add(Map.of("name", "Statistics", "students", 28, "room", "Room 105", "schedule", "Mon/Wed 2:00 PM"));
        data.put("classes", classes);

        // Recent Students
        List<Map<String, String>> students = new ArrayList<>();
        students.add(Map.of("name", "Alice Johnson", "class", "Mathematics 101", "grade", "A", "status", "Active"));
        students.add(Map.of("name", "Bob Williams", "class", "Advanced Calculus", "grade", "B+", "status", "Active"));
        students.add(Map.of("name", "Carol Brown", "class", "Statistics", "grade", "A-", "status", "Active"));
        students.add(Map.of("name", "David Lee", "class", "Mathematics 101", "grade", "C+", "status", "At Risk"));
        students.add(Map.of("name", "Emma Davis", "class", "Statistics", "grade", "B", "status", "Active"));
        data.put("recentStudents", students);

        // Assignments to Grade
        List<Map<String, Object>> pending = new ArrayList<>();
        pending.add(Map.of("title", "Calculus Problem Set #5", "class", "Advanced Calculus", "submitted", 20, "total", 24, "dueDate", "2026-03-10"));
        pending.add(Map.of("title", "Midterm Exam", "class", "Mathematics 101", "submitted", 30, "total", 32, "dueDate", "2026-03-08"));
        pending.add(Map.of("title", "Statistics Project", "class", "Statistics", "submitted", 15, "total", 28, "dueDate", "2026-03-15"));
        data.put("pendingAssignments", pending);

        // Announcements
        List<Map<String, String>> announcements = new ArrayList<>();
        announcements.add(Map.of("title", "Faculty Meeting", "date", "2026-03-07", "desc", "Mandatory meeting at 3 PM in Hall A"));
        announcements.add(Map.of("title", "Grades Deadline", "date", "2026-03-20", "desc", "Submit all midterm grades by EOD"));
        data.put("announcements", announcements);

        // Stats
        Map<String, Object> stats = new LinkedHashMap<>();
        stats.put("totalStudents", 84);
        stats.put("totalClasses", 3);
        stats.put("averageClassScore", "78%");
        stats.put("assignmentsPendingReview", 3);
        data.put("stats", stats);

        return ResponseEntity.ok(data);
    }
}
