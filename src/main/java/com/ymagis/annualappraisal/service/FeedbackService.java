package com.ymagis.annualappraisal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymagis.annualappraisal.model.Feedback;
import com.ymagis.annualappraisal.repository.FeedbackRepository;

@Service(value = "feedbackService")
public class FeedbackService {

	private static Logger logger = Logger.getLogger(FeedbackService.class.getName());

	@Autowired
	private FeedbackRepository repository;

	public List<Feedback> getAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return new ArrayList<>();
	}

	public Feedback save(Feedback feedback) {
		try {
			repository.save(feedback);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return feedback;
	}

	public Feedback get(Long id) {
		try {
			Optional<Feedback> item = repository.findById(id);
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
			Optional<Feedback> item = repository.findById(id);
			if (item.isPresent()) {
				repository.deleteById(id);
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
}
