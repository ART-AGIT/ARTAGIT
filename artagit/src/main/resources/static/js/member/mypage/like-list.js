window.addEventListener("load",function(){

const likeListSection = this.document.querySelector(".like-list-section");

// 하트 누르면 삭제되는 로직 ================================================================
//    likeListSection.onclick = function(e){
      
//         if(!e.target.classList.contains("exh-like"))
//            return;
       
//         // 좋아요 전시 삭제
//         e.preventDefault();
//         if(e.target.classList.contains("exh-like") && e.target.classList.contains("icon-heart-red")){
         	
// //        modal.style.display="flex";
//         	e.target.classList.remove("icon-heart-red");
          
       
          
//         	let el = null;

//        //    i == el , i < 10 , I++ 2,3,4
//        //    section 
//         	for(el=e.target; el.tagName!="SECTION"; el=el.parentElement);

       
// 				let id = el.dataset.id;
// 				fetch(`/api/like/${id}`,{
// 				method:"DELETE"
// 				})
// 				.then(response => response.json())
// 				.then(data => {
// 				let result = data.resultObject;
// 				console.log("result"+result);
// 				if(result==1){
// 				console.log("삭제완료");  
// 				el.remove();  
// 				}
// 			})
//        }
//    }
// });
// 하트 누르면 삭제되는 로직 끝================================================================

const delBtn = document.querySelector(".del-btn");
const canBtn = document.querySelector(".cancel-btn");
let exhId = document.querySelector(".exh-id");
let input = document.querySelector(".find-id");
const modal =document.getElementById("modal");
const modalDel = document.querySelector(".madal-delete");
const btnWrap = this.document.querySelector(".button-wrap");
let el = null;
let id = 0;
	//    모달~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// 취소, 삭제 누르면 모달 사라짐
	btnWrap.onclick = function(e){

		modal.style.display="none";
	}    


	// 하트 클릭시
	likeListSection.onclick = function(e){
		// if(!e.target.classList.contains("exh-like"))
		// 	return; 

		e.preventDefault();
		
		if(e.target.classList.contains("exh-like") && e.target.classList.contains("icon-heart-red")){
			modal.style.display="flex";

			// 삭제를 누르면 사라져야 하는 값
			//e.target.classList.remove("icon-heart-red");
			for(el=e.target; el.tagName!="SECTION"; el=el.parentElement);
			id = el.dataset.id;

			console.log("id값을 보자~~~~~~"+id)
		}

		console.log(id);
		// let modalCancel = document.querySelector("....");

		// modalCancel.addEventListener("click", f(el))

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
 				}
 			})

		}



	}

	let f = function(){

	}


});








