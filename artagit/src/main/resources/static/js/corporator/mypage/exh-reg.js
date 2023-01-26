window.addEventListener("load", function() {
	const firstNext = document.querySelector(".btn-next");
	const secondNext = document.querySelector("#btn-y");
	const btnReg = document.querySelector(".exh-reg-button-box-page3");
	const page1 = document.querySelector(".page1");

	// 페이지 전환(위저드)
	const register = document.querySelector(".btn-register");
	const registercancelBtn = this.document.querySelector(".register-cancel-btn");
	const registermodal = this.document.querySelector(".modalregister");
	//전시등록날짜제한걸기
	const startDate = document.querySelector("#start-date");
	const endDate = document.querySelector("#end-date");
	const regDate = document.querySelector("#regdate");

	const date = new Date().toISOString().substring(0, 10);
	//오늘날짜

	startDate.onchange = function(e) {
		//오늘날짜보다 전날을 누르면 적용되지않고 오늘날짜로적용되도록
		console.log("date ==> " + date)
		console.log("startDate.value ==> " + startDate.value);

		if (startDate.value != "" && startDate.value < date) {
			alert('현재 시간보다 이전의 날짜는 설정할 수 없습니다.');
			startDate.value = date;
		}

	}
	endDate.onchange = function(e) {
		
		if (endDate.value != "" && endDate.value < date) {
			//빈칸이거나 오늘보다 이전일때
			alert('현재 시간보다 이전의 날짜는 설정할 수 없습니다.');
			endDate.value = startDate.value;
		} else if (endDate.value != "" && endDate.value < startDate.value) {
			//빈칸이거나 끝나는날이 시작날보다 이전일때 
			alert('전시시작일 이전의 날짜는 설정할 수 없습니다.');
			endDate.value = startDate.value;
		}
	
	}
	register.onclick = function(e) {
		e.preventDefault();
		registermodal.style.display = "flex";
	};
	registercancelBtn.onclick = function(e) {
		e.preventDefault();
		registermodal.style.display = "none";

	}

	firstNext.onclick = function(e) {
		e.preventDefault();
		document.querySelector(".reg-list-page").classList.add("d-none");
		document.querySelector(".reg-list-page2").classList.remove("d-none");
		page1.classList.add("d-none");
		document.querySelector(".exh-reg-button-box-page2").classList.remove("d-none");
		document.querySelector("#second-circle").classList.remove("circle-off");
		document.querySelector("#first-circle").classList.add("circle-off");
	};

	secondNext.onclick = function(e) {
		e.preventDefault();
		document.querySelector(".reg-list-page2").classList.add("d-none");
		document.querySelector(".reg-list-page3").classList.remove("d-none");
		document.querySelector(".exh-reg-button-box-page2").classList.add("d-none");
		document.querySelector(".exh-reg-button-box-page3").classList.remove("d-none");
		document.querySelector("#second-circle").classList.add("circle-off");
		document.querySelector("#third-circle").classList.remove("circle-off");
	};


	btnReg.onclick = function(e) {

	};

	//===================뒤로가기버튼=========================================
	const firstBefore = document.querySelector("#btn-x");
	const secondBefore = document.querySelector("#btn-z");

	firstBefore.onclick = function(e) {
		e.preventDefault();
		page1.classList.remove("d-none");
		document.querySelector(".reg-list-page2").classList.add("d-none");
		document.querySelector(".reg-list-page").classList.remove("d-none");
		document.querySelector(".exh-reg-button-box-page2").classList.add("d-none");
		document.querySelector("#third-circle").classList.add("circle-off");
		document.querySelector("#second-circle").classList.add("circle-off");
		document.querySelector("#first-circle").classList.remove("circle-off");
	};
	secondBefore.onclick = function(e) {
		e.preventDefault();
		document.querySelector(".reg-list-page2").classList.remove("d-none");
		document.querySelector(".exh-reg-button-box-page2").classList.remove("d-none");
		document.querySelector(".exh-reg-button-box-page3").classList.add("d-none");
		document.querySelector(".reg-list-page3").classList.add("d-none");
		document.querySelector(".reg-list-page").classList.add("d-none");
		document.querySelector("#first-circle").classList.add("circle-off");
		document.querySelector("#second-circle").classList.remove("circle-off");
		document.querySelector("#third-circle").classList.add("circle-off");
	};
	//==========================이미지 첨부, 미리보기=================================================
	const imgInput = document.querySelector(".input-image-button1");
	const imgInput2 = document.querySelector(".input-image-button2");
	const imgInput3 = document.querySelector(".input-image-button3");
	const fileInput = document.querySelector("#input-image1");
	const fileInput2 = document.querySelector("#input-image2");
	const fileInput3 = document.querySelector("#input-image3");


	imgInput.onclick = function(e) {

		let event = new MouseEvent("click", {
			'view': window,
			'bubbles': true,
			'cancelable': true
		});

		fileInput.dispatchEvent(event);
	}

	fileInput.oninput = function(e) {
		let url = fileInput.files[0];
		let reader = new FileReader();
		reader.onload = (evt) => {
			imgInput.src = evt.target.result;
		};
		reader.readAsDataURL(url);
	}

	imgInput2.onclick = function(e) {

		let event = new MouseEvent("click", {
			'view': window,
			'bubbles': true,
			'cancelable': true
		});

		fileInput2.dispatchEvent(event);
	}

	fileInput2.oninput = function(e) {
		let url = fileInput2.files[0];
		let reader = new FileReader();
		reader.onload = (evt) => {
			imgInput2.src = evt.target.result;
		};
		reader.readAsDataURL(url);
	}



});