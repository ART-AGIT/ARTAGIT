window.addEventListener("load", function(){
    const modiBtn = this.document.querySelector(".modify-btn");

    const deleteBtn = this.document.querySelector(".delete-btn");
    const modal = this.document.querySelector(".modal");
    const yesBtn = document.querySelector(".yes-btn");
    const detailSection = this.document.querySelector(".exh-content-container");
    const modiLine = detailSection.querySelectorAll(".content");
    
    const btnMore = this.document.querySelector(".btn-more");
    const feedContent = this.document.querySelector(".feed-content");
    
    let id = document.querySelectorAll(".button-box-wrap input");


    //////////// 더보기/접기 버튼 눌렀을 때
    btnMore.onclick = function(e){
        e.preventDefault();

        if(feedContent.classList.contains("hidden")) {
            feedContent.classList.remove("hidden");
            this.innerHTML ="접기";
        } else if(!feedContent.classList.contains("hidden")) {
            feedContent.classList.add("hidden");
            this.innerHTML ="더보기";
        }
    };

    //////////// 삭제 버튼 눌렀을 때
    deleteBtn.onclick = function(e){
        e.preventDefault();

        if(e.target.classList.contains("delete-btn")){
            console.log("삭제버튼 클릭");
            
            modal.classList.remove("d-none");
            document.body.classList.add("stop-scroll");
        }
};


	let check = false; // 수정 버튼 상태값
	
    //////////// 수정 버튼 눌렀을 때
    modiBtn.onclick = function(e){
        e.preventDefault();

		if(!check){

        console.log("수정버튼 클릭");
        btnMore.classList.add('d-none');
        
        // 각 항목들에 contenteditable (편집모드) 속성을 추가해준다. 
        if(modiLine[0].getAttribute('contenteditable') == null){
            for(let i = 0; i<modiLine.length; i++){
                modiLine[i].setAttribute('contenteditable', 'true');
                modiLine[i].classList.add('mody-on'); // 수정모드 의미를 가진 클래스 추가
            }
            let date = detailSection.querySelector('.start-date').innerText;
            let time = detailSection.querySelector('.start-time').innerText;
            let startD = date.substring(0, 10);
            let endD = date.substring(13, 23);
            let startT = time.substring(0, 5);
            let endT = time.substring(8, 13);

            console.log(date);
            console.log(startD);
            console.log(endD);
            console.log(startT);
            console.log(endT);
            // let end = detailSection.querySelector('.end-date').innerText;
            
            let startDateTem = `<input type="date" class="item content start-date-input" style="font-weight: normal" value="${startD}" required pattern="\d{4}-\d{2}-\d{2}"><span>~</span>`
            let endDateTem = `<input type="date" class="item content end-date-input" value="${endD}" required pattern="\d{4}-\d{2}-\d{2}"></input>`
            let startTimeTem = `<input type="time" class="item content start-time-input" style="font-weight: normal" value="${startT}" data-placeholder="시작시간" required></input><span>~</span>`
            let endTimeTem = `<input type="time" class="item content end-time-input" value="${endT}" data-placeholder="종료시간" required></input>`
            
            let el = new DOMParser() // string으로 된 HTML 태그들을 DOM 객체로 변환해준다.
            .parseFromString(startDateTem, "text/html") // 어떤 문자열(1st param)을 어떠한 형식(2nd param)으로 변환할건지.
            .body
            .firstElementChild;

            let el2 = new DOMParser() 
            .parseFromString(endDateTem, "text/html")
            .body
            .firstElementChild;

            let el3 = new DOMParser() 
            .parseFromString(startTimeTem, "text/html")
            .body
            .firstElementChild;

            let el4 = new DOMParser() 
            .parseFromString(endTimeTem, "text/html")
            .body
            .firstElementChild;
			
			
            
            detailSection.querySelector('.start-date').innerHTML='';
            // detailSection.querySelector('.end-date').innerHTML='';
            detailSection.querySelector('.start-time').innerHTML='';
            // detailSection.querySelector('.end-time').innerHTML='';
            detailSection.querySelector('.start-date').append(el, '~', el2);
            // detailSection.querySelector('.start-date').append(el2);
            detailSection.querySelector('.start-time').append(el3, '~', el4);
            // detailSection.querySelector('.end-time').append(el4);
			
//			detailSection.querySelector('.start-date-input').setAttribute('data-placeholder', detailSection.querySelector('.start-date').innerText);
            modiBtn.innerText = '저장';
            
            check = true;
		}
        }else{
			console.log("저장하기 버튼 클릭");            
        let exhName = detailSection.querySelector(".exh-name").innerText;
        let exhArtist = detailSection.querySelector(".exh-artist").innerText;
        let muName = detailSection.querySelector(".museum-name").innerText;
        let localName = detailSection.querySelector(".local-name").innerText;
        let startDate = detailSection.querySelector(".start-date-input").value;
        let endDate = detailSection.querySelector(".end-date-input").value;
        let startTime = detailSection.querySelector(".start-time-input").value;
        let endTime = detailSection.querySelector(".end-time-input").value;
        let exhPrice = detailSection.querySelector(".exh-price").innerText;
        let corpName = detailSection.querySelector(".corp-name").innerText;
        let corpAddr = detailSection.querySelector(".corp-address").innerText;
        let corpPhone = detailSection.querySelector(".corp-phone").innerText;
        let exhStock = detailSection.querySelector(".exh-stock").innerText;
        let corpManager = detailSection.querySelector(".corp-manager").innerText;
        let exhContent = detailSection.querySelector(".feed-content").innerText;
        let exhURL = detailSection.querySelector(".exh-url").innerText;

            console.log(startDate);
        fetch("/corp/exh/update", {
                method: "POST",
                headers: {
                            "Content-Type": "application/json",
                        },
                body: JSON.stringify( 
                    { "exh": {
                        "id" : id[0].value,
                        "name": exhName,
                        "artist": exhArtist,
                        "startDate": startDate,
                        "endDate": endDate,
                        "startTime": startTime,
                        "endTime": endTime,
                        "ticketPrice": exhPrice,
                        "ticketStock" : exhStock,
                        "content" : exhContent,
                        "homepage" : exhURL
                        },
                        "corp":{
                            "id" : id[1].value,
                            "museumName" : muName,
                            "name" : corpName,
                            "address" : corpAddr,
                            "phone" : corpPhone,
                            "manager" : corpManager
                            },
                        "local":{
                            "id" : id[2].value,
                            "name" : localName
                        } 
                    }
                ),
            })
            .then((response) => {
				if(response.ok) {
				console.log("성공");
				return response;
				} else {console.log("실패")}})
//            .then(location.href='/corp/exh/'+id[0].value);
            .then(location.reload());
		}
    }
    

    // }


	// yesBtn.onclick = function(e){
	//     let id = e.target.dataset.id;
	//     console.log("id========>" + id);
	//     console.log(e.target);

    //         // if(e.target.classList.contains(".yes-btn")){
    //             e.preventDefault();
    //             // console.log(e.target);

    //             fetch(`/api/delete/${id}`, {
    //                 method: "DELETE" // delete 라는 메서드를 보낸다.
    //             })
    //             .then(resp => resp.json())
    //             .then(data => {
    //                 console.log(data.resultObject);
    //                 let result = data.resultObject;

	// 				console.log(result);
    //                 if(result == 1){
							
	// 						modal.classList.add("d-none");
							
    //                         let modal2 = `
    //                                     <div class="modal">
    //                                         <div class="modal-header">
    //                                             <h1 class="header-title">정상적으로 삭제되었습니다.</h1>
    //                                         </div>
    //                                         <div class="modal-actions">
    //                                             <a class="modal-action" href="">확인</a>
    //                                         </div>
    //                                     </div>
    //                                     `
    //                     detailSection.insertAdjacentHTML("beforeend", modal2);
    //                     // document.body.classList.add("stop-scroll");
    //                 }
    //             })
    //             .then(location.href="/corp/exh/list");
    //     };
});