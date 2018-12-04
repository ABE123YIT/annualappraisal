package com.ymagis.annualappraisal.model.beans;

public class SkillLevelBean {

	private Long id;
	private Long ranking;
	private String meaning;
	private Boolean checked;
	private SkillBean skillBean;

	public SkillLevelBean() {
	}

	public SkillLevelBean(Long id, Long ranking, String meaning, Boolean checked, SkillBean skillBean) {
		super();
		this.id = id;
		this.ranking = ranking;
		this.meaning = meaning;
		this.checked = checked;
		this.skillBean = skillBean;
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

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public SkillBean getSkillBean() {
		return skillBean;
	}

	public void setSkillBean(SkillBean skillBean) {
		this.skillBean = skillBean;
	}

}
