package com.example.system.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Table(name = "t_department")
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String departmentName;
    private String departmentCode;
    private String departmentDesc;
    @ManyToOne
    @JoinColumn(name="parent_department_id")
    private Department parentDepartment;
}
