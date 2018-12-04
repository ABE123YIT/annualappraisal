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

import com.ymagis.annualappraisal.model.AnnualSession;
import com.ymagis.annualappraisal.service.AnnualSessionService;

@RestController
@RequestMapping(value = "/annual_session", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class AnnualSessionController {

	@Autowired
	private AnnualSessionService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	List<AnnualSession> getAll() {
		return service.getAll();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public AnnualSession save(@RequestBody AnnualSession model) {
		service.save(model);
		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	AnnualSession get(@PathVariable(value = "id") Long id) throws Exception {
		return service.get(id);
	}
	
	@RequestMapping(value = "/label/{label}", method = RequestMethod.GET)
	AnnualSession getByLabel(@PathVariable(value = "label") String label) throws Exception {
		return service.getByLabel(label);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public AnnualSession update(@RequestBody AnnualSession model, @PathVariable("id") Long id) {
		model.setId(id);
		service.save(model);
		return model;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void delete(@PathVariable(value = "id") Long id) throws Exception {
		service.delete(id);
	}
}
