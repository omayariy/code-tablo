package com.example.todolist.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "tablo")
@Entity
@Getter
@Setter
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    private String code;


}