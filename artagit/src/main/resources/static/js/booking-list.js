window.addEventListener("load", function(){
    const payDetailModal = document.querySelector(".pay-detail");
    const modal = document.querySelector(".modal");
    // const btnOpenModal = document.querySelector('.btn-open-modal');
    // const btnClose = document.querySelector(".btn-close");
    
    payDetailModal.onclick=function(e){
        e.preventDefault();
        document.querySelector(".modal").classList.remove("d-none");
        document.body.style.overflow = "unset";

    }


})