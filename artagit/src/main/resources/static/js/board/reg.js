window.addEventListener("load", function(){

    let section = this.document.querySelector(".post-option");
    let box = section.querySelector(".select-box");
    var option = box.querySelectorAll(".option");
    const label = box.querySelector(".label");


    box.onclick=function(e){
        e.preventDefault();
        if(!box.classList.contains("active"))
            box.classList.add("active");
        else
            box.classList.remove("active");
    }
    
    const handleSelect = function(item) {
        label.innerHTML = item.textContent;
        box.classList.remove("active");
      }
      // 옵션 클릭시 클릭한 옵션을 넘김
        option.forEach(function(option){
        option.addEventListener('click', function(){handleSelect(option)})
      })
      // 라벨을 클릭시 옵션 목록이 열림/닫힘
    
     


})