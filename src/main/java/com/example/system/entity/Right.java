package com.example.system.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "t_right")
public class Right implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "menu_id", unique = true)
    private Menu menu;
    @OneToOne
    @JoinColumn(name = "button_id", unique = true)
    private Button button;
    private String rightDesc;
    @ManyToMany(mappedBy = "rightSet")
    private Set<Role> roleSet;
}
