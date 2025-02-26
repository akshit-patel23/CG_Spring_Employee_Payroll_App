package com.example.employeepayroll;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.add(employee));
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        Employee updated = employeeService.update(id, employee);
        return (updated != null)
                ? ResponseEntity.ok(updated)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        return (employeeService.deleting(id))
                ?ResponseEntity.ok("Employee deleted successfully")
                :ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> all(){
        return ResponseEntity.ok(employeeService.fetchAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> checking(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.check(id);

        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

}
