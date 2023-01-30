window.addEventListener("load", function(){
    const imgInput = this.document.querySelectorAll(".input-image-button1")
	const fileInput = this.document.querySelectorAll(".input-image1");
	var toolbox = this.document.querySelector(".toolbox");
	let title = this.document.querySelector(".input-title");
	let content = this.document.querySelector(".content");
	const del =this.document.querySelectorAll(".icon-trash");
	



	
	
	
	

		imgInput[0].onclick=function(e){
			
			let event = new MouseEvent("click", {
				'view': window,
				'bubble': true,
						'cancelable': true
				});
		
				fileInput[0].dispatchEvent(event);
		}
		
		fileInput[0].oninput = function() {
			let url = fileInput[0].files[0];
			let reader = new FileReader();
			reader.onload = (evt) => {
				imgInput[0].src = evt.target.result;
			};
			reader.readAsDataURL(url);
			del[0].classList.remove("d-none");
		}				
	
		imgInput[1].onclick=function(){
			let event = new MouseEvent("click", {
				'view': window,
				'bubble': true,
				'cancelable': true
			});
	
			fileInput[1].dispatchEvent(event);
		}
		
		fileInput[1].oninput = function() {
			let url = fileInput[1].files[0];
			let reader = new FileReader();
			reader.onload = (evt) => {
				imgInput[1].src = evt.target.result;
			};
			reader.readAsDataURL(url);
		}
		
		
		
		imgInput[2].onclick=function(){
			let event = new MouseEvent("click", {
				'view': window,
				'bubble': true,
				'cancelable': true
			});
	
			fileInput[2].dispatchEvent(event);
		}
		
		fileInput[2].oninput = function() {
			let url = fileInput[2].files[0];
			let reader = new FileReader();
			reader.onload = (evt) => {
				imgInput[2].src = evt.target.result;
			};
			reader.readAsDataURL(url);
		}
		
		imgInput[3].onclick=function(){
			let event = new MouseEvent("click", {
				'view': window,
				'bubble': true,
				'cancelable': true
			});
	
			fileInput[3].dispatchEvent(event);
		}
		
		fileInput[3].oninput = function() {
			let url = fileInput[3].files[0];
			let reader = new FileReader();
			reader.onload = (evt) => {
				imgInput[3].src = evt.target.result;
			};
			reader.readAsDataURL(url);
		}
		
		
			
		
		

		
	
	})