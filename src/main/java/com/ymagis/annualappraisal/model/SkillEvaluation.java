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
import com.ymagis.annualappraisal.utils.AnnualAppraisalListSerializer;
import com.ymagis.annualappraisal.utils.AnnualAppraisalSerializer;
import com.ymagis.annualappraisal.utils.Constants;
import com.ymagis.annualappraisal.utils.SkillLevelSerializer;
import com.ymagis.annualappraisal.utils.SkillSerializer;

@Entity
@Table(name = "skill_evaluations")
@NamedQuery(name = "SkillEvaluation.namedFindAllSkillEvaluationsBySkill", query = "select s from SkillEvaluation s where s.skillLevel.id = :id")
@NamedQuery(name = "SkillEvaluation.namedFindAllSkillEvaluationsByAnnualAppraisalAndType", query = "select s from SkillEvaluation s where s.annualAppraisal.id = :id and s.skillLevel.skill.type = :type")
public class SkillEvaluation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = Constants.COL_ID)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Constants.COL_CREATED)
	private Date created;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Constants.COL_UPDATED)
	private Date updated;
	@ManyToOne
	@JoinColumn(name = Constants.COL_SKILL_LEVEL_ID)
	@JsonSerialize(using = SkillLevelSerializer.class)
	private SkillLevel skillLevel;
	@ManyToOne
	@JoinColumn(name = Constants.COL_APPRAISAL_ID)
	@JsonSerialize(using = AnnualAppraisalSerializer.class)
	private AnnualAppraisal annualAppraisal;

	public SkillEvaluation() {
	}

	public SkillEvaluation(Long id, Date created, Date updated, SkillLevel skillLevel,
			AnnualAppraisal annualAppraisal) {
		this.id = id;
		this.created = created;
		this.updated = updated;
		this.skillLevel = skillLevel;
		this.annualAppraisal = annualAppraisal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public SkillLevel getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(SkillLevel skillLevel) {
		this.skillLevel = skillLevel;
	}

	public AnnualAppraisal getAnnualAppraisal() {
		return annualAppraisal;
	}

	public void setAnnualAppraisal(AnnualAppraisal annualAppraisal) {
		this.annualAppraisal = annualAppraisal;
	}

}
