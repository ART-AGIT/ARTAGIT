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

