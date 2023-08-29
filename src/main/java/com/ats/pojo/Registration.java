package com.ats.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class Registration {
	
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	
	
	private  String password;
	private Long phonum;
	private Date dob;
	private String gender;
	private String role;

	
	private String newpassword;
	private String confirmpassword;
	
	private String lockstatus;
	private String activestatus;
	private Date CreateDate;
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
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
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
		return "Registration [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", phonum=" + phonum + ", dob=" + dob + ", gender=" + gender + ", role="
				+ role + ", newpassword=" + newpassword + ", confirmpassword=" + confirmpassword + ", lockstatus="
				+ lockstatus + ", activestatus=" + activestatus + ", CreateDate=" + CreateDate + ", updateDate="
				+ updateDate + "]";
	}
	
	
}
