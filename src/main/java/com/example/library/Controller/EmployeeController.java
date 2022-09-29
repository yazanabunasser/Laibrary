package com.example.library.Controller;

import com.example.library.Service.EmployeeService;
import com.example.library.dto.Request.EmployeeRequest;
import com.example.library.dto.model.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDTO> getEmployee(){
        return employeeService.getEmployee();
    }

    @PostMapping
    public void addEmployee(@RequestBody EmployeeRequest employeeRequest){
        employeeService.addEmployee(employeeRequest);
    }

    @PutMapping
    public void updateEmployee(@RequestBody EmployeeRequest employeeRequest){
        employeeService.updateEmployee(employeeRequest);
    }

    @DeleteMapping("/{employee_id}")
    public void deleteEmployee(@PathVariable Long employeeId){
        employeeService.deleteEmployee(employeeId);
    }
}
