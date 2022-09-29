package com.example.library.dto.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO {
    private Long bookId;
    private String bookName;
    private String author;
    private int size;
    private EmployeeDTO employeeDTO;
    private UserDTO userDTO;

    public BookDTO(Long bookId, String bookName, String author, int size) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.size = size;
    }
}

