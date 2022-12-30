window.addEventListener("load", function(){
    const body = document.querySelector('body');
    const modal = document.querySelector('.modal');
    const btnOpenModal = document.querySelector('.btn-open-modal');
    
    btnOpenModal.onclick = function(e){
        e.preventDefault();
        modal.classList.toggle('show');
    
        if (modal.classList.contains('show')) {
        body.style.overflow = 'hidden';
        }
        console.log(body.scrollHeight)
    }

    modal.onclick = function(e){
        e.preventDefault();
        if (e.target === modal) {
          modal.classList.toggle('show');
      
          if (!modal.classList.contains('show')) {
            body.style.overflow = 'auto';
          };
        };
    };


})