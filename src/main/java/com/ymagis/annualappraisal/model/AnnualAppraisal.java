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
import com.ymagis.annualappraisal.utils.AnnualSessionSerializer;
import com.ymagis.annualappraisal.utils.AppraisalFeedbackListDeserializer;
import com.ymagis.annualappraisal.utils.AppraisalFeedbackListSerializer;
import com.ymagis.annualappraisal.utils.CompetencieListDeserializer;
import com.ymagis.annualappraisal.utils.CompetencieListSerializer;
import com.ymagis.annualappraisal.utils.Constants;
import com.ymagis.annualappraisal.utils.EmployeeSerializer;
import com.ymagis.annualappraisal.utils.ObjectiveListDeserializer;
import com.ymagis.annualappraisal.utils.ObjectiveListSerializer;
import com.ymagis.annualappraisal.utils.SkillEvaluationListDeserializer;
import com.ymagis.annualappraisal.utils.SkillEvaluationListSerializer;

@Entity
@Table(name = "annual_appraisals")
@NamedQuery(name = "AnnualAppraisal.namedFindAllAnnualAppraisalsByEmployee", query = "select a from AnnualAppraisal a where a.employee.id = :id")
@NamedQuery(name = "AnnualAppraisal.namedFindAllAnnualAppraisalsByAnnualSession", query = "select a from AnnualAppraisal a where a.annualSession.id = :id")
@NamedQuery(name = "AnnualAppraisal.namedFindAllAnnualAppraisalsByEmployeeAndAnnualSession", query = "select a from AnnualAppraisal a where a.employee.id = :employee_id and a.annualSession.id = :annual_session_id")
public class AnnualAppraisal implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = Constants.COL_ID)
	private Long id;
	@Column(name = Constants.COL_APPRAISAL_DATE)
	private Date appraisalDate;
	@Column(name = Constants.COL_STRENGHTS)
	private String strenghts;
	@Column(name = Constants.COL_IMPROVED)
	private String improved;
	@Column(name = Constants.COL_STATUS)
	private String status;
	@Column(name = Constants.COL_ADDITIONAL_FEEDBACK)
	private String additionalFeedback;
	@Column(name = Constants.COL_EMPLOYEE_WISH)
	private String employeeWish;
	@Column(name = Constants.COL_MANAGER_OPINION)
	private String managerOpinion;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Constants.COL_CREATED)
	private Date created;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Constants.COL_UPDATED)
	private Date updated;
	@ManyToOne
	@JoinColumn(name = Constants.COL_EMPLOYEE_ID)
	@JsonSerialize(using = EmployeeSerializer.class)
	private Employee employee;
	@ManyToOne
	@JoinColumn(name = Constants.COL_SESSION_ID)
	@JsonSerialize(using = AnnualSessionSerializer.class)
	private AnnualSession annualSession;

	@OneToMany(mappedBy = "annualAppraisal")
	@JsonSerialize(using = ObjectiveListSerializer.class)
	@JsonDeserialize(using = ObjectiveListDeserializer.class)
	private List<Objective> objectives = new ArrayList<Objective>();

	@OneToMany(mappedBy = "annualAppraisal")
	@JsonSerialize(using = CompetencieListSerializer.class)
	@JsonDeserialize(using = CompetencieListDeserializer.class)
	private List<Competencie> competencies = new ArrayList<Competencie>();

	@OneToMany(mappedBy = "annualAppraisal")
	@JsonSerialize(using = SkillEvaluationListSerializer.class)
	@JsonDeserialize(using = SkillEvaluationListDeserializer.class)
	private List<SkillEvaluation> skillEvaluations = new ArrayList<SkillEvaluation>();

	@OneToMany(mappedBy = "annualAppraisal")
	@JsonSerialize(using = AppraisalFeedbackListSerializer.class)
	@JsonDeserialize(using = AppraisalFeedbackListDeserializer.class)
	private List<AppraisalFeedback> appraisalFeedbacks = new ArrayList<AppraisalFeedback>();

	public AnnualAppraisal() {
	}

	public AnnualAppraisal(Long id, Date appraisalDate, String strenghts, String improved, String status,
			String additionalFeedback, String employeeWish, String managerOpinion, Date created, Date updated,
			Employee employee, AnnualSession annualSession, List<Objective> objectives, List<Competencie> competencies,
			List<SkillEvaluation> skillEvaluations, List<AppraisalFeedback> appraisalFeedbacks) {
		this.id = id;
		this.appraisalDate = appraisalDate;
		this.strenghts = strenghts;
		this.improved = improved;
		this.status = status;
		this.additionalFeedback = additionalFeedback;
		this.employeeWish = employeeWish;
		this.managerOpinion = managerOpinion;
		this.created = created;
		this.updated = updated;
		this.employee = employee;
		this.annualSession = annualSession;
		this.objectives = objectives;
		this.competencies = competencies;
		this.skillEvaluations = skillEvaluations;
		this.appraisalFeedbacks = appraisalFeedbacks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAppraisalDate() {
		return appraisalDate;
	}

	public void setAppraisalDate(Date appraisalDate) {
		this.appraisalDate = appraisalDate;
	}

	public String getStrenghts() {
		return strenghts;
	}

	public void setStrenghts(String strenghts) {
		this.strenghts = strenghts;
	}

	public String getImproved() {
		return improved;
	}

	public void setImproved(String improved) {
		this.improved = improved;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAdditionalFeedback() {
		return additionalFeedback;
	}

	public void setAdditionalFeedback(String additionalFeedback) {
		this.additionalFeedback = additionalFeedback;
	}

	public String getEmployeeWish() {
		return employeeWish;
	}

	public void setEmployeeWish(String employeeWish) {
		this.employeeWish = employeeWish;
	}

	public String getManagerOpinion() {
		return managerOpinion;
	}

	public void setManagerOpinion(String managerOpinion) {
		this.managerOpinion = managerOpinion;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public AnnualSession getAnnualSession() {
		return annualSession;
	}

	public void setAnnualSession(AnnualSession annualSession) {
		this.annualSession = annualSession;
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

	public List<SkillEvaluation> getSkillEvaluations() {
		return skillEvaluations;
	}

	public void setSkillEvaluations(List<SkillEvaluation> skillEvaluations) {
		this.skillEvaluations = skillEvaluations;
	}

	public List<AppraisalFeedback> getAppraisalFeedbacks() {
		return appraisalFeedbacks;
	}

	public void setAppraisalFeedbacks(List<AppraisalFeedback> appraisalFeedbacks) {
		this.appraisalFeedbacks = appraisalFeedbacks;
	}

}
