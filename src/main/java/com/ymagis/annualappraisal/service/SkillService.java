package com.ymagis.annualappraisal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymagis.annualappraisal.model.Skill;
import com.ymagis.annualappraisal.repository.SkillRepository;

@Service(value = "skillService")
public class SkillService {

	private static Logger logger = Logger.getLogger(SkillService.class.getName());

	@Autowired
	private SkillRepository repository;

	public List<Skill> getAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return new ArrayList<>();
	}

	public Skill save(Skill skill) {
		try {
			repository.save(skill);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return skill;
	}

	public Skill get(Long id) {
		try {
			Optional<Skill> item = repository.findById(id);
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
			Optional<Skill> item = repository.findById(id);
			if (item.isPresent()) {
				repository.deleteById(id);
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
}
