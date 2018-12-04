package com.ymagis.annualappraisal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ymagis.annualappraisal.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public List<Employee> findByDeletedFalse();

	public List<Employee> findByDeletedTrue();

	public Employee findByLoginAndDeletedFalse(@Param("login") String login);

	public List<Employee> findByManagerAndDeletedFalse(@Param("manager") Employee manager);

	public List<Employee> findByIsManagerTrueAndDeletedFalse();

}
