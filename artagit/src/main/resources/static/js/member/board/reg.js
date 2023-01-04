window.addEventListener("load", function(){

    let section = this.document.querySelector(".post-option");
    let box = section.querySelector(".select-box");
    var options = box.querySelectorAll(".option");
    const label = box.querySelector(".label");
    const imgInput = document.querySelector(".input-image-button1")
	const fileInput = document.querySelector(".input-image1");


	box.onclick = function(e){
		e.preventDefault();
		
		current=document.querySelector(".active");
		const el = e.target;
	console.log(e.target);
		if(el==label)
			box.classList.add('active');
			console.log(e.target.value);
	};
	
		options.forEach(function(option){
	  	option.addEventListener('click', function(e){
			  e.preventDefault();
			   label.innerHTML = option.textContent;
	  		   box.classList.remove("active");
		})
		
		
	});
	
	
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

	
	})