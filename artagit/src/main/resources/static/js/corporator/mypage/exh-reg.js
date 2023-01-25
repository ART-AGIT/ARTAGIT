window.addEventListener("load", function() {
	// 페이지 전환(위저드)
	const firstNext = document.querySelector(".btn-next");
	const secondNext = document.querySelector("#btn-y");
	const btnReg = document.querySelector(".exh-reg-button-box-page3");
	const page1 = document.querySelector(".page1");
	// 모달창
	const register = document.querySelector(".btn-register");
	const registercancelBtn = this.document.querySelector(".register-cancel-btn");
	const registermodal = this.document.querySelector(".modalregister");

	//등록버튼 눌렀을 때 
	register.onclick = function(e) {
		e.preventDefault();
		registermodal.style.display = "flex";
	};
	//취소버튼 눌렀을 때
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
		window.scrollTo(0, 0);
	};

	secondNext.onclick = function(e) {
		e.preventDefault();
		document.querySelector(".reg-list-page2").classList.add("d-none");
		document.querySelector(".reg-list-page3").classList.remove("d-none");
		document.querySelector(".exh-reg-button-box-page2").classList.add("d-none");
		document.querySelector(".exh-reg-button-box-page3").classList.remove("d-none");
		document.querySelector("#second-circle").classList.add("circle-off");
		document.querySelector("#third-circle").classList.remove("circle-off");
		window.scrollTo(0, 0);
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
		window.scrollTo(0, 0);
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
		window.scrollTo(0, 0);
	};
	//==========================이미지 첨부, 미리보기=================================================
	const imgInput = document.querySelector(".input-image-button1");
	const imgInput2 = document.querySelector(".input-image-button2");

	const fileInput = document.querySelector("#input-image1");
	const fileInput2 = document.querySelector("#input-image2");


	//let inputImageFile = document.querySelector(".input-image-button");
	//이미지 여러개넣는 배열
	const inputFileList = new Array();


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

		console.log("클릭이벤트먹힘");
		let files = e.target.files;
		let filesArr = Array.prototype.slice.call(files);

		filesArr.forEach(function(f) {
			inputFileList.push(f);    // 이미지 파일을 배열에 담는다.
		});
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
		console.log("이미지2클릭이벤트먹힘");
		let files = e.target.files;
		let filesArr = Array.prototype.splice.call(files);

	
			inputFileList.add(filesArr);    // 이미지 파일을 배열에 담는다.
	
		console.log(inputFileList);
	}






	//공통이미지 버튼
	//const inputImageFile = document.querySelector(".imageRegBtn");

	/*inputImageFile.onclick = function(e) {
		console.log("이미지버튼눌렀음");
		let files = e.target.files;
		let filesArr = Array.prototype.slice.call(files);
		e.preventDefault();

		filesArr.forEach(function(f) {
			inputFileList.push(f);    // 이미지 파일을 배열에 담는다.
		});

		let formData = new FormData($('#uploadForm')[0]);  // 폼 객체

		for (let i = 0; i < inputFileList.length; i++) {
			formData.append("images", inputFileList[i]);  // 배열에서 이미지들을 꺼내 폼 객체에 담는다.
		}

		$.ajax({
			type: 'post'
			, enctype: "multipart/form-data"  // 업로드를 위한 필수 파라미터
			, url: '/upload_image'
			, data: formData
			, processData: false   // 업로드를 위한 필수 파라미터
			, contentType: false   // 업로드를 위한 필수 파라미터
			, success: function(data) {
				alert(data);
			}
			, error: function(e) {
				alert("error:" + e);
			}
		});


	}
*/

});