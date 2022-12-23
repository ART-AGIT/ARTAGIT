
var colorBtn = document.querySelector(".wrap");

window.addEventListener("load",function(){

    colorBtn.onclick= function(e){
        e.preventDefault();
        console.log("hihi");

    }
});

/*
<div id="area1" class="area"></div>

<input id="color" type="color">

<button onclick="colorChange();">변경</button>

<script>
    function colorChange(){

        document.getElementById("area1").style.backgroundColor = document.getElementById("color").value;


    };

*/