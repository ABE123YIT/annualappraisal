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

import com.ymagis.annualappraisal.model.Employee;
import com.ymagis.annualappraisal.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	List<Employee> getAll() {
		return service.getAll();
	}

	@RequestMapping(value = "/team/{manager_id}", method = RequestMethod.GET)
	List<Employee> getTeam(@PathVariable(value = "manager_id") Long managerId) {
		return service.getManagerTeam(service.get(managerId));
	}

	@RequestMapping(value = "/managers", method = RequestMethod.GET)
	List<Employee> getManagers() {
		return service.getManagers();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Employee save(@RequestBody Employee model) {
		service.save(model);
		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	Employee get(@PathVariable(value = "id") Long id) throws Exception {
		return service.get(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Employee update(@RequestBody Employee model, @PathVariable("id") Long id) {
		model.setId(id);
		service.update(model);
		return model;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void delete(@PathVariable(value = "id") Long id) throws Exception {
		Employee employee = get(id);
		service.delete(employee);
	}

	@RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
	Employee login(@PathVariable(value = "login") String login) throws Exception {
		return service.login(login);
	}
}
