package com.ymagis.annualappraisal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ymagis.annualappraisal.utils.AnnualAppraisalListDeserializer;
import com.ymagis.annualappraisal.utils.AnnualAppraisalListSerializer;
import com.ymagis.annualappraisal.utils.Constants;
import com.ymagis.annualappraisal.utils.ManagerSerializer;
import com.ymagis.annualappraisal.utils.ManagerTeamDeserializer;
import com.ymagis.annualappraisal.utils.ManagerTeamSerializer;

@Entity
@Table(name = "employees")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = Constants.COL_ID)
	private Long id;
	@Column(name = Constants.COL_LAST_NAME)
	private String lastName;
	@Column(name = Constants.COL_FIRST_NAME)
	private String firstName;
	@Column(name = Constants.COL_POSITION)
	private String position;
	@Column(name = Constants.COL_MAIL)
	private String mail;
	@Column(name = Constants.COL_SENIORITY)
	private String seniority;
	@Column(name = Constants.COL_LOGIN)
	private String login;
	@Column(name = Constants.COL_BU)
	private String bu;
	@Column(name = Constants.COL_TEAM)
	private String team;
	@Column(name = Constants.COL_ADMIN)
	private Boolean isAdmin;
	@Column(name = Constants.COL_MANAGER)
	private Boolean isManager;
	@Temporal(TemporalType.DATE)
	@Column(name = Constants.COL_START_DATE)
	private Date startDate;
	@Column(name = Constants.COL_DELETED)
	private Boolean deleted;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Constants.COL_CREATED)
	private Date created;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Constants.COL_UPDATED)
	private Date updated;

	// Self join for manager
	@ManyToOne
	@JoinColumn(name = Constants.COL_MANAGER_ID)
	@JsonSerialize(using = ManagerSerializer.class)
	// @JsonDeserialize(using = ManagerDeserializer.class)
	private Employee manager;

	@OneToMany(mappedBy = "manager")
	@JsonSerialize(using = ManagerTeamSerializer.class)
	@JsonDeserialize(using = ManagerTeamDeserializer.class)
	private Set<Employee> managerTeam = new HashSet<Employee>();

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	@JsonSerialize(using = AnnualAppraisalListSerializer.class)
	@JsonDeserialize(using = AnnualAppraisalListDeserializer.class)
	private List<AnnualAppraisal> annualAppraisals = new ArrayList<AnnualAppraisal>();

	public Employee() {
	}

	public void businessTreatment() {
		// generate login
		String fn = firstName.trim().substring(0, 1).toLowerCase();
		String ln = lastName.trim().replace(" ", "").toLowerCase();
		setLogin(fn.concat(ln));
		// default values
		setCreated(new Date());
		setDeleted(false);
	}

	public Employee(Long id, String lastName, String firstName, String position, String mail, String seniority,
			String login, String bu, String team, Boolean isAdmin, Boolean isManager, Date startDate, Boolean deleted,
			Date created, Date updated, Employee manager, Set<Employee> managerTeam,
			List<AnnualAppraisal> annualAppraisals) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.position = position;
		this.mail = mail;
		this.seniority = seniority;
		this.login = login;
		this.bu = bu;
		this.team = team;
		this.isAdmin = isAdmin;
		this.isManager = isManager;
		this.startDate = startDate;
		this.deleted = deleted;
		this.created = created;
		this.updated = updated;
		this.manager = manager;
		this.managerTeam = managerTeam;
		this.annualAppraisals = annualAppraisals;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSeniority() {
		return seniority;
	}

	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getBu() {
		return bu;
	}

	public void setBu(String bu) {
		this.bu = bu;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
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

	public List<AnnualAppraisal> getAnnualAppraisals() {
		return annualAppraisals;
	}

	public void setAnnualAppraisals(List<AnnualAppraisal> annualAppraisals) {
		this.annualAppraisals = annualAppraisals;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Boolean getIsManager() {
		return isManager;
	}

	public void setIsManager(Boolean isManager) {
		this.isManager = isManager;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Set<Employee> getManagerTeam() {
		return managerTeam;
	}

	public void setManagerTeam(Set<Employee> managerTeam) {
		this.managerTeam = managerTeam;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
