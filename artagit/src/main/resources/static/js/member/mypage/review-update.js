
window.addEventListener("load",function(){
	const btnList = document.querySelector(".review-button-list");
	const writeForm = document.querySelector(".write-form");
	var box = document.querySelector(".box");
	var colorInput = document.querySelector(".color-input");
	const reviewForm = document.querySelector(".review-form");
//	const optionList = document.querySelector(".review-option-list");
	
	colorInput.oninput= function(e){
        box.style.background = colorInput.value;
    }
	
	btnList.onclick=function(e){
		
		if(e.target.classList.contains("btn-reg")){
			e.preventDefault();
			
			let form = new FormData();
			form.append("content",writeForm.querySelector(".input-review").value);
			form.append("color",box.querySelector(".color-input").value);
			var id = document.querySelector(".reviewId").value;
			var payid = document.querySelector(".payId").value;
			console.log(payid);
				
			fetch(
				`/member/mypage/review/update/${id}`,{
					method:"POST",
					body:form})
			.then((response)=>response.json())
			.then((data)=>{
				
				console.log("js 테스트-----------------");
				console.log("data------ "+data.resultObject);
				let review = data.resultObject;
				let bookingList = data.bookingList;
				console.log(review);	
				
			let template =`
				<div class="review-form" >
	        
		            <div class="box" style="background-color:${review.color}"}>
		                <div class="write-form" >
		                    <div class="content" >${review.content}</div>			                    
		                    
		                </div>
		                <div class="detail-info">
		                    <div>
		                        <label class="exh-name" id="exhName">${bookingList.exhName}</label>
		                    </div>
		                    <div>
		                        <span class="exh-loc" >${bookingList.museumName}</span>
		                        <span class="exh-date" >${bookingList.bookingDate}</span>
		                    </div>
		    
		                    <div class="color-option">
		                        <input type="color" class="color-input" name="color"></input>
		                    </div>
		                    
		                    <div class="trash">
                        		<a href="/member/mypage/review/del/${review.id}"><img class="trash-img" src="../../../../image/trash.png" ></a>
                    	
                    		</div>
		                    
		                </div>
		            </div>
	        	</div>
	 
    
			        
			
			        <div class="review-button-list">
			        	<input type="hidden" class= "bookingId" name="bookingId" >

			            <a href="/member/mypage/review/update/${review.id}" class="btn btn-default btn-default-fill btn-mod" type="submit" value="수정">수정</a>
			            <a class="btn btn-default btn-default-line btn-exit" type="button" href="/member/mypage/review/list" value="닫기">닫기</a>
			        </div>
			          	
	        	`;
		        	
		        	
	        	// 2번째시도 
	        	reviewForm.innerHTML="";
//	        	optionList.innerHTML="";
	        	btnList.innerHTML="";
						
	        	reviewForm.insertAdjacentHTML("afterend",template);	
				
		})
	}
	}})
	