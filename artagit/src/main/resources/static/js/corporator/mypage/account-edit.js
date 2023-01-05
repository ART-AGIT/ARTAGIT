window.addEventListener("load",function(){


	//  아코디언 =======================================
	const btnHeader = this.document.querySelectorAll(".accordion-header");
    const regListBox = this.document.querySelectorAll(".reg-list-box");
    // let currentEl = this.document.querySelector(".d-none");
    let contents = this.document.querySelectorAll(".accordion-content");
    const form = this.document.querySelector("form");
	const icon = this.document.querySelectorAll(".arrow-icon");
	const formWrap = this.document.querySelector(".form-wrap");

	// img 등록하기
	const editImg = document.querySelector(".edit-img")
	const imgInput = this.document.querySelector(".img-input");
	const fileInput = this.document.querySelector(".file-input");
	
	// 회원 탈퇴
//	const btnUnregister = document.querySelector(".btn-unregister");
	
//	btnUnregister.onclick = function(e){
//			if(e.target.classList.contains("btn-unregister")){
//		        console.log("test");
//				fetch('/corp/account-edit/delete');
//			}
//		}
		formWrap.onclick = function(e){
            // e.preventDefault()
            
			
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


 
