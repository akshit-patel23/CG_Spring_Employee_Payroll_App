package com.example.employeepayroll;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
<<<<<<< HEAD
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
=======
import jakarta.validation.constraints.*;
>>>>>>> UC16_CRUDCode
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.util.List;

@Data

@Entity
@Table(name = "employees")
@AllArgsConstructor
public class Employee {
    @Id
<<<<<<< HEAD
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
=======
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Ensure auto-increment is enabled
    @Column(name = "employee_id", nullable = false, updatable = false)
    private Long id;  // Change to Wrapper class Long instead of long

    @Pattern(regexp = "^[A-Za-z ]+$",message = "Name should contain alphabets and spaces")
    @NotNull(message="Employee name cannot be null")
    @Column(name="name")
    public String name;
    @Min(value=500,message="Min Wage should be more than 500")
    public double salary;
    @Pattern(regexp = "male|female", message = "Please enter valid gender")
    public String gender;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "startDate should Not be Empty")
    @PastOrPresent(message = "startDate should be past or today date")

    public LocalDate startDate;

    @NotBlank(message = "Note cannot be empty")
    public String note;

    @NotBlank(message = "Profile Pic cannot be empty")
    public String profilePic;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "department")
    @NotEmpty(message = "Department cannot be empty")
    private List<String> department = new ArrayList<>();


    public Employee(Employee emp){
        this.name=emp.name;
        this.salary=emp.salary;
        this.gender=emp.gender;
>>>>>>> UC16_CRUDCode
        this.department=emp.department;
        this.profilePic=emp.profilePic;
        this.note=emp.note;
        this.startDate=emp.startDate;
    }
<<<<<<< HEAD

    public Employee() {
    }
=======
    public Employee() {
    }

>>>>>>> UC16_CRUDCode
    public Employee(String name, double salary, String gender, LocalDate startDate, String note, String profilePic, List<String> department) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.note = note;
        this.profilePic = profilePic;
        this.department = department;
    }
<<<<<<< HEAD


}

=======
    public void updateEmployee(Employee empPayrollDTO) {
        if (empPayrollDTO.getName() != null)
            this.name = empPayrollDTO.getName();
        if (empPayrollDTO.getSalary() != 0)
            this.salary = empPayrollDTO.getSalary();
        if (empPayrollDTO.getGender() != null)
            this.gender = empPayrollDTO.getGender();
        if (empPayrollDTO.getStartDate() != null)
            this.startDate = empPayrollDTO.getStartDate();
        if (empPayrollDTO.getNote() != null)
            this.note = empPayrollDTO.getNote();
        if (empPayrollDTO.getProfilePic() != null)
            this.profilePic = empPayrollDTO.getProfilePic();
        if (empPayrollDTO.getDepartment() != null)
            this.department = empPayrollDTO.getDepartment();
    }
}
>>>>>>> UC16_CRUDCode
