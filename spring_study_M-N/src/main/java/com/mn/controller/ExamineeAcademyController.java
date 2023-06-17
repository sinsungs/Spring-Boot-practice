package com.mn.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mn.dto.ExamineeAcademyDTO;
import com.mn.dto.ExamineeDTO;
import com.mn.dto.RegisterRequestDTO;
import com.mn.entity.Academy;
import com.mn.entity.Examinee;
import com.mn.entity.ExamineeAcademy;
import com.mn.repository.AcademyRepository;
import com.mn.repository.ExamineeAcademyRepository;
import com.mn.repository.ExamineeRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/exam")
@RequiredArgsConstructor
public class ExamineeAcademyController {
	
	private final ExamineeRepository examineeRepository;
	private final AcademyRepository academyRepository;
	private final ExamineeAcademyRepository examineeAcademyRepository;
	
    
    @PostMapping("/register-academy")
    public ResponseEntity<String> registerAcademy(@RequestBody RegisterRequestDTO request) {
        Examinee examinee = examineeRepository.findById(request.getExamineeId()).get();
        Academy academy = academyRepository.findById(request.getAcademyId()).get();

        ExamineeAcademy newRegister = new ExamineeAcademy();
        newRegister.setExaminee(examinee);
        newRegister.setAcademy(academy);
        newRegister.setRegisterDate(LocalDateTime.now());
        examineeAcademyRepository.save(newRegister);
        

        String response = String.format("%s 수험생이 %s에 등록하였습니다.", examinee.getName(), academy.getName()); 
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/list-academy")
    public ResponseEntity<String> showRegisterAcademy() {
        List<ExamineeAcademy> examineeAcademies = examineeAcademyRepository.findAll();

        List<ExamineeAcademyDTO> dto = new ArrayList<>();
        for(ExamineeAcademy examineeAcademy : examineeAcademies) {
            dto.add(ExamineeAcademyDTO.of(examineeAcademy));
        }

        String response = dto.toString();
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/examinee/{examineeId}")
    public ResponseEntity<String> showExaminee(@PathVariable Long examineeId) {
        Examinee examinee = examineeRepository.findById(examineeId).get();
        	String response = ExamineeDTO.of(examinee).toString();
        	return ResponseEntity.ok(response);
    }

    
}
    
    