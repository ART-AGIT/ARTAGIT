window.addEventListener("load", function(){

    let header = document.querySelector(".header");
    let burgerNav = header.querySelector(".burger-nav");
    let subMenuBox = header.querySelector(".sub-menu-box");
    let main = document.querySelector("main");

    burgerNav.onclick = function(e){
        e.preventDefault();
        // searchContainer.classList.remove("")
        subMenuBox.classList.toggle("show");
        header.classList.toggle("show");
        main.classList.toggle("show");
    }



})