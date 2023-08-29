package com.ats.entity;

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
@Table(name="Agency_Master")
@IdClass(RegistrationDetailsId.class) 
public class AgencyRegistrationEntity {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agency_reg_id_generator")
	@SequenceGenerator(name="agency_reg_id_generator",
	                   initialValue = 1,allocationSize = 1,
	                   sequenceName = "agency_reg_id_seq")
	private Integer id;
	private String agencyname;
	private String email;
	private Long phonum;
	
	
    @Id
	@GenericGenerator(name = "pwd", strategy = "com.ats.hibernate.annotations.CustomGenerator")
	@GeneratedValue(generator = "pwd")
	private  String password;
    private String role;
	private String status;
	
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
		return "AgencyRegistrationEntity [id=" + id + ", agencyname=" + agencyname + ", email=" + email + ", phonum="
				+ phonum + ", password=" + password + ", role=" + role + ", status=" + status + ", CreateDate="
				+ CreateDate + ", updateDate=" + updateDate + "]";
	}
	

}
