package com.ats.pojo;

public class UnLock {

	private Integer id;
	private String temppassword;
	private String newpassword;
	private String confirmpassword;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTemppassword() {
		return temppassword;
	}
	public void setTemppassword(String temppassword) {
		this.temppassword = temppassword;
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
	@Override
	public String toString() {
		return "UnLock [id=" + id + ", temppassword=" + temppassword + ", newpassword=" + newpassword
				+ ", confirmpassword=" + confirmpassword + "]";
	}
	
	
}
