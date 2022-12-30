window.addEventListener("load", function(){

    let section = this.document.querySelector(".post-option");
    let box = section.querySelector(".select-box");
    var options = box.querySelectorAll(".option");
    const label = box.querySelector(".label");

	box.onclick = function(e){
		e.preventDefault();
		current=document.querySelector(".active");
		const el = e.target;
		console.log(el);
		if(el==label)
			box.classList.add('active');

		
	};
	
	


		options.forEach(function(option){
	  	option.addEventListener('click', function(e){
			  e.preventDefault();
			   label.innerHTML = option.textContent;
	  		   box.classList.remove("active");
		})
	})
	})