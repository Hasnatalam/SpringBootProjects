package com.hasnat.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private AddressDTO address;
}
