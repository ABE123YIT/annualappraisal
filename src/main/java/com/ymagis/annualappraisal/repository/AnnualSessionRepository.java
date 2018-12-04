package com.ymagis.annualappraisal.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ymagis.annualappraisal.model.AnnualSession;

@Repository
public interface AnnualSessionRepository extends JpaRepository<AnnualSession, Long> {

	public List<AnnualSession> findByEndDateAfter(@Param("endDate") Date endDate);
	
	public AnnualSession findByLabel(@Param("label") String label);

}
