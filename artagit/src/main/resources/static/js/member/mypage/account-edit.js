window.addEventListener("load",function(){
	//	member img넣기
	 const imgInput = document.querySelector(".img-input");
	 const fileInput = document.querySelector(".file-input");
	console.log(fileInput)
	//비밀번호 일치확인
	let elInputPassword = this.document.querySelector("#password");
    let elInputPasswordCheck = this.document.querySelector("#password-check");
    
     let Pwdchkfailuremassage = this.document.querySelector(".chkFialure-message");
    let Pwdchksuccessmassage = this.document.querySelector(".chkSuccess-message");
	
	//  img 수정
	 imgInput.onclick = function(e){
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


 
