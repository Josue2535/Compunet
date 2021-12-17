package com.example.front.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.example.model.hr.Employee;
import com.sun.istack.NotNull;

import lombok.NonNull;

/**
 * The persistent class for the person database table.
 *
 */
@Entity
@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@SequenceGenerator(name = "PERSON_BUSINESSENTITYID_GENERATOR", allocationSize = 1, sequenceName = "PERSON_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_BUSINESSENTITYID_GENERATOR")
	private Integer businessentityid;

	private String additionalcontactinfo;

	private String demographics;

	private Integer emailpromotion;

	private String firstname;

	private String lastname;

	private String middlename;

	private Timestamp modifieddate;

	private String namestyle;
	
	@NonNull
	private String persontype;

	private Integer rowguid;
	
	@OneToOne
	private Integer employee;

	private String suffix;
	
	private String title;
	
	public Integer getEmployee() {
		return employee;
	}

	public void setEmployee(Integer employee) {
		this.employee = employee;
	}


	// bi-directional many-to-one association to Emailaddress
	@OneToMany(mappedBy = "person")
	private List<Emailaddress> emailaddresses;



	public Person() {
	}


	public Emailaddress addEmailaddress(Emailaddress emailaddress) {
		getEmailaddresses().add(emailaddress);
		emailaddress.setPerson(this);

		return emailaddress;
	}



	public String getAdditionalcontactinfo() {
		return this.additionalcontactinfo;
	}

	public Integer getBusinessentityid() {
		return this.businessentityid;
	}

	public String getDemographics() {
		return this.demographics;
	}

	public List<Emailaddress> getEmailaddresses() {
		return this.emailaddresses;
	}

	public Integer getEmailpromotion() {
		return this.emailpromotion;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public String getMiddlename() {
		return this.middlename;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public String getNamestyle() {
		return this.namestyle;
	}


	public String getPersontype() {
		return this.persontype;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public String getTitle() {
		return this.title;
	}


	public Emailaddress removeEmailaddress(Emailaddress emailaddress) {
		getEmailaddresses().remove(emailaddress);
		emailaddress.setPerson(null);

		return emailaddress;
	}

	public void setAdditionalcontactinfo(String additionalcontactinfo) {
		this.additionalcontactinfo = additionalcontactinfo;
	}

	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}

	public void setDemographics(String demographics) {
		this.demographics = demographics;
	}

	public void setEmailaddresses(List<Emailaddress> emailaddresses) {
		this.emailaddresses = emailaddresses;
	}

	public void setEmailpromotion(Integer emailpromotion) {
		this.emailpromotion = emailpromotion;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setNamestyle(String namestyle) {
		this.namestyle = namestyle;
	}


	public void setPersontype(String persontype) {
		this.persontype = persontype;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}