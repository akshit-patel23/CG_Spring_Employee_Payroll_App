package com.example.employeepayroll;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {
    private List<Employee> list=new ArrayList<>();

    @Autowired
    private EmployeeRepository employeeRepository;
    public Employee add(@Valid Employee employee){

        return employeeRepository.save(employee);
    }

    public boolean deleting(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        else{
            throw new EmployeeNotFound("Employee not found");
        }

    }
    public List<Employee> fetchAll(){

        return employeeRepository.findAll();
    }

    public Employee update(long id ,@Valid Employee updateEmployee) {
        return employeeRepository.findById(id).map(employee -> {employee.setName(updateEmployee.getName());
            employee.setSalary(updateEmployee.getSalary());
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new EmployeeNotFound("Employee not found"));
    }

    public Optional<Employee> check(long id){
        return Optional.ofNullable( employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFound("Employee not found.")));
    }
}