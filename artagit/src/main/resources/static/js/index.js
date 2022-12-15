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


{/* <h1>5. 스타일 다루기 : 아이템 이동</h1> */}
window.addEventListener("load", function(){
    var section = this.document.querySelector("#s5");

    var box = section.querySelector(".box");

    var btnPrev = section.querySelector(".btn-prev");
    var btnNext = section.querySelector(".btn-next");

    var lis = section.querySelectorAll("li");

    var offIndex = 0;

    box.onclick = function(e){
        e.preventDefault();
        e.stopPropagation();

        // offIndex++;

        var size = lis.length;

        lis[(0+offIndex)%size].className="card-1th";
        lis[(1+offIndex)%size].className="card-2th";
        lis[(2+offIndex)%size].className="card-3th";
        
        if(e.target.nodeName != "LI")
            return;


        
    }



    btnPrev.onclick = function(e){
        e.preventDefault();

        offIndex++;

        var size = lis.length;
        lis[(0+offIndex)%size].className="card-1th";
        lis[(1+offIndex)%size].className="card-2th";
        lis[(2+offIndex)%size].className="card-3th";

        

        console.log(offIndex);
    }

    btnNext.onclick = function(e){
        e.preventDefault();

        offIndex++;

        var size = lis.length;
        lis[(0+offIndex)%size].className="card-1th";
        lis[(1+offIndex)%size].className="card-2th";
        lis[(2+offIndex)%size].className="card-3th";

        console.log("다음");
    }

});

