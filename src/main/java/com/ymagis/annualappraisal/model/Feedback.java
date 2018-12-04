package com.ymagis.annualappraisal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.ymagis.annualappraisal.utils.AppraisalFeedbackListDeserializer;
import com.ymagis.annualappraisal.utils.AppraisalFeedbackListSerializer;
import com.ymagis.annualappraisal.utils.Constants;

@Entity
@Table(name = "feedbacks")
public class Feedback implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = Constants.COL_ID)
	private Long id;
	@Column(name = Constants.COL_CODE)
	private String code;
	@Column(name = Constants.COL_LABEL)
	private String label;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Constants.COL_CREATED)
	private Date created;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Constants.COL_UPDATED)
	private Date updated;

	@OneToMany(mappedBy = "feedback")
	@JsonSerialize(using = AppraisalFeedbackListSerializer.class)
	@JsonDeserialize(using = AppraisalFeedbackListDeserializer.class)
	private List<AppraisalFeedback> appraisalFeedbacks = new ArrayList<AppraisalFeedback>();

	public Feedback() {
	}

	public Feedback(Long id, String code, String label, Date created, Date updated,
			List<AppraisalFeedback> appraisalFeedbacks) {
		this.id = id;
		this.code = code;
		this.label = label;
		this.created = created;
		this.updated = updated;
		this.appraisalFeedbacks = appraisalFeedbacks;
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

	public List<AppraisalFeedback> getAppraisalFeedbacks() {
		return appraisalFeedbacks;
	}

	public void setAppraisalFeedbacks(List<AppraisalFeedback> appraisalFeedbacks) {
		this.appraisalFeedbacks = appraisalFeedbacks;
	}

}
