package com.ats.pojo;

import java.util.Date;



public class AgencyRegistration {


	private Integer id;
	private String agencyname;
	private String email;
	private Long phonum;
	private  String password;
    private String role;
	private String status;
	private Date CreateDate;
	private Date updateDate;
	
	private String newpassword;
	private String confirmpassword;
	
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAgencyname() {
		return agencyname;
	}
	public void setAgencyname(String agencyname) {
		this.agencyname = agencyname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhonum() {
		return phonum;
	}
	public void setPhonum(Long phonum) {
		this.phonum = phonum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
		return "AgencyRegistration [id=" + id + ", agencyname=" + agencyname + ", email=" + email + ", phonum=" + phonum
				+ ", password=" + password + ", role=" + role + ", status=" + status + ", CreateDate=" + CreateDate
				+ ", updateDate=" + updateDate + ", newpassword=" + newpassword + ", confirmpassword=" + confirmpassword
				+ "]";
	}
	
	
	
	
}
