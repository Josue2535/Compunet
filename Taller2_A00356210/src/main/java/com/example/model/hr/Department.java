package com.example.model.hr;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the department database table.
 *
 */
@Entity
@NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@SequenceGenerator(name = "DEPARTMENT_DEPARTMENTID_GENERATOR", allocationSize = 1, sequenceName = "DEPARTMENT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPARTMENT_DEPARTMENTID_GENERATOR")
	private Integer departmentid;
	@NotNull(message = "Debes especificar el groupName")
	private String groupname;
	@NotNull
	private LocalDate modifieddate;
	private String modifieddate1
	;
	public String getModifieddate1() {
		return modifieddate1;
	}

	public void setModifieddate1(String modifieddate1) {
		this.modifieddate1 = modifieddate1;
	}

	@NotNull(message = "Debes especificar el nombre")
	private String name;

	// bi-directional many-to-one association to Employeedepartmenthistory
	@NotNull
	@OneToMany(mappedBy = "department")
	private List<Employeedepartmenthistory> employeedepartmenthistories;
	
	public Department() {
	}

	public Employeedepartmenthistory addEmployeedepartmenthistory(Employeedepartmenthistory employeedepartmenthistory) {
		getEmployeedepartmenthistories().add(employeedepartmenthistory);
		employeedepartmenthistory.setDepartment(this);

		return employeedepartmenthistory;
	}

	public Integer getDepartmentid() {
		return this.departmentid;
	}

	public List<Employeedepartmenthistory> getEmployeedepartmenthistories() {
		return this.employeedepartmenthistories;
	}

	public String getGroupname() {
		return this.groupname;
	}

	public LocalDate getModifieddate() {
		return this.modifieddate;
	}

	public String getName() {
		return this.name;
	}

	public Employeedepartmenthistory removeEmployeedepartmenthistory(
			Employeedepartmenthistory employeedepartmenthistory) {
		getEmployeedepartmenthistories().remove(employeedepartmenthistory);
		employeedepartmenthistory.setDepartment(null);

		return employeedepartmenthistory;
	}

	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}

	public void setEmployeedepartmenthistories(List<Employeedepartmenthistory> employeedepartmenthistories) {
		this.employeedepartmenthistories = employeedepartmenthistories;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public void setModifieddate(LocalDate modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setName(String name) {
		this.name = name;
	}

}