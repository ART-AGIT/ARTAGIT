window.addEventListener("load", function() {
	const btnReg = document.querySelector(".btn-write")
	let content = document.querySelector(".content-null")
	let wrapper = document.querySelector(".comment-title-wrapper")
	let modal = document.querySelector(".popup-overlay")
	let com = document.getElementById("modal-popup");
	let content1 = document.querySelector(".report-form")
	let nickname =  document.querySelector(".add-modify")
	let commentBox = document.querySelector(".comment")
	let type = document.querySelector(".type-post")
	let img = document.querySelector(".comment-profile")

	let date = document.querySelector(".date")
	


	btnReg.onclick = function(e) {
		e.preventDefault();
		
				
		let formData = new FormData(document.querySelector("#comment-form"));
		fetch(`/api/reg`, { method: "post", body: formData })
			.then(response => response.json())
			.then(data => {
				let name = data.member
				let name2 = data.comment
				
				let template = `
   <section class="comment-detail">
            <form data-id=${name2.id}>
               <h1 class="d-none">댓글1개</h1>
               <div class="comment-writer-wrapper">
                  <div class="comment-writer">
                     <img class="profile-photo" src="${img.src}">
                     <div class="user-name">${name}</div>
                     
                  </div>
                  <div class="icon icon-report">
                        <button id="4"    class="icon icon-report" type="submit" value="수정">수정</button>
                  </div>
               </div>

               <div class="comment-main" >${name2.content}</div>
               <div class="comment-info">
                  <div class="date" >
                    ${date.dataset.id}</div>
                  <div class="re-comment">
                  </div>
                     <div class="add-modify">
                <a class="a-btn" href=""  id="1">수정</a>
                     <a class="a-btn a-btn-black"  id="2">삭제</a>
                     </div>
               </div>
               </form>
            </section>
      
      `;
      
            wrapper.insertAdjacentHTML("afterend", template);
            // 댓글작성후 text창 초기화
            content.value = "";
            
         })


   }
   
   
   
   
   
      
   

   commentBox.onclick = function(e) {
      e.preventDefault();

   
      if (e.target.id == 1) {
         

         
         let form = null;
         for (form = e.target; form.tagName != "FORM"; form = form.parentElement);
            commentId = form.dataset.id
         let oldComment =  form.querySelector(".comment-main").innerText;
         
         
         let template = `
             <form>
                  <div class="comment-writing comment-infoline">
                     <textarea class="content-null2" name="content" spellcheck="false">${oldComment}</textarea>
                    <a class="a-btn comment-modify2" type="submit" value="작성">완료</a>
                     <a class="a-btn a-btn-black comment-cancel" type="submit" value="취소">취소</a>
                  </div>
              </form>
         `;
         form.innerHTML = "";
//         oldText.innerHTML = oldComment.dataset.id;
         form.insertAdjacentHTML("beforeend", template);

         let commntCancel = document.querySelector(".comment-cancel")
         commntCancel.onclick = function() {
            form.innerHTML = "";
               let template = `
             <section class="comment-detail">
               <div class="comment-writer-wrapper">
                  <div class="comment-writer">
                         <img class="profile-photo" src="${img.src}">
                     <div class="user-name">${nickname.dataset.id}</div>
                  </div>
                  <div class="icon icon-report">
                        <button id="4"    class="icon icon-report" type="submit" value="수정">수정</button>
                  </div>
                  </div>
               </div>

               <div class="comment-main" >${oldComment}</div>
               <div class="comment-info">
              <div class="date" >
                    ${time}</div>
              <div class="date" >
                    ${time}</div>
                  <div class="re-comment">
                  </div>
                     <div class="add-modify">
                <a class="a-btn" href=""  id="1">수정</a>
                    <a class="a-btn a-btn-black "  id="2">삭제</a>
                     </div>
               </div>
            </section>
      
      `;
         form.insertAdjacentHTML("beforeend", template);
			}
	
			
			let commntModify = document.querySelector(".comment-modify2")
			commntModify.onclick = function(e) {
//				for (el = e.target; form.tagName != "FORM"; el = el.parentElement);
//				console.log(el.parentElement.parentElement.dataset.id)
//				for (el = e.target; form.tagName != "SECTION"; el = el.parentElement);
	let img = document.querySelector(".comment-profile")
				let textValue = e.target.previousElementSibling.value
//				nickName = asd
				let formData2 = new FormData();
				formData2.append("id",commentId)
				formData2.append("content",textValue)
				fetch(`/api/update`, { method: "put", body: formData2})
					.then(response => response.json())
					.then(data => {



                     form.innerHTML = "";
            let template = `
             <section>
               <h1 class="d-none">댓글1개</h1>
               <div class="comment-writer-wrapper">
                  <div class="comment-writer">
                         <img class="profile-photo" src="${img.src}">
                         <img class="profile-photo" src="${img.src}">
                     <div class="user-name">${nickname.dataset.id}</div>
                  </div>
                 <div class="icon icon-report">
                       <a class="a-btn" href=""  id="1">수정</a>
                  </div>
                  </div>
               </div>

               <div class="comment-main" >${textValue}</div>
               <div class="comment-info">
                  <div class="date" >
                    ${time}</div>
                  <div class="date" >
                    ${time}</div>
                  <div class="re-comment">
                              </div>
                          <div class="add-modify">
                           <a class="a-btn" href=""  id="1">수정</a>
                     <a class="a-btn a-btn-black"  id="2">삭제</a>
                        </div>
                  </div>

               </div>
             
            </section>
               
      `;

      form.insertAdjacentHTML("beforeend", template);
            })
         }
      }

	
				
			
				if(e.target.id == 2){
					for (form = e.target; form.tagName != "FORM"; form = form.parentElement);
						commentId = form.dataset.id;
				let formData2 = new FormData();
				formData2.append("id",commentId)
				fetch(`/api/delete`, { method: "delete", body: formData2})
					.then(response => response.json())
					.then(data => {
						let result = (data.result)
						if(result == 1)
							form.remove();
					})
					
			


      }




      if(e.target.id == 4){
      for (form = e.target; form.tagName != "FORM"; form = form.parentElement)
            type.innerHTML = "댓글"
            modal.classList.remove("d-none");
         
     
      let popup = document.querySelector(".popup-overlay")
      popup.onclick = function(e){
      
      if(e.target.classList.contains("no"))
      popup.classList.add("d-none");
               content.value = "";
      
      
      if(e.target.classList.contains("yes")){
      commentId = form.dataset.id
      
      let box = document.querySelector(".box-select")
      let memId = form.querySelector(".btn-black").dataset.id
      
      let formData = new FormData();
      formData.append("commentId",commentId)
      formData.append("memId",memId)
      formData.append("content",content1.value)
      formData.append("roleId",box.value)
      
      fetch(`/api/reportComment`, { method: "post", body: formData})
               .then(response => response.json())
               .then(data => {
                  popup.classList.add("d-none");
                  com.classList.remove("d-none")
                  
               })
               content1.value ="";
               
   
      
      }
      
      
        }
      
      
   }
         
         
         
         
      
//         if(e.target.id ==3){
//         for (form = e.target; form.tagName != "FORM"; form = form.parentElement);
//             template = `
//               <form>
//                  <div class="comment-writing comment-infoline">
//                     <textarea class="content-null2" name="content"></textarea>
//                    <button class="btn btn-default-fill comment-modify2" type="submit" value="작성">완료</button>
//                     <button class="btn btn-default-fill comment-del" type="submit" value="작성">취소</button>
//                  </div>
//              </form>
//         `;
//      
//      form.insertAdjacentHTML("afterend", template);
//      
//      
//      
//         let formData = new FormData(document.querySelector("#comment-form"));
//      fetch(`/api/reg`, { method: "post", body: formData })
//         .then(response => response.json())
//         .then(data => {
//            let name = data.member
//            let name2 = data.comment
//
//            let template = `
//   <section class="comment-detail">
//            <form data-id=${name2.id}>
//               <h1 class="d-none">댓글1개</h1>
//               <div class="comment-writer-wrapper">
//                  <div class="comment-writer">
//                     <img class="profile-photo" src="../../image/accountImage.png">
//                     <div class="user-name" >${name}</div>
//                  </div>
//                  <div class="icon icon-miniMenu">
//                     <a href=""></a>
//                  </div>
//               </div>
//
//               <div class="comment-main" >${name2.content}</div>
//               <div class="comment-info">
//                  <div >
//                     2022.11.26 18:38</div>
//                  <div class="re-comment">
//                  </div>
//                     <div class="add-modify">
//               <button id="1" class="btn btn-default-fill comment-modify" type="submit" value="작성">수정</button>
//                     <button id="2" class="btn btn-default-fill  comment-del" type="submit" value="작성">삭제</button>
//                     </div>
//               </div>
//               </form>
//            </section>
//      
//      `;
//
//            wrapper.insertAdjacentHTML("afterend", template);
//            // 댓글작성후 text창 초기화
//            content.value = "";
//         })
//      
//         }

   }
   
   com.onclick = function(e) {
      e.preventDefault();
      com.classList.add("d-none")      
   }
   



})

