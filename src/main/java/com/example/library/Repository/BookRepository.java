package com.example.library.Repository;

import com.example.library.Model.Book;
import com.example.library.dto.model.BookDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select b from Book b join fetch Employee e")
    List<Book> getAllBook();

}
