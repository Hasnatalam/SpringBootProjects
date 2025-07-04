package com.hasnat.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hasnat.dto.AddressDTO;
import com.hasnat.dto.StudentDTO;
import com.hasnat.entity.Address;
import com.hasnat.entity.Student;
import com.hasnat.exception.ResourceNotFoundException;
import com.hasnat.repository.AddressRepository;
import com.hasnat.repository.StudentRepository;
import com.hasnat.util.DTOConverter;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, AddressRepository addressRepository) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    @Transactional
    public StudentDTO createStudent(StudentDTO studentDTO) {
        log.info("Creating new student with email: {}", studentDTO.getEmail());
        
        // Check if email already exists
        if (studentRepository.existsByEmail(studentDTO.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Convert DTO to entity
        Student student = DTOConverter.convertToStudentEntity(studentDTO);
        
        // Save student
        Student savedStudent = studentRepository.save(student);
        
        // Handle address if present
        if (studentDTO.getAddress() != null) {
            AddressDTO addressDTO = studentDTO.getAddress();
            Address address = DTOConverter.convertToAddressEntity(addressDTO);
            address.setStudent(savedStudent);
            addressRepository.save(address);
            savedStudent.setAddress(address);
        }
        
        log.info("Created new student with ID: {}", savedStudent.getId());
        return DTOConverter.convertToStudentDTO(savedStudent);
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        log.info("Fetching student with ID: {}", id);
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        return DTOConverter.convertToStudentDTO(student);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        log.info("Fetching all students");
        return studentRepository.findAll().stream()
                .map(DTOConverter::convertToStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        log.info("Updating student with ID: {}", id);
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        // Update student details
        existingStudent.setFirstName(studentDTO.getFirstName());
        existingStudent.setLastName(studentDTO.getLastName());
        
        // Only update email if it's different
        if (!existingStudent.getEmail().equals(studentDTO.getEmail())) {
            if (studentRepository.existsByEmail(studentDTO.getEmail())) {
                throw new IllegalArgumentException("Email already exists");
            }
            existingStudent.setEmail(studentDTO.getEmail());
        }

        // Update address if present
        if (studentDTO.getAddress() != null) {
            Address existingAddress = existingStudent.getAddress();
            AddressDTO addressDTO = studentDTO.getAddress();
            
            if (existingAddress == null) {
                // Create new address
                Address newAddress = DTOConverter.convertToAddressEntity(addressDTO);
                newAddress.setStudent(existingStudent);
                addressRepository.save(newAddress);
                existingStudent.setAddress(newAddress);
            } else {
                // Update existing address
                existingAddress.setStreet(addressDTO.getStreet());
                existingAddress.setCity(addressDTO.getCity());
                existingAddress.setState(addressDTO.getState());
                existingAddress.setZipCode(addressDTO.getZipCode());
                addressRepository.save(existingAddress);
            }
        }

        Student updatedStudent = studentRepository.save(existingStudent);
        log.info("Updated student with ID: {}", id);
        return DTOConverter.convertToStudentDTO(updatedStudent);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        log.info("Deleting student with ID: {}", id);
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        
        // Delete address first to avoid constraint violation
        if (student.getAddress() != null) {
            addressRepository.delete(student.getAddress());
        }
        
        studentRepository.delete(student);
        log.info("Deleted student with ID: {}", id);
    }
}
