window.addEventListener("load", function(){
    const imgInput = document.querySelectorAll(".input-image-button1")
	const fileInput = document.querySelectorAll(".input-image1");
	var toolbox = document.querySelector(".toolbox");
	let title = document.querySelector(".input-title");
	let content = document.querySelector(".input-content");
	
	const del =document.querySelectorAll(".icon-trash");





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
		
		
			
		
		
//		del[0].onclick=function(){
//			var box = document.querySelector(".input-box-container");
////			imgInput[0].remove();
////			fileInput[0].remove();
//			imgInput[0].src = "";
////			fileInput[0].style.display="d-none";
////			reader.readAsDataURL("");
// 			var template=`
// 				<div class="reg-list-input-box-image">     
//					<div class=" icon icon-trash d-none"></div>  
//                    <img src="../../image/camera.svg" class="input-image-button input-image-button1 input-image">
//                    <input name="img1" type="file" class="input-image1 d-none">
//		        </div>
// 			`;
// 			
//// 			fileInput[0].insertAdjacentElement("afterend",template);
// 			
// 			
//			console.log("dd")
//		}
		
		
		


	
	})