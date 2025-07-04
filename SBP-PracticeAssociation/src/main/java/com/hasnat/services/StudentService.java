package com.hasnat.services;


import java.util.List;

import com.hasnat.dto.StudentDTO;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);
    StudentDTO getStudentById(Long id);
    List<StudentDTO> getAllStudents();
    StudentDTO updateStudent(Long id, StudentDTO studentDTO);
    void deleteStudent(Long id);
}