package com.artagit.web.entity;
	
public class ExhibitionView {
	private int id;
	private int memId;
	private int cateId;
	private String name;
	private String content;
	private String poster;
	private String detailImage;
	private String startDate;
	private String endDate;
	private String startTime;
	private String endTime;
	private int ticketPrice;
	private int ticketStock;
	private String artist;
	private int stateId;
	private int museumId;
	private int corpId;
	private int corpLocalId;
	private int	memberId; //좋아요 목록위해
	
	
	
	// NN 제거한 생성자. 전시 등록 시 사용되는 생성자
	public ExhibitionView(int memId, int cateId, String name, String poster,
			String startDate, String endDate, String startTime, String endTime, int ticketPrice, int ticketStock,
			String artist, int stateId, int museumId, int memberId) {
		this.memId = memId;
		this.cateId = cateId;
		this.name = name;
		this.poster = poster;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.ticketPrice = ticketPrice;
		this.ticketStock = ticketStock;
		this.artist = artist;
		this.stateId = stateId;
		this.museumId = museumId;
		this.memberId = memberId;
	}
	
	// 전시 정보를 모두 불러올 때 사용되는 생성자
	public ExhibitionView(int id, int memId, int cateId, String name, String content, String poster, String detailImage,
			String startDate, String endDate, String startTime, String endTime, int ticketPrice, int ticketStock,
			String regDate, String artist, int stateId, int museumId,int corpId,int corpLocalId, int memberId) {
		this.id = id;
		this.memId = memId;
		this.cateId = cateId;
		this.name = name;
		this.content = content;
		this.poster = poster;
		this.detailImage = detailImage;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.ticketPrice = ticketPrice;
		this.ticketStock = ticketStock;
		this.artist = artist;
		this.stateId = stateId;
		this.museumId = museumId;
		this.corpId =corpId;
		this.corpLocalId = corpLocalId;
		this.memberId = memberId;
	}
	



	@Override
	public String toString() {
		return "ExhibitionView [id=" + id + ", memId=" + memId + ", cateId=" + cateId + ", name=" + name + ", content="
				+ content + ", poster=" + poster + ", detailImage=" + detailImage + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", startTime=" + startTime + ", endTime=" + endTime + ", ticketPrice="
				+ ticketPrice + ", ticketStock=" + ticketStock + ", artist=" + artist + ", stateId=" + stateId
				+ ", museumId=" + museumId + ", corpId=" + corpId + ", corpLocalId=" + corpLocalId + ", memberId="
				+ memberId + "]";
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
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

	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getDetailImage() {
		return detailImage;
	}

	public void setDetailImage(String detailImage) {
		this.detailImage = detailImage;
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

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getTicketStock() {
		return ticketStock;
	}

	public void setTicketStock(int ticketStock) {
		this.ticketStock = ticketStock;
	}


	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getMuseumId() {
		return museumId;
	}

	public void setMuseumId(int museumId) {
		this.museumId = museumId;
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

	public ExhibitionView() {
		// TODO Auto-generated constructor stub
	}
	


	
}
