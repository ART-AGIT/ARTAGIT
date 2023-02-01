window.addEventListener("load", function(){
	const postManage = document.querySelector(".post-manage");
	const miniMenuList = document.querySelector(".mini-menu-list");
	const miniMenus = document.querySelectorAll(".mini-menu");
	let currentLi = miniMenuList.querySelector(".selected");
	
	postManage.onclick = function(e){
		//e.preventDefault();
		const el = e.target;
		currentLi = miniMenuList.querySelector(".selected");
		
		if (el.tagName != "LI" && el.tagName != "A")
			return;

		let li = el;
		if (el.tagName == "A")
			li = el.parentElement;
		
		if(li.classList.contains("post-manage")){
			miniMenuList.firstElementChild.classList.add("selected")
		}
		
		miniMenuList.classList.add("show")
		li.classList.add("selected")
		
		if (currentLi != null)
			currentLi.classList.remove("selected");

		currentLi = li;
		
	}
    
});
