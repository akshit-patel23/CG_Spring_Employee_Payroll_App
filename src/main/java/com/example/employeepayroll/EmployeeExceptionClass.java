package com.example.employeepayroll;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class EmployeeExceptionClass {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseClass> handleMethod(MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());

        ErrorResponseClass response = new ErrorResponseClass("Validation Failed", errMsg);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    //for id exception
    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<ErrorResponseClass> handleEmployeeId(EmployeeNotFound exception){
        ErrorResponseClass response=new ErrorResponseClass("Employee not found",List.of(exception.getMessage()));
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}