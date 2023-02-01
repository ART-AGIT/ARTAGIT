window.addEventListener("load", function(){
    const body = document.querySelector('body');
    const modal = document.querySelector('.modal');
    const btnOpenModal = document.querySelector('.btn-open-modal');
    const btnClose = document.querySelector(".btn-close");
    
    btnOpenModal.onclick = function(e){
        e.preventDefault();
        modal.classList.toggle('show');
    
        if (modal.classList.contains('show')) {
          body.style.overflow = 'scroll';
        }
    }

    modal.onclick = function(e){
        //e.preventDefault();
        if (e.target === modal || e.target === btnClose) {
          modal.classList.toggle('show');
      
        if (!modal.classList.contains('show')) {
          body.style.overflow = 'auto';
        };
      };
    };;

})