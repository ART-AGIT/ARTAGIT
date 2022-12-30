window.addEventListener("load", function(){
    console.log("h2");
    let section = document.querySelector(".section");
    var qnaBox = section.querySelector(".qna-box");
    var noticeBox = section.querySelector(".notice-box");
    // let noticeSection = document.querySelector(".notice-section");
    // var qnaBox = section.querySelector(".qna-box");
    // var currentEl = section.querySelector(".active");

    qnaBox.onclick = function(e){ 
        var currentEl = e.target;
        console.log(currentEl);
        
        var isHeader = e.target.nodeName == 'H4'
                        || e.target.classList.contains('accordion-header');
        
        // if((e.target.nodeName != 'H2') && (e.target.classList.contains("accordion-header")))
        if(!isHeader) // 클릭된 요소가 헤더가 아니면 아무것도 하지 않고 넘어가기.
            return;
            

        console.log(currentEl);
        console.log("click!");

        // if(currentEl != null){
        //     console.log(e.target.classList);
        //     currentEl.classList.remove("active");
        // }
        
        currentEl.classList.add('active');
        currentEl = null;
        
    }

    noticeBox.onclick = function(e){
        var isHeader = e.target.nodeName == 'H4'
                        || e.target.classList.contains('accordion-header');

        if(!isHeader)
            return;

        console.log("공지 click!");

        if(currentEl != null){
            console.log(e.target.classList);
            currentEl.classList.remove("active");
        }
        
        e.target.classList.add('active');
        currentEl = e.target;
    }
});

// ㅎㅇㅎㅇㅎㅇ