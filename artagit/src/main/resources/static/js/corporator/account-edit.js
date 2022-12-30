/**
 * 
 */
 window.addEventListener("load",function(){
	//	img 수정
	 const imgInput = document.querySelector(".img-input");
	 const fileInput = document.querySelector(".file-input");
	// toggle  
	//  var section = this.document.querySelector(".reg-list");
	//  var regListBox = section.querySelector(".reg-list-box");
	//  // var headers = section.querySelector(".active"); for문을 돌려서 remove할때
	//  var current =section.querySelector(".active");
 
	//  // toggle
	//  regListBox.onclick = function(e){
	// 	 var isHeader = e.target.nodeName != "H1"
	// 				 || e.target.classList.contains("accordion-header")
		 
	// 	 if(!isHeader)
	// 		 return;
 
	// 	 if(current !=null)
	// 		 current.classList.remove("active");
		 
	// 	 e.target.classList.add("active");
	// 	 current = e.target;
		 
	 
	// 	//console.log("test"); 

	//  };

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


 
