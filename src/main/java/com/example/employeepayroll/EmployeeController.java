package com.example.employeepayroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping
    public String getEmployee() {
        return "Employee data";
    }

    @Autowired
    private EmployeeServices employeeService;

    @PostMapping("/add")
    public Employee add(@RequestBody Employee employee) {
        return employeeService.add(employee);
    }

    @PutMapping("/put/{id}")
    public Employee put(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.update(id,employee);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){

        return employeeService.deleting(id);
    }
    @GetMapping("/all")
    public List<Employee> all(){
        return employeeService.fetchAll();
    }
    @GetMapping("/get/{id}")
    public Optional<Employee> checking(@PathVariable Long id){

        return employeeService.check(id);
    }


}
