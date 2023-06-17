package com.mn.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.mn.entity.Examinee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

//ExamineeDto
@AllArgsConstructor
@Builder
@ToString
public class ExamineeDTO {
 private Long id;
 private String name;
 private int age;
 private List<String> academyNames;

 public static ExamineeDTO of(Examinee examinee) {
     return ExamineeDTO.builder()
             .id(examinee.getId())
             .name(examinee.getName())
             .age(examinee.getAge())
             .academyNames(examinee.getExamineeAcademies().stream().map(list -> {
                 return list.getAcademy().getName();
             }).collect(Collectors.toList()))
             .build();
 }
}