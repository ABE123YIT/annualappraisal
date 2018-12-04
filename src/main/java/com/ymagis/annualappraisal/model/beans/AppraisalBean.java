package com.ymagis.annualappraisal.model.beans;

import java.util.Date;

public class AppraisalBean {

	private Long id;
	private Date appraisalDate;
	private String strenghts;
	private String improved;
	private String status;
	private String additionalFeedback;
	private Date employeeWish;
	private Date managerOpinion;
	private Long employeeId;
	private Long annualSessionId;
	private String sessionLabel;
	private Date sessionEndDate;
	private String mode;

	public AppraisalBean() {
	}

	public AppraisalBean(Long id, Long annualSessionId, String sessionLabel, Date sessionEndDate, String status) {
		this.id = id;
		this.annualSessionId = annualSessionId;
		this.sessionLabel = sessionLabel;
		this.sessionEndDate = sessionEndDate;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAppraisalDate() {
		return appraisalDate;
	}

	public void setAppraisalDate(Date appraisalDate) {
		this.appraisalDate = appraisalDate;
	}

	public String getStrenghts() {
		return strenghts;
	}

	public void setStrenghts(String strenghts) {
		this.strenghts = strenghts;
	}

	public String getImproved() {
		return improved;
	}

	public void setImproved(String improved) {
		this.improved = improved;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAdditionalFeedback() {
		return additionalFeedback;
	}

	public void setAdditionalFeedback(String additionalFeedback) {
		this.additionalFeedback = additionalFeedback;
	}

	public Date getEmployeeWish() {
		return employeeWish;
	}

	public void setEmployeeWish(Date employeeWish) {
		this.employeeWish = employeeWish;
	}

	public Date getManagerOpinion() {
		return managerOpinion;
	}

	public void setManagerOpinion(Date managerOpinion) {
		this.managerOpinion = managerOpinion;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getAnnualSessionId() {
		return annualSessionId;
	}

	public void setAnnualSessionId(Long annualSessionId) {
		this.annualSessionId = annualSessionId;
	}

	public String getSessionLabel() {
		return sessionLabel;
	}

	public void setSessionLabel(String sessionLabel) {
		this.sessionLabel = sessionLabel;
	}

	public Date getSessionEndDate() {
		return sessionEndDate;
	}

	public void setSessionEndDate(Date sessionEndDate) {
		this.sessionEndDate = sessionEndDate;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

}
