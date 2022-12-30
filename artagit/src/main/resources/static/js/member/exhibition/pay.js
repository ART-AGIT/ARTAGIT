window.addEventListener("load", function(){
    const payMenu = document.querySelector(".payment-select-menu");
    let currentEl = document.querySelector(".active")

    
    //------------ 결제수단 선택하기----------------
    payMenu.addEventListener("click", function(e){
        e.preventDefault();
        
        let el = e.target;


        if(el.tagName != 'A')
            return;

        el.classList.add('active');

        if(currentEl != null)
            currentEl.classList.remove('active');

        currentEl = el;
    })




})