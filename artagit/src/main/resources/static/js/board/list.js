window.addEventListener("load", function() {
	const ul = document.querySelector(".board-category-l");
	const boardbox = document.querySelector(".board-box");
	let currentLi = document.querySelector(".board-category-box ul li.board-selected");
	
	ul.onclick = function(e) {
		e.preventDefault();
		console.log(e.target);
		const el = e.target;
		
		if (el.tagName != "LI" && el.tagName != "SPAN")
			return;

		let li = el;
		if (el.tagName == "SPAN")
			li = el.parentElement;

		li.classList.add("board-selected");

		if (currentLi != null && currentLi != e.target)
			currentLi.classList.remove("board-selected");

		currentLi = li;
		console.log(currentLi);

	
	




	let queryString = `?c=${currentLi.dataset.id}`
		
	console.log(queryString);
	fetch(
		`/boardApi/boards${queryString}`)
		.then((response) => 
			response.json())
		.then((list) => {
			boardbox.innerHTML="";
		for (let board of list) {
			
			let template = ` 
		<form class="board-box">
        <section class="board-list">
        <h1 class="board-title">
         	<a href = "/member/board/${board.id}">${board.title}</a>
        </h1>
        <div>[${board.name}]</div>
        <div class="board-regdate">${board.regDate}</div>
        <div class="board-writer-info">
                <img class="profile" src = "../image/${board.memImage}">
            <div>${board.nickname}</div>
        </div>
        
        <div class="board-post-info">
            
            <div class="view">
                <div class="icon icon-view">조회수 아이콘</div>
                <div>${board.hit}</div>
            </div>
            <div class="like-up">
                <div class="icon icon-like-up">좋아요 아이콘</div>
                <div>${board.hearts}</div>
            </div>
            <div class="comment">
                <div class="icon icon-comment">댓글 아이콘</div>
                <div>${board.commentTotal}</div>
            </div>
        </div>
        <div class="board-post-img-box">
        <a href="/member/board/${board.id}">
           <img onerror="this.style.display='none'"  src="/image/${board.image}" class="post-img">
           </a>
        </div>
          </section>
             <div class="writing-img-box">
			        <a href = "../member/board/reg"><img src = "../image/writing-img.png"></img></a>
	    </div>
    </form>
    
			 

    `;
				
			
			
			
				let el = new DOMParser().parseFromString(template, "text/html").body.firstElementChild;
				//body를 지우면 body안쪽만 나온다. firstelement를 만들겠다.
				boardbox.append(el); //6개의 객체를 하나하나 넣어준다.
				
//				const li = document.querySelector(".");
//				
//				li.onclick = function(e) {let template=`
//					<div class="writing-img-box">
//       		 			<a href = "./reg"><img src = "../image/writing-img.png"></img></a>
//					</div>`
				
			
		};})
		}})

