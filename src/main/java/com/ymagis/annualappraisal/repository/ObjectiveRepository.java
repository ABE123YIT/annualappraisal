package com.ymagis.annualappraisal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ymagis.annualappraisal.model.Objective;

@Repository
public interface ObjectiveRepository extends JpaRepository<Objective, Long> {

	List<Objective> namedFindAllObjectivesByAnnualAppraisal(@Param("id") Long id);

	List<Objective> namedFindAllObjectivesByEmployeeAndAnnualSession(@Param("employee_id") Long employeeId,
			@Param("annual_session_id") Long annualSessionId);

}
