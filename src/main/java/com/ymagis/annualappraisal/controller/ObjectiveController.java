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

import com.ymagis.annualappraisal.model.Objective;
import com.ymagis.annualappraisal.service.ObjectiveService;

@RestController
@RequestMapping(value = "/objective", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ObjectiveController {

	@Autowired
	private ObjectiveService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	List<Objective> getAll() {
		return service.getAll();
	}

	@RequestMapping(value = "/appraisal/{id}", method = RequestMethod.GET)
	List<Objective> getByAppraisal(@PathVariable("id") Long id) {
		return service.getByAppraisal(id);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Objective save(@RequestBody Objective model) {
		service.save(model);
		return model;
	}

	@RequestMapping(value = "/saveAll", method = RequestMethod.POST)
	public List<Objective> saveAll(@RequestBody List<Objective> models) {
		service.saveAll(models);
		return models;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	Objective get(@PathVariable(value = "id") Long id) throws Exception {
		return service.get(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Objective update(@RequestBody Objective model, @PathVariable("id") Long id) {
		model.setId(id);
		service.save(model);
		return model;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public boolean updateList(@RequestBody List<Objective> models) {
		return service.saveAll(models);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void delete(@PathVariable(value = "id") Long id) throws Exception {
		service.delete(id);
	}
}
