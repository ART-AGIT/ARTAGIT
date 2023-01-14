window.addEventListener("load", function(){
    const imgInput = document.querySelector(".input-image-button1")
	const fileInput = document.querySelector(".input-image1");
	var toolbox = document.querySelector(".toolbox");

	toolbox.onclick = function(e){
		e.preventDefault();
		let target = e.target;
		if(target.classList.contains("btn-bold")){
			const selObj = window.getSelection();
			let template = `<span style = "font-weight:bold">${selObj.toString()}</span>`;

			const range = selObj.getRangeAt(0);

			let frag = document.createDocumentFragment();
			let el = document.querySelector("div");
			el.innerHTML = template;
			frag.appendChild(el.firstChild);
			selObj.deleteFromDocument();
			range.insertNode(frag);
		}
	}

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