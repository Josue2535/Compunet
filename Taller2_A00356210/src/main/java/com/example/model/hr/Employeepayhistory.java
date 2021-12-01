package com.example.model.hr;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the employeepayhistory database table.
 *
 */
@Entity
@NamedQuery(name = "Employeepayhistory.findAll", query = "SELECT e FROM Employeepayhistory e")
public class Employeepayhistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EMPLOYEE_PAYHISTORY_GENERATOR", allocationSize = 1, sequenceName = "EMPLOYEE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_BUSINESSENTITYID_GENERATOR")
	private Integer businessentityid;

	private LocalDate modifieddate;
	
	private String modifieddate1;

	public String getModifieddate1() {
		return modifieddate1;
	}

	public void setModifieddate1(String modifieddate1) {
		this.modifieddate1 = modifieddate1;
	}

	private Integer payfrequency;

	private BigDecimal rate;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "businessentityid", insertable = false, updatable = false)
	private Employee employee;

	public Employeepayhistory() {
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public int getId() {
		return this.businessentityid;
	}

	public LocalDate getModifieddate() {
		return this.modifieddate;
	}

	public Integer getPayfrequency() {
		return this.payfrequency;
	}

	public BigDecimal getRate() {
		return this.rate;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setId(Integer id) {
		this.businessentityid = id;
	}

	public void setModifieddate(LocalDate modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setPayfrequency(Integer payfrequency) {
		this.payfrequency = payfrequency;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

}