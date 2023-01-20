//window.addEventListener("load", function(){
//    const payDetailModal = document.querySelectorAll(".pay-detail");
//    const paymentTable = document.querySelectorAll(".payment-table");
//    const bookingListSection = document.querySelector(".booking-list");
//    const ListSection = document.querySelector(".button-list");
//	
//
//
//    bookingListSection.onclick=function(e){
//		
//		if(e.target.classList.contains("pay-detail")){
//			
//			var id = e.target.dataset.id;
//			var current = e.target;
////			console.log("bookingid를 가져왔지만 그건 또한 payId "+e.target.dataset.id);
////			console.log(current);
//			
//			fetch(
//				`/member/mypage/payment/${id}`,{
//					method:"GET"}
//					)
//			.then((response)=>response.json())
//			.then((data)=>{
//				console.log("페치안에들어옴");
//				let payment = data.payment;
//				let user = data.user;
//				let exhibition = data.exhibition;
//				let booking = data.booking;
//				
//				var bookingDate = booking.date.substring(0,10);
//			
//			
//			var template =
//				`
//			<div class="pay-modal-background "> 
//	        	<div class="pay-modal-window"> 
//		        	<div class=" pay-modal-popup"> 
//			            <section class="payment-list"> 
//			                <h1>결제 상세</h1> 
//			                 <a class="btn btn-default btn-default-fill-off pay-cancel"  value="닫기">결제 취소</a> 
//			                <div class=""> 
//								<div class="payment-table">
//					                <div class="item" >결제번호</div>
//					                <div class="item">${payment.payNum}</div>
//					                <div class="item">아이디</div>
//					                <div class="item">${user.username}</div>
//					                <div class="item">이름</div>
//					                <div class="item">${user.name}</div>
//					                <div class="item">전시</div>
//					                <div class="item">${exhibition.name}</div>
//					                <div class="item">인원</div>
//					                <div class="item">${booking.amount}</div>
//					                <div class="item">관람일</div>
//					                <div class="item">${bookingDate}</div>
//					                <div class="item">결제금액</div>
//					                <div class="item">${payment.price}</div>
//					                <div class="item">결제방식</div>
//					                <div class="item">${payment.method}</div>
//					                <div class="item" >결제일</div>
//					                <div class="item">${payment.regDate}</div>
//					            </div>
//						            <div class="btn-box"> 
//	 			                        <a class="btn btn-default btn-default-fill btn-exit"  value="닫기">닫기</a> 
//	 			                    </div> 
// 			                </div> 
// 			            </section> 
// 		        	</div>    
// 	        	</div> 
// 	        </div> 
//					            
//				`;
//				
//			
//			paymentTable.innerHTML="";
//			ListSection.insertAdjacentHTML("afterend",template);
//			
//			const closeBtn = document.querySelector(".btn-exit");
//			const payModal = document.querySelector(".pay-modal-background");
//			
//			closeBtn.addEventListener("click",()=>{close(payModal)})
//			
//			})
//		}
//		
//			let close = function(payModal){
//				console.log("in");
//				payModal.classList.add("d-none");	
//			}
//
//		
//	}
//	
//})




//모달로 재도전

window.addEventListener("load", function(){
//    const payDetailModal = document.querySelectorAll(".pay-detail");
    const paymentTable = document.querySelectorAll(".payment-table");
    const bookingListSection = document.querySelector(".booking-list");
    const ListSection = document.querySelector(".button-list"); //리뷰등록, 결제상세
    
	

	//리뷰보기, 리뷰작성, 결제상세
    bookingListSection.onclick=function(e){
		
		
		//결제상세-----------------------------------------------------------------------------
		if(e.target.classList.contains("pay-detail")){
	
			var id = e.target.dataset.id;

			fetch(
				`/member/mypage/payment/${id}`,{
					method:"GET"}
					)
			.then((response)=>response.json())
			.then((data)=>{
				console.log("페치안에들어옴");
				let payment = data.payment;
				let user = data.user;
				let exhibition = data.exhibition;
				let booking = data.booking;
				
				var bookingDate = booking.date.substring(0,10);
			
			
			var template =
				`
			<div class="pay-modal-background "> 
	        	<div class="pay-modal-window"> 
		        	<div class=" pay-modal-popup"> 
			            <section class="payment-list"> 
			                <h1>결제 상세</h1> 
			                 <a class="btn btn-default btn-default-fill-off pay-cancel"  value="닫기">결제 취소</a> 
			                <div class=""> 
								<div class="payment-table">
					                <div class="item" >결제번호</div>
					                <div class="item">${payment.payNum}</div>
					                <div class="item">아이디</div>
					                <div class="item">${user.username}</div>
					                <div class="item">이름</div>
					                <div class="item">${user.name}</div>
					                <div class="item">전시</div>
					                <div class="item">${exhibition.name}</div>
					                <div class="item">인원</div>
					                <div class="item">${booking.amount}</div>
					                <div class="item">관람일</div>
					                <div class="item">${bookingDate}</div>
					                <div class="item">결제금액</div>
					                <div class="item">${payment.price}</div>
					                <div class="item">결제방식</div>
					                <div class="item">${payment.method}</div>
					                <div class="item" >결제일</div>
					                <div class="item">${payment.regDate}</div>
					            </div>
						            <div class="btn-box"> 
	 			                        <a class="btn btn-default btn-default-fill btn-exit"  value="닫기">닫기</a> 
	 			                    </div> 
 			                </div> 
 			            </section> 
 		        	</div>    
 	        	</div> 
 	        </div> 
					            
				`;
				
			
			paymentTable.innerHTML="";
			ListSection.insertAdjacentHTML("afterend",template);
			
			const closeBtn = document.querySelector(".btn-exit");
			const payModal = document.querySelector(".pay-modal-background");
			
			closeBtn.addEventListener("click",()=>{close(payModal)})
			
			})
		}
		
		
		
		
		//결제상세끝-----------------------------------------------------------------------------
		
		
		//리뷰 보기------------------------------------------------------------------------------
		else if(e.target.classList.contains("btn-review")){
			e.preventDefault();
			console.log("리뷰보기");
			
			var reviewId = e.target.dataset.id;
			console.log(reviewId);	
			
			fetch(
				`/member/mypage/review/api/${reviewId}`,{
					method:"GET"}
					)
			.then((response)=>response.json())
			.then((data)=>{
			
			console.log("패치들어옴");
			let bookingInfo = data.bookingInfo;
			console.log("bookingInfo"+bookingInfo);
			console.log(bookingInfo.reviewId);
			console.log(bookingInfo.reviewColor);
			var bookingDate = bookingInfo.bookingDate.substring(0,10);
			
			
			var template =
				`
				<div class="review-modal-background "> 
		        	<div class="review-modal-window"> 
			        	<div class=" review-modal-popup"> 
				            

				            <div class="box" style="background-color:${bookingInfo.reviewColor};">
								<div class="review" >리뷰 보기</div>
	                			<div class="write-form" >
		                    		<div class="content" >${bookingInfo.reviewColor}</div>
	                			</div>
	                
		                		<div class="detail-info">
		                    		<div>
		                        		<label class="exh-name"  id="exhName">${bookingInfo.exhName}</label>
		                    		</div>
		                    		<div>
		                        		<span class="exh-loc" >${bookingInfo.museumName}국립현대미술관</span>
		                        		<span class="exh-date"  >${bookingDate}</span>
		                    		</div>
		    
		                    		<div class="color-option">
										
		                    		</div>
		                    
		                    		<div>
										<a class="trash">
											<img class="trash-img" src="../../../image/trash2.png">
										</a>
		                    		</div>
		                    		
		 	        	 			<div class="review-button-list">
	            						<a class="btn btn-default btn-default-fill btn-mod" type="button"   value="수정" >수정</a>
	            						<a class="btn btn-default btn-default-line btn-exit" type="button" href="/member/mypage/review/list" value="닫기">닫기</a>
	    							</div>
		                		</div>
	             			</div> 


	 		        	</div>    
	 	        	</div> 
	 	        </div> 
	 	        
				`;
				
				paymentTable.innerHTML="";
				ListSection.insertAdjacentHTML("afterend",template);

				//리뷰 보기 안에서 수정 
				const btnMod = document.querySelector(".btn-mod");
				btnMod.addEventListener("click",()=>{modify()})
			})
			
			}
			
			
		
			//리뷰 작성--------------------------------------------------------------------------
			else if(e.target.classList.contains("btn-write")){
				e.preventDefault();
				console.log("h");
				
				var bookingId = e.target.dataset.id;
				console.log(bookingId);
				
				fetch(
				`/member/mypage/review/api/view/${bookingId}`,{
					method:"GET"}
					)
				.then((response)=>response.json())
				.then((data)=>{
				console.log("패치2들")
				var bookingInfo = data.bookingInfo;
				console.log(bookingInfo);
				var bookingDate = bookingInfo.bookingDate.substring(0,10);

				var template =`
						<div class="review-modal-background ">
				        	<div class="review-modal-window">
			        			<div class=" review-modal-popup">
		
												<div class="box">
													<div class="review">리뷰 작성</div>
													<div class="write-form">
													     <textarea name ="content" class="input-review" placeholder="리뷰를 작성해주세요" ></textarea>       
													</div>        
									                <div class="detail-info">
									                    <div>
									                        <label class="exh-name"  id="exhName">${bookingInfo.exhName}</label>
									                    </div>
									                    <div>
									                        <span class="exh-loc"  >${bookingInfo.museumName}</span>
									                        <span class="exh-date" >${bookingDate}</span>
									                    </div>
									    
									                    <div class="color-option">
									                    		<a class="color purple"></a>
																<a class="color green"></a>
																<a class="color blue"></a>
									                    </div>
									                    
									                    <div class="trash">
															
									                    </div>
									                    
									                   
									                    
									                    <div class="review-button-list">
            												<a class="btn btn-default btn-default-fill btn-reg" type="button"   value="등록" >등록</a>
            												<a class="btn btn-default btn-default-line btn-exit" type="button" href="/member/mypage/review/list" value="닫기">닫기</a>
    													</div>
								                	</div>
							             		</div> 
				             		</div>
				     			</div>
				     		</div>	
		             `;
			
					paymentTable.innerHTML="";
					ListSection.insertAdjacentHTML("afterend",template);

					//리뷰 테마 색상선택
					const colorOption = document.querySelector(".color-option");
					var color=1;
					var box = document.querySelector(".box");

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
						
					}
					
					//등록 ,닫기
					const reviewBtn= document.querySelector(".review-button-list"); // 등록, 수정, 삭제
					const writeForm = document.querySelector(".write-form");
					reviewBtn.onclick = function(e){
							e.preventDefault();
						
						//등록
						if(e.target.classList.contains("btn-reg")){

							let form = new FormData();
							form.append("content",writeForm.querySelector(".input-review").value);
							form.append("color",color);
							console.log(writeForm.querySelector(".input-review").value);
							
							console.log(bookingId);
							
							fetch(
								`/member/mypage/review/api/reg/${bookingId}`,
								{method:"POST",body:form})
							.then((response)=>response.json())
							.then(()=>{
								
								console.log("갖다놓음");	
								
							})
					
							
							
							
						}
					}
					
					
					console.log(color);
					
			
			
//					fetch(
//						`/member/mypage/review/reg/${id}`,{
//							method:"POST",
//							body:form})
//					.then((response)=>response.json())
//					.then((data)=>{

	
	
	
	
			})//fetch 끝
			
			
			
			

			
			
		}
		//리뷰 작성끝--------------------------------------------------------------------------
		
	
	
			let modify = function(){
				console.log("수정창떠야함");
				
				var template =
				`
				<div class="review-modal-background "> 
		        	<div class="review-modal-window"> 
			        	<div class=" review-modal-popup"> 
				            

				            <div class="box" style="background-color:${bookingInfo.reviewColor};">
								<div class="review" >리뷰 쓰기</div>
	                			<div class="write-form" >
		                    		<div class="content" >${bookingInfo.reviewColor}</div>

	                   
	                			</div>
	                
	                		<div class="detail-info">
	                    		<div>
	                        		<label class="exh-name"  id="exhName">${bookingInfo.exhName}</label>
	                    		</div>
	                    		<div>
	                        		<span class="exh-loc" >${bookingInfo.museumName}국립현대미술관</span>
	                        		<span class="exh-date"  >${bookingInfo.bookingDate}</span>
	                    		</div>
	    
	                    		<div class="color-option">
									<a class="color purple" value="pink"  ></a>
									<a class=" color green"   ></a>
									<a class="color blue"  ></a>
	                    		</div>
	                    
	                    		<div>
									<a class="trash">
										<img class="trash-img" src="../../../image/trash2.png">
									</a>
	                    		</div>
	                    		
	 	        	 			<div class="review-button-list">
            						<a class="btn btn-default btn-default-fill btn-mod" type="button"   value="수정" >수정</a>
            						<a class="btn btn-default btn-default-line btn-exit" type="button" href="/member/mypage/review/list" value="닫기">닫기</a>
    							</div>
    							
    							
	                		</div>
				            
	             		</div> 

	 		        	</div>    
	 	        	</div> 

	 	        </div> 
	 	        
				`;
				
				paymentTable.innerHTML="";
				ListSection.insertAdjacentHTML("afterend",template);
			
			}
	
	
		}
	
				
			
	
	
	
		//닫기
		let close = function(payModal){
			console.log("in");
			payModal.classList.add("d-none");	
		}
		

	
});