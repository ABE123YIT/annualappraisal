package com.ymagis.annualappraisal.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymagis.annualappraisal.model.Employee;
import com.ymagis.annualappraisal.repository.EmployeeRepository;

@Service(value = "employeeService")
public class EmployeeService {

	private static Logger logger = Logger.getLogger(EmployeeService.class.getName());

	@Autowired
	private EmployeeRepository repository;

	public List<Employee> getAll() {
		try {
			return repository.findByDeletedFalse();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return new ArrayList<>();
	}

	public Employee login(String login) {
		try {
			return repository.findByLoginAndDeletedFalse(login);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return null;
	}

	public List<Employee> getManagerTeam(Employee manager) {
		try {
			return repository.findByManagerAndDeletedFalse(manager);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return new ArrayList<>();
	}

	public List<Employee> getManagers() {
		try {
			return repository.findByIsManagerTrueAndDeletedFalse();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return new ArrayList<>();
	}

	public Employee save(Employee employee) {
		try {
			employee.businessTreatment();
			repository.save(employee);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return employee;
	}

	public Employee update(Employee employee) {
		try {
			employee.setUpdated(new Date());
			repository.save(employee);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return employee;
	}

	public Employee get(Long id) {
		try {
			Optional<Employee> item = repository.findById(id);
			if (item.isPresent()) {
				return item.get();
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return null;
	}

	public void delete(Employee employee) {
		try {
			employee.setDeleted(true);
			repository.save(employee);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
}
