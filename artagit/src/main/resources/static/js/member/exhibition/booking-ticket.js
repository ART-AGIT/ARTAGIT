window.addEventListener("load", function(e){
	const cNumBox = document.querySelector(".client-number");
	const cInfoBox = document.querySelector(".client-info");
	const plus = document.querySelector(".plus");
	const minus = this.document.querySelector(".minus");
	const numBox = this.document.querySelector(".count");
	const priceBox = this.document.querySelector(".price");

	const totalPrice = this.document.querySelectorAll(".total-price");
	const bookingContainer = this.document.querySelector(".booking-container");
	const payContainer = this.document.querySelector(".pay-container");

	const payWayBtn = this.document.querySelector(".btn-way");
	let depositDate = this.document.querySelector(".deposit-date");

	let userInfo = this.document.querySelectorAll(".transparency");
	let i = 0;
	let price = priceBox.innerText.replace(/[^0-9]/g, "");

	// [+] 버튼 클릭 시, 수량 증가 및 수량에 따른 결제 금액 증가
	plus.onclick = function(e){
		e.preventDefault();
		cInfoBox.classList.remove("d-none");

		i++;
		console.log(`수량: ${i} + 금액: ${i*price}`);

		numBox.innerText = i;
		totalPrice[0].innerText = (i*price).toLocaleString();
	}

	// [-] 버튼 클릭 시, 수량 감소 및 수량에 따른 결제 금액 감소
	minus.onclick = function(e){
		e.preventDefault();
		if(i>0){
			i--;
			console.log(`수량: ${i} + 금액: ${i*price}`);
	
			numBox.innerText = i;
			totalPrice[0].innerText = (i*price).toLocaleString();
		} else {
			numBox.innerText = 0;
		}
	}

	payWayBtn.onclick = function(e){
		e.preventDefault();
		console.log("결제방식 선택 클릭");

		
		// numBox.innerText
		console.log(numBox.innerText);
		console.log(userInfo);
		console.log(userInfo[0].value);
		console.log(userInfo[1].value);
		bookingContainer.classList.add('d-none');
		payContainer.classList.remove('d-none');

		totalPrice[1].innerText = (i*price).toLocaleString();
		totalPrice[2].innerText = (i*price).toLocaleString();
	}

	// 입금기한 출력 (오늘부터 다음날 23:59:59 까지)
	var today = new Date();

	var year = today.getFullYear();
	var month = ('0' + (today.getMonth()+1)).slice(-2);
	var day = ('0' + (today.getDate()+1)).slice(-2);

	var dateString = year + '년 ' + month  + '월 ' + day + '일 23시 59분 59초' ;
	 	depositDate.innerText = dateString;
});