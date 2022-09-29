package com.example.library.Repository;

import com.example.library.Model.User;
import com.example.library.dto.model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u ")
    List<UserDTO> getAllUser();
}
