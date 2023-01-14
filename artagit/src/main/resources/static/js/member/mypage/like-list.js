window.addEventListener("load",function(){

const likeListSection = this.document.querySelector(".like-list-section");
// const delBtn = document.querySelector(".del-btn");
// const canBtn = document.querySelector(".cancel-btn");

// 	delBtn.onclick = function(e){
// //		e.preventDefault();
// 		e.target.classList.remove("icon-heart-red");
		
		
// 	}
	
	


//    likeListSection.onclick = function(e){
//       
//        if(!e.target.classList.contains("exh-like"))
//            return;
//        
//        // 좋아요 전시 삭제
//        e.preventDefault();
//        if(e.target.classList.contains("exh-like") && e.target.classList.contains("icon-heart-red")){
//          	
////        modal.style.display="flex";
//          e.target.classList.remove("icon-heart-red");
//           
//        
//           
//           let el = null;
//
//        //    i == el , i < 10 , I++ 2,3,4
//        //    section 
//           for(el=e.target; el.tagName!="SECTION"; el=el.parentElement);
//
//        
//            let id = el.dataset.id;
//            fetch(`/api/like/${id}`,{
//                method:"DELETE"
//            })
//            .then(response => response.json())
//            .then(data => {
//                let result = data.resultObject;
//                console.log("result"+result);
//                if(result==1){
//                console.log("삭제완료");  
//                el.remove();  
//                }
//            })
//
//        
//        }
//
//    }
    
const delBtn = document.querySelector(".del-btn");
const canBtn = document.querySelector(".cancel-btn");
let exhId = document.querySelector(".exh-id");
let exhId1 = document.querySelector(".find-id");
const modal =document.getElementById("modal");

   // 하트 클릭시
    likeListSection.onclick = function(e){
       if(!e.target.classList.contains("exh-like"))
           return;
        
        // 좋아요 전시 삭제
       e.preventDefault();
       if(e.target.classList.contains("exh-like") && e.target.classList.contains("icon-heart-red")){
	        modal.style.display="flex";
	        var el = exhId1.dataset.id;
	      	// let el = null;
	
	        // for(el=e.target; el.tagName!="SECTION"; el=el.parentElement);	    
	        // let id = el.dataset.id;
	        // console.log("하트 클릭시!!"+id);
       	}
       }
    
//    모달~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // 취소
//	canBtn.onclick = function(e){
//		modal.style.display="none";
//	}
	
	modal.onclick = function(e){
		e.preventDefault();
		console.log(e.target);
		if(e.target.classList.contains("cancel-btn")){
			let ee = e.target.parentElement;
			let ee2 = ee.parentElement; // modal-window
			let ee3 = ee2.parentElement; // modal-overlay
			let ee4 = ee3.parentElement;
			let ee5 = ee4.parentElement;
			let ee4Id = ee5.dataset.id;
			
//            console.log(ee5.className);
            console.log(el);
			modal.style.display="none";
			
			   
//			console.log("e.target알아보자*****************"+e.target.previousElementSibling.className)
//			console.log(id);
		
// 		}else if(e.target.classList.contains("del-btn")){
// 			let el = null;
// 			console.log("e.target알아보자*****************"+e.target.previousElementSibling.className)
// 	        for(el=e.target; el.tagName!="SECTION"; el=el.parentElement);	    
// 	        let id = el.dataset.id;
// 			modal.style.display="none";
			
// 			fetch(`/api/like/${id}`,{
//                  method:"DELETE"
//             })
//             .then(response => response.json())
//             .then(data => {
//                 let result = data.resultObject;
//                 console.log("result"+result);
//                 if(result==1){
//                 console.log("삭제완료");  
// //                el.remove();  
//                 }
//              })			
// 			console.log("삭제")
			
 		}
	}

 

        // 삭제 버튼
//        if(e.target.classList.contains("del-btn")){
//
////          let el = null;
//
////	        for(el=e.target; el.tagName!="SECTION"; el=el.parentElement);	    
//			
////	        let id = el.dataset.id;
//            console.log("삭제!!");
//
//
//            fetch(`/api/like/${exhId}`,{
//                 method:"DELETE"
//            })
//            .then(response => response.json())
//            .then(data => {
//                let result = data.resultObject;
//                console.log("result"+result);
//                if(result==1){
//                console.log("삭제완료");  
//                el.remove();  
//                }
//             })
//
//        
//        }
			
//	}
           
        
});