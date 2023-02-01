window.addEventListener("load", function() {
	let postLikeBtn = document.querySelector(".post-like-btn")||{};
	const deleteBtn = document.querySelector(".delete-btn")||{};
	let el = document.querySelector(".board-id");
    const modal = document.getElementById("modal");
    let report = document.querySelector(".post-report")
    let popup = document.querySelector(".popup-over")
    let content = document.querySelector(".report-form")
	let com = document.getElementById("modal-popup");
	let type = document.querySelector(".type-post")
	
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
	
	
	
	report.onclick = function(e){
		 e.preventDefault();
            popup.classList.remove("d-none");
              type.innerHTML = "게시글"
            
            
           
        }
        
		popup.onclick = function(e){
		if(e.target.classList.contains("no"))
		popup.classList.add("d-none");
		
		if(e.target.classList.contains("yes")){
		postId = el.dataset.id
            
		let box = document.querySelector(".box-select")
//		let memId = form.querySelector(".btn-black").dataset.id
		
		let formData = new FormData();
		formData.append("postId",postId)
//		formData.append("memId",memId)
		formData.append("content",content.value)
		formData.append("roleId",box.value)
		
		fetch(`/api/reportBoard`, { method: "post", body: formData})
					.then(response => response.json())
					.then(data => {
						console.log(data)
						popup.classList.add("d-none");
						com.classList.remove("d-none")
						
					})
							content.value = "";
			}
	
		}
	
	});
	
	
