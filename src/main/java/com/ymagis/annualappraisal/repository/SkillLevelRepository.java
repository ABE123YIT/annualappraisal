package com.ymagis.annualappraisal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ymagis.annualappraisal.model.SkillLevel;

@Repository
public interface SkillLevelRepository extends JpaRepository<SkillLevel, Long> {

	List<SkillLevel> namedFindAllSkillLevelsBySkill(@Param("id") Long id);

}
