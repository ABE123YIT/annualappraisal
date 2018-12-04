package com.ymagis.annualappraisal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ymagis.annualappraisal.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

	public List<Skill> findByType(@Param("type") String type);

}
