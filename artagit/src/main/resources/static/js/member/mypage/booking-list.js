
//모달로 재도전
window.addEventListener("load", function(){

    const paymentTable = document.querySelectorAll(".payment-table");
    const bookingListSection = document.querySelector(".booking-list");
    const ListSection = document.querySelector(".button-list"); //리뷰등록, 결제상세
    
	

	//리뷰보기(o), 리뷰작성(o), 결제상세(o)
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
		
		
		
		
		//등록된 리뷰 보기------------------------------------------------------------------------------
		else if(e.target.classList.contains("btn-review")){
			e.preventDefault();
			var reviewId = e.target.dataset.id;

			fetch(
				`/member/mypage/review/api/${reviewId}`,{
					method:"GET"}
					)
			.then((response)=>response.json())
			.then((data)=>{
			
			let bookingInfo = data.bookingInfo;
			var bookingDate = bookingInfo.bookingDate.substring(0,10);
			
			
			var template =
				`
				<div class="review-modal-background "> 
		        	<div class="review-modal-window"> 
			        	<div class=" review-modal-popup"> 
				            

				            <div class="box" style="background-color:${bookingInfo.color};">
								<div class="review" >리뷰 보기</div>
	                			<div class="write-form" >
		                    		<div class="content" >${bookingInfo.reviewCon}</div>
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
		                    		
		 	        	 			<div class="review-button-list" style="margin-left:0px;">
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
				const reviewModal = document.querySelector(".review-modal-background");
				
	
				//수정등록 ,닫기
					const reviewBtn= document.querySelector(".review-button-list"); // 등록, 수정, 삭제
					const writeForm = document.querySelector(".write-form");
					
					reviewBtn.onclick = function(e){
							e.preventDefault();
						
						
						//수정
						if(e.target.classList.contains("btn-mod")){
							
								console.log("수정등록에서 "+reviewId);
			
								let bookingInfo = data.bookingInfo;
								var bookingDate = bookingInfo.bookingDate.substring(0,10);
								const reviewModal = document.querySelector(".review-modal-background");
								reviewModal.classList.add("d-none")
								
								var template =
									`
									<div class="review-modal-background "> 
							        	<div class="review-modal-window"> 
								        	<div class=" review-modal-popup"> 
									            
					
									            <div class="box" style="background-color:${bookingInfo.color};">
													<div class="review" >리뷰 수정</div>
						                			<div class="write-form" >
							                    		<textarea class="input-review"  spellcheck="false" placeholder="리뷰를 작성해주세요">${bookingInfo.reviewCon}</textarea>
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
								                    		<a class="color purple"></a>
															<a class="color green"></a>
															<a class="color blue"></a>
									                    </div>
							                    
							                    		<div>
															<a class="trash">
					
															</a>
							                    		</div>
							                    		
							 	        	 			<div class="review-button-list" style="margin-left:80px;">
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
										
										const modreg = document.querySelector(".btn-reg");
										const writeForm = document.querySelector(".write-form");
										modreg.onclick= function(){
										console.log(color);
										
											console.log(reviewId);
											let form = new FormData();
											form.append("content",writeForm.querySelector(".input-review").value);
											form.append("color",color);
								
											console.log(form);


										fetch(
										`/member/mypage/review/api/mod/${reviewId}`,{
											method:"POST",body:form}
											)
										.then((response)=>response.json())
										.then((data)=>{
											
											if(data==1){
												alert("리뷰가 수정되었습니다.");
													const reviewModal = document.querySelector(".review-modal-background");
								reviewModal.classList.add("d-none")
											}
											else
												alert("리뷰 수정에 실패했습니다.");
										})
															
							}
						}//수정 끝-------------------------------
						
						
						
						
						//닫기
						else if(e.target.classList.contains("btn-exit")){
							var reviewModal = document.querySelector(".review-modal-background");
							reviewModal.classList.add("d-none");
						}
					}

							
				
				//등록된 리뷰 보기 안에서 삭제
				var del = document.querySelector(".trash-img");
				del.onclick = function(){
					var resp = confirm("리뷰를 삭제하시겠습니까?");
					console.log(resp);
					
					if(resp ==true){
						console.log(reviewId);
						fetch(
							`/member/mypage/review/api/del/${reviewId}`,{
							method:"DELETE"}
							)
							.then(()=>{
								console.log("data"+data);
								console.log("패치들들들");
						})
						alert('리뷰가 삭제되었습니다.');
						reload();
					}
//					else
//						reviewModal.classList.add("d-none");
				}
				
				
				//등록된 리뷰 보기 안에서 닫기
				var exit = document.querySelector(".btn-exit");
				console.log(reviewModal)
				exit.addEventListener("click",()=>{close1(reviewModal)});
			})
			
			}
			//등록된 리뷰 보기 끝------------------------------------------------------------------------------
			
		
		
		
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


				console.log("bookingDate"+bookingDate);
				var now = new Date();
					now = 
				    leadingZeros(now.getFullYear(), 4) + '-' +
				    leadingZeros(now.getMonth() + 1, 2) + '-' +
				    leadingZeros(now.getDate(), 2);
				console.log("timestamp"+now);

				if(bookingDate >=  now){
    				alert("관람 전인 리뷰에 대해서는 작성할 수 없습니다. \n관람 후에 작성해 주세요.");
  				}			
  				
  				else{

				var template =`
						<div class="review-modal-background ">
				        	<div class="review-modal-window">
			        			<div class=" review-modal-popup">
		
												<div class="box">
													<div class="review">리뷰 작성</div>
													<div class="write-form">
													     <textarea name ="content" spellcheck="false" class="input-review" placeholder="리뷰를 작성해주세요" ></textarea>       
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
																<a class="icon icon-question3"></a>
									                    </div>
									                    
									                    <div class="trash">
									                    </div>
									                   
									                   
									                    
									                    <div class="review-button-list">
            												<a class="btn btn-default btn-default-fill btn-reg" type="button"   value="등록" >등록</a>
            												<a class="btn btn-default btn-default-line btn-exit" type="button" href="/member/mypage/review/list" value="닫기">닫기</a>
    													</div>
								                	</div>
									                   <div class="form-color"><img class="help-img d-none" src="../../../../image/help3.png"></div>
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
							console.log(form);
							fetch(
								`/member/mypage/review/api/reg/${bookingId}`,
								{method:"POST",body:form})
							.then((response)=>response.json())
							.then((data)=>{
								
								var result = data.regResult;
								if(result ==0){
									alert('리뷰가 등록되었습니다');
								}	
								else if(result==0){
									alert('리뷰 등록에 실패했습니다.');
								}

								var reviewModal = document.querySelector(".review-modal-background");
								reviewModal.classList.add("d-none");
       							reload();
								
							})
				
						}
						//닫기
						else if(e.target.classList.contains("btn-exit")){
							var reviewModal = document.querySelector(".review-modal-background");
							reviewModal.classList.add("d-none");
						}
					}
					
					//도움말 호버
					var ques = document.querySelector(".icon-question3");
					var helpImg = document.querySelector(".help-img");
					ques.onmouseover= function(){
						helpImg.classList.remove("d-none");
					}
					ques.onmouseout= function(){
						helpImg.classList.add("d-none");
					}
					
					
				}
					
			})
		}
		//리뷰 작성끝--------------------------------------------------------------------------
		
	
	
		}
	
				
			
		function reload(){  
		   location.reload();
		}

		//닫기
		let close = function(paymodal){
			console.log("in");
			paymodal.classList.add("d-none");	
		}
		
		let close1 = function(reviewModal){
			console.log("in1");	
			reviewModal.classList.add("d-none");
		}
		
		function leadingZeros(n, digits) {
			    var zero = '';
			    n = n.toString();
		
			    if (n.length < digits) {
			        for (i = 0; i < digits - n.length; i++)
			            zero += '0';
			    }
			    return zero + n;
			}
	
});