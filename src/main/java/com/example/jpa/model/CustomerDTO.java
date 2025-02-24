package com.example.jpa.model;

import lombok.*;

import java.util.List;


@Data
public class CustomerDTO {
        private String name;
        private Address officeAddress;
        private List<Address> homeAddress;
    }
