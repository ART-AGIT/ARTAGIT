window.addEventListener("load", function(){

    const box = document.querySelector(".value-check-box");
    let input = box.querySelector("input");
    let btn = box.querySelector("button");
    let span = box.querySelector("span");

    // input에 값 입력시 버튼색 바뀜
    input.onkeyup = function(){
        btn.classList.remove("btn-default-fill-off");
        span.classList.remove("d-none");
        if(input.value == ""){
            btn.classList.add("btn-default-fill-off")
            span.classList.add("d-none");
        }
        
    }

})