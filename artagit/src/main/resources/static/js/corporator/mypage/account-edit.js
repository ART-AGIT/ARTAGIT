window.addEventListener("load",function(){


	//  아코디언 =======================================
	const btnHeader = this.document.querySelectorAll(".accordion-header");
    const regListBox = this.document.querySelectorAll(".reg-list-box");
	const btnToggle = this.document.querySelectorAll(".toggle");
	const btnIcon = document.querySelectorAll(".arrow-icon");
    
    // let currentEl = this.document.querySelector(".d-none");
    let contents = this.document.querySelectorAll(".accordion-content");
    const form = this.document.querySelector("form");
	const icon = this.document.querySelectorAll(".arrow-icon");
	const formWrap = this.document.querySelector(".form-wrap");

	// img 등록하기
	const editImg = document.querySelector(".edit-img")
	const imgInput = this.document.querySelector(".img-input");
	const fileInput = this.document.querySelector(".file-input");
	
	// 회원탈퇴 modal
	const modal = document.querySelector("#modal");
	const unregBtn = this.document.querySelector(".btn-unregister");
	const cancelBtn = this.document.querySelector(".cancel-btn");
	const saveBtn = this.document.querySelector(".save-btn");

	// 회원 탈퇴
	unregBtn.onclick = function(e){
		modal.style.display="flex";
	}

	cancelBtn.onclick = function(e){
		e.preventDefault();
		
		if(e.target.classList.contains("cancel-btn"))
			modal.style.display="none";
	}
	

		// 토글
		formWrap.onclick = function(e){
            // e.preventDefault()
            console.log(e.target);

            if(regListBox[1].classList.contains("d-none") && (e.target == btnHeader[1]
    															|| e.target == btnToggle[1] 
            													|| e.target == btnIcon[1])){
                contents[1].classList.remove("d-none");
				icon[1].classList.remove("icon-arrow-toggle-up");
				icon[1].classList.add("icon-arrow-toggle-down");
            }

            else if(e.target != regListBox[1].classList.contains("d-none") && (e.target == btnHeader[1]
				    															|| e.target == btnToggle[1] 
				            													|| e.target == btnIcon[1])){
                contents[1].classList.add("d-none");
				icon[1].classList.remove("icon-arrow-toggle-down");
				icon[1].classList.add("icon-arrow-toggle-up");
            }

            if(regListBox[0].classList.contains("d-none") && (e.target == btnHeader[0] 
            													|| e.target == btnToggle[0]
            													|| e.target == btnIcon[0])){
                contents[0].classList.remove("d-none");
				icon[0].classList.remove("icon-arrow-toggle-up");
				icon[0].classList.add("icon-arrow-toggle-down");
                console.log("test");
            }

            else if(e.target != regListBox[0].classList.contains("d-none") && (e.target == btnHeader[0] 
				            													|| e.target == btnToggle[0]
				            													|| e.target == btnIcon[0])){
				contents[0].classList.add("d-none");
				icon[0].classList.remove("icon-arrow-toggle-down");
				icon[0].classList.add("icon-arrow-toggle-up");
              
            }


			if(e.target.classList.contains("icon-write")){
				//  img 수정
				imgInput.onclick = function(e){
					//  e.preventDefault();
					console.log("test")
					let event = new MouseEvent("click",{
						'view':window,
						'bubbles':true,
						'cancelable':true
						
					})
					fileInput.dispatchEvent(event);
					
				}
				
				// 미리보기
				fileInput.oninput = function(e){
					
					let url = fileInput.files[0];
					let reader = new FileReader();
					reader.onload = (evt) =>{
						imgInput.src = evt.target.result;
					};
					reader.readAsDataURL(url)
				}
			}

        }
	 
 });


 
