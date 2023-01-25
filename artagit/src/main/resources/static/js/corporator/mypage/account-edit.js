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
	const modal = document.querySelectorAll("#modal");
	const unregBtn = this.document.querySelector(".btn-unregister");
	const cancelBtn = this.document.querySelector(".cancel-btn");
	const delBtn = document.querySelector(".del-btn");

	// 정보 수정 완료 modal
//	const modal = document.querySelector(".modal-wrap");
	const saveBtn = this.document.querySelector(".save-btn");
	const okBtn = document.querySelector(".ok-btn");
	
	const editmodal = document.querySelector(".modaledit");
//	const saveBtn = this.document.querySelector(".save-btn");
//	const okBtn = this.document.querySelector(".ok-btn");
	const editcancelBtn = this.document.querySelector(".edit-cancel-btn");

	// 비밀번호 유효성 및 정규식
 	let elInputPassword = this.document.querySelector("#password");
    let elInputPasswordCheck = this.document.querySelector("#password-check");

    let Pwdfailuremassage = this.document.querySelector(".passwordFialure-message");
    let Pwdsuccessmassage = this.document.querySelector(".passwordSuccess-message");
    let Pwdchkfailuremassage = this.document.querySelector(".chkFialure-message");
    let Pwdchksuccessmassage = this.document.querySelector(".chkSuccess-message");




	//회원수정
	saveBtn.onclick = function(e){
		e.preventDefault();
		editmodal.style.display="flex";
	}

	editcancelBtn.onclick = function(e){
		e.preventDefault();
		editmodal.style.display="none";
	}

	// 회원 탈퇴
	unregBtn.onclick = function(e){
		console.log("회원탈퇴 ㄱㄱ")
		modal[1].style.display="flex";
//		e.preventDefault();
	}

	cancelBtn.onclick = function(e){
//		e.preventDefault();
		console.log("탈퇴 취소")
		if(e.target.classList.contains("cancel-btn"))
			modal[1].style.display="none";
	}
	delBtn.onclick = function(e){
		
		console.log("회원탈퇴")
	}
	
	
		// 토글
		formWrap.onclick = function(e){
             e.preventDefault()
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
					// e.preventDefault();
					console.log("test---------------------")
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
        
        
        
    // 비빌번호 정규식
    elInputPassword.onkeyup = function(){
        var regExpPwd = /^[a-z0-9_]{8,16}$/

        
        if(elInputPassword.value==false){ 
            Pwdfailuremassage.classList.add('d-none');
            Pwdsuccessmassage.classList.add('d-none');
        }

        else if(regExpPwd.test(elInputPassword.value)==true){
            Pwdfailuremassage.classList.add('d-none');

            Pwdsuccessmassage.classList.remove('d-none');
            
        }
        else {
            Pwdfailuremassage.classList.remove('d-none');
    
            Pwdsuccessmassage.classList.add('d-none');
        }

    };
    
    
    // 비밀번호 확인과 일치여부
    elInputPasswordCheck.onkeyup = function(){
        let pwd1=elInputPassword.value;
        let pwd2=elInputPasswordCheck.value;

        if(pwd2==false){ 
            Pwdchkfailuremassage.classList.add('d-none');
            Pwdchksuccessmassage.classList.add('d-none');
        }

        else if(pwd1 === pwd2){
            Pwdchkfailuremassage.classList.add('d-none');

            Pwdchksuccessmassage.classList.remove('d-none');
        }
        else{

            Pwdchkfailuremassage.classList.remove('d-none');

            Pwdchksuccessmassage.classList.add('d-none');
        }
    }
		document.getElementById("address_kakao").addEventListener("click", function(){ //주소입력칸을 클릭하면
//       	e.preventDefault();
       	console.log("주소를 찾자!!!!!!!!!!!!!!!!!!!!!!!")
        //카카오 지도 발생
     new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("address").value = data.address; // 주소 넣기
                document.querySelector(".address-detail").focus(); //상세입력 포커싱
            }
        }).open();
    });

        
        
	 
 });


 
