window.addEventListener("load", function(){
    const payDetailModal = document.querySelectorAll(".pay-detail");
    const paymentTable = document.querySelectorAll(".payment-table");
    const bookingListSection = document.querySelector(".booking-list");
    const ListSection = document.querySelector(".button-list");
	


    bookingListSection.onclick=function(e){
		
		if(e.target.classList.contains("pay-detail")){
			
			var id = e.target.dataset.id;
			var current = e.target;
//			console.log("bookingid를 가져왔지만 그건 또한 payId "+e.target.dataset.id);
//			console.log(current);
			
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
//				console.log("payment"+payment.payNum);
//				console.log("payment"+payment.id);
//				console.log("payment"+payment.method);
//				console.log("payment"+payment.account);
//				console.log("payment"+user.username);
//				console.log("payment"+user.name);
			
			
			var template =
				`
			<div class="pay-modal-background "> 
	        	<div class="pay-modal-window"> 
		        	<div class=" pay-modal-popup"> 
			            <section class="payment-list"> 
			                <h1>결제 상세</h1> 
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
					                <div class="item">${booking.date}</div>
					                <div class="item">결제금액</div>
					                <div class="item">${payment.price}</div>
					                <div class="item">결제방식</div>
					                <div class="item">${payment.method}</div>
					                <div class="item" >결제일</div>
					                <div class="item">${payment.regDate}</div>
					            </div>
					            <div class="btn-box"> 
 			                        <div class="btn btn-default btn-default-fill btn-exit"  value="닫기">닫기</div> 
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
		
			let close = function(payModal){
				console.log("in");
				payModal.classList.add("d-none");	
			}

		
	}
	

	
    



})