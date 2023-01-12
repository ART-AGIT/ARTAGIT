window.addEventListener("load", function() {
	postLikeBtn = document.querySelector(".post-like-btn")
	deleteBtn = document.querySelector(".delete-btn");
	el = document.querySelector(".board-id");

	postLikeBtn.onclick = function(e){
		e.preventDefault();
		console.log("클릭");
		if(!e.target.classList.contains("icon-heart-red")){
		e.target.classList.add("icon-heart-red")
		let id = el.dataset.id;
		console.log(id);
		fetch(`/boardApi/like/${id}`,{
				method:"PUT"
			})
			.then(response => response.json())
			.then(data => {
				 let result = data.resultObject;
				console.log(result);
			})
            }
            else{
				e.target.classList.remove("icon-heart-red");
				let id = el.dataset.id;
				console.log(id);
			}
		
	};
	
	
	
	})
