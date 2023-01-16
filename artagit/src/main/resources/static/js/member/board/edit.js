window.addEventListener("load", function(){
  

	imgInput.onclick = function(e) {

		let event = new MouseEvent("click", {
			'view': window,
			'bubble': true,
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

	
	})