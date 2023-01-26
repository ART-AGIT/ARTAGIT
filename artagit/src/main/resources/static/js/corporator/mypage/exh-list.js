window.addEventListener("load", function(){
//  예매내역리스트 보여주기 (더보기 기능)
    const itemMore = document.querySelector(".item-more");
	var page=1;
	let today = new Date(); 
	var state = null;
    itemMore.onclick = function(){
		page+=1;

		queryString = `?p=${page}`;

		fetch(`/corpApi/exh/list${queryString}`)
		.then((response)=>response.json())
		.then((lists)=>{
			for(list of lists){
				console.log(Object.keys(lists).length);
	            if(Object.keys(lists).length<6)
	            	itemMore.classList.add("d-none");
	            
//                    if(list.length<=6)
//                    	itemMore.classList.add("d-none")
					//리뷰 없음
					let date = new Date(list.endDate);
					
					if(date<today){
						state = "전시종료"
					}
					else if(date>=today)
						state = "전시중"
						
                    var template = `
                     
		       
                      
		        <div class="exh-list">
		            <form action="">
		
		                <div class="exh-img-box">
		                    <a href="/corp/exh/${list.id}" ><img class="exh-img" src="/image/poster/${list.poster}" alt=""></a>
		                </div>
		                <div class="text exh-state exh-ing">${state}</div>
		                <div class="text exh-title">${list.name}</div>
		                <div class="text exh-author">author. ${list.artist}</div>
		                <div class="text exh-date" >${list.startDate} ~ ${list.endDate}</div>
		
			            </form>
			        </div>
			    	 <button class="text item-more"">
		        	<div>더보기</div>
		        </button>
                    	`;
                    
                    
                    
                    //리뷰 있음
                 
		            	
                    let el = new DOMParser()
                             .parseFromString(template, "text/html")
                             .body
                             .firstElementChild;
                                
                    var list = document.querySelector(".exh-list-tong");
                    list.append(el);
                 } });}})


