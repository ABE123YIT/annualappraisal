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

import com.ymagis.annualappraisal.model.Competencie;
import com.ymagis.annualappraisal.service.CompetencieService;

@RestController
@RequestMapping(value = "/competencie", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CompetencieController {

	@Autowired
	private CompetencieService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	List<Competencie> getAll() {
		return service.getAll();
	}

	@RequestMapping(value = "/appraisal/{id}", method = RequestMethod.GET)
	List<Competencie> getByAppraisal(@PathVariable("id") Long id) {
		return service.getByAppraisal(id);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Competencie save(@RequestBody Competencie model) {
		service.save(model);
		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	Competencie get(@PathVariable(value = "id") Long id) throws Exception {
		return service.get(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Competencie update(@RequestBody Competencie model, @PathVariable("id") Long id) {
		model.setId(id);
		service.save(model);
		return model;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void delete(@PathVariable(value = "id") Long id) throws Exception {
		service.delete(id);
	}
}
