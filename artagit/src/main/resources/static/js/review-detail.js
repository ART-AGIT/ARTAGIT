

window.addEventListener("load",function(e){
    var formBox = document.querySelector(".form-box");
    var colorInput = document.querySelector(".color-input");
    const btnList = document.querySelector(".review-button-list");

//	리뷰 테마 컬러 변경
    colorInput.oninput= function(e){
        formBox.style.background = colorInput.value;
    }
    
//	버튼리스트 
	btnList.onclick=function(e){
		
		//수정
		if(e.target.classList.contains("btn-mod")){
			
			console.log("수")
		}
		
		//삭제
		else if(e.target.classList.contains("btn-del")){
			console.log("삭")
		}
		
		//닫기
		else{
			console.log("닫")
		}
		
	}
	   
    
    
});