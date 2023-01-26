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
				
	            if(list.length<6)
	            	itemMore.classList.add("d-none");
	            	else{

					let date = new Date(list.endDate);
					
					if(date<today){
						state="<p style='color:#545454;'>전시종료</p>";
					}
					else if(date>=today)
						state="<p style='color:#FF5171;'>전시중</p>";
						
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
                    
                    }
                   
                    let el = new DOMParser()
                             .parseFromString(template, "text/html")
                             .body
                             .firstElementChild;
                                
                    var list = document.querySelector(".exh-list-tong");
                    list.append(el);
                 }  });}})


