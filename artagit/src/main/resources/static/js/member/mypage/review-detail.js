

window.addEventListener("load",function(e){
    var box = document.querySelector(".box");
    var colorInput = document.querySelector(".color-input");
    const btnList = document.querySelector(".review-button-list");
	const btnDel = document.querySelector(".btn-del");
	const writeForm = document.querySelector(".write-form");
	const reviewForm = document.querySelector(".review-form");
//	const optionList = document.querySelector(".review-option-list");
	const input = document.querySelector(".input-review");
	const detailInfo = document.querySelector(".detail-info");
//	const color=null;
	const colorOption = document.querySelector(".color-option");
//	const trash = document.querySelector(".trash");
	var color=1;

    
    colorOption.onclick=function(e){
		
		if(e.target.classList.contains("purple")){
			box.style.background = "#E2D1F0";
			color = "#ffb8b8";
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
	
	//	버튼리스트 (수정 등록 닫기)
	btnList.onclick=function(e){
		
	console.log(color);
		//등록
		if(e.target.classList.contains("btn-reg")){
			e.preventDefault();
			
			console.log("color"+color);
			console.log("등록버튼 reg test");

			let form = new FormData();
			form.append("content",writeForm.querySelector(".input-review").value);
			
//			form.append("color",box.querySelector(".color-input").value);
			form.append("color",color);
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
			
		//닫기
		else if(e.target.classList.contains("btn-exit")){
			console.log("닫")
		}
		
	}
	
    
});