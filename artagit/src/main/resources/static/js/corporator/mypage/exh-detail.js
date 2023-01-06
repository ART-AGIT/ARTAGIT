window.addEventListener("load", function(){
    const modiBtn = this.document.querySelector(".modify-btn");
    const deleteBtn = this.document.querySelector(".delete-btn");
    const modal = this.document.querySelector(".modal");
    const yesBtn = document.querySelector(".yes-btn");
    // const modiPart = this.document.querySelector(".exh-detail-table");
    const detailSection = this.document.querySelector(".exh-detail-section");
    const modiLine = detailSection.querySelectorAll(".content");
    const btnMore = this.document.querySelector(".btn-more");
    const feedContent = this.document.querySelector(".feed-content");

    btnMore.onclick = function(e){
        e.preventDefault();

        if(feedContent.classList.contains("hidden")){
            feedContent.classList.remove("hidden");
            this.innerHTML ="접기";
        }

        else if(!feedContent.classList.contains("hidden")){
            feedContent.classList.add("hidden");
            this.innerHTML ="더보기";
        }

    };

    // const moreBtn = detailSection.querySelector(".viewmore");

    deleteBtn.onclick = function(e){

        e.preventDefault();

        if(e.target.classList.contains("delete-btn")){
                // return;

        console.log("삭제버튼 클릭");
        
        modal.classList.remove("d-none");
        document.body.classList.add("stop-scroll");
    }
};
    console.log(modiBtn);


    modiBtn.onclick = function(e){
        
        e.preventDefault();

        console.log("수정버튼 클릭");
    if(modiLine[0].getAttribute('contenteditable') == null){
        console.log("hihi");
        for(let i = 0; i<modiLine.length; i++){
            modiLine[i].setAttribute('contenteditable', 'true');
            modiLine[i].classList.add('mody-on');
        }

        let startDateTem = `<input type="date" class="item content start-date" data-placeholder="시작일자" required></input>`
        let endDateTem = `<input type="date" class="item content end-date" data-placeholder="종료일자" required></input>`
        let startTimeTem = `<input type="time" class="item content exh-time" data-placeholder="시작시간" required></input>`
        let endTimeTem = `<input type="time" class="item content exh-time" data-placeholder="종료시간" required></input>`

        // let template = `<input type="date" class="item content exh-date" data-placeholder="시작일자" required></input>
        //                         <span>~</span>
        //                         <input type="date" class="item content exh-date" data-placeholder="종료일자" required></input>`
        // let template2 = `<input type="time" class="item content exh-time" data-placeholder="시작시간" required></input>
        //                 <span>~</span>
        //                 <input type="time" class="item content exh-time" data-placeholder="종료시간" required></input>`
        
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

        document.querySelector('.start-date').innerHTML='';
        document.querySelector('.end-date').innerHTML='';
        document.querySelector('.start-time').innerHTML='';
        document.querySelector('.end-time').innerHTML='';
        document.querySelector('.start-date').append(el);
        document.querySelector('.end-date').append(el2);
        document.querySelector('.start-time').append(el3);
        document.querySelector('.end-time').append(el4);

        modiBtn.innerText = '저장';
        btnMore.classList.add("hidden");

        let exhName = detailSection.querySelector(".exh-name").innerText;
        let exhArtist = detailSection.querySelector(".exh-artist").innerText;
        let muName = detailSection.querySelector(".museum-name").innerText;
        let localName = detailSection.querySelector(".local-name").innerText;
        let exhDate = detailSection.querySelector(".exh-date").innerText;
        let exhTime = detailSection.querySelector(".exh-time").innerText;
        let exhPrice = detailSection.querySelector(".exh-price").innerText;
        let corpName = detailSection.querySelector(".corp-name").innerText;
        let corpAddr = detailSection.querySelector(".corp-address").innerText;
        let corpPhone = detailSection.querySelector(".corp-phone").innerText;
        let exhStock = detailSection.querySelector(".exh-stock").innerText;
        let corpManager = detailSection.querySelector(".corp-manager").innerText;
        let exhContent = detailSection.querySelector(".feed-content").innerText;


          fetch("/corp/exh/update", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify( 
               { "exh": {
                    "name": exhName,
                    "artist": exhArtist,
                    "startDate": exhDate,
                    "endDate": exhTime,
                    "ticketPrice": exhPrice,
                    "ticketStock" : exhStock,
                    "content" : exhContent
                },
                "corp":{
                    "museumName" : muName,
                    "name" : corpName,
                    "address" : corpAddr,
                    "phone" : corpPhone,
                    "manager" : corpManager
                },
                "local":{
                    "name" : localName
                } 
            }
              ),
            }).then((response) => console.log(response));
    }
    }

    // else{
    //     console.log("contenteditable 이 true이다.");

    //     let 
    // }




            // 파일 및 데이터를 전송 가능하게 해주는 객체인 formData 생성
            // let formData = new FormData();

            // // 사용자가 입력한 값
            // let dataField = document.querySelector

            // // 텍스트 데이터
            // formData.append('exh.name', '')
        // }


    // }

    // if(e.target.classList.contains())

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