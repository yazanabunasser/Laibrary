package com.example.library.Model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "employee")
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @Column(name = "name")
    private String employeeName;

    @OneToMany(mappedBy = "employee" ,fetch = FetchType.LAZY)
    private List<Book> books;

}


