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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ymagis.annualappraisal.utils.Constants;
import com.ymagis.annualappraisal.utils.SkillEvaluationListDeserializer;
import com.ymagis.annualappraisal.utils.SkillEvaluationListSerializer;
import com.ymagis.annualappraisal.utils.SkillSerializer;

@Entity
@Table(name = "skill_levels")
@NamedQuery(name = "SkillLevel.namedFindAllSkillLevelsBySkill", query = "select c from SkillLevel c where c.skill.id = :id")
public class SkillLevel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = Constants.COL_ID)
	private Long id;
	@Column(name = Constants.COL_RANKING)
	private Long ranking;
	@Column(name = Constants.COL_MEANING)
	private String meaning;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Constants.COL_CREATED)
	private Date created;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Constants.COL_UPDATED)
	private Date updated;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = Constants.COL_SKILL_ID)
	@JsonSerialize(using = SkillSerializer.class)
	private Skill skill;

	@OneToMany(mappedBy = "skillLevel", fetch = FetchType.LAZY)
	@JsonSerialize(using = SkillEvaluationListSerializer.class)
	@JsonDeserialize(using = SkillEvaluationListDeserializer.class)
	private List<SkillEvaluation> skillEvaluations = new ArrayList<SkillEvaluation>();

	public SkillLevel() {
	}

	public SkillLevel(Long id, Long ranking, String meaning, Date created, Date updated, Skill skill,
			List<SkillEvaluation> skillEvaluations) {
		this.id = id;
		this.ranking = ranking;
		this.meaning = meaning;
		this.created = created;
		this.updated = updated;
		this.skill = skill;
		this.skillEvaluations = skillEvaluations;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRanking() {
		return ranking;
	}

	public void setRanking(Long ranking) {
		this.ranking = ranking;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
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

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public List<SkillEvaluation> getSkillEvaluations() {
		return skillEvaluations;
	}

	public void setSkillEvaluations(List<SkillEvaluation> skillEvaluations) {
		this.skillEvaluations = skillEvaluations;
	}

}
