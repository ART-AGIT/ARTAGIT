

window.addEventListener("load",function(){
    var formBox = document.querySelector(".form-box");
    var colorInput = document.querySelector(".color-input");

    colorInput.oninput= function(e){
        formBox.style.background = colorInput.value;
        console.log("hihi");
    }
});