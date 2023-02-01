window.addEventListener("load",function(){
	//	member img넣기
	 const imgInput = document.querySelector(".img-input");
	 const fileInput = document.querySelector(".file-input");
	console.log(fileInput)
	//  img 수정
	 imgInput.onclick = function(e){
		 e.preventDefault();
		 let event = new MouseEvent("click",{
			'view':window,
         	'bubbles':true,
         	'cancelable':true
			 
		 })
		 fileInput.dispatchEvent(event);
		 
	 }
	 
	 fileInput.oninput = function(e){
		 
		 let url = fileInput.files[0];
		 let reader = new FileReader();
		 reader.onload = (evt) =>{
			 imgInput.src = evt.target.result;
		 };
		 reader.readAsDataURL(url)
	 }
	 
 });


 
