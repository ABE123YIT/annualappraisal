package com.ymagis.annualappraisal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ymagis.annualappraisal.model.AppraisalFeedback;

@Repository
public interface AppraisalFeedbackRepository extends JpaRepository<AppraisalFeedback, Long> {

	List<AppraisalFeedback> namedFindAllAppraisalFeedbacksByAnnualAppraisal(@Param("id") Long id);

}
