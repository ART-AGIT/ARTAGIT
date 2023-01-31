window.addEventListener("load", function(){
    const main = this.document.querySelector("main");
    let section = document.querySelector(".section");
    var qnaBox = section.querySelector(".qna-box");
    var noticeBox = section.querySelectorAll(".notice-box");
    var currentEl = section.querySelector(".active");

    qnaBox.onclick = function(e){ 
        // var currentEl = e.target;
        
        var isHeader = e.target.nodeName == 'H4'
                        || e.target.classList.contains('accordion-header');
        
        // if((e.target.nodeName != 'H2') && (e.target.classList.contains("accordion-header")))
        if(!isHeader) // 클릭된 요소가 헤더가 아니면 아무것도 하지 않고 넘어가기.
            return;

            console.log("click!");

            if(currentEl != null){
                console.log(e.target.classList);
                currentEl.classList.remove("active");
                currentEl.style.fontWeight = 400;
                currentEl.style.borderBottom = '1px solid #dbdbdb';
            } 
            
            e.target.classList.add('active');
            e.target.style.fontWeight = 600;
            e.target.style.borderBottom = 0;
            currentEl = e.target;
    }
    
    for(let i=0; i<noticeBox.length; i++){
        noticeBox[i].onclick = function(e){
            console.log(`${noticeBox[i].dataset.id}번 공지 클릭`);

            // let queryString = `?c=${noticeBox[i].dataset.id}`;
            let queryString = noticeBox[i].dataset.id;

            console.log(queryString);

            // if(noticeBox[i].dataset.id == 0)
            //     queryString = "";

            fetch(`customer_notice/${queryString}`, {
                method: "GET"
            })
            .then((response) => {
				if(response.ok) {
                    console.log("성공");
                    return response.json();
                    } else {console.log("실패")}})
            .then((notice) => {
                main.innerHTML = "";
                console.log(notice);
                console.log(notice.image);
                if(notice.image == ""){
                    notice.image == "/image/idresult.png";
                }
            let template = `<main>
                            <section class="notice-detail-container">
                                <h1 class="notice-detail-title">${notice.title}</h1>
                                <span class="notice-detail-date">관리자&nbsp;&nbsp;${notice.regDate}</span>

                                <div class="notice-detail-content">
                                    <img class="notice-img" src="/image/딸기청.jpg">
                                    <p>${notice.content}</p>
                                </div>
                                <a class="notice-detail-back" href="/customer_notice">목록보기</a>
                            </section>
                            </main>`

            let el = new DOMParser() // string으로 된 HTML 태그들을 DOM 객체로 변환해준다.
            .parseFromString(template, "text/html") // 어떤 문자열(1st param)을 어떠한 형식(2nd param)으로 변환할건지.
            .body 	// body 에
                    // DOMParser가 넣어주는 것은 html의 태그 이기 때문에 body에 넣는다는 의미로 body 명시해주기.
            .firstElementChild;

			window.scrollTo(0,0);
            main.append(el);
        })
        }
    }
});