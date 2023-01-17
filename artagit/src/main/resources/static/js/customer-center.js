window.addEventListener("load", function(){
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
            // 닫혀있는 것 열어주기
            // if(!e.target.classList.contains("active")){
            //     e.target.classList.add("active");
            //     prev = e.target;
            // } else if() {
            // }

            
            

        }
        // if(currentEl!=null || isOpen){
            //     currentEl.classList.remove('active');
    //     currentEl = null;
    // }else{
    //     e.target.classList.add('active');
    //     isOpen = true;
    //     currentEl = e.target;
    // }
    for(let i=0; i<noticeBox.length; i++){

    
    noticeBox[i].onclick = function(e){
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
}
});
