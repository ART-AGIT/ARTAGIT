window.addEventListener("load",function(){

	//  아코디언 =======================================
	const btnHeader = this.document.querySelectorAll(".accordion-header");
	const btnToggle = this.document.querySelectorAll(".toggle");
	const btnIcon = document.querySelectorAll(".arrow-icon");

    const regListBox = this.document.querySelectorAll(".reg-list-box");
    // let currentEl = this.document.querySelector(".d-none");
    let contents = this.document.querySelectorAll(".accordion-content");
    // const form = this.document.querySelector("form");
    const regList = this.document.querySelector(".reg-list");
	const icon = this.document.querySelectorAll(".arrow-icon");

    const chkId = this.document.querySelector(".loginId");
    
    // 비밀번호 유효성 및 정규식
 	let elInputPassword = this.document.querySelector("#password");
    let elInputPasswordCheck = this.document.querySelector("#password-check");

    let Pwdfailuremassage = this.document.querySelector(".passwordFialure-message");
    let Pwdsuccessmassage = this.document.querySelector(".passwordSuccess-message");
    let Pwdchkfailuremassage = this.document.querySelector(".chkFialure-message");
    let Pwdchksuccessmassage = this.document.querySelector(".chkSuccess-message");
    
    // 아이디 유효성, 중복확인
    const elInputLoginId = this.document.querySelector("#login-id");
    const chkLoginId = this.document.querySelector(".id-check-massage");
    const elIdfailuremassage = this.document.querySelector(".idFialure-message");
    const elIdsuccessmassage = this.document.querySelector(".idSuccess-message");
    
    // 가입 버튼
    const btnSignup = document.querySelector(".btn-signup");

	// 아이디, 비번 유효성 - 가입 막기
	let idReg = true;
	let idChk = true;
	let pwdReg = true;
	let pwdChk = true;
	
	btnSignup.onclick = function(e){
		if(pwdReg == false || pwdChk == false || idReg ==false || idChk==false){
			e.preventDefault();
			alert("아이디 또는 비밀번호가 올바르지 않습니다.");
		
		}
	}
    
	// 토글
    regList.onclick = function(e){
//            e.preventDefault();
			console.log(e.target.className);
            var isHeader = e.target.classList.contains("accordion-header")
//                            ||e.target.classList.contains("accordion")
                            ||e.target.classList.contains("toggle")
                            ||e.target.classList.contains("icon")
                            ||e.target.classList.contains("btn-signup");
           
            if(!isHeader)
                return;

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
            													|| e.target == btnIcon[0])) {
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
            pwdReg = true;
        }
        else {
            Pwdfailuremassage.classList.remove('d-none');
    
            Pwdsuccessmassage.classList.add('d-none');
            pwdReg = false;
        }

    };
    
    //아이디 유효성 및 정규식, 중복 확인
    elInputLoginId.oninput = function(){

        // console.log(input)s
        var regExpId = /^[a-z0-9_]{8,16}$/
       

        if(elInputLoginId.value==false){ 
            elIdfailuremassage.classList.add('d-none');
            elIdsuccessmassage.classList.add('d-none');
        }

        else if(regExpId.test(elInputLoginId.value)==true){
            elIdfailuremassage.classList.add('d-none');

            elIdsuccessmassage.classList.remove('d-none');
            idReg = true;
            
        }
        else {
            elIdfailuremassage.classList.remove('d-none');
    
            elIdsuccessmassage.classList.add('d-none');
            idReg = false;
        }
        console.log("값을 찍어 보자"+elInputLoginId.value);

         // 아이디 중복확인
         if(elInputLoginId.value != ''){
		
         fetch(`/corpApi/signup/id-check/${elInputLoginId.value}`)
         .then(resp=>resp.json())
         .then(data=>{
                 console.log(data)
                 //결과가 1이면 중복
                 if(data.resultObject == 1){
                     chkLoginId.classList.remove('d-none');
					 elIdsuccessmassage.classList.add('d-none');
					 idChk=false;
				 }
				 //나머진 사용가능
				 else{
					 chkLoginId.classList.add('d-none');
					 idChk = true;
				 }

             })
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
            pwdChk = true;
        }
        else{

            Pwdchkfailuremassage.classList.remove('d-none');

            Pwdchksuccessmassage.classList.add('d-none');
            pwdChk = false;
        }
    }
 
 	// 주소 입력
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


 
