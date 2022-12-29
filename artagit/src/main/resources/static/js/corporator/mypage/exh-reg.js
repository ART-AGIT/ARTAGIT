window.addEventListener("load", function() {
	let firstNext = document.querySelector(".btn-next");
	let secondNext = document.querySelector("#btn-y");
	let btnReg = document.querySelector(".exh-reg-button-box-page3");
	let page1 = document.querySelector(".page1");
	//	let page2 = document.querySelector(".page2");
	//	let page3 = document.querySelector(".page3");

	//	const btnPage = document.querySelector(".exh-reg-list a");
	// 	const btnBeforeP2 =	document.querySelector(".btn-before x");
	// 	const btnNextP2 =	document.querySelector(".btn-next y");
	// 	const btnBeforeP3 = document.querySelector(".btn-before z");


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
		// document.querySelector(".reg-list-page").classList.add("d-none");
		document.querySelector("#second-circle").classList.add("circle-off");
		document.querySelector("#third-circle").classList.remove("circle-off");
	};

	btnReg.onclick = function(e) {
		e.preventDefault();
		document.querySelector(".reg-list-page3").classList.add("d-none");

		document.querySelector(".reg-list-page").classList.remove("d-none");
		document.querySelector(".exh-reg-button-box-page3").classList.add("d-none");
		//document.querySelector(".exh-reg-button-box-page").classList.remove("d-none");
		//console.log(document.querySelector(".reg-list-page").classList.add("d-none"))
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
		//document.querySelector(".exh-reg-button-box-page").classList.remove("d-none");
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
		// document.querySelector("#first-page-next").classList.add("d-none");
		document.querySelector("#first-circle").classList.add("circle-off");
		document.querySelector("#second-circle").classList.remove("circle-off");
		document.querySelector("#third-circle").classList.add("circle-off");
	};
	//==========================이미지 첨부, 미리보기=================================================
	const imgInput = document.querySelector(".input-image-button1");
	const fileInput = document.querySelector("#input-image1");
	const fileInputDe = document.querySelector("#input-image2");
	const fileInputDe2 = document.querySelector("#input-image3");
	

	imgInput.onclick = function(e) {
		
			
			let event = new MouseEvent("click", {
				'view': window,
				'bubbles': true,
				'cancelable': true
			});
			
			fileInput.dispatchEvent(event);
		
		console.log(e.target);
	}

	fileInput.oninput = function(e) {
		let url = fileInput.files[0];
		let reader = new FileReader();
		reader.onload = (evt) => {
		imgInput.src = evt.target.result;
		};
		reader.readAsDataURL(url);
			
	}
	












});