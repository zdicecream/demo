package com.example.system.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "t_user")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String loginName;
    private String password;
    private String email;
    private String phone;
    private Date createTime;
    /* 权限设置 */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="department_id", nullable=false)
    private Department department;
    @ManyToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JoinTable(name = "t_user_role",joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private Set<Role> roleSet;
    /* 登陆相关*/
    private Date lastLoginTime;
    private Integer loginCount;
}
