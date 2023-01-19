package com.artagit.web.entity;

public class ExhLikeList {
	
	private int id;
	private String name;
	private int corpId;
	private int corpLocalId;
	private String poster;
	private String useYN;
	private String startDate;
	private String endDate;
	private String startTime;
	private String endTime;
	private String museumName;
	private String nickname;

	
	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getMuseumName() {
		return museumName;
	}

	public void setMuseumName(String museumName) {
		this.museumName = museumName;
	}

	public ExhLikeList() {
		// TODO Auto-generated constructor stub
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

	public int getCorpId() {
		return corpId;
	}

	public void setCorpId(int corpId) {
		this.corpId = corpId;
	}

	public int getCorpLocalId() {
		return corpLocalId;
	}

	public void setCorpLocalId(int corpLocalId) {
		this.corpLocalId = corpLocalId;
	}

	public String getUseYN() {
		return useYN;
	}

	public void setUseYN(String useYN) {
		this.useYN = useYN;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	

	@Override
	public String toString() {
		return "ExhLikeList [id=" + id + ", name=" + name + ", corpId=" + corpId + ", corpLocalId=" + corpLocalId
				+ ", poster=" + poster + ", useYN=" + useYN + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", museumName=" + museumName + ", nickname="
				+ nickname + "]";
	}

	public ExhLikeList(int id, String name, int corpId, int corpLocalId, String poster, String useYN, String startDate,
			String endDate, String startTime, String endTime, String museumName) {
	
		this.id = id;
		this.name = name;
		this.corpId = corpId;
		this.corpLocalId = corpLocalId;
		this.poster = poster;
		this.useYN = useYN;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.museumName = museumName;
		this.nickname = nickname;
	
	}



	
	
	
}
