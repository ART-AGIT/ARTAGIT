

window.addEventListener("load",function(){
	
    var box = document.querySelector(".box");
    const btnList = document.querySelector(".review-button-list");
	const writeForm = document.querySelector(".write-form");
	const reviewForm = document.querySelector(".review-form");
	const colorOption = document.querySelector(".color-option");
	var color=1;

	const btnDel = document.querySelector(".trash-img");
	const trash = document.querySelector(".trash");
	const delModal = document.querySelector(".del-modal-background");
	
	
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
//		color = box.style.backgroud;
	}

	btnList.onclick=function(e){
		

		//등록
		if(e.target.classList.contains("btn-reg")){
			e.preventDefault();
			
			let form = new FormData();
			form.append("content",writeForm.querySelector(".input-review").value);
			form.append("color",color);
			var id = document.querySelector(".bookingId").value;
			
			
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
		        console.log(booking2.bookingDate);
		        console.log(booking2.bookingDate.substring(0,10));
		       	var bookingDate =booking2.bookingDate.substring(0,10);
	        	/*-------------------------------2번째시도 */
	        	
	        	let template =`
				<div class="review-form" >
	        
		            <div class="box" style="background-color:${review.color}"}>
		                <div class="write-form" >
		                    <div class="content" >${review.content}</div>			                    
		                    
		                </div>
		                <div class="detail-info">
		                    <div>
		                        <label class="exh-name" id="exhName">${booking2.exhName}</label>
		                    </div>
		                    <div>
		                        <span class="exh-loc" >${booking2.museumName}</span>

								<span class="exh-date" >${bookingDate} </span>
		                    </div>
		    
		                   
		                    
		                    <div class="color-option" style="display:hidden">
								<a class="color purple" value="pink"  style="background-color:${review.color}; border:2px solid ${review.color}" ></a>
								<a class=" color green" style="background-color:${review.color}; border:2px solid ${review.color}" ></a>
								<a class="color blue" style="background-color:${review.color}; border:2px solid ${review.color}" ></a>
	                    	</div>
		                    
		                    
		                    
		                    <div class="trash" style="margin-left:60%"  >
                        		<a href="/member/mypage/review/del/${review.id}"><img class="trash-img" src="../../../image/trash2.png" ></a>
                    	
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

		//삭제
//		btnDel.onclick=function(e){
//			var id = e.target.dataset.id;
//			console.log("id "+id);
////			console.log(review.id)
//			e.preventDefault();
//			delModal.classList.remove("d-none");
//			console.log("hh");
//			if(e.target.classList.contains("del-btn")){
//				console.log("페치")
//				fetch(`/member/mypage/review/del/${id}`,
//						{method:"DELETE"})
//				
//			}
//				
//			else if(e.target.classList.contains("cancel-btn")){}
			
		}
		
		
	});
	
    
//});