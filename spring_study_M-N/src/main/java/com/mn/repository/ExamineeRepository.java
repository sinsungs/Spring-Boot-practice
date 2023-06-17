package com.mn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mn.entity.Examinee;

public interface ExamineeRepository extends JpaRepository<Examinee, Long> {
	
}
