package com.example.library.Controller;

import com.example.library.dto.Request.BookRequest;
import com.example.library.Model.Book;
import com.example.library.Service.BookService;
import com.example.library.dto.model.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

//    @RequestMapping(method = RequestMethod.POST , path = "/book")
//    public void addBook(@RequestParam("name") String name, @RequestParam("author") String author,@RequestParam("size") int size, @RequestParam("employee_id") Long employeeId){
//        bookService.addBook(name,author,size, employeeId);}

    @GetMapping
    public List<BookDTO> getBooks(){
            return bookService.getBooks();
    }

    @PostMapping
    public void addBook(@RequestBody @Valid BookRequest bookRequest){
        bookService.addBook(bookRequest);
    }

    @PutMapping
    public void updatebook(@RequestBody BookRequest bookRequest){
        bookService.updateBook(bookRequest);
    }

    @DeleteMapping("/{bookid}")
    public void deleteBook(@PathVariable Long bookid){
      bookService.deleteBook(bookid);
    }





}
