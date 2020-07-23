package com.example.system.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "t_button")
@Data
public class Button implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String buttonName;
    private String buttonCode;
    private String buttonDesc;
    @ManyToOne
    @JoinColumn(name="menu_id", nullable=false)
    private Menu menu;
}
