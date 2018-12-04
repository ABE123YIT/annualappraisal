package com.ymagis.annualappraisal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ymagis.annualappraisal.model.SkillEvaluation;

@Repository
public interface SkillEvaluationRepository extends JpaRepository<SkillEvaluation, Long> {

	List<SkillEvaluation> namedFindAllSkillEvaluationsBySkill(@Param("id") Long id);
	
	List<SkillEvaluation> namedFindAllSkillEvaluationsByAnnualAppraisalAndType(@Param("id") Long id, @Param("type") String type);
}
