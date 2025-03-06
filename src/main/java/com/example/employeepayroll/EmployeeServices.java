package com.example.employeepayroll;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class EmployeeServices {
    private List<Employee> list = new ArrayList<>();

    @Autowired
    private EmployeeRepository employeeRepository;
<<<<<<< HEAD
    public Employee add(Employee employee){
        Employee emp=null;
        emp=new Employee(employee);

=======

    public Employee add(Employee employee) {
        Employee emp = null;
        emp = new Employee(employee);

>>>>>>> UC16_CRUDCode
        list.add(employee);
        return employeeRepository.save(emp);
    }


    public boolean deleting(Long id) {
        if (employeeRepository.existsById(id)) {
            Employee empData = check(id);
            employeeRepository.delete(empData);
            return true;
<<<<<<< HEAD
        }
        else {
=======
        } else {
>>>>>>> UC16_CRUDCode
            throw new EmployeeNotFound("Employee not found");
        }

    }

    public List<Employee> fetchAll() {

        return employeeRepository.findAll();
    }

<<<<<<< HEAD
    public Employee update(long id ,Employee updateEmployee) {
        return employeeRepository.findById(id).map(employee -> {employee.setName(updateEmployee.getName());
=======
    public Employee update(long id, Employee updateEmployee) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(updateEmployee.getName());
>>>>>>> UC16_CRUDCode
            employee.setSalary(updateEmployee.getSalary());
            employee.setStartDate(updateEmployee.getStartDate());
            employee.setNote(updateEmployee.getNote());
            employee.setProfilePic(updateEmployee.getProfilePic());
            employee.setGender(updateEmployee.getGender());

            if (updateEmployee.getDepartment() != null) {
                employee.getDepartment().clear();
                employee.getDepartment().addAll(updateEmployee.getDepartment());
            }

            return employeeRepository.save(employee);
        }).orElseThrow(() -> new EmployeeNotFound("Employee not found"));
    }
<<<<<<< HEAD
    public Optional<Employee> check(long id){
        return Optional.ofNullable(employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFound("Employee not found.")));
    }}
=======




    public Employee check(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFound("Employee not found."));
    }


}
>>>>>>> UC16_CRUDCode
