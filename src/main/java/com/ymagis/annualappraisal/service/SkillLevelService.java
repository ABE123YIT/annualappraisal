package com.ymagis.annualappraisal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymagis.annualappraisal.model.SkillLevel;
import com.ymagis.annualappraisal.repository.SkillLevelRepository;

@Service(value = "skillLevelService")
public class SkillLevelService {

	private static Logger logger = Logger.getLogger(SkillLevelService.class.getName());

	@Autowired
	private SkillLevelRepository repository;

	public List<SkillLevel> getAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return new ArrayList<>();
	}

	public SkillLevel save(SkillLevel skillLevel) {
		try {
			repository.save(skillLevel);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return skillLevel;
	}

	public SkillLevel get(Long id) {
		try {
			Optional<SkillLevel> item = repository.findById(id);
			if (item.isPresent()) {
				return item.get();
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return null;
	}

	public void delete(Long id) {
		try {
			Optional<SkillLevel> item = repository.findById(id);
			if (item.isPresent()) {
				repository.deleteById(id);
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
}
