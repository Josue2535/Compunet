package com.example.model.person;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 * The persistent class for the emailaddress database table.
 *
 */
@Entity
@NamedQuery(name = "Emailaddress.findAll", query = "SELECT e FROM Emailaddress e")
public class Emailaddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@SequenceGenerator(name = "EMAIL_GENERATOR", allocationSize = 1, sequenceName = "EMAIL_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMAIL_GENERATOR")
	private Integer id;

	private String emailaddress;

	private Timestamp modifieddate;

	private Integer rowguid;

	// bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name = "businessentityid", insertable = false, updatable = false)
	private Person person;

	public Emailaddress() {
	}

	public String getEmailaddress() {
		return this.emailaddress;
	}

	public Integer getId() {
		return this.id;
	}

	public Timestamp getModifieddate() {
		return this.modifieddate;
	}

	public Person getPerson() {
		return this.person;
	}

	public Integer getRowguid() {
		return this.rowguid;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}

}