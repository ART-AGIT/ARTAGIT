window.addEventListener("load", function(){
	////////////// booking-ticket ///////////////////////
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
	const doPayBtn = this.document.querySelector(".do-pay");
	let depositDate = this.document.querySelector(".deposit-date");

	let userInfo = this.document.querySelectorAll(".transparency");
	let i = 0;
	let price = priceBox.innerText.replace(/[^0-9]/g, "");

	////////////// pay ///////////////////////
	const payMenu = document.querySelector(".payment-select-menu");
    let currentEl = document.querySelector(".active");

    const paySimple = document.querySelector(".payment-select-simple");

	let tabContents = document.querySelectorAll(".tab-content");
    let choosePay = document.querySelector(".choose-pay")
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

	// 결제방식 선택 버튼 클릭시
	payWayBtn.onclick = function(e){
		e.preventDefault();
		console.log("결제방식 선택 클릭");
		
		// 결제금액 띄우기
		totalPrice[1].innerText = (i*price).toLocaleString();
		totalPrice[2].innerText = (i*price).toLocaleString();
		totalPrice[3].innerText = (i*price).toLocaleString();

		let phone = userInfo[0].value;
		let email = userInfo[1].value;
		
		if((phone=='')||(email=='')){
			window.alert("필수 입력 사항을 모두 입력해주세요.");
		} else {
			// 연락처, 이메일 모두 입력을 했다면 다음 페이지로 넘겨주기
			console.log(`연락처 : ${phone}`);
			console.log(`이메일 : ${email}`);
			// 버튼 텍스트 변경
			// payWayBtn.innerText = '결제하기';
			bookingContainer.classList.add('d-none');
			payContainer.classList.remove('d-none');
		}
	}

	//------------ pay ------------//
	//------------ 결제수단 선택하기 --------------//
    payMenu.addEventListener("click", function(e){
        e.preventDefault();

		choosePay.innerHTML="";
        
        let el = e.target;

        if(el.tagName != 'A' || currentEl == el)
            return;
		
        el.classList.add('active');

        if(currentEl != null)
            currentEl.classList.remove('active');

        currentEl = el;

		let tabNumber = el.dataset.forTab;
		const tabContent = document.querySelector(`.tab-content[data-tab="${tabNumber}"]`)
		
		tabContents.forEach(tab => {
			if(!tab.classList.contains("d-none"))
				tab.classList.add("d-none")
		})

		tabContent.classList.remove("d-none");
    })

	let kakaoImg = this.document.querySelector(".kakao-img");

	doPayBtn.onclick = function(e){
		// const checkbox = document.querySelector(input[id="caution-check"]);
		e.preventDefault();
		const checkbox = document.getElementById('caution-check');

		

		if(checkbox.checked == false){
			window.alert("결제 시, 예매 시 유의사항의 동의가 필요합니다.");
		}
        console.log("test");

		kakaopay();
    }

    function kakaopay() {
		let memId = doPayBtn.dataset.id;
		console.log("memid ==> "+memId);
		const exhTitle = document.querySelector(".exh-title").innerText;
		console.log('카카오페이 클릭');
		var IMP = window.IMP; // 생략가능
		IMP.init('imp63753861'); 
		// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
		// ''안에 띄어쓰기 없이 가맹점 식별코드를 붙여넣어주세요. 안그러면 결제창이 안뜹니다.
		IMP.request_pay({
			pg: 'kakaopay',
			pay_method: 'card',
			merchant_uid: 'merchant_' + new Date().getTime(),
			/* 
			 *  merchant_uid에 경우 
			 *  https://docs.iamport.kr/implementation/payment
			 *  위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
			 */
			name: exhTitle,
			// 결제창에서 보여질 이름
			// name: '주문명 : ${auction.a_title}',
			// 위와같이 model에 담은 정보를 넣어 쓸수도 있습니다.
			amount: i*price,
			// amount: ${bid.b_bid},
			// 가격 
			buyer_name: '이름',
			// 구매자 이름, 구매자 정보도 model값으로 바꿀 수 있습니다.
			// 구매자 정보에 여러가지도 있으므로, 자세한 내용은 맨 위 링크를 참고해주세요.
			buyer_postcode: '123-456',
			}, function (rsp) { // callback
				console.log(rsp);
			if (rsp.success) { // 결제 성공 시
				var msg = '결제가 완료되었습니다.';
				msg += '결제 금액 : ' + rsp.paid_amount + '원';
				// success.submit();
				// 결제 성공 시 정보를 넘겨줘야한다면 body에 form을 만든 뒤 위의 코드를 사용하는 방법이 있습니다.
				// 자세한 설명은 구글링으로 보시는게 좋습니다.
				fetch("/member/exh/pay", {
					method: "POST",
					headers: {
								"Content-Type": "application/json",
					},
					body: JSON.stringify({
						"booking" : {
							"date" : '2023-01-13',
							"amount" : numBox.innerText,
							"phone" : userInfo[0].value,
							"email" : userInfo[1].value,
							"memId" : memId,
							"exhId" : '17'
						},

						"payment" : {
							"payNum" : '12345678',
							"price" : i*price,
							"method" : '카카오페이'
						}
					})
				})
				.then(res => res.json())
				.then( // db 전송 후, 페이지 이동
					location.replace('/')
				)
			} else {
				var msg = '결제에 실패하였습니다. 다시 시도해주세요.';
				msg += '에러내용 : ' + rsp.error_msg;
			}
			alert(msg);
		}); 
	};

	// 입금기한 출력 (오늘부터 다음날 23:59:59 까지)
	var today = new Date();

	var year = today.getFullYear();
	var month = ('0' + (today.getMonth()+1)).slice(-2);
	var day = ('0' + (today.getDate()+1)).slice(-2);

	var dateString = year + '년 ' + month  + '월 ' + day + '일 23시 59분 59초' ;
	depositDate.innerText = dateString;
	
	// input 태그에 숫자만 입력받기

	
});