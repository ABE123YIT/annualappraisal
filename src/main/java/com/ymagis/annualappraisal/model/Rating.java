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
import com.ymagis.annualappraisal.utils.CompetencieListDeserializer;
import com.ymagis.annualappraisal.utils.CompetencieListSerializer;
import com.ymagis.annualappraisal.utils.Constants;
import com.ymagis.annualappraisal.utils.ObjectiveListDeserializer;
import com.ymagis.annualappraisal.utils.ObjectiveListSerializer;

@Entity
@Table(name = "ratings")
public class Rating implements Serializable {

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

	@OneToMany(mappedBy = "rating")
	@JsonSerialize(using = ObjectiveListSerializer.class)
	@JsonDeserialize(using = ObjectiveListDeserializer.class)
	private List<Objective> objectives = new ArrayList<Objective>();

	@OneToMany(mappedBy = "rating")
	@JsonSerialize(using = CompetencieListSerializer.class)
	@JsonDeserialize(using = CompetencieListDeserializer.class)
	private List<Competencie> competencies = new ArrayList<Competencie>();

	public Rating() {
	}

	public Rating(Long id, String code, String label, Date created, Date updated, List<Objective> objectives,
			List<Competencie> competencies) {
		this.id = id;
		this.code = code;
		this.label = label;
		this.created = created;
		this.updated = updated;
		this.objectives = objectives;
		this.competencies = competencies;
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

	public List<Objective> getObjectives() {
		return objectives;
	}

	public void setObjectives(List<Objective> objectives) {
		this.objectives = objectives;
	}

	public List<Competencie> getCompetencies() {
		return competencies;
	}

	public void setCompetencies(List<Competencie> competencies) {
		this.competencies = competencies;
	}

}
