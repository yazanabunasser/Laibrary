package com.example.library.dto.Request;

import com.example.library.Model.Book;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeRequest {
    private Long employeeId;
    private String employeeName;
    private List<Book> books;

}
