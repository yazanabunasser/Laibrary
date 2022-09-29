package com.example.library.Service;

import com.example.library.Model.User;
import com.example.library.Repository.UserRepository;
import com.example.library.dto.Request.BookRequest;
import com.example.library.Model.Book;
import com.example.library.Model.Employee;
import com.example.library.Repository.BookRepository;
import com.example.library.Repository.EmployeeRepository;
import com.example.library.dto.mapper.ObjectMapperUtils;
import com.example.library.dto.model.BookDTO;
import com.example.library.dto.model.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    UserRepository userRepository;

    public void addBook(String name,String author , int size ,  Long employeeId) {
        Book book = new Book();
        if (employeeId != null) {
            Optional<Employee> employee = employeeRepository.findById(employeeId);
            if (employee.isPresent()) {
                book.setEmployee(employee.get());
            } else {
                System.out.println("NO EMPLOYEE whit id " + employeeId);
                return;
            }
        }
        book.setBookName(name);
        book.setAuthor(author);
        book.setSize(size);
        bookRepository.save(book);
    }
    public void addBook(BookRequest bookRequest) {
        Book book = ObjectMapperUtils.map(bookRequest, Book.class);
        Optional<Employee> employee = employeeRepository.findById(bookRequest.getEmployeeid());
        if (employee.isPresent()) {
            book.setEmployee(employee.get());
        }else {
            System.out.println("NO EMPLOYEE whit id ");
            return;
        }
        Optional<User> user =userRepository.findById(bookRequest.getUserid());
        if (user.isPresent()) {
            book.setUser(user.get());
        }else {
            System.out.println("NO User whit id ");
            return;
        }
            bookRepository.save(book);
        }

    public BookDTO getBook() {
        Optional<Book> book = bookRepository.findById(Long.valueOf(3));
        if (book.isPresent()) {
            Book book1 = book.get();
            BookDTO bookDTO = new BookDTO();
            bookDTO.setBookId(book1.getBookId());
            bookDTO.setBookName(book1.getBookName());
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setEmployeeId(book1.getEmployee().getEmployeeId());
            employeeDTO.setEmployeeName(book1.getEmployee().getEmployeeName());
//            bookDTO.setEmployee(employeeDTO);
            return bookDTO;
        }
        return null;
    }

    public List<BookDTO> getBooks() {
        List<Book> books = bookRepository.findAll();
        return ObjectMapperUtils.mapAll(books, BookDTO.class);
    }
    public void deleteBook(Long bookid) {
        bookRepository.deleteAllById(Collections.singleton(bookid));
    }
    public void updateBook(BookRequest bookRequest) {

        Book book = ObjectMapperUtils.map(bookRequest, Book.class);
        Optional<Employee> employee = employeeRepository.findById(bookRequest.getEmployeeid());
        if (employee.isPresent()) {
            book.setEmployee(employee.get());
        }else {
            System.out.println("NO EMPLOYEE whit id ");
            return;
        }
        Optional<User> user =userRepository.findById(bookRequest.getUserid());
        if (user.isPresent()) {
            book.setUser(user.get());
        }else {
            System.out.println("NO User whit id ");
            return;
        }
        bookRepository.save(book);
    }
}
