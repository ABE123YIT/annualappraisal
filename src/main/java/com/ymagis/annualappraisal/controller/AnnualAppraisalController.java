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

import com.ymagis.annualappraisal.model.AnnualAppraisal;
import com.ymagis.annualappraisal.model.beans.AppraisalBean;
import com.ymagis.annualappraisal.service.AnnualAppraisalService;

@RestController
@RequestMapping(value = "/annual_appraisal", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class AnnualAppraisalController {

	@Autowired
	private AnnualAppraisalService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	List<AnnualAppraisal> getAll() {
		return service.getAll();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public AnnualAppraisal save(@RequestBody AnnualAppraisal model) {
		service.save(model);
		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	AnnualAppraisal get(@PathVariable(value = "id") Long id) throws Exception {
		return service.get(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public AnnualAppraisal update(@RequestBody AnnualAppraisal model, @PathVariable("id") Long id) {
		model.setId(id);
		service.save(model);
		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Long id) throws Exception {
		service.delete(id);
	}

	@RequestMapping(value = "/by/{employee_id}/{session_id}", method = RequestMethod.GET)
	AnnualAppraisal getByEmployeeAndSession(@PathVariable(value = "employee_id") Long employeeId,
			@PathVariable(value = "session_id") Long sessionId) throws Exception {
		return service.getByEmployeeAndSession(employeeId, sessionId);
	}

	@RequestMapping(value = "/history/{employee_id}/{date}", method = RequestMethod.GET)
	List<AppraisalBean> getAppraisalsHistory(@PathVariable(value = "employee_id") Long employeeId,
			@PathVariable(value = "date") String date) throws Exception {
		return service.getAppraisalsHistory(employeeId, date);
	}
	
	@RequestMapping(value = "/employee/{employee_id}", method = RequestMethod.GET)
	List<AppraisalBean> getEmployeeAppraisals(@PathVariable(value = "employee_id") Long employeeId) throws Exception {
		return service.getEmployeeAppraisals(employeeId);
	}
}
