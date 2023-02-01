window.addEventListener("load",function(){

	//  아코디언 =======================================
	const btnHeader = this.document.querySelectorAll(".accordion-header");
    const regListBox = this.document.querySelectorAll(".reg-list-box");
    // let currentEl = this.document.querySelector(".d-none");
    let contents = this.document.querySelectorAll(".accordion-content");
    // const form = this.document.querySelector("form");
    const regList = this.document.querySelector(".reg-list");
	const icon = this.document.querySelectorAll(".arrow-icon");

    const chkId = this.document.querySelector(".loginId");

    regList.onclick = function(e){
            e.preventDefault()

            var isHeader = e.target.classList.contains("accordion-header")
                            ||e.target.classList.contains("accordion");
           
            if(!isHeader)
                return;

            if(regListBox[1].classList.contains("d-none") && e.target == btnHeader[1]){
                contents[1].classList.remove("d-none");
				icon[1].classList.remove("icon-arrow-toggle-up");
				icon[1].classList.add("icon-arrow-toggle-down");
            }

            else if(e.target != regListBox[1].classList.contains("d-none") && e.target == btnHeader[1]){
                contents[1].classList.add("d-none");
				icon[1].classList.remove("icon-arrow-toggle-down");
				icon[1].classList.add("icon-arrow-toggle-up");
            }

            if(regListBox[0].classList.contains("d-none") && e.target == btnHeader[0]){
                contents[0].classList.remove("d-none");
				icon[0].classList.remove("icon-arrow-toggle-up");
				icon[0].classList.add("icon-arrow-toggle-down");
                console.log("test");
            }

            else if(e.target != regListBox[0].classList.contains("d-none") && e.target == btnHeader[0]){
				contents[0].classList.add("d-none");
				icon[0].classList.remove("icon-arrow-toggle-down");
				icon[0].classList.add("icon-arrow-toggle-up");
              
            }

        }
	 
 });


 
