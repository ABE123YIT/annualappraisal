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
@Table(name = "competencies")
@NamedQuery(name = "Competencie.namedFindAllCompetenciesByAnnualAppraisal", query = "select c from Competencie c where c.annualAppraisal.id = :id")
public class Competencie implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = Constants.COL_ID)
	private Long id;
	@Column(name = Constants.COL_CODE)
	private String code;
	@Column(name = Constants.COL_LABEL)
	private String label;
	@Column(name = Constants.COL_MEANING)
	private String meaning;
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

	public Competencie() {
	}

	public Competencie(Long id, String code, String label, String meaning, String comment, Date created, Date updated,
			AnnualAppraisal annualAppraisal, Rating rating) {
		this.id = id;
		this.code = code;
		this.label = label;
		this.meaning = meaning;
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

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
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
