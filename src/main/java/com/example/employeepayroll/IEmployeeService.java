package com.example.employeepayroll;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getEmployeeByDepartment(String department);

}