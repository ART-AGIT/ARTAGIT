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
   




})


