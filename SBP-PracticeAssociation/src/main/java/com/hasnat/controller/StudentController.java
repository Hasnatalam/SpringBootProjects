package com.hasnat.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hasnat.dto.StudentDTO;
import com.hasnat.services.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student Management", description = "Student Management APIs")
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @Operation(summary = "Create a new student", description = "Creates a new student with address")
    @ApiResponse(responseCode = "201", description = "Student created successfully")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        log.info("Received request to create student: {}", studentDTO);
        StudentDTO createdStudent = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get student by ID", description = "Returns a single student by ID")
    @ApiResponse(responseCode = "200", description = "Student found")
    @ApiResponse(responseCode = "404", description = "Student not found")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        log.info("Received request to get student with ID: {}", id);
        StudentDTO studentDTO = studentService.getStudentById(id);
        return ResponseEntity.ok(studentDTO);
    }

    @GetMapping
    @Operation(summary = "Get all students", description = "Returns a list of all students")
    @ApiResponse(responseCode = "200", description = "List of students returned")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        log.info("Received request to get all students");
        List<StudentDTO> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update student", description = "Updates an existing student")
    @ApiResponse(responseCode = "200", description = "Student updated successfully")
    @ApiResponse(responseCode = "404", description = "Student not found")
    public ResponseEntity<StudentDTO> updateStudent(
            @PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        log.info("Received request to update student with ID: {}", id);
        StudentDTO updatedStudent = studentService.updateStudent(id, studentDTO);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete student", description = "Deletes a student by ID")
    @ApiResponse(responseCode = "204", description = "Student deleted successfully")
    @ApiResponse(responseCode = "404", description = "Student not found")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        log.info("Received request to delete student with ID: {}", id);
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
