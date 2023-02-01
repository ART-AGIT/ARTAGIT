window.addEventListener("load", function(e){
    const findPw = document.querySelector(".find-pw");
    const findId = document.querySelector(".find-id");
    const findIdBox = document.querySelector(".find-content-box");
    const findResult = document.querySelector(".find-result");
    const findPwBox = document.querySelector(".find-content-box.find-pw-box");
    
    findPw.onclick = function(e){
        e.preventDefault();
        console.log("hi hi");
        
        findId.classList.remove("select-on");
        findPw.classList.add("select-on");
        findPwBox.classList.remove("d-none");
        findIdBox.classList.add("d-none");
        findResult.classList.add("d-none");
        // findPwBox.classList.add("d-none");
    }
});