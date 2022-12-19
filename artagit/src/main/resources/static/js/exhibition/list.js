window.addEventListener("load", function(){

    let body = document.querySelector("body");
    let main = document.querySelector("main");
    let exhMenu = main.querySelector(".exh-menu-list");
    var current = main.querySelector(".active");
    var exhHeart = main.querySelector(".exhibition-heart");

    exhHeart.onclick = function(e){
        e.preventDefault();
        exhHeart.style.backgroundColor("red");
    }

    exhMenu.onclick = function(e){
        e.preventDefault();
        e.stopPropagation();

        if(!e.target.classList.contains("exh-menu-select"))
            return;
        
        if(current != null){
            current.classList.remove("active");
        }
        e.target.classList.add("active");
        current = e.target;

        // 바탕 클릭하면 메뉴 꺼지게
        body.onclick=function(e){
            e.preventDefault();
            current.classList.remove("active");
        }

    }

})