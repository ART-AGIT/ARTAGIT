package com.artagit.web.entity;

import java.util.Date;

public class Board {
	private int id;
	private int memId;
	private String name;
	private String title;
	private String image;
	private int hit;
	private Date regDate;
	private String nickname;
	private int roleId;
	private String useYN;
	private int commentTotal;
	private String content;	
	private int like;
	private Date modiDate;
	private int heart;
	
	public int getHeart() {
		return heart;
	}
	public void setHeart(int heart) {
		this.heart = heart;
	}
	public Board(int id, int memId, String name, String title, String image, int hit, Date regDate, String nickname,
			int roleId, String useYN, int commentTotal, String content, int like, Date modiDate, int heart) {
		super();
		this.id = id;
		this.memId = memId;
		this.name = name;
		this.title = title;
		this.image = image;
		this.hit = hit;
		this.regDate = regDate;
		this.nickname = nickname;
		this.roleId = roleId;
		this.useYN = useYN;
		this.commentTotal = commentTotal;
		this.content = content;
		this.like = like;
		this.modiDate = modiDate;
		this.heart = heart;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMemId() {
		return memId;
	}
	public void setMemId(int memId) {
		this.memId = memId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getUseYN() {
		return useYN;
	}
	public void setUseYN(String useYN) {
		this.useYN = useYN;
	}
	public int getCommentTotal() {
		return commentTotal;
	}
	public void setCommentTotal(int commentTotal) {
		this.commentTotal = commentTotal;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public Date getModiDate() {
		return modiDate;
	}
	public void setModiDate(Date modiDate) {
		this.modiDate = modiDate;
	}
	
	public Board() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Board [id=" + id + ", memId=" + memId + ", name=" + name + ", title=" + title + ", image=" + image
				+ ", hit=" + hit + ", regDate=" + regDate + ", nickname=" + nickname + ", roleId=" + roleId + ", useYN="
				+ useYN + ", commentTotal=" + commentTotal + ", content=" + content + ", like=" + like + ", modiDate="
				+ modiDate + "]";
	}


}