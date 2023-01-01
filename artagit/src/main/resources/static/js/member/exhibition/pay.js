window.addEventListener("load", function(){

    const payMenu = document.querySelector(".payment-select-menu");
    let currentEl = document.querySelector(".active");

    const paySimple = document.querySelector(".payment-select-simple");

	let tabContents = document.querySelectorAll(".tab-content");
    let choosePay = document.querySelector(".choose-pay")


    //------------ 결제수단 선택하기----------------
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

	//카카오페이 이미지 클릭시
    paySimple.onclick = function(e){
        //e.preventDefault();
        console.log("test");

		kakaoImg.innerHTML = `<img src="../../image/kakaopay.PNG" width="150px" alt="">`

        kakaopay();
    }



    function kakaopay() {
		
		console.log('클릭')
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
			/**/ name: '어노니머스 프로젝트',
			// 결제창에서 보여질 이름
			// name: '주문명 : ${auction.a_title}',
			// 위와같이 model에 담은 정보를 넣어 쓸수도 있습니다.
			amount: 20000,
			// amount: ${bid.b_bid},
			// 가격 
			buyer_name: '이름',
			// 구매자 이름, 구매자 정보도 model값으로 바꿀 수 있습니다.
			// 구매자 정보에 여러가지도 있으므로, 자세한 내용은 맨 위 링크를 참고해주세요.
			buyer_postcode: '123-456',
			}, function (rsp) {
				console.log(rsp);
			if (rsp.success) {
				var msg = '결제가 완료되었습니다.';
				msg += '결제 금액 : ' + rsp.paid_amount;
				// success.submit();
				// 결제 성공 시 정보를 넘겨줘야한다면 body에 form을 만든 뒤 위의 코드를 사용하는 방법이 있습니다.
				// 자세한 설명은 구글링으로 보시는게 좋습니다.
			} else {
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
			}
			alert(msg);
		}); 
	};
	
	
	


})