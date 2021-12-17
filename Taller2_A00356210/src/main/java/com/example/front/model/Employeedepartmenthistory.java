package com.example.front.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the employeedepartmenthistory database table.
 *
 */
@Entity
@NamedQuery(name = "Employeedepartmenthistory.findAll", query = "SELECT e FROM Employeedepartmenthistory e")
public class Employeedepartmenthistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EMPLOYEE_DEPARTMENTHISTORY_GENERATOR", allocationSize = 1, sequenceName = "EMPLOYEE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_BUSINESSENTITYID_GENERATOR")
	private Integer businessentityid;


	@Temporal(TemporalType.DATE)
	private LocalDate enddate;
	
	private String enddate1;

	public Integer getBusinessentityid() {
		return businessentityid;
	}

	public void setBusinessentityid(Integer businessentityid) {
		this.businessentityid = businessentityid;
	}

	public String getEnddate1() {
		return enddate1;
	}

	public void setEnddate1(String enddate1) {
		this.enddate1 = enddate1;
	}

	public String getModifieddate1() {
		return modifieddate1;
	}

	public void setModifieddate1(String modifieddate1) {
		this.modifieddate1 = modifieddate1;
	}

	private LocalDate modifieddate;
	
	private String modifieddate1;

	// bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name = "departmentid", insertable = false, updatable = false)
	private Department department;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name = "businessentityid", insertable = false, updatable = false)
	private Employee employee;

	// bi-directional many-to-one association to Shift
	@ManyToOne
	@JoinColumn(name = "shiftid", insertable = false, updatable = false)
	private Shift shift;

	public Employeedepartmenthistory() {
	}

	public Department getDepartment() {
		return this.department;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public LocalDate getEnddate() {
		return this.enddate;
	}

	public LocalDate getModifieddate() {
		return this.modifieddate;
	}

	public Shift getShift() {
		return this.shift;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}

	public void setModifieddate(LocalDate modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}

}