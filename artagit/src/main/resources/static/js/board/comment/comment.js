window.addEventListener("load", function() {
	const btnReg = document.querySelector(".btn-write")
	const commentlist = document.querySelector(".comment-detail")
	let content = document.querySelector(".content-null")

	let commentDelete = document.querySelector(".comment-delete")
	let commentBox = document.querySelector(".comment")



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

				commentlist.insertAdjacentHTML("beforebegin", template);
				// 댓글작성후 text창 초기화
				content.value = "";
			})

	}

	commentBox.onclick = function(e) {
		e.preventDefault();




		if (e.target.id == 1) {

			let form = null;
			for (form = e.target; form.tagName != "FORM"; form = form.parentElement);
					
					
			form.innerHTML = "";
			let template = `
       <form id="comment-form2" >
              <input type="hidden">
               <input type="hidden">
                  <div class="user-name">spicychocolate</div>
                  <div class="comment-writing">
                     <textarea class="content-null" name="content"></textarea>
                    <button class="btn btn-default-fill comment-modify2" type="submit" value="작성">완료</button>
                     <button class="btn btn-default-fill comment-modify" type="submit" value="작성">취소</button>
                  </div>
              </form>
         `;
			form.insertAdjacentHTML("beforeend", template);


			let commntModify = document.querySelector(".comment-modify2")
			commntModify.onclick = function(e) {
				console.log(commntModify)
			
				let formData2 = new FormData();
				formData2.append("id",573)
				formData2.append("content",e.target.previousElementSibling.value)
				//				console.log(document.querySelector("#comment-form"));
				fetch(`/api/update`, { method: "put", body: formData2})
					.then(response => response.json())
					.then(data => {
						console.log(data)



										let template = `
			   <section class="comment-detail">
			            <form action="">
			               <h1 class="d-none">댓글1개</h1>
			               <div class="comment-writer-wrapper">
			                  <div class="comment-writer">
			                     <img class="profile-photo" src="../../image/accountImage.png">
			                     <div class="user-name" >1</div>
			                  </div>
			                  <div class="icon icon-miniMenu">
			                     <a href=""></a>
			                  </div>
			               </div>
			
			               <div class="comment-main" >1</div>
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
      form.innerHTML = "";
      commentlist.insertAdjacentHTML("beforebegin", template);
					})





			}


		}



	}









})


