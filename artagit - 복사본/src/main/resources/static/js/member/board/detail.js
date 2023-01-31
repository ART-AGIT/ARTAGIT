window.addEventListener("load", function() {
	let postLikeBtn = document.querySelector(".post-like-btn")||{};
	const deleteBtn = document.querySelector(".delete-btn")||{};
	let el = document.querySelector(".board-id");
    const modal = document.getElementById("modal");

	
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
				
			})
            }
            else{
				e.target.classList.remove("icon-heart-red");
				let id = el.dataset.id;
				fetch(`/boardApi/like/${id}`,{
				method:"DELETE"
			})
			.then(response => response.json())
			.then(data => {
				 let result = data.resultObject;
				console.log(result);
			})
			}
		
	};
	
	 //////////// 삭제 버튼 눌렀을 때
    deleteBtn.onclick = function(e){
        e.preventDefault();
	
        if(e.target.classList.contains("delete-btn")){
            modal.classList.remove("d-none");
        }
            
	modal.onclick = function(e){
		
		let id = el.dataset.id;
		
		if(e.target.classList.contains("no"))
		modal.classList.add("d-none");
	}}
	
	
	});
	
	
