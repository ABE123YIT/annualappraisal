package com.ymagis.annualappraisal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymagis.annualappraisal.model.AppraisalFeedback;
import com.ymagis.annualappraisal.model.Feedback;
import com.ymagis.annualappraisal.repository.AnnualAppraisalRepository;
import com.ymagis.annualappraisal.repository.AppraisalFeedbackRepository;
import com.ymagis.annualappraisal.repository.FeedbackRepository;

@Service(value = "appraisalFeedbackService")
public class AppraisalFeedbackService {

	private static Logger logger = Logger.getLogger(AppraisalFeedbackService.class.getName());

	@Autowired
	private AppraisalFeedbackRepository repository;

	@Autowired
	private FeedbackRepository feedbackrepository;

	@Autowired
	private AnnualAppraisalRepository appraisalrepository;

	public List<AppraisalFeedback> getAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return new ArrayList<>();
	}

	public List<AppraisalFeedback> getByAppraisal(Long id) {
		List<AppraisalFeedback> list = new ArrayList<>();
		Map<Long, AppraisalFeedback> map = new HashMap<>();
		try {
			List<Feedback> feedbacks = feedbackrepository.findAll();
			List<AppraisalFeedback> appraisalfeedbacks = repository.namedFindAllAppraisalFeedbacksByAnnualAppraisal(id);
			if (null != appraisalfeedbacks && !appraisalfeedbacks.isEmpty()) {
				for (AppraisalFeedback elt : appraisalfeedbacks) {
					map.put(elt.getFeedback().getId(), elt);
				}
			}
			if (null != feedbacks && !feedbacks.isEmpty()) {
				for (Feedback elt : feedbacks) {
					if (map.containsKey(elt.getId())) {
						list.add(map.get(elt.getId()));
					} else {
						AppraisalFeedback appraisalfeedback = new AppraisalFeedback();
						appraisalfeedback.setFeedback(elt);
						appraisalfeedback.setAnnualAppraisal(appraisalrepository.findById(id).get());
						list.add(appraisalfeedback);
					}
				}
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return list;
	}

	public AppraisalFeedback save(AppraisalFeedback appraisalFeedback) {
		try {
			repository.save(appraisalFeedback);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return appraisalFeedback;
	}

	public List<AppraisalFeedback> saveAll(List<AppraisalFeedback> models) {
		try {
			repository.saveAll(models);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return models;
	}

	public AppraisalFeedback get(Long id) {
		try {
			Optional<AppraisalFeedback> item = repository.findById(id);
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
