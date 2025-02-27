package com.example.employeepayroll;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

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
    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    private String gender;
    @JsonFormat(pattern = "dd mm yyyy")
    @NotNull(message = "Start Date should not be null")
    @PastOrPresent(message ="Start date should be past or present days" )
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be empty")
    private String note;

    @NotBlank(message = "Profile cannot be empty")
    private String profilePic;

    @NotNull(message = "Department cannot be empty")
    private List<String> department;
}
