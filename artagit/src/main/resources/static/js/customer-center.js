window.addEventListener("load", function(){
    console.log("h2");
    let section = document.querySelector(".section");
    var box = section.querySelector(".box");
    // let noticeSection = document.querySelector(".notice-section");
    // var qnaBox = section.querySelector(".qna-box");
    var currentEl = section.querySelector(".active");

    box.onclick = function(e){ 
        
        var isHeader = e.target.nodeName == 'H4'
                        || e.target.classList.contains('accordion-header');
        
        // if((e.target.nodeName != 'H2') && (e.target.classList.contains("accordion-header")))
        if(!isHeader) // 클릭된 요소가 헤더가 아니면 아무것도 하지 않고 넘어가기.
            return;
            
            console.log(currentEl);


        console.log("click!");

        if(currentEl != null){
            console.log(e.target.classList);
            currentEl.classList.remove("active");
        }
        
        e.target.classList.add('active');
        currentEl = e.target;
    }
});

// ㅎㅇㅎㅇㅎㅇ