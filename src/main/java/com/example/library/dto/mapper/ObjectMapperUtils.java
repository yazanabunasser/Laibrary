package com.example.library.dto.mapper;

import com.example.library.Model.Book;
import com.example.library.Model.Employee;
import com.example.library.Model.User;
import com.example.library.dto.model.BookDTO;
import com.example.library.dto.model.EmployeeDTO;
import com.example.library.dto.model.UserDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectMapperUtils {

    private static MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    static {
        mapperFactory.classMap(Employee.class, EmployeeDTO.class).customize(
                new CustomMapper<Employee, EmployeeDTO>() {
                    @Override
                    public void mapAtoB(Employee employee, EmployeeDTO employeeDTO, MappingContext context) {
                        super.mapAtoB(employee, employeeDTO, context);
                        List<BookDTO> bookDTOs = new ArrayList<>();
                        employee.getBooks().stream().forEach(bookEntity -> {
                                    BookDTO bookDTO = new BookDTO(
                                            bookEntity.getBookId(),
                                            bookEntity.getBookName(),
                                            bookEntity.getAuthor(),
                                            bookEntity.getSize()
                                    );
                                    bookDTOs.add(bookDTO);
                                }
                        );
                        employeeDTO.setBooks(bookDTOs);
                    }
                }
        ).byDefault().register();

        mapperFactory.classMap(User.class, UserDTO.class).customize(
                new CustomMapper<User, UserDTO>() {
                    @Override
                    public void mapAtoB(User user, UserDTO userDTO, MappingContext context) {
                        super.mapAtoB(user, userDTO, context);
                        List<BookDTO> bookDTOs = new ArrayList<>();
                        user.getBooks().stream().forEach(
                                bookEntity ->{
                                    BookDTO bookDTO = new BookDTO(
                                            bookEntity.getBookId(),
                                            bookEntity.getBookName(),
                                            bookEntity.getAuthor(),
                                            bookEntity.getSize()
                                    );
                                    bookDTOs.add(bookDTO);
                                }
                        );
                        userDTO.setBooks(bookDTOs);
                    }
                }
        ).byDefault().register();

        mapperFactory.classMap(Book.class, BookDTO.class)
                .field("bookId", "bookId")
                .field("bookName", "bookName")
                .field("author", "author")
                .field("size", "size")
                .field("employee.employeeId", "employeeDTO.employeeId")
                .field("employee.employeeName", "employeeDTO.employeeName")
                .field("user.userId", "userDTO.userId")
                .field("user.userName", "userDTO.userName")
                .register();
    }

    public static <D, T> D map(final T entity, Class<D> outClass) {
        MapperFacade modelMapper = mapperFactory.getMapperFacade();
        return modelMapper.map(entity, outClass);
    }

    public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }
}
