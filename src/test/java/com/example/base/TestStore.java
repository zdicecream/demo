package com.example.base;

import com.example.system.entity.Department;
import com.example.system.entity.User;
import com.example.system.repository.DepartmentReprository;
import com.example.system.repository.UserReprository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestStore {
    @Autowired
    private UserReprository userReprository;
    @Autowired
    private DepartmentReprository departmentReprository;
    @Test
    public void contextLoads() {
        User user = new User();
        user.setName("test1231");
        Department department = new Department();
        department.setDepartmentName("21312311111a");
//        this.departmentReprository.save(department);
        user.setDepartment(department);
        this.userReprository.save(user);
    }

    @Test
    public void testNewBranch1() {
        User user = new User();
        user.setName("test1231");
        Department department = new Department();
        department.setDepartmentName("21312311111a");
//        this.departmentReprository.save(department);
        user.setDepartment(department);
        this.userReprository.save(user);
    }
}
