window.addEventListener("load", function(){
	const main = this.document.querySelector("main");
	const urlCopy = document.querySelector(".deco-url");
	const heart = document.querySelector(".deco-heart");
	const likeNum = document.querySelector(".like-num");
	const mapBox = document.querySelector(".deco-map");
	const modalBox = this.document.querySelector(".mini-menu-list>li");


	/////// URL 복사 버튼 클릭 시
	urlCopy.onclick = function(e){
		e.preventDefault();

		navigator.clipboard.writeText(window.location.href)
		.then(()=>{
			let modal = 
						`<div class="d-modal modal-overlay">
							<div class="modal-window">
								<div class="modal-header">
									<h1 class="header-title">URL이 복사되었습니다.</h1>
								</div>
								<div class="modal-actions">
									<a class="modal-action" href="">확인</a>
								</div>
							</div>
						</div>`

						let el = new DOMParser()
						.parseFromString(modal, "text/html")
						.body
						.firstElementChild;
					const container = document.querySelector('.container');
					main.append(el);

					// document.insertAdjacentHTML("beforeend", modal);
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
				if(data.status == '405'){
					window.alert("일반회원만 가능합니다.")
					location.reload();		
				}
				if(data.status == '500'){
					window.alert("로그인을 해주세요.")
					location.replace("/user/login")	
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


window.addEventListener("scroll", function() {
	console.log("스크롤 내려간다~~~");
	let bookingBtn = this.document.querySelector(".btn-booking");
	let limitVal = Math.max(document.body.scrollHeight,
							document.body.offsetHeight,
							document.documentElement.clientHeight,
							document.documentElement.scrollHeight,
							document.documentElement.offsetHeight);
		bookingBtn.scrollTop = Math.max(-250, 0-this.scrollTop);
		// this.window.scrollTo(0, limitVal-117.2);
	
		console.log("limitVal ==> " +limitVal);
	// bookingBtn.style.marginTop = Math.max(-250, 0-this.scrollTop())
	// el.scrollHeight - 117.2;
});