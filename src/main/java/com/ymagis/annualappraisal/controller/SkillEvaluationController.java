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

import com.ymagis.annualappraisal.model.SkillEvaluation;
import com.ymagis.annualappraisal.model.beans.SkillBean;
import com.ymagis.annualappraisal.service.SkillEvaluationService;

@RestController
@RequestMapping(value = "/skill_evaluation", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class SkillEvaluationController {

	@Autowired
	private SkillEvaluationService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	List<SkillEvaluation> getAll() {
		return service.getAll();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public SkillEvaluation save(@RequestBody SkillEvaluation model) {
		service.save(model);
		return model;
	}

	@RequestMapping(value = "/saveAll/{appraisal_id}/{type}", method = RequestMethod.POST)
	public List<SkillEvaluation> saveAll(@RequestBody List<SkillEvaluation> models,
			@PathVariable(value = "appraisal_id") Long appraisalId, @PathVariable(value = "type") String type) {
		service.saveAll(models, appraisalId, type);
		return models;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	SkillEvaluation get(@PathVariable(value = "id") Long id) throws Exception {
		return service.get(id);
	}

	@RequestMapping(value = "/appraisal/{id}/{type}", method = RequestMethod.GET)
	List<SkillBean> getByAppraisalAndType(@PathVariable(value = "id") Long id,
			@PathVariable(value = "type") String type) throws Exception {
		return service.getByAppraisalAndType(id, type);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public SkillEvaluation update(@RequestBody SkillEvaluation model, @PathVariable("id") Long id) {
		model.setId(id);
		service.save(model);
		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Long id) throws Exception {
		service.delete(id);
	}
}
