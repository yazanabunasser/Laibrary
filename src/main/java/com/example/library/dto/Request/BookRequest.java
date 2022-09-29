package com.example.library.dto.Request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class BookRequest {

    private Long bookId;

    private String bookName;

    private String author;

    private int size;

    @NotNull
    private Long employeeid;

    private Long userid;

}
