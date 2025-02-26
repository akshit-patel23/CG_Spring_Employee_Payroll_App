package com.example.employeepayroll;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Name Cannot be empty or null")
    @Pattern(regexp = "^[A-Z][a-zA-z ]{2,}$",message = "Name must start with a capital letter and have at least 3 characters")
    private String name;
    private double salary;
}
