package com.example.system.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name = "t_role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String roleName;
    private String roleDesc;
    @ManyToOne
    @JoinColumn(name="parent_role_id")
    private Role parentRole;
    private Date createTime;
    @ManyToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JoinTable(name = "t_role_right",joinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "right_id",referencedColumnName = "id"))
    private Set<Right> rightSet;
    @ManyToMany(mappedBy = "roleSet")
    private Set<User> userSet;
}
