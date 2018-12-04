package com.ymagis.annualappraisal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ymagis.annualappraisal.utils.AnnualAppraisalSerializer;
import com.ymagis.annualappraisal.utils.Constants;
import com.ymagis.annualappraisal.utils.RatingSerializer;

@Entity
@Table(name = "objectives")
@NamedQuery(name = "Objective.namedFindAllObjectivesByAnnualAppraisal", query = "select o from Objective o where o.annualAppraisal.id = :id")
@NamedQuery(name = "Objective.namedFindAllObjectivesByEmployeeAndAnnualSession", query = "select o from Objective o where o.annualAppraisal.employee.id = :employee_id and o.annualAppraisal.annualSession.id = :annual_session_id")
public class Objective implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = Constants.COL_ID)
	private Long id;
	@Column(name = Constants.COL_CODE)
	private String code;
	@Column(name = Constants.COL_LABEL)
	private String label;
	@Column(name = Constants.COL_INDICATOR)
	private String indicator;
	@Column(name = Constants.COL_MEAN)
	private String mean;
	@Temporal(TemporalType.DATE)
	@Column(name = Constants.COL_DEADLINE)
	private Date deadline;
	@Column(name = Constants.COL_COMMENT)
	private String comment;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Constants.COL_CREATED)
	private Date created;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Constants.COL_UPDATED)
	private Date updated;
	@ManyToOne
	@JoinColumn(name = Constants.COL_APPRAISAL_ID)
	@JsonSerialize(using = AnnualAppraisalSerializer.class)
	private AnnualAppraisal annualAppraisal;
	@ManyToOne
	@JoinColumn(name = Constants.COL_RATING_ID)
	@JsonSerialize(using = RatingSerializer.class)
	private Rating rating;

	public Objective() {
	}

	public Objective(Long id, String code, String label, String indicator, String mean, Date deadline, String comment,
			Date created, Date updated, AnnualAppraisal annualAppraisal, Rating rating) {
		this.id = id;
		this.code = code;
		this.label = label;
		this.indicator = indicator;
		this.mean = mean;
		this.deadline = deadline;
		this.comment = comment;
		this.created = created;
		this.updated = updated;
		this.annualAppraisal = annualAppraisal;
		this.rating = rating;
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

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public String getMean() {
		return mean;
	}

	public void setMean(String mean) {
		this.mean = mean;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public AnnualAppraisal getAnnualAppraisal() {
		return annualAppraisal;
	}

	public void setAnnualAppraisal(AnnualAppraisal annualAppraisal) {
		this.annualAppraisal = annualAppraisal;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

}
