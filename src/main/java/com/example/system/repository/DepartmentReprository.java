package com.example.system.repository;

import com.example.system.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentReprository extends JpaRepository<Department,Integer> {
}
