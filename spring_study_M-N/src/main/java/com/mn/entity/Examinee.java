package com.mn.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Examinee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "examinee_id")
    private Long id;

    private String name;
    private int age;

    // 연관관계 매핑
    @OneToMany(mappedBy = "examinee")
    private List<ExamineeAcademy> examineeAcademies = new ArrayList<>();
    
}