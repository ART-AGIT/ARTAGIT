package com.artagit.web.entity;

public class BoardRole {
	private int id;
	private String name;
	@Override
	public String toString() {
		return "BoardRole [id=" + id + ", name=" + name + "]";
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
	public BoardRole(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
