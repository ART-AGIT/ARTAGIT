

window.addEventListener("load",function(e){
    var box = document.querySelector(".box");
    var colorInput = document.querySelector(".color-input");
    const btnList = document.querySelector(".review-button-list");
	const btnDel = document.querySelector(".btn-del");
	const writeForm = document.querySelector(".write-form");
	const reviewForm = document.querySelector(".review-form");
	const optionList = document.querySelector(".review-option-list");
	const input = document.querySelector(".input");
	const detailInfo = document.querySelector(".detail-info");
//	const trash = document.querySelector(".trash");
	
	//유효성검사
	//리뷰작성 문자수
	//관람일보다 지난 날짜일경우만 리뷰 작성 가능
	
	//	리뷰 테마 컬러 변경
    colorInput.oninput= function(e){
        box.style.background = colorInput.value;
    }
    
    
	//	버튼리스트 (수정 등록 닫기)
	btnList.onclick=function(e){
		
		//수정
		if(e.target.classList.contains("btn-mod")){
			let content = writeForm.getElementsByTagName("textarea").value;
//			console.log(content);
			console.log("수")
		}
		
		
		
		
		
		
		
		
		
		
		
		
		//등록
		else if(e.target.classList.contains("btn-reg")){
			e.preventDefault();
			
			console.log("등록버튼 reg test");

			let form = new FormData();
			form.append("content",writeForm.querySelector(".input").value);
			form.append("color",box.querySelector(".color-input").value);
			console.log("form객체----"+form);
			var id = document.querySelector(".bookingId").value;
			console.log(id);
			
			fetch(
				`/member/mypage/review/reg/${id}`,{
					method:"POST",
					body:form})
			.then((response)=>response.json())
			.then((data)=>{
				
				console.log("js 테스트-----------------");
				console.log("data------ "+data.resultObject);
				let review = data.resultObject;
				let booking2 = data.booking2;
				console.log(review);
		        
		        	
	        	/*-------------------------------2번째시도 */
	        	
	        	let template =`
				<div class="review-form" >
	        
		            <div class="box">
		                <div class="write-form" >
		                    <div class="content" >${review.content}</div>			                    
		                    
		                </div>
		                <div class="detail-info">
		                    <div>
		                        <label class="exh-name" id="exhName">${booking2.exhName}</label>
		                    </div>
		                    <div>
		                        <span class="exh-loc" >${booking2.museumName}</span>
		                        <span class="exh-date" >${booking2.bookingDate}</span>
		                    </div>
		    
		                    <div class="color-option">
		                        <input type="color" class="color-input" name="color"></input>
		                    </div>
		                    
		                    <div class="trash">
                        		<a href="/member/mypage/review/del/${review.id}"><img class="trash-img" src="../../../image/trash.png" ></a>
                    	
                    		</div>
		                    
		                </div>
		            </div>
	        	</div>
	 
    
			        <div class="review-option-list">
			            <span class="review-option">
			                <input type="radio" name="공개여부">
			                <label>공개</label>
			            </span>
			
			            <span class="review-option">
			                <input type="radio" name="공개여부">
			                <label>비공개</label>
			            </span>    
			        </div>
			
			        <div class="review-button-list">
			        	<input type="hidden" class= "bookingId" name="bookingId" >

			            <input class="btn btn-default btn-default-fill btn-mod" type="submit" value="수정">
			            <a class="btn btn-default btn-default-line btn-exit" type="button" href="/member/mypage/review/list" value="닫기">닫기</a>
			        </div>
			          	
	        	`;
		        	
		        	
	        	// 2번째시도 
	        	reviewForm.innerHTML="";
	        	optionList.innerHTML="";
	        	btnList.innerHTML="";
						
	        	reviewForm.insertAdjacentHTML("afterend",template);
		        	
	        	/*-----------------------3번째 시도
	        	let template3 = `
	                    <div class="content" >${review.content}</div>
	        	`;
	        	let trash = document.querySelector(".trash");
	        	writeForm.innerHTML=template3;
	        	console.log("trash---------"+trash);
	        	trash.classList.add('d-none');
				*/
		        	
			})
		}
			
		//닫기
		else if(e.target.classList.contains("btn-exit")){
			console.log("닫")
		}
		
	}
	
	//삭제
	/*
	btnDel.onclick=function(e){
		e.preventDefault();
		let reviewId = e.target.dataset.id;
		console.log("reviewId "+reviewId);
		console.log("삭제");
	}
	   */
    
    
});