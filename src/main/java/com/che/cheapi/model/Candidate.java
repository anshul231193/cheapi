package com.che.cheapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="candidate")
public class Candidate extends BaseEntity{
	
	private static final long serialVersionUID = 1L;

    @NotNull
    @Column
    private String name;
    
    @NotNull
    @Column(unique=true)
    private String email;

    @NotNull
    @Column(unique=true)
    private String mobile;
    
    @Column(unique=true)
    private String skypeId;

    @NotNull
    @Column
    private String fname;
    
    @Column
    private String address;

    @Column
    private String dob;
    
    @Column
    private String location;
    
    @Column
    private String center;
    
    @Column
    private String skill1;
    
    @Column
    private String experience;
    
    @Column
    private String skill2;

	@Column
    private String additionalSkills;
    
    @Column
    private String skill3;
    
    @Column
    private String targetWA;
    
    @Column
    private String salary;
    
    @Column
    private String company;
    
    @Column
    private String noticePeriod;
    
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public String getSkill1() {
		return skill1;
	}

	public void setSkill1(String skill1) {
		this.skill1 = skill1;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getSkill2() {
		return skill2;
	}

	public void setSkill2(String skill2) {
		this.skill2 = skill2;
	}

	public String getAdditionalSkills() {
		return additionalSkills;
	}

	public void setAdditionalSkills(String additionalSkills) {
		this.additionalSkills = additionalSkills;
	}

	public String getSkill3() {
		return skill3;
	}

	public void setSkill3(String skill3) {
		this.skill3 = skill3;
	}

	public String getTargetWA() {
		return targetWA;
	}

	public void setTargetWA(String targetWA) {
		this.targetWA = targetWA;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

}
