package com.hasnat.util;

import com.hasnat.dto.AddressDTO;
import com.hasnat.dto.StudentDTO;
import com.hasnat.entity.Address;
import com.hasnat.entity.Student;

public class DTOConverter {

    public static StudentDTO convertToStudentDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setEmail(student.getEmail());
        
        if (student.getAddress() != null) {
            studentDTO.setAddress(convertToAddressDTO(student.getAddress()));
        }
        
        return studentDTO;
    }

    public static AddressDTO convertToAddressDTO(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setCity(address.getCity());
        addressDTO.setState(address.getState());
        addressDTO.setZipCode(address.getZipCode());
        
        if (address.getStudent() != null) {
            addressDTO.setStudentId(address.getStudent().getId());
        }
        
        return addressDTO;
    }

    public static Student convertToStudentEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        return student;
    }

    public static Address convertToAddressEntity(AddressDTO addressDTO) {
        Address address = new Address();
        address.setId(addressDTO.getId());
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setZipCode(addressDTO.getZipCode());
        return address;
    }
}