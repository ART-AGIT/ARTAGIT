window.addEventListener("load", function(){
    var body = document.getElementById("body");
    var header = body.querySelector("header");
    var icon = header.querySelector("icon");

    window.addEventListener("scroll", function(){
        var scrollValue = document.documentElement.scrollTop;
        var windowHeight = window.innerHeight;

        if(scrollValue >= 200){
            body.classList.add("bg-white");
            header.classList.add("bg-white");
            // icon.classList.add("icon-black");
        }
        else{
            body.classList.remove("bg-white");
            header.classList.remove("bg-white");
            // icon.classList.remove("icon-black");
        }
        console.log("scrollValue"+scrollValue);
        console.log("window"+window.screenY);
    })
})


window.addEventListener("load", function(){
    var section = this.document.querySelector(".main-banner-box");

    var box = section.querySelector(".main-banner");

    var btnPrev = section.querySelector(".btn-prev-img");
    var btnNext = section.querySelector(".btn-next-img");

    var lis = section.querySelectorAll("li");

    var offIndex = 0;

    // box.onclick = function(e){
    //     e.preventDefault();
    //     e.stopPropagation();

    //     offIndex++;

    //     var size = lis.length;

    //     lis[(0+offIndex)%size].className="img-1";
    //     lis[(1+offIndex)%size].className="img-2";
    //     lis[(2+offIndex)%size].className="img-3";
        
    //     if(e.target.nodeName != "LI")
    //         return;
    // }

    btnPrev.onclick = function(e){
        e.preventDefault();

        offIndex--;
        if(offIndex<0)
            offIndex=3;

        var size = lis.length;
        lis[(0+offIndex)%size].className="img-1";
        lis[(1+offIndex)%size].className="img-2";
        lis[(2+offIndex)%size].className="img-3";

        

        console.log(offIndex);
    }

    btnNext.onclick = function(e){
        e.preventDefault();

        offIndex++;

        var size = lis.length;
        lis[(0+offIndex)%size].className="img-1";
        lis[(1+offIndex)%size].className="img-2";
        lis[(2+offIndex)%size].className="img-3";

        console.log("다음");
    }

});

