window.addEventListener("load", function(){
    const body = document.querySelector('body');
    const modals = document.querySelectorAll('.modal');
    const btnOpenModals = document.querySelectorAll('.btn-open-modal');
    const btnClose = document.querySelector(".btn-close");

    
 	btnOpenModals.forEach(btnOpenModal => {
	    btnOpenModal.onclick = function(e){
	        e.preventDefault();
	        console.log("test")
	        
	        modals.forEach(modal => {
		        modal.classList.toggle('show');
		    
		        if (modal.classList.contains('show')) {
		          body.style.overflow = 'scroll';
		        }
					
			})
	    };		 
	 });
	
	modals.forEach(modal => {
	    modal.onclick = function(e){
	        //e.preventDefault();
	        if (e.target === modal || e.target === btnClose) {
	          modal.classList.toggle('show');
	      
	        if (!modal.classList.contains('show')) {
	          body.style.overflow = 'auto';
	        };
	      };
	    };
	})

})