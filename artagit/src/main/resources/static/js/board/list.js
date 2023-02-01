window.addEventListener("load", function() {
   const ul = document.querySelector(".board-category-l");
   const boardbox = document.querySelector(".post-list-box");
   const noticebox = document.querySelector(".notice-list-box");
   var currentPage = document.querySelector(".paging");
      let currentLi = document.querySelector(".board-category-box ul li.board-selected");
   

   ul.onclick = function(e) {
      e.preventDefault();
      
      const el = e.target;
      
      if (el.tagName != "LI" && el.tagName != "DIV")
         return;

      let li = el;
      if (el.tagName == "DIV")
         li = el.parentElement;

      li.classList.add("board-selected");
      
      
      if (currentLi != null && currentLi != e.target 
      && currentLi.querySelector(".div-btn") != e.target)
         currentLi.classList.remove("board-selected");
      currentLi = li;
      

   
   




   let queryString = `?c=${currentLi.dataset.id}`
      
   fetch(
      `/boardApi/notice${queryString}`)
      .then((response) => 
         response.json())
      .then((list) => {
         noticebox.innerHTML="";

      for (let notice of list) {
         let beforeNoticeDate = new Date(notice.regDate);
         let utc = beforeNoticeDate.getTime() + (beforeNoticeDate.getTimezoneOffset() * 60 * 1000);
         let time_diff = 9 * 60 * 60 * 1000;
         let cur_date_korea = new Date(utc + (time_diff));
         let year = notice.regDate.toString().substring(2, 4);
         let month = notice.regDate.toString().substring(5, 7);
         let day = notice.regDate.toString().substring(8, 10);
         let hour = cur_date_korea.toString().substring(15, 18);
         let min = cur_date_korea.toString().substring(19, 21);
         
         
      
         
         let template1 =
         `
          <section class="notice">
               <h1 class="d-none">공지목록</h1> 
                <div class="notice-icon">공지</div>
               <h1 class="notice-title">
                   <a href = "../notice/${notice.id}">${notice.title}</a></h1>
               <div> </div>
               <div class="notice-info">
                   
                <div>
                   
                   <div>운영자 </div>
               </div>
               <div> ${year}/${month}/${day} ${hour}:${min}</div>
                   
                <div class="view">
                    <div class="icon icon-view icon-size">조회수 아이콘</div>
                    <div>${notice.hit}</div>
                </div>
           </section>`;
           
            let el1 = new DOMParser().parseFromString(template1, "text/html").body.firstElementChild;
            //body를 지우면 body안쪽만 나온다. firstelement를 만들겠다.
            noticebox.append(el1); //6개의 객체를 하나하나 넣어준다.
      }})
   console.log(queryString);
   fetch(
      `/boardApi/boards${queryString}`)
      .then((response) => 
         response.json())
      .then((list) => {
         boardbox.innerHTML="";
      for (let board of list) {
         //시간 format설정(->KST)
         let beforeBoardDate = new Date(board.regDate);
         let utcBoard = beforeBoardDate.getTime() + (beforeBoardDate.getTimezoneOffset() * 60 * 1000);
         let time_diffBoard = 9 * 60 * 60 * 1000;
         let cur_date_koreaBoard = new Date(utcBoard + (time_diffBoard));
         
         let year = board.regDate.toString().substring(2, 4);
         let month = board.regDate.toString().substring(5, 7);
         let day = board.regDate.toString().substring(8, 10);
         let hour = cur_date_koreaBoard.toString().substring(15, 18);
         let min = cur_date_koreaBoard.toString().substring(19, 21);
         let titleImage = null;
         if(board.image1!=null)
            titleImage = board.image1;
            
         else if(board.image2 != null)
            titleImage = board.image2;
         else if(board.image3 !=null)
            titleImage = board.image3;
         else if(board.image4 != null)
            titleImage = board.image4;
         else
            titleImage = '';
         
         
         
            
         
         let template = ` 
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
           <img onerror="this.style.display='none'"  src="/image/board/${titleImage}" class="post-img">
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
            

            
         
      };})
      }
      //------------카테고리 선택
      
      //----------카테고리 안에서 페이지 선택
   
      //-------------------------카테고리& 페이징
      
      
      
      
      
      
      })