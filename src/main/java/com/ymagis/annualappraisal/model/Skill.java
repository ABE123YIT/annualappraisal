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
import com.ymagis.annualappraisal.utils.Constants;
import com.ymagis.annualappraisal.utils.SkillLevelListDeserializer;
import com.ymagis.annualappraisal.utils.SkillLevelListSerializer;

@Entity
@Table(name = "skills")
public class Skill implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = Constants.COL_ID)
	private Long id;
	@Column(name = Constants.COL_CODE)
	private String code;
	@Column(name = Constants.COL_LABEL)
	private String label;
	@Column(name = Constants.COL_TYPE)
	private String type;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Constants.COL_CREATED)
	private Date created;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Constants.COL_UPDATED)
	private Date updated;
	@OneToMany(mappedBy = "skill", fetch = FetchType.LAZY)
	@JsonSerialize(using = SkillLevelListSerializer.class)
	@JsonDeserialize(using = SkillLevelListDeserializer.class)
	private List<SkillLevel> skillLevels = new ArrayList<SkillLevel>();

	public Long getId() {
		return id;
	}

	public Skill() {
	}

	public Skill(Long id, String code, String label, String type, Date created, Date updated,
			List<SkillLevel> skillLevels) {
		this.id = id;
		this.code = code;
		this.label = label;
		this.type = type;
		this.created = created;
		this.updated = updated;
		this.skillLevels = skillLevels;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public List<SkillLevel> getSkillLevels() {
		return skillLevels;
	}

	public void setSkillLevels(List<SkillLevel> skillLevels) {
		this.skillLevels = skillLevels;
	}

}
