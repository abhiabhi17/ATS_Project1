package com.ats.entity;

import java.io.Serializable;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;



@Entity
@Table(name="registration_dtls")
@IdClass(RegistrationDetailsId.class) 
public class RegistrationEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reg_id_generator")
	@SequenceGenerator(name="reg_id_generator",
	                   initialValue = 1,allocationSize = 1,
	                   sequenceName = "reg_id_seq")
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	
    @Id
	@GenericGenerator(name = "pwd", strategy = "com.ats.hibernate.annotations.CustomGenerator")
	@GeneratedValue(generator = "pwd")
	private  String password;
    
	private Long phonum;
	private Date dob;
	private String gender;
	private String role;
	
	@Column(name="lock_status")
	private String lockstatus;
	
	@Column(name="active_status")
	private String activestatus;
	
	@Column(name="createDate",updatable = false)
	@CreationTimestamp
	private Date CreateDate;
	
	@Column(name="updateDate")
	@UpdateTimestamp
	private Date updateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhonum() {
		return phonum;
	}

	public void setPhonum(Long phonum) {
		this.phonum = phonum;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLockstatus() {
		return lockstatus;
	}

	public void setLockstatus(String lockstatus) {
		this.lockstatus = lockstatus;
	}

	public String getActivestatus() {
		return activestatus;
	}

	public void setActivestatus(String activestatus) {
		this.activestatus = activestatus;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "RegistrationEntity [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", password=" + password + ", phonum=" + phonum + ", dob=" + dob + ", gender=" + gender
				+ ", role=" + role + ", lockstatus=" + lockstatus + ", activestatus=" + activestatus + ", CreateDate="
				+ CreateDate + ", updateDate=" + updateDate + "]";
	}


	
	
}
