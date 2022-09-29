package com.example.library.Repository;

import com.example.library.Model.Employee;
import com.example.library.dto.model.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>  {
    @Query("select e from Employee e")
    List<EmployeeDTO> getAllEmp();
}
