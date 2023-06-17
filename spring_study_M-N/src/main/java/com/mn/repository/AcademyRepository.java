package com.mn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mn.entity.Academy;

public interface AcademyRepository extends JpaRepository<Academy, Long> {
	
}
