package com.ymagis.annualappraisal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ymagis.annualappraisal.model.Competencie;

@Repository
public interface CompetencieRepository extends JpaRepository<Competencie, Long> {

	List<Competencie> namedFindAllCompetenciesByAnnualAppraisal(@Param("id") Long id);

}
