window.addEventListener("load", function(){
    const imgInput = this.document.querySelectorAll(".input-image-button1")
	const fileInput = this.document.querySelectorAll(".input-image1");
	var toolbox = this.document.querySelector(".toolbox");
	let title = this.document.querySelector(".input-title");
	let content = this.document.querySelector(".content");
	const del =this.document.querySelectorAll(".icon-trash");
	



	
//		=======================================================
// 반복되는 코드 수정 필요 ..? 

		imgInput[0].onclick=function(){
			
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
			console.log(url);
			del[0].classList.remove("d-none");
			
			del[0].onclick=function(){
				console.log("hh")
				fileInput[0].src="";
				
				var template=`
				<div class="reg-list-input-box-image">
		       		<div class=" icon icon-trash d-none"></div>
	            	<img src="../../image/camera.svg" class="input-image-button input-image-button1 input-image">
	            	<input name="img1"  id="img1" type="file" class="input-image1 d-none">
            	</div>
				`
				var inputBox = document.querySelector(".reg-list-input-box");
				inputBox.insertAdjacentHTML("beforebegin", template)
				
				
				var imgInputTemp = document.querySelector(".input-image-button1")
				var fileInputTemp = document.querySelector(".input-image1");
				
				
				
				imgInputTemp.onclick=function(){
			
					let event = new MouseEvent("click", {
						'view': window,
						'bubble': true,
								'cancelable': true
						});
				
						fileInputTemp.dispatchEvent(event);
				}
		
				fileInputTemp.oninput = function() {
					let url = fileInputTemp.files[0];
					let reader = new FileReader();
					reader.onload = (evt) => {
						imgInputTemp.src = evt.target.result;
					};
					reader.readAsDataURL(url);
					console.log(url);
					var trash = document.querySelector(".icon-trash");
					trash.classList.remove("d-none");
				}
			}
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
			del[1].classList.remove("d-none");
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
			del[2].classList.remove("d-none");
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
			del[3].classList.remove("d-none");
		}
		
//		=======================================================
			
		del[0].addEventListener("click",()=>{temp(0)})	;
		del[1].addEventListener("click",()=>{temp(1)})	;
		del[2].addEventListener("click",()=>{temp(2)})	;
		del[3].addEventListener("click",()=>{temp(3)})	;
		


		var temp = function(i){
//			console.log(i);
			
//			imgInput[i].remove();
			fileInput[i].innerHTML="";
//			
//			var template =
//			`
//			<div class="reg-list-input-box-image">
//		       	<div class=" icon icon-trash d-none"></div>
//	            <img src="../../image/camera.svg" class="input-image-button input-image-button1 input-image">
//	            <input name="img1"  id="img1" type="file" class="input-image1 d-none">
//            </div>
//			`
//			var inputBox = document.querySelector(".reg-list-input-box");
//			inputBox.insertAdjacentHTML("beforebegin", template)


		}

		
});