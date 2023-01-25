   window.addEventListener("load", function(){
   const boardbox = document.querySelector(".post-list-box");
   const itemMore = document.querySelector(".item-more");
	var page=1;
    itemMore.onclick = function(){
	
		page+=1;
		queryString = `?p=${page}`;

		fetch(`/member/mypage/board/api/list${queryString}`)
		.then((response)=>response.json())
		.then((list)=>{

			for(let board of list){
					console.log("length"+list.length)
				
	            if(list.length<6)
	            	itemMore.classList.add("d-none");
//                    if(list.length<=6)
//                    	itemMore.classList.add("d-none");
		
					//리뷰 없음
                    var template = `
                        <form class="board-box">
					        <section class="board-list">
					        <h1 class="board-title">
					         	<a href = "/member/board/${board.id}">${board.title}</a>
					        </h1>
					        <div>[${board.name}]</div>
					        
					        <div class="board-regdate">
					        ${year}/${month}/${day} ${hour}:${min}</div>
					        <div class="board-writer-info">
					                <img class="profile" src = "../image/${board.memImage}">
					            <div>${board.nickname}</div>
					        </div>
					        
					        <div class="board-post-info">
					            
					            <div class="view">
					                <div class="icon icon-view icon-size">조회수 아이콘</div>
					                <div>${board.hit}</div>
					            </div>
					            <div class="like-up">
					                <div class="icon icon-like-up icon-size">좋아요 아이콘</div>
					                <div>${board.hearts}</div>
					            </div>
					            <div class="comment">
					                <div class="icon icon-comment icon-size">댓글 아이콘</div>
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
                    
                    }
                    //리뷰 있음
                 
		            	
                  
				let el = new DOMParser().parseFromString(template, "text/html").body.firstElementChild;
				//body를 지우면 body안쪽만 나온다. firstelement를 만들겠다.
				boardbox.append(el); //6개의 객체를 하나하나 넣어준다.
				
                                
             
                    
					}
                    
                    
					
			
			);
	}

})