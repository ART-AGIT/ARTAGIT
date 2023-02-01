window.addEventListener("load", function() {
	const btnReg = document.querySelector(".btn-write")
	const commentlist = document.querySelector(".comment-detail")
	let content = document.querySelector(".content-null")
	let wrapper = document.querySelector(".comment-title-wrapper")
	
	let info = document.querySelector(".comment-info")
//	let el = document.querySelector(".board-id");
	
	let nickname =  document.querySelector(".add-modify")
	let commentBox = document.querySelector(".comment")
	let commentId = 0;

	btnReg.onclick = function(e) {
e.preventDefault();
		
		
		let formData = new FormData(document.querySelector("#comment-form"));
		fetch(`/api/reg`, { method: "post", body: formData })
			.then(response => response.json())
			.then(data => {
//				for (form = e.target; form.tagName != "FORM"; form = form.parentElement);
//				console.log(commentId = form.dataset.id)
				let name = data.member
				let name2 = data.comment

				let template = `
   <section class="comment-detail">
            <form data-id=${name2.id}>
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
                  </div>
                     <div class="add-modify">
					<button id="1" class="btn btn-default-fill comment-modify" type="submit" value="작성">수정</button>
                     <button id="2" class="btn btn-default-fill  comment-del" type="submit" value="작성">삭제</button>
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
			
//			console.log(nickname.dataset.itemtype)
//			console.log(oldComment.dateset.id)
			
			let form = null;
			for (form = e.target; form.tagName != "FORM"; form = form.parentElement);
				commentId = form.dataset.id
			let oldComment =  form.querySelector(".comment-main").innerText;
			
			
			let template = `
       		<form>
                  <div class="comment-writing comment-infoline">
                     <textarea class="content-null2" name="content">${oldComment}</textarea>
                    <button class="btn btn-default-fill comment-modify2" type="submit" value="작성">완료</button>
                     <button class="btn btn-default-fill comment-cancel" type="submit" value="취소">취소</button>
                  </div>
              </form>
         `;
         
			form.innerHTML = "";
//			oldText.innerHTML = oldComment.dataset.id;
			form.insertAdjacentHTML("beforeend", template);

			let commntCancel = document.querySelector(".comment-cancel")
			commntCancel.onclick = function(e) {
				form.innerHTML = "";
					let template = `
       		<section class="comment-detail">
               <div class="comment-writer-wrapper">
                  <div class="comment-writer">
                     <img class="profile-photo" src="../../image/accountImage.png">
                     <div class="user-name">${nickname.dataset.id}</div>
                  </div>
                  <div class="icon icon-miniMenu">
                     <a href=""></a>
                  </div>
               </div>

               <div class="comment-main" >${oldComment}</div>
               <div class="comment-info">
                  <div >
                     2022.11.26 18:38</div>
                  <div class="re-comment">
                  </div>
                     <div class="add-modify">
					<button id="1" class="btn btn-default-fill comment-modify" type="submit" value="작성">수정</button>
                     <button id="2" class="btn btn-default-fill  comment-del" type="submit" value="작성">삭제</button>
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
				let textValue = e.target.previousElementSibling.value
//				nickName = asd
				let formData2 = new FormData();
				formData2.append("id",commentId)
				formData2.append("content",textValue)
				fetch(`/api/update`, { method: "put", body: formData2})
					.then(response => response.json())
					.then(data => {
						console.log(data)



			            form.innerHTML = "";
				let template = `
			    <section>
               <h1 class="d-none">댓글1개</h1>
               <div class="comment-writer-wrapper">
                  <div class="comment-writer">
                     <img class="profile-photo" src="../../image/accountImage.png">
                     <div class="user-name">${nickname.dataset.id}</div>
                  </div>
                  <div class="icon icon-miniMenu">
                     <a href=""></a>
                  </div>
               </div>

               <div class="comment-main" >${textValue}</div>
               <div class="comment-info">
                  <div >
                     2022.11.26 18:38</div>
                  <div class="re-comment">
                       	    </div>
                       	<div class="add-modify">
                       		<button id="1" class="btn btn-default-fill comment-modify" type="submit" value="작성">수정</button>
                     <button  id="2" class="btn btn-default-fill  comment-del" type="sub mit" value="작성">삭제</button>
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
//						console.log(result);
					})
					
			


		}


		
//			if(e.target.id ==3){
//			for (form = e.target; form.tagName != "FORM"; form = form.parentElement);
//				 template = `
//      			<form>
//                  <div class="comment-writing comment-infoline">
//                     <textarea class="content-null2" name="content"></textarea>
//                    <button class="btn btn-default-fill comment-modify2" type="submit" value="작성">완료</button>
//                     <button class="btn btn-default-fill comment-del" type="submit" value="작성">취소</button>
//                  </div>
//              </form>
//         `;
//		
//		form.insertAdjacentHTML("afterend", template);
//		
//		
//		
//			let formData = new FormData(document.querySelector("#comment-form"));
//		fetch(`/api/reg`, { method: "post", body: formData })
//			.then(response => response.json())
//			.then(data => {
//				let name = data.member
//				let name2 = data.comment
//
//				let template = `
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
//					<button id="1" class="btn btn-default-fill comment-modify" type="submit" value="작성">수정</button>
//                     <button id="2" class="btn btn-default-fill  comment-del" type="submit" value="작성">삭제</button>
//                     </div>
//               </div>
//               </form>
//            </section>
//      
//      `;
//
//				wrapper.insertAdjacentHTML("afterend", template);
//				// 댓글작성후 text창 초기화
//				content.value = "";
//			})
//		
//		
//			}

	}

	







})


