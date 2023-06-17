package com.mn.dto;

import java.time.LocalDateTime;

import com.mn.entity.ExamineeAcademy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

//ExamineeAcademyDto
@AllArgsConstructor
@Builder
@ToString
public class ExamineeAcademyDTO {
 private String examineeName;
 private String academyName;
 private LocalDateTime registerDate;

 public static ExamineeAcademyDTO of(ExamineeAcademy examineeAcademy) {
     return ExamineeAcademyDTO.builder()
             .examineeName(examineeAcademy.getExaminee().getName())
             .academyName(examineeAcademy.getAcademy().getName())
             .registerDate(examineeAcademy.getRegisterDate())
             .build();
 }
}
