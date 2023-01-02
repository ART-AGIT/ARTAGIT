package com.artagit.web.entity;

public class Local {
	private int id;
	private String name;
	
	public Local() {
		// TODO Auto-generated constructor stub
	}

	public Local(int id, String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Local [id=" + id + ", name=" + name + "]";
	}
	
	
}
