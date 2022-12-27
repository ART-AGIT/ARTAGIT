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
	};

	secondNext.onclick = function(e) {
		e.preventDefault();
		document.querySelector(".reg-list-page2").classList.add("d-none");
		document.querySelector(".reg-list-page3").classList.remove("d-none");
		document.querySelector(".exh-reg-button-box-page2").classList.add("d-none");
		document.querySelector(".exh-reg-button-box-page3").classList.remove("d-none");
		// document.querySelector(".reg-list-page").classList.add("d-none");
	};

	btnReg.onclick = function(e) {
		e.preventDefault();
		document.querySelector(".reg-list-page3").classList.add("d-none");
		
		document.querySelector(".reg-list-page").classList.remove("d-none");
		document.querySelector(".exh-reg-button-box-page3").classList.add("d-none");
		document.querySelector(".exh-reg-button-box-page").classList.remove("d-none");
		console.log(document.querySelector(".reg-list-page").classList.add("d-none"))
	};
	//============================================================
	const firstBefore = document.querySelector("#btn-x");
	const secondBefore = document.querySelector("#btn-z");

	firstBefore.onclick = function(e) {
		e.preventDefault();
		page1.classList.remove("d-none");
		document.querySelector(".reg-list-page2").classList.add("d-none");
		document.querySelector(".reg-list-page").classList.remove("d-none");
		document.querySelector(".exh-reg-button-box-page2").classList.add("d-none");
		//document.querySelector(".exh-reg-button-box-page").classList.remove("d-none");
		console.log("ch")

	};
	secondBefore.onclick = function(e) {
		e.preventDefault();
		document.querySelector(".reg-list-page2").classList.remove("d-none");
		document.querySelector(".exh-reg-button-box-page2").classList.remove("d-none");
		document.querySelector(".exh-reg-button-box-page3").classList.add("d-none");
		document.querySelector(".reg-list-page3").classList.add("d-none");
		document.querySelector(".reg-list-page").classList.add("d-none");
		// document.querySelector("#first-page-next").classList.add("d-none");
		console.log("ch")
	};


});