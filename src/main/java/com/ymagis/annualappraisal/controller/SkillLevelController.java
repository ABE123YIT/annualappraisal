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

import com.ymagis.annualappraisal.model.SkillLevel;
import com.ymagis.annualappraisal.service.SkillLevelService;

@RestController
@RequestMapping(value = "/skill_level", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class SkillLevelController {

	@Autowired
	private SkillLevelService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	List<SkillLevel> getAll() {
		return service.getAll();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public SkillLevel save(@RequestBody SkillLevel model) {
		service.save(model);
		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	SkillLevel get(@PathVariable(value = "id") Long id) throws Exception {
		return service.get(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public SkillLevel update(@RequestBody SkillLevel model, @PathVariable("id") Long id) {
		model.setId(id);
		service.save(model);
		return model;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void delete(@PathVariable(value = "id") Long id) throws Exception {
		service.delete(id);
	}
}
