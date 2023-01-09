window.addEventListener("load", function(){

    const box = document.querySelector(".value-check-box");
    let input = box.querySelectorAll("input");
    let btn = box.querySelector("button");
    let span = box.querySelector("span");
    
    // 아이디 정규식
    const elInputLoginId = this.document.querySelector("#login-id");
    const chkLoginId = this.document.querySelector(".id-check-massage");
    const elIdfailuremassage = this.document.querySelector(".idFialure-message");
    const elIdsuccessmassage = this.document.querySelector(".idSuccess-message");

    // 비밀번호 일치 확인 및 정규식
    let elInputPassword = this.document.querySelector("#password");
    let elInputPasswordCheck = this.document.querySelector("#password-check");

    let Pwdfailuremassage = this.document.querySelector(".passwordFialure-message");
    let Pwdsuccessmassage = this.document.querySelector(".passwordSuccess-message");
    let Pwdchkfailuremassage = this.document.querySelector(".chkFialure-message");
    let Pwdchksuccessmassage = this.document.querySelector(".chkSuccess-message");




    // input에 값 입력시 버튼색 바뀜
    elInputLoginId.onkeyup = function(){

        // console.log(input)s
        var regExpId = /^[a-z0-9_]{8,16}$/
       

        if(elInputLoginId.value==false){ 
            elIdfailuremassage.classList.add('d-none');
            elIdsuccessmassage.classList.add('d-none');
        }

        else if(regExpId.test(elInputLoginId.value)==true){
            elIdfailuremassage.classList.add('d-none');

            elIdsuccessmassage.classList.remove('d-none');
            
        }
        else {
            elIdfailuremassage.classList.remove('d-none');
    
            elIdsuccessmassage.classList.add('d-none');
        }
        console.log(elInputLoginId.value);

         // 아이디 중복확인
         fetch(`/userApi/signup/id-check/${elInputLoginId.value}`)
         .then(resp=>resp.json())
         .then(data=>{
                 console.log(data)
                 //결과가 1이면 중복
                 if(data.resultObject == 1){
                     chkLoginId.classList.remove('d-none');
					 elIdsuccessmassage.classList.add('d-none');
				 }
				 //나머진 사용가능
				 else{
					 chkLoginId.classList.add('d-none');
				 }

             })

    };

    // 비빌번호 정규식
    elInputPassword.onkeyup = function(){
        var regExpPwd = /^(?=.*[a-z])(?=.*\d)(?=.*[~!@#$%^&*()+|=])[a-z\d~!@#$%^&*()+|=]{8,16}$/

        
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




});







 //if(elInputPassword.value == elInputPasswordCheck.value)