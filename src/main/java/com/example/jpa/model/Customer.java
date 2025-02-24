package com.example.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
@Entity
public class Customer {
    @Id
    int id;
    String name;
    Address address;
}
