

window.addEventListener("load",function(e){
    var box = document.querySelector(".box");
    var colorInput = document.querySelector(".color-input");
    const btnList = document.querySelector(".review-button-list");
	const btnDel = document.querySelector(".btn-del");
	const writeForm = document.querySelector(".write-form");
	//	리뷰 테마 컬러 변경
    colorInput.oninput= function(e){
        box.style.background = colorInput.value;
    }
    
	//	버튼리스트 
	btnList.onclick=function(e){
		
		//수정
		if(e.target.classList.contains("btn-mod")){
			let content = writeForm.getElementsByTagName("textarea").value;
			console.log(content);
			console.log("수")
		}
		
		//등록
		else if(e.target.classList.contains("btn-reg")){
			let content = writeForm.getElementsByTagName("textarea").value;
			console.log(content);
			console.log("등");
		
		}
			
		//닫기
		else if(e.target.classList.contains("btn-exit")){
			console.log("닫")
		}
		
	}
	
	//삭제
	btnDel.onclick=function(e){
		e.preventDefault();
		let reviewId = e.target.dataset.id;
		console.log("reviewId"+reviewId);
		console.log("삭제");
	}
	   
    
    
});