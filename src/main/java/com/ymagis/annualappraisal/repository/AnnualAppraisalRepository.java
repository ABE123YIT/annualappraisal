package com.ymagis.annualappraisal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ymagis.annualappraisal.model.AnnualAppraisal;

@Repository
public interface AnnualAppraisalRepository extends JpaRepository<AnnualAppraisal, Long> {

	List<AnnualAppraisal> namedFindAllAnnualAppraisalsByEmployee(@Param("id") Long id);

	List<AnnualAppraisal> namedFindAllAnnualAppraisalsByAnnualSession(@Param("id") Long id);

	AnnualAppraisal namedFindAllAnnualAppraisalsByEmployeeAndAnnualSession(@Param("employee_id") Long employeeId,
			@Param("annual_session_id") Long annualSessionId);

}
