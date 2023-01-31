window.addEventListener("load",function(){
	//	member img넣기
	const imgInput = document.querySelector(".img-input");
	const fileInput = document.querySelector(".file-input");
	//비밀번호 일치확인
	let elInputPassword = this.document.querySelector("#password");
    let elInputPasswordCheck = this.document.querySelector("#password-check");

    let Pwdfailuremassage = this.document.querySelector(".passwordFialure-message");
    let Pwdsuccessmassage = this.document.querySelector(".passwordSuccess-message");
	let Pwdchkfailuremassage = this.document.querySelector(".chkFialure-message");
    let Pwdchksuccessmassage = this.document.querySelector(".chkSuccess-message");
	
	// 회원탈퇴 modal
	const unregistermodal = document.querySelector(".modalunregister");
	const unregBtn = this.document.querySelector(".btn-unregister");
	const unregistercancelBtn = this.document.querySelector(".unregister-cancel-btn");
	const modal = this.document.querySelector(".modal-overlay");
	//회원수정 modal
	const editmodal = document.querySelector(".modaledit");
	const saveBtn = this.document.querySelector(".save-btn");
	const okBtn = this.document.querySelector(".ok-btn");
	const editcancelBtn = this.document.querySelector(".edit-cancel-btn");
	
	//회원수정
	saveBtn.onclick = function(e){
		editmodal.style.display="flex";
		e.preventDefault();
	}

	editcancelBtn.onclick = function(e){
		e.preventDefault();
		
		//if(e.target.classList.contains("cancel-btn"))
		editmodal.style.display="none";
	}
	
	// 회원 탈퇴
	unregBtn.onclick = function(e){
		e.preventDefault();
		console.log("회원탈퇴")
		unregistermodal.style.display="flex";
	}

	unregistercancelBtn.onclick = function(e){
		e.preventDefault();
		
		//if(e.target.classList.contains("cancel-btn"))
		unregistermodal.style.display="none";
	}
	
	
	
	
	//  img 수정
	imgInput.onclick = function(e){
		 console.log("fileInput")
		 e.preventDefault();
		 let event = new MouseEvent("click",{
			'view':window,
         	'bubbles':true,
         	'cancelable':true
			 
		 })
		 fileInput.dispatchEvent(event);
		 
	 }
	 
	 fileInput.oninput = function(e){
		 
		 let url = fileInput.files[0];
		 let reader = new FileReader();
		 reader.onload = (evt) =>{
			 imgInput.src = evt.target.result;
		 };
		 reader.readAsDataURL(url)
	 }
 // 비밀번호 정규식-숫자와 문자 포함 형태의 8~12자리 이내의 암호 정규식
	//  elInputPassword.onkeyup = function(){
    //     var regExpPwd = /^[A-Za-z0-9]{8,12}$/;

        
    //     if(elInputPassword.value==false){ 
    //         Pwdfailuremassage.classList.add('d-none');
    //         Pwdsuccessmassage.classList.add('d-none');
    //     }

    //     else if(regExpPwd.test(elInputPassword.value)==true){
    //         Pwdfailuremassage.classList.add('d-none');

    //         Pwdsuccessmassage.classList.remove('d-none');
            
    //     }
    //     else {
    //         Pwdfailuremassage.classList.remove('d-none');
    
    //         Pwdsuccessmassage.classList.add('d-none');
    //     }

    // };

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
	 
 });


 
