package com.artagit.web.entity;

public class Museum {
	private int id;
	private String name;
	private String phone;
	private String address;
	private int localId;
	
	public Museum() {
	}

	public Museum(int id, String name, String address, int localId, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.localId = localId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getLocalId() {
		return localId;
	}

	public void setLocalId(int localId) {
		this.localId = localId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Museum [id=" + id + ", name=" + name + ", address=" + address + ", localId=" + localId + "]";
	}
}
