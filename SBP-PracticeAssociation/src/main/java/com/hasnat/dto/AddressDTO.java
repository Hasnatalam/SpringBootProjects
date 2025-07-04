package com.hasnat.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDTO {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private Long studentId;
}