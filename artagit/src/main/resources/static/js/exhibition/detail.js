window.addEventListener("load", function(){
	const urlCopy = document.querySelector(".deco-url");
	const heart=document.querySelector(".deco-heart");
	const likeNum = document.querySelector(".like-num");
	const mapBox = document.querySelector(".deco-map");
	const modalBox = this.document.querySelector(".mini-menu-list>li");

	/////// URL 복사 버튼 클릭 시
	urlCopy.onclick = function(e){
		e.preventDefault();

		navigator.clipboard.writeText(window.location.href)
		.then(()=>{
			let modal = `
						<div class="modal-hj">
							<div class="modal-header-hj">
								<h1 class="header-title-hj">URL이 복사되었습니다.</h1>
							</div>
							<div class="modal-actions-hj">
								<a class="modal-action-hj" href="">확인</a>
							</div>
						</div>
						`

						modalBox.insertAdjacentHTML("beforeend", modal);
                        document.body.classList.add("stop-scroll");
		})
		.then(console.log("성공"));
	};

//------------- 좋아요 ---------------------------------
	heart.onclick = function(e){
		e.preventDefault();
		
		//---- 좋아요가 눌려있지 않으면 좋아요 누르기----------
		if(!heart.classList.contains("deco-heart-red")){
			heart.classList.add("deco-heart-red");

			let id = e.target.dataset.id;
			
			// 데이터 추가
			fetch(`/api/like/${id}`,{
				method:"PUT"
			})
			.then(response => response.json())
			.then(data => {
				let count = data.countNum;
				if(data.resultObject == 1){
					likeNum.innerHTML="";
					let template = `${count}`
	                        
	            	likeNum.append(template);	
				}
					
			})
		}
		//---- 좋아요가 눌려있으면, 좋아요 빼기----------
		else if(heart.classList.contains("deco-heart-red")){
			heart.classList.remove("deco-heart-red")
			
			let id = e.target.dataset.id;
			
			// 데이터 삭제
			fetch(`/api/like/${id}`,{
				method:"DELETE"
			})
			.then(response => response.json())
			.then(data => {
				let count = data.countNum;
				if(data.resultObject == 1){
					likeNum.innerHTML="";
					let template = `${count}`

	            	likeNum.append(template);	
				}
			})
		}
	}
});


