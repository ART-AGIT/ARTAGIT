window.addEventListener("load", function(e){
	const cNumBox = document.querySelector(".client-number");
	const cInfoBox = document.querySelector(".client-info");
	// const info
	const date = document.querySelector(".choice-date");
	const incOrdec = document.querySelector(".plus");

	date.onclick = function(e){
		console.log("hihihihihihi");
		cNumBox.classList.remove("d-none");
	}

	incOrdec.onclick = function(e){
		e.preventDefault();
		cInfoBox.classList.remove("d-none");
	}

	
});