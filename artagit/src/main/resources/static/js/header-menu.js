window.addEventListener("load", function(){
    const header = document.querySelector(".header");
    const burgerNav = header.querySelector(".burger-nav");
    const subMenuBox = header.querySelector(".sub-menu-box");
    const main = document.querySelector("main");

    burgerNav.onclick = function(e){
        e.preventDefault();
        // searchContainer.classList.remove("")
        subMenuBox.classList.toggle("show");
        header.classList.toggle("show");
        main.classList.toggle("show");
    }

    const headerSearch = document.querySelector(".header-search");
    const btnSearch = document.querySelector(".btn-search");

    btnSearch.onclick = function(e){
        btnSearch.value = headerSearch.value;
    }


    headerSearch.addEventListener("keyup", function(e){
        if(e.keyCode === 13)
            btnSearch.onclick();
    })



})