package com.ymagis.annualappraisal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymagis.annualappraisal.model.AnnualSession;
import com.ymagis.annualappraisal.repository.AnnualSessionRepository;

@Service(value = "annualSessionService")
public class AnnualSessionService {

	private static Logger logger = Logger.getLogger(AnnualSessionService.class.getName());

	@Autowired
	private AnnualSessionRepository repository;

	public List<AnnualSession> getAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return new ArrayList<>();
	}

	public AnnualSession save(AnnualSession annualSession) {
		try {
			repository.save(annualSession);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return annualSession;
	}

	public AnnualSession get(Long id) {
		try {
			Optional<AnnualSession> item = repository.findById(id);
			if (item.isPresent()) {
				return item.get();
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return null;
	}
	
	public AnnualSession getByLabel(String label) {
		try {
			return repository.findByLabel(label);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return null;
	}

	public void delete(Long id) {
		try {
			Optional<AnnualSession> item = repository.findById(id);
			if (item.isPresent()) {
				repository.deleteById(id);
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

}
