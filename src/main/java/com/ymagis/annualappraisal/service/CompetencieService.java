package com.ymagis.annualappraisal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymagis.annualappraisal.model.Competencie;
import com.ymagis.annualappraisal.repository.CompetencieRepository;

@Service(value = "competencieService")
public class CompetencieService {

	private static Logger logger = Logger.getLogger(CompetencieService.class.getName());

	@Autowired
	private CompetencieRepository repository;

	public List<Competencie> getAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return new ArrayList<>();
	}

	public List<Competencie> getByAppraisal(Long id) {
		try {
			return repository.namedFindAllCompetenciesByAnnualAppraisal(id);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return new ArrayList<>();
	}

	public Competencie save(Competencie competencie) {
		try {
			repository.save(competencie);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return competencie;
	}

	public Competencie get(Long id) {
		try {
			Optional<Competencie> item = repository.findById(id);
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
