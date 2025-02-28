package com.example.employeepayroll;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data

@Entity
@Table(name = "employees")
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private Long id;

    @Column(name="name")
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
    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @NotNull(message = "Department cannot be empty")
    private List<String> department;


    public Employee(Employee emp) {
        this.name=emp.name;
        this.salary=emp.salary;
        this.gender=emp.gender;
        this.id=emp.id;
        this.department=emp.department;
        this.profilePic=emp.profilePic;
        this.note=emp.note;
        this.startDate=emp.startDate;
    }

    public Employee() {
    }
    public Employee(String name, double salary, String gender, LocalDate startDate, String note, String profilePic, List<String> department) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.note = note;
        this.profilePic = profilePic;
        this.department = department;
    }


}

