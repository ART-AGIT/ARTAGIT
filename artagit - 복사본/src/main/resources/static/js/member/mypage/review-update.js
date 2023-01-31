
window.addEventListener("load",function(){
	const btnList = document.querySelector(".review-button-list");
	const writeForm = document.querySelector(".write-form");
	var box = document.querySelector(".box");
	var colorInput = document.querySelector(".color-input");
	const reviewForm = document.querySelector(".review-form");
//	const optionList = document.querySelector(".review-option-list");
	const colorOption = document.querySelector(".color-option");
	var color=1;

	
	
	colorOption.onclick=function(e){
		
		if(e.target.classList.contains("purple")){
			box.style.background = "#E2D1F0";
			color = "#E2D1F0";
			}
		else if(e.target.classList.contains("green")){
			box.style.background = "#E4F0D1";
			color = "#E4F0D1";
			}
		else if(e.target.classList.contains("blue")){
			box.style.background = "#D1EBF0";
			color = "#D1EBF0";
			}
			console.log(color);
	}
	
	
	
	
	
	
	
	btnList.onclick=function(e){
		
		if(e.target.classList.contains("btn-reg")){
			e.preventDefault();
			
			let form = new FormData();
			form.append("content",writeForm.querySelector(".input-review").value);
//			form.append("color",box.querySelector(".color-input").value);
			form.append("color",color);
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
				var bookingDate =bookingList.bookingDate.substring(0,10);
				
			let template =`
				<div class="review-form" >
	        
		            <div class="box" style="background-color:${review.color}">
		                <div class="write-form" >
		                    <div class="content" >${review.content}</div>			                    
		                    
		                </div>
		                <div class="detail-info">
		                    <div>
		                        <label class="exh-name" id="exhName">${bookingList.exhName}</label>
		                    </div>
		                    <div>
		                        <span class="exh-loc" >${bookingList.museumName}</span>
		                        <span class="exh-date" >${bookingDate}</span>
		                    </div>
		 
		                    <div class="color-option" >
		                        <div  class="color" name="color" style="background-color:${review.color}"></div>
		                    </div>
		                    
		                    <div class="trash">
                        		<a href="/member/mypage/review/del/${review.id}"><img class="trash-img" src="../../../../image/trash2.png" ></a>
                    	
                    		</div>
		                    
		                </div>
		            </div>
	        	</div>
	 
    
			        
			
			        <div class="review-button-list" style="margin-left:0px">
			        	<input type="hidden" class= "bookingId" name="bookingId" >

			            <a href="/member/mypage/review/update/${review.id}" class="btn btn-default btn-default-fill btn-mod" type="submit" value="수정">수정</a>
			            <a class="btn btn-default btn-default-line btn-exit" type="button" href="/member/mypage/review/list" value="닫기">닫기</a>
			        </div>
			          	
	        	`;
		        	
		        
	        	reviewForm.innerHTML="";
	        	btnList.innerHTML="";
						
	        	reviewForm.insertAdjacentHTML("afterend",template);	
				
		})
	}
	}})
	