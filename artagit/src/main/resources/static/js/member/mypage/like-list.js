window.addEventListener("load",function(){

const likeListSection = this.document.querySelector(".like-list-section");
const MyLikeList = document.querySelector(".my-like-list");

const delBtn = document.querySelector(".del-btn");
const canBtn = document.querySelector(".cancel-btn");
let exhId = document.querySelector(".exh-id");
let input = document.querySelector(".find-id");
const modal =document.getElementById("modal");
const modalDel = document.querySelector(".madal-delete");
const btnWrap = this.document.querySelector(".button-wrap");
let el = null;
let id = 0;
let page=1;
//let i = page*6-1;

// 하트 누르면 삭제되는 로직 끝================================================================
	//    모달~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// 취소, 삭제 누르면 모달 사라짐
	btnWrap.onclick = function(e){

		modal.style.display="none";
	}    


	// 하트 클릭시
//	likeListSection.onclick = function(e){
		MyLikeList.onclick = function(e){
		if(e.target.classList.contains("exh-like") && e.target.classList.contains("icon-heart-red")){
			modal.style.display="flex";

			// 삭제를 누르면 사라져야 하는 값
			//e.target.classList.remove("icon-heart-red");
			for(el=e.target; el.tagName!="SECTION"; el=el.parentElement);
			id = el.dataset.id;

			console.log("id값을 보자~~~~~~"+id)
		}

		console.log(id);

		if(e.target.classList.contains("del-btn")){
			console.log("삭제!!"+id);
			fetch(`/api/like/${id}`,{
 				method:"DELETE"
 				})
 				.then(response => response.json())
 				.then(data => {
	 				let result = data.resultObject;
	 				console.log("result"+result);
	 				if(result==1){
		 				console.log("삭제완료");  
		 				el.remove(); 
		 				
		 				// 삭제 시 추가할 전시1개
		 				let likeList = data.likeList;
		 				console.log(likeList);
//							oneItem(likeList);
//		 				if(e.target.classList.contains("item-more"))
//		 				{
//							  
//						 }// if(item-more)
		 				
	 				}
 			})

		}

	} // 하트 클릭 시 끝
	
//	let i = page*6-1;
//	function oneItem(likeList) {
//		console.log("한 개만 더 보자~~~~~~~~~~~");
//			
//				console.log("길이~~~~~~"+likeList.length);
//
//	          	if(likeList.length>6){	
//	            	var template = `
//				        	<section class="like-list" data-id="${likeList[i].id}">
//					            <form action="">
//					                <div class="exh-img-box">
//					                    <a href="/exhibition/${likeList[i].id}"><img src="/image/poster/${likeList[i].poster}" class="exh-img"alt=""></a>
//					                </div>
//					               
//				                    <div class="icon icon-heart icon-heart-red exh-like"></div>
//				                    <div class="text exh-title">${likeList[i].name}</div>
//				                    <div class="text exh-place">${likeList[i].museumName}</div>
//				                    <div class="text exh-date">${likeList[i].startDate} ~ ${likeList[i].endDate}</div>
//					            </form>
//					        </section>
//					        
////					        <button class="text item-more" >
////								<div>더보기</div>
////							</button>  
//	            	
//	        	            	
//	            	`;	
//	            	
//	            	let el = new DOMParser()
//                             .parseFromString(template, "text/html")
//                             .body
//                             .firstElementChild;
//                                
//                    var list = document.querySelector(".like-list-section");
//                    list.append(el);
//	            	
//	            }// if	
//
//	}
	
	
	
	//  좋아요 전시 보여주기 (더보기 기능)
    const itemMore = document.querySelector(".item-more");
//	page=1;
    itemMore.onclick = function(){
		console.log("더보자************************8");
		page+=1;
		console.log("더보기"+page);
		
		queryString = `?p=${page}`;

		fetch(`/member/mypage/api/like-list${queryString}`)
		.then((response)=>response.json())
		.then((lists)=>{
			for(list of lists){
				console.log(Object.keys(lists).length);
	            if(Object.keys(lists).length<6)
	            	itemMore.classList.add("d-none");
	            	
	            	var template = `
        	<section class="like-list" data-id="${list.id}">
	            <form action="">
	                <div class="exh-img-box">
	                    <a href="/exhibition/${list.id}"><img src="/image/poster/${list.poster}" class="exh-img"alt=""></a>
	                </div>
	               
                    <div class="icon icon-heart icon-heart-red exh-like"></div>
                    <div class="text exh-title">${list.name}</div>
                    <div class="text exh-place">${list.museumName}</div>
                    <div class="text exh-date">${list.startDate} ~ ${list.endDate}</div>
	            </form>
	        </section>
	     
			<button class="text item-more" >
				<div>더보기</div>
			</button>  
	            	
	            	`;	
	            	
	            	let el = new DOMParser()
                             .parseFromString(template, "text/html")
                             .body
                             .firstElementChild;
                                
                    var list = document.querySelector(".like-list-section");
                    list.append(el);
	            	
	            	
	        }
	    }) // .then
		
	
	
	}// itemMore
	

});
