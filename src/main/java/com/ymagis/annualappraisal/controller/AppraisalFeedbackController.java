package com.ymagis.annualappraisal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ymagis.annualappraisal.model.AppraisalFeedback;
import com.ymagis.annualappraisal.model.Competencie;
import com.ymagis.annualappraisal.service.AppraisalFeedbackService;

@RestController
@RequestMapping(value = "/appraisal_feedback", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class AppraisalFeedbackController {

	@Autowired
	private AppraisalFeedbackService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	List<AppraisalFeedback> getAll() {
		return service.getAll();
	}
	
	@RequestMapping(value = "/appraisal/{id}", method = RequestMethod.GET)
	List<AppraisalFeedback> getByAppraisal(@PathVariable("id") Long id) {
		return service.getByAppraisal(id);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public AppraisalFeedback save(@RequestBody AppraisalFeedback model) {
		service.save(model);
		return model;
	}
	
	@RequestMapping(value = "/saveAll", method = RequestMethod.POST)
	public List<AppraisalFeedback> saveAll(@RequestBody List<AppraisalFeedback> models) {
		service.saveAll(models);
		return models;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	AppraisalFeedback get(@PathVariable(value = "id") Long id) throws Exception {
		return service.get(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public AppraisalFeedback update(@RequestBody AppraisalFeedback model, @PathVariable("id") Long id) {
		model.setId(id);
		service.save(model);
		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Long id) throws Exception {
		service.delete(id);
	}
}
