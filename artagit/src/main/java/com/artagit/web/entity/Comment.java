package com.artagit.web.entity;

import java.util.Date;

public class Comment {
   
   
   private int id;
   private int postId;
   private int memId;
   private String content;
   private String nickname;
   private Date regDate;
   
   public Comment() {
      // TODO Auto-generated constructor stub
   }
   
   public Comment(int postId, int memId, String content) {
      this.postId = postId;
      this.memId = memId;
      this.content = content;
   }
   
   public int getId() {
      return id;
   }


   public void setId(int id) {
      this.id = id;
   }


   public String getNickname() {
      return nickname;
   }

   public void setNickname(String nickname) {
      this.nickname = nickname;
   }

   public int getPostId() {
      return postId;
   }


   public void setPostId(int postId) {
      this.postId = postId;
   }


   public int getMemId() {
      return memId;
   }


   public void setMemId(int memId) {
      this.memId = memId;
   }


   public String getContent() {
      return content;
   }


   public void setContent(String content) {
      this.content = content;
   }


   public Date getRegDate() {
      return regDate;
   }


   public void setRegDate(Date regDate) {
      this.regDate = regDate;
   }

   @Override
   public String toString() {
      return "Comment [id=" + id + ", postId=" + postId + ", memId=" + memId + ", content=" + content + ", nickname="
            + nickname + ", regDate=" + regDate + "]";
   }






   
   
}