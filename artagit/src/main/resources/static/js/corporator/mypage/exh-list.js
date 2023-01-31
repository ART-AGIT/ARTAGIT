//======================================================
/*
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
               
               let date = new Date(list.endDate);
               
               if(date<today)
                  state="<p style='color:#545454;'>전시종료</p>";
               
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
                    
                   
                    let el = new DOMParser()
                             .parseFromString(template, "text/html")
                             .body
                             .firstElementChild;
                                
                    var list = document.querySelector(".exh-list-tong");
                    list.append(el);
                 } });}})


*/




//=====================================================

window.addEventListener("load", function () {
   //  예매내역리스트 보여주기 (더보기 기능)
   const itemMore = document.querySelector(".item-more");
   var page = 1;
   let today = new Date();
   var state = null;
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
})



function selectexh() {
   const selectList = document.querySelector("#selectexhibition");
   const selectBtnTwo = document.querySelector(".select-box");
   const optionsTwo = document.querySelectorAll(".option-2");
   var page = 1;
   
   let current = document.querySelector(".active");
   let isEndPage = true;
   let queryString;
   const listTong = document.querySelector(".exh-list-tong");
   const itemMore = document.querySelector(".item-more");






//====================================전시중 s=1

   if (selectList.options[selectList.selectedIndex].value == "exh-ing") {
      console.log("전시중")
      queryString = `?p=${page}&s=${selectList.options[selectList.selectedIndex].dataset.id}`;
      console.log(queryString);
      
      
      fetch(`/corpApi/exh/list/date${queryString}`)
         .then((response) => response.json())
         .then((lists) => {

            console.log(lists)
            listTong.innerHTML = '';
            
            for (list of lists) {

               console.log(Object.keys(lists).length);
               if (Object.keys(lists).length < 6)
                  itemMore.classList.add("d-none");
               var template = `

               <div class="exh-list">
                  <form action="">

                     <div class="exh-img-box">
                        <a href="/corp/exh/${list.id}" ><img class="exh-img" src="/image/poster/${list.poster}" alt=""></a>
                     </div>
                     <div class="text exh-state exh-ing">전시중</div>
                     <div class="text exh-title">${list.name}</div>
                     <div class="text exh-author">author. ${list.artist}</div>
                     <div class="text exh-date" >${list.startDate} ~ ${list.endDate}</div>

                  </form>
               </div>
            `;

               let el = new DOMParser()
                  .parseFromString(template, "text/html")
                  .body
                  .firstElementChild;
               listTong.append(el);
            }
         });
         
         
         
//         =====================================
         itemMore.onclick=function(){
			 page+=1;
			 queryString = `?p=${page}&s=${selectList.options[selectList.selectedIndex].dataset.id}`;
			 
			 
			 fetch(`/corpApi/exh/list/date${queryString}`)
         	.then((response) => response.json())
         	.then((lists) => {
				 
			for (list of lists) {

               console.log(Object.keys(lists).length);
               if (Object.keys(lists).length < 6)
                  itemMore.classList.add("d-none");
               var template = `

              	<div class="exh-list">
                  <form action="">

                     <div class="exh-img-box">
                        <a href="/corp/exh/${list.id}" ><img class="exh-img" src="/image/poster/${list.poster}" alt=""></a>
                     </div>
                     <div class="text exh-state exh-ing">전시중</div>
                     <div class="text exh-title">${list.name}</div>
                     <div class="text exh-author">author. ${list.artist}</div>
                     <div class="text exh-date" >${list.startDate} ~ ${list.endDate}</div>

                  </form>
               </div>
            `;

               let el = new DOMParser()
                  .parseFromString(template, "text/html")
                  .body
                  .firstElementChild;
               listTong.append(el);
            }
				 
		 });
		 
		 
   		}
//         =====================================   		
   		
 }
//====================================전시중끝 s=1   
   
   
   
   
   
//====================================전시예정 s=2
   if (selectList.options[selectList.selectedIndex].value == "exh-according") {

      queryString = `?p=${page}&s=${selectList.options[selectList.selectedIndex].dataset.id}`;
      console.log("전시예정");
      console.log(queryString);
      
      fetch(`/corpApi/exh/list/date${queryString}`)
         .then((response) => response.json())
         .then((lists) => {

            console.log(lists)
            listTong.innerHTML = '';
            for (list of lists) {

               console.log(Object.keys(lists).length);
               if (Object.keys(lists).length < 6)
                  itemMore.classList.add("d-none");

               var template = `

               <div class="exh-list">
                  <form action="">

                     <div class="exh-img-box">
                        <a href="/corp/exh/${list.id}" ><img class="exh-img" src="/image/poster/${list.poster}" alt=""></a>
                     </div>
                     <div class="text exh-state exh-ing">전시예정</div>
                     <div class="text exh-title">${list.name}</div>
                     <div class="text exh-author">author. ${list.artist}</div>
                     <div class="text exh-date" >${list.startDate} ~ ${list.endDate}</div>

                  </form>
               </div>
            `;

               let el = new DOMParser()
                  .parseFromString(template, "text/html")
                  .body
                  .firstElementChild;

               listTong.append(el);
            }
         });
         
         
          itemMore.onclick=function(){
			 page+=1;
			 queryString = `?p=${page}&s=${selectList.options[selectList.selectedIndex].dataset.id}`;
			 
			 
			 fetch(`/corpApi/exh/list/date${queryString}`)
         	.then((response) => response.json())
         	.then((lists) => {
				 
			for (list of lists) {

               console.log(Object.keys(lists).length);
               if (Object.keys(lists).length < 6)
                  itemMore.classList.add("d-none");
               var template = `

               <div class="exh-list">
                  <form action="">

                     <div class="exh-img-box">
                        <a href="/corp/exh/${list.id}" ><img class="exh-img" src="/image/poster/${list.poster}" alt=""></a>
                     </div>
                     <div class="text exh-state exh-ing">전시예정</div>
                     <div class="text exh-title">${list.name}</div>
                     <div class="text exh-author">author. ${list.artist}</div>
                     <div class="text exh-date" >${list.startDate} ~ ${list.endDate}</div>

                  </form>
               </div>
            `;

               let el = new DOMParser()
                  .parseFromString(template, "text/html")
                  .body
                  .firstElementChild;
               listTong.append(el);
            }
				 
		 });
		 
		 
   		}
   }
//====================================전시예정 s=2

   


//====================================전시종료 s=3
   if (selectList.options[selectList.selectedIndex].value == "exh-end") {
      
      console.log("전시종료")
      queryString = `?p=${page}&s=${selectList.options[selectList.selectedIndex].dataset.id}`;
      console.log(page)
      console.log(queryString)
      
      
      fetch(`/corpApi/exh/list/date${queryString}`)
      .then((response) => response.json())
      .then((lists) => {
         
         console.log(lists)
            listTong.innerHTML = '';
            for (list of lists) {

               console.log(Object.keys(lists).length);
               if (Object.keys(lists).length < 6)
                  //전시값이 6개보다적으면 '더보기'버튼 사라지기
                  itemMore.classList.add("d-none");
               
               var template = `

               <div class="exh-list">
                  <form action="">

                     <div class="exh-img-box">
                        <a href="/corp/exh/${list.id}" ><img class="exh-img" src="/image/poster/${list.poster}" alt=""></a>
                     </div>
                     <div class="text exh-state exh-ing" style="color:#545454;">전시종료</div>
                     <div class="text exh-title">${list.name}</div>
                     <div class="text exh-author">author. ${list.artist}</div>
                     <div class="text exh-date" >${list.startDate} ~ ${list.endDate}</div>

                  </form>
               </div>
               <button class="text item-more"">
                       <div>더보기</div>
               </button>
            `;

               let el = new DOMParser()
                  .parseFromString(template, "text/html")
                  .body
                  .firstElementChild;


               listTong.append(el);
            }
         });
         
         
          itemMore.onclick=function(){
			 page+=1;
			 queryString = `?p=${page}&s=${selectList.options[selectList.selectedIndex].dataset.id}`;
			 
			 
			 fetch(`/corpApi/exh/list/date${queryString}`)
         	.then((response) => response.json())
         	.then((lists) => {
				 
			for (list of lists) {

               console.log(Object.keys(lists).length);
               if (Object.keys(lists).length < 6)
                  itemMore.classList.add("d-none");
               var template = `

              <div class="exh-list">
                  <form action="">

                     <div class="exh-img-box">
                        <a href="/corp/exh/${list.id}" ><img class="exh-img" src="/image/poster/${list.poster}" alt=""></a>
                     </div>
                     <div class="text exh-state exh-ing" style="color:#545454;">전시종료</div>
                     <div class="text exh-title">${list.name}</div>
                     <div class="text exh-author">author. ${list.artist}</div>
                     <div class="text exh-date" >${list.startDate} ~ ${list.endDate}</div>

                  </form>
               </div>
               <button class="text item-more"">
                       <div>더보기</div>
               </button>
            `;

               let el = new DOMParser()
                  .parseFromString(template, "text/html")
                  .body
                  .firstElementChild;
               listTong.append(el);
            }
				 
		 });
		 
		 
   		}
        

   }
//====================================전시중 s=1




   
   

}




