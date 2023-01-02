
window.addEventListener("load", function(){
	const urlCopy = document.querySelector(".deco-url");
	const heart=document.querySelector(".deco-heart");
	const likeNum = document.querySelector(".like-num");
	const mapBox = document.querySelector(".deco-map");

	urlCopy.onclick = function(e){
		e.preventDefault();
//		 var url = window.document.location.href;
//		 window.alert("url이 복사되었습니다!");
//		 console.log(url);

        let url = '';    // <a>태그에서 호출한 함수인 clip 생성
        const textarea = document.createElement("textarea");  
        //url 변수 생성 후, textarea라는 변수에 textarea의 요소를 생성
        
        document.body.appendChild(textarea); //</body> 바로 위에 textarea를 추가(임시 공간이라 위치는 상관 없음)
        url = window.document.location.href;  //url에는 현재 주소값을 넣어줌
        textarea.value = url;  // textarea 값에 url를 넣어줌
        textarea.select();  //textarea를 설정
        document.execCommand("copy");   // 복사
        document.body.removeChild(textarea); //extarea 요소를 없애줌
        
        alert("URL이 복사되었습니다.")  // 알림창
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


