package com.ymagis.annualappraisal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymagis.annualappraisal.model.Objective;
import com.ymagis.annualappraisal.repository.ObjectiveRepository;

@Service(value = "objectiveService")
public class ObjectiveService {

	private static Logger logger = Logger.getLogger(ObjectiveService.class.getName());

	@Autowired
	private ObjectiveRepository repository;

	public List<Objective> getAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return new ArrayList<>();
	}

	public List<Objective> getByAppraisal(Long id) {
		try {
			return repository.namedFindAllObjectivesByAnnualAppraisal(id);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return new ArrayList<>();
	}

	public Objective save(Objective objective) {
		try {
			repository.save(objective);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return objective;
	}

	public boolean saveAll(List<Objective> objectives) {
		try {
			repository.saveAll(objectives);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			return false;
		}
		return true;
	}

	public Objective get(Long id) {
		try {
			Optional<Objective> item = repository.findById(id);
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
			repository.deleteById(id);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
}
