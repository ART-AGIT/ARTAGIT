// window.addEventListener("load",function(){
//     const exhHeart = this.document.querySelector(".exh-like");
//     // const likeList = this.document.querySelector(".like-list");
    

//     exhHeart.onclick = function(e){
//         e.preventDefault();
//         console.log("test");
//         if(e.target.classList.contains("exh-like") && e.target.classList.contains("icon-heart-red")){
//             e.preventDefault();
            
//             e.target.classList.remove("icon-heart-red");
            
//             console.log("삭제")
            
//             let el = null;

//             // i == el , i < 10 , I++ 2,3,4
//             // section 
//             for(el=e.target; el.tagName!="SECTION"; el=el.parentElement);

//             // console.log(el);
//             let id = el.dataset.id;

//             console.log(id);
            
// //            fetch(`/api/like/${id}`,{
// //                method:"DELETE"
// //            })
// //            .then(response => response.json())
// //            .then(data => {
// //                console.log(data.result);
// //            })
// //            fetch(`member/mypage/like-list`)
        
//         }

//     }
// });