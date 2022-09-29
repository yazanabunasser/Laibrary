package com.example.library.dto.Request;

import com.example.library.Model.Book;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UserRequest {
    
    private Long userId;

    @NotNull
    private String userName;

    private List<Book> books;
}
