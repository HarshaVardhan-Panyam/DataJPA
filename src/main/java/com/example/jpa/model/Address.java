package com.example.jpa.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    int id;
    String houseNo;
    String city;
    int postalCode;
}
