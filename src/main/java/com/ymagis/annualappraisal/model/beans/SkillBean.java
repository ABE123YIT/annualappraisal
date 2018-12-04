package com.ymagis.annualappraisal.model.beans;

import java.util.ArrayList;
import java.util.List;

public class SkillBean {

	private Long id;
	private String code;
	private String label;
	private String type;
	private List<SkillLevelBean> skillLevelBeans = new ArrayList<SkillLevelBean>();

	public SkillBean() {
	}

	public SkillBean(Long id, String code, String label, String type, List<SkillLevelBean> skillLevelBeans) {
		super();
		this.id = id;
		this.code = code;
		this.label = label;
		this.type = type;
		this.skillLevelBeans = skillLevelBeans;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<SkillLevelBean> getSkillLevelBeans() {
		return skillLevelBeans;
	}

	public void setSkillLevelBeans(List<SkillLevelBean> skillLevelBeans) {
		this.skillLevelBeans = skillLevelBeans;
	}

}
