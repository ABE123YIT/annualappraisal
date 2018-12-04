package com.ymagis.annualappraisal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ymagis.annualappraisal.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

}
