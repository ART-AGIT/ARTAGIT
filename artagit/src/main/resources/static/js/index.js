window.addEventListener("load", function(){
    var body = document.getElementById("body");
    var header = body.querySelector("header");
    var icon = header.querySelector(".icon");
    var subMenu = header.querySelector(".sub-menu-box");
    var links = subMenu.querySelectorAll("a");

    var headerPc = body.querySelector(".header-pc");
    var mainMenuPc = headerPc.querySelector(".main-menu");
    var linksPc = mainMenuPc.querySelectorAll("a")

    window.addEventListener("scroll", function(){
        var scrollValue = document.documentElement.scrollTop;
        var windowHeight = window.innerHeight;

        if(scrollValue >= 200){
            body.classList.add("bg-white");
            header.classList.add("bg-white");
            headerPc.classList.add("bg-white")
            subMenu.classList.add("bg-white");
            for(let link of links)
                link.classList.add("bg-white");
            for(let linkPc of linksPc)
                linkPc.classList.add("bg-white");
            icon.classList.add("bg-white");
        }
        else{
            body.classList.remove("bg-white");
            header.classList.remove("bg-white");
            headerPc.classList.remove("bg-white")
            subMenu.classList.remove("bg-white");
            for(let link of links)
                link.classList.remove("bg-white")
            for(let linkPc of linksPc)
                linkPc.classList.remove("bg-white"); 
            icon.classList.remove("bg-white");
        }
    })
})

window.addEventListener("load", function(){
    var slider = document.querySelector(".slider");
    var prevBtn = slider.querySelector(".prev");
    var nextBtn = slider.querySelector(".next");

    let currSlide = 1;
    showSlide(currSlide);

    prevBtn.onclick = function(){
        currSlide--;
        showSlide(currSlide);
    }

    nextBtn.onclick = function(){
        currSlide++;
        showSlide(currSlide);
    }

    function showSlide(num){
    const slides = document.querySelectorAll(".slide");
    if(num > slides.length){
        currSlide = 1;
    }if(num < 1){
        currSlide = slides.length;
    }
    for(let i=0; i<slides.length; i++){
        slides[i].style.display="none";
    }slides[currSlide -1].style.display="block";

    
    }
    setInterval(function(){
        currSlide++;
        showSlide(currSlide);
    }, 5000);
})


// window.addEventListener("load", function(){
//     var section = this.document.querySelector(".main-banner-box");

//     var box = section.querySelector(".main-banner");

//     var btnPrev = section.querySelector(".btn-prev-img");
//     var btnNext = section.querySelector(".btn-next-img");

//     var lis = section.querySelectorAll("li");

//     var offIndex = 0;

//     // box.onclick = function(e){
//     //     e.preventDefault();
//     //     e.stopPropagation();

//     //     offIndex++;

//     //     var size = lis.length;

//     //     lis[(0+offIndex)%size].className="img-1";
//     //     lis[(1+offIndex)%size].className="img-2";
//     //     lis[(2+offIndex)%size].className="img-3";
        
//     //     if(e.target.nodeName != "LI")
//     //         return;
//     // }

//     btnPrev.onclick = function(e){
//         e.preventDefault();

//         offIndex--;
//         if(offIndex<0)
//             offIndex=3;

//         var size = lis.length;
//         lis[(0+offIndex)%size].className="img-1";
//         lis[(1+offIndex)%size].className="img-2";
//         lis[(2+offIndex)%size].className="img-3";

        

//         console.log(offIndex);
//     }

//     btnNext.onclick = function(e){
//         e.preventDefault();

//         offIndex++;

//         var size = lis.length;
//         lis[(0+offIndex)%size].className="img-1";
//         lis[(1+offIndex)%size].className="img-2";
//         lis[(2+offIndex)%size].className="img-3";

//         console.log("다음");
//     }

// });

