window.addEventListener("load", function() {
	let current = document.querySelector(".exh-reg-list-selected");
	const btnNextP1 = document.querySelector(".btn-next");
 	const btnBeforeP2 =	document.querySelector(".btn-before x");
 	const btnNextP2 =	document.querySelector(".btn-next y");
 	const btnBeforeP3 = document.querySelector(".btn-before z");
 	const reg = document.querySelector(".exh-reg-button-box button");
 	const reg2 = document.querySelector(".reg-2")
 	let currentLi = document.querySelector(".exh-reg-list .d-none");


	 btnNextP1.onclick = function(e){
		 e.preventDefault();
	
		 const nextP1 = e.target;
		 	
		if (nextP1.tagName != "A")
			return;
	
		current.classList.add("d-none");
		current = current.nextElementSibling;
		current.classList.remove("d-none");
		
		
		}
	
 btnBeforeP2.onclick = function(e){
	 e.preventDefault();
	 const beforeP2 = e.target;
 
 if (beforeP2.tagName != "A")
		return;
		
 	if (beforeP2.tagName == "A")

	a.classList.add("d-none");
	currentLi.classList.remove("d-none");
	}
 
 
 btnNextP2.onclick = function(e){
	 e.preventDefault();
	 const nextP2 = e.target;
 }
 btnBeforeP3.onclick = function(e){
	 e.preventDefault();
	 const beforeP3 = e.target;
 }
  reg.onclick = function(e){
	 e.preventDefault();
	 const nextP3 = e.target;
 }
	
	});