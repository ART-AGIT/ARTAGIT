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
        // console.log(e.target.classList.contains("active"));

        // if(current.classList.contains("active"))
        //     e.target.classList.remove("active")
        console.log(`e.target ${e.target.classList}`);
        // console.log(`current ${current.classList}`);
        // e.target.classList.add("active");
        
        if(!e.target.classList.contains("active"))
            e.target.classList.add("active");
        else{
            e.target.classList.remove("active")
        }



        if(!e.target.classList.contains("exh-menu-select"))
            return;

        

        if(current != null)
            current.classList.remove("active");

        if(current == e.target)
            current.classList.remove("active");

        // current = e.target;



        console.log(`e.target ${e.target.classList}`);
        // console.log(`current ${current.classList}`);
        
        // // 바탕 클릭하면 메뉴 꺼지게?
        // body.onclick=function(e){
        //     e.preventDefault();
        //     current.classList.remove("active");
        // }

   
    }

})