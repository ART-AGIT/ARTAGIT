window.addEventListener("load",function(){
// const exhHeart = this.document.querySelector(".exh-like");
//    const likeList = this.document.querySelectorAll(".like-list");
    const likeListSection = this.document.querySelector(".like-list-section");
    
//    const Form = this.document.querySelector("form");


    likeListSection.onclick = function(e){
        e.preventDefault();
        //console.log(e.target);
       if(!e.target.classList.contains("exh-like"))
           return;

        if(e.target.classList.contains("exh-like") && e.target.classList.contains("icon-heart-red")){
          	console.log(e.target);
           
           e.target.classList.remove("icon-heart-red");
           
           console.log("삭제")
           
           let el = null;

           // i == el , i < 10 , I++ 2,3,4
           // section 
           for(el=e.target; el.tagName!="DIV"; el=el.parentElement);

           console.log(el);
           let id = el.dataset.id;

           console.log(id);
           
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
});