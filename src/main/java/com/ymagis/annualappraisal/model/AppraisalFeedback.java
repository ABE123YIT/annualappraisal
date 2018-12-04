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
import com.ymagis.annualappraisal.utils.FeedbackSerializer;

@Entity
@Table(name = "appraisal_feedbacks")
@NamedQuery(name = "AppraisalFeedback.namedFindAllAppraisalFeedbacksByAnnualAppraisal", query = "select a from AppraisalFeedback a where a.annualAppraisal.id = :id")
public class AppraisalFeedback implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = Constants.COL_ID)
	private Long id;
	@Column(name = Constants.COL_COMMENT)
	private String comment;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Constants.COL_CREATED)
	private Date created;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Constants.COL_UPDATED)
	private Date updated;
	@ManyToOne
	@JoinColumn(name = Constants.COL_FEEDBACK_ID)
	@JsonSerialize(using = FeedbackSerializer.class)
	private Feedback feedback;
	@ManyToOne
	@JoinColumn(name = Constants.COL_APPRAISAL_ID)
	@JsonSerialize(using = AnnualAppraisalSerializer.class)
	private AnnualAppraisal annualAppraisal;

	public AppraisalFeedback() {
	}

	public AppraisalFeedback(Long id, String comment, Date created, Date updated, Feedback feedback,
			AnnualAppraisal annualAppraisal) {
		this.id = id;
		this.comment = comment;
		this.created = created;
		this.updated = updated;
		this.feedback = feedback;
		this.annualAppraisal = annualAppraisal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public AnnualAppraisal getAnnualAppraisal() {
		return annualAppraisal;
	}

	public void setAnnualAppraisal(AnnualAppraisal annualAppraisal) {
		this.annualAppraisal = annualAppraisal;
	}

}
