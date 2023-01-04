window.addEventListener("load", function() {
	let firstNext = document.querySelector(".btn-next");
	let secondNext = document.querySelector("#btn-y");
	let btnReg = document.querySelector(".exh-reg-button-box-page3");
	let page1 = document.querySelector(".page1");

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
		e.preventDefault();
		
		//location.href = 'http://localhost:8080/corporator/mypage/exh-list.html';


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

	imgInput3.onclick = function(e) {

		let event = new MouseEvent("click", {
			'view': window,
			'bubbles': true,
			'cancelable': true
		});

		fileInput3.dispatchEvent(event);
	}

	fileInput3.oninput = function(e) {
		let url = fileInput3.files[0];
		let reader = new FileReader();
		reader.onload = (evt) => {
			imgInput3.src = evt.target.result;
		};
		reader.readAsDataURL(url);
	}

});