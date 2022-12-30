package com.artagit.web.entity;

public class Corporate {
	private int id;
	private String name;
	private String loginId;
	private String password;
	private String ceoName;
	private int businessNum;
	private String manager;
	private String phone;
	private String regState;
	private String processDate;
	private String address;
	private String refuseReason;
	private String managerPhone;
	private String museumName; 
	private int localId;
	
	public Corporate() {
		// TODO Auto-generated constructor stub
	}

	public Corporate(String name, String loginId, String password, String ceoName, int businessNum,
			String manager, String phone, String processDate, String address, String refuseReason,
			String managerPhone, String museumName, int localId) {

		this.name = name;
		this.loginId = loginId;
		this.password = password;
		this.ceoName = ceoName;
		this.businessNum = businessNum;
		this.manager = manager;
		this.phone = phone;

		this.processDate = processDate;
		this.address = address;
		this.refuseReason = refuseReason;
		this.managerPhone = managerPhone;
		this.museumName = museumName;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCeoName() {
		return ceoName;
	}

	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}

	public int getBusinessNum() {
		return businessNum;
	}

	public void setBusinessNum(int businessNum) {
		this.businessNum = businessNum;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegState() {
		return regState;
	}

	public void setRegState(String regState) {
		this.regState = regState;
	}

	public String getProcessDate() {
		return processDate;
	}

	public void setProcessDate(String processDate) {
		this.processDate = processDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRefuseReason() {
		return refuseReason;
	}

	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public String getMuseumName() {
		return museumName;
	}

	public void setMuseumName(String museumName) {
		this.museumName = museumName;
	}

	public int getLocalId() {
		return localId;
	}

	public void setLocalId(int localId) {
		this.localId = localId;
	}

	@Override
	public String toString() {
		return "Coporate [id=" + id + ", name=" + name + ", loginId=" + loginId + ", password=" + password
				+ ", ceoName=" + ceoName + ", businessNum=" + businessNum + ", manager=" + manager + ", phone=" + phone
				+ ", regState=" + regState + ", processDate=" + processDate + ", address=" + address + ", refuseReason="
				+ refuseReason + ", managerPhone=" + managerPhone + ", museumName=" + museumName + ", localId="
				+ localId + "]";
	}

	
	
}