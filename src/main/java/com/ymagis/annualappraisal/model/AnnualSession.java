package com.ymagis.annualappraisal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ymagis.annualappraisal.utils.AnnualAppraisalListDeserializer;
import com.ymagis.annualappraisal.utils.AnnualAppraisalListSerializer;
import com.ymagis.annualappraisal.utils.Constants;

@Entity
@Table(name = "annual_sessions")
public class AnnualSession implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = Constants.COL_ID)
	private Long id;
	@Column(name = Constants.COL_CODE)
	private String code;
	@Column(name = Constants.COL_LABEL)
	private String label;
	@Column(name = Constants.COL_STATUS)
	private String status;
	@Temporal(TemporalType.DATE)
	@Column(name = Constants.COL_START_DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	@Column(name = Constants.COL_END_DATE)
	private Date endDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Constants.COL_CREATED)
	private Date created;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Constants.COL_UPDATED)
	private Date updated;
	@OneToMany(mappedBy = "annualSession", fetch = FetchType.LAZY)
	@JsonSerialize(using = AnnualAppraisalListSerializer.class)
	@JsonDeserialize(using = AnnualAppraisalListDeserializer.class)
	private List<AnnualAppraisal> annualAppraisals = new ArrayList<AnnualAppraisal>();

	public AnnualSession() {
	}

	public AnnualSession(Long id, String code, String label, String status, Date startDate, Date endDate, Date created,
			Date updated, List<AnnualAppraisal> annualAppraisals) {
		this.id = id;
		this.code = code;
		this.label = label;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.created = created;
		this.updated = updated;
		this.annualAppraisals = annualAppraisals;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public List<AnnualAppraisal> getAnnualAppraisals() {
		return annualAppraisals;
	}

	public void setAnnualAppraisals(List<AnnualAppraisal> annualAppraisals) {
		this.annualAppraisals = annualAppraisals;
	}

}
