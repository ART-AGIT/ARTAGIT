window.addEventListener("load", function(e){
    /*---------- 모바일 버전 ---------- */
    const findPw = document.querySelector(".find-pw");
    const findId = document.querySelector(".find-id");
    const findIdBox = document.querySelector(".find-content-box");
    const findResult = document.querySelector(".find-result");
    const findPwBox = document.querySelector(".find-content-box.find-pw-box");
    
    findPw.onclick = function(e){
        e.preventDefault();
        console.log("hi hi");
        
        findId.classList.remove("select-on");
        findPw.classList.add("select-on");
        findPwBox.classList.remove("d-none");
        findIdBox.classList.add("d-none");
        findResult.classList.add("d-none");
        // findPwBox.classList.add("d-none");
    }

    /*---------- 피씨 버전 ---------- */
    const nameBox = findIdBox.querySelector(".name-input");
    const emailBox = findIdBox.querySelector(".email-input")
    // const idOkBtn = findIdBox.querySelector(".id-btn");
    const okBtn = findIdBox.querySelector(".submit-btn");
    const message = findIdBox.querySelector('.msg');
    console.log(okBtn);

    /*---------- ID 찾기 ---------- */
    okBtn.onclick = function(e){
        e.preventDefault();
        console.log("클릭!");

        let name = nameBox.value;
        let email = emailBox.value;

        // 입력값이 없을 경우 못넘어가게 하기
        if(!name || (!name && !email)){
            nameBox.focus();
            return false; // 아래 코드부터 아무것도 진행하지 말것
        }

        if(!email){
            emailBox.focus();
            return false;
        }

        console.log(`입력한 name: ${name}, email: ${email}`);

        fetch(`findId/${name}/${email}`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify ({
                "name": name,
                "email": email,
            })
        })
        .then((response) => {
				if(response.ok) {
                    console.log("성공");
            		console.log(response);                 
                    return response.text();
                    } else {console.log("실패");}})
        .then((user) => {

            console.log(user);
            
            if (user==="비회원"){
                message.classList.add('caution-msg');
                message.innerText = "존재하지 않는 회원입니다."
            }
            else if(user!=="비회원"){
                let template = `<div class="find-content-box find-result">
                                <div class="mail-img-box">
                                    <img class="mail-img" src="/image/idresult.png">
                                </div>
                                <div class="text-box result-text-box">
                                    <span class="md-text"><span class="user-email">${name}</span>님의 아이디는 <span class="user-email">${user}</span> 입니다.</span>
                                </div>
                    
                                <div class="result-btn-box">
                                    <a class="btn btn-default-line find-pw-btn  whtie-btn" href="find-pw">비밀번호 찾기</a>
                                    <a class="btn btn-default-fill login-btn" href="login">로그인</a>
                                </div>
                            </div>`
                
                let el = new DOMParser()
                        .parseFromString(template, "text/html")
                        .body
                        .firstElementChild; 

                document.querySelector(".flow-btn-box").classList.add("d-none");
                findIdBox.innerHTML='';
                findIdBox.append(el);
            } 
    })
    .catch(err => {
        console.log(err);
        alert("일시적인 오류가 발생되었습니다. 다시 시도해주세요.")})
    }
});