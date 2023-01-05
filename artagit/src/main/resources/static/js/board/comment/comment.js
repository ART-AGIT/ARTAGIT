window.addEventListener("load", function() {
   const btnReg = document.querySelector(".btn-write")
   const commentlist = document.querySelector(".comment-detail")
   let content = document.querySelector(".content-null")
   let commntModify = document.querySelector(".comment-modify")
   let commentDelete = document.querySelector(".comment-delete")
   let commentBox = document.querySelector(".comment")



   btnReg.onclick = function(e) {
      e.preventDefault();

   let formData = new FormData(document.querySelector("#comment-form")); 

      fetch(`/api/reg`, { method: "post" ,body:formData})
         .then(response => response.json())
         .then(data => {
         
         let name = data.member
         let name2 = data.comment
         
            
      let template = `
   <section class="comment-detail">
            <form action="">
               <h1 class="d-none">댓글1개</h1>
               <div class="comment-writer-wrapper">
                  <div class="comment-writer">
                     <img class="profile-photo" src="../../image/accountImage.png">
                     <div class="user-name" >${name}</div>
                  </div>
                  <div class="icon icon-miniMenu">
                     <a href=""></a>
                  </div>
               </div>

               <div class="comment-main" >${name2.content}</div>
               <div class="comment-info">
                  <div >
                     2022.11.26 18:38</div>
                  <div class="re-comment">
                     <a href="">답글쓰기</a>
                     <button class="" type="submit" value="수정">수정</button>
                     <button class="" type="submit" value="삭제">삭제</button>
                     
                  </div>

               </div>
               </form>
            </section>
      
      `;
               
         commentlist.insertAdjacentHTML("afterbegin", template);
         // 댓글작성후 text창 초기화
         content.value = "";
         })
      
   }
   
   commentBox.onclick = function(e) {
      e.preventDefault();
      
      
         if(e.target.id == 1){
         let template = `
         <textarea class="content-null" name="content"></textarea>
         <button id="3" class="btn btn-default-fill" type="submit" value="작성">작성</button>
         `;
         commentlist.insertAdjacentHTML("afterend", template);
         }
         
         if(e.target.id == 3){
            console.log("아멘")
            
         }
   console.log()   
      }
   
   
   
   






})


