package com.example.library.Service;

import com.example.library.Model.Employee;
import com.example.library.Model.User;
import com.example.library.Repository.EmployeeRepository;
import com.example.library.Repository.UserRepository;
import com.example.library.dto.Request.EmployeeRequest;
import com.example.library.dto.mapper.ObjectMapperUtils;
import com.example.library.dto.model.EmployeeDTO;
import com.example.library.dto.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.ListUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public void addEmployee(EmployeeRequest employeeRequest) {
        Employee employee = ObjectMapperUtils.map(employeeRequest , Employee.class);
        employeeRepository.save(employee);
    }

    public List<EmployeeDTO> getEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return ObjectMapperUtils.mapAll(employees , EmployeeDTO.class);
    }

    public void updateEmployee(EmployeeRequest employeeRequest) {
        Employee employee = ObjectMapperUtils.map(employeeRequest , Employee.class);
        employeeRepository.save(employee);

    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteAllById(Collections.singleton(employeeId));
    }
}
