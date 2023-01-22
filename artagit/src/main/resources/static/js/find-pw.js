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
    const idBox = findPwBox.querySelector(".id-input");
    const emailBox = findPwBox.querySelector(".email-input")
    const idOkBtn = findIdBox.querySelector(".id-btn");
    const okBtn = findPwBox.querySelector(".submit-btn");
    const message = findPwBox.querySelector('.msg');
    console.log(okBtn);

    /*---------- PW 찾기 ---------- */
    okBtn.onclick = function(e){
        e.preventDefault();
        let id = idBox.value;
        let email = emailBox.value;

        // 입력값이 없을 경우 못넘어가게 하기
        if(!id || (!id && !email)){
            idBox.focus();
            return false; // 아래 코드부터 아무것도 진행하지 말것
        }

        if(!email){
            emailBox.focus();
            return false;
        }
        
        console.log('클릭!');
        console.log(`입력한 id: ${id}, email: ${email}`);
    
        fetch(`sendEmail/${id}/${email}`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify ({
                "loginId": id,
                "email": email,
            })
        })
        .then(res => res.json())
        .then(data => {
            console.log(data);
            // let result = data.resultObject;

            if(data == 1){
                let template = `<div class="find-content-box find-result">
                                <div class="mail-img-box">
                                    <img class="mail-img" src="/image/mail.png">
                                </div>
                                <div class="text-box result-text-box">
                                    <span class="md-text">임시비밀번호가 <span class="user-email">${email}</span> 로 발송되었습니다.</span>
                                    <span class="text md-2-text">로그인 후 새로운 비밀번호로 변경해 주시기 바랍니다.</span>
                                </div>
                    
                                <div class="result-btn-box">
                                    <a class="btn btn-default-line home-btn" href="/">홈으로 이동</a>
                                    <a class="btn btn-default-fill login-btn" href="login">로그인</a>
                                </div>
                            </div>`

                let el = new DOMParser()
                        .parseFromString(template, "text/html")
                        .body
                        .firstElementChild; 
                
                document.querySelector(".flow-btn-box").classList.add("d-none");
                findPwBox.innerHTML='';
                findPwBox.append(el);
            }
            else if(data == 2){
                message.classList.add('caution-msg');
                message.innerText = "이메일이 올바르지 않습니다."
            }
            else if(data == 0){
                message.classList.add('caution-msg');
                message.innerText = "존재하지 않는 ID 입니다."				
			}
        })
        .catch(err => {
            alert("일시적인 오류가 발생되었습니다. 다시 시도해주세요.")})
    }

});