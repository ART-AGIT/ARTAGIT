window.addEventListener("load", function(){
    const modiBtn = this.document.querySelector(".modify-btn");

    const deleteBtn = this.document.querySelector(".delete-btn");
    const modal = this.document.querySelector(".modal");
    const yesBtn = document.querySelector(".yes-btn");
    const detailSection = this.document.querySelector(".exh-detail-section");
    const modiLine = detailSection.querySelectorAll(".content");
    const btnMore = this.document.querySelector(".btn-more");
    const feedContent = this.document.querySelector(".feed-content");
    let id = detailSection.querySelectorAll(".button-box-wrap > input");


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

    //////////// 수정 버튼 눌렀을 때
    modiBtn.onclick = function(e){
        e.preventDefault();

        console.log("수정버튼 클릭");
        btnMore.classList.add('d-none');

        if(modiLine[0].getAttribute('contenteditable') == null){
            for(let i = 0; i<modiLine.length; i++){
                modiLine[i].setAttribute('contenteditable', 'true');
                modiLine[i].classList.add('mody-on');
            }
            
            let startDateTem = `<input type="date" class="item content start-date" data-placeholder="시작일자" required></input>`
            let endDateTem = `<input type="date" class="item content end-date" data-placeholder="종료일자" required></input>`
            let startTimeTem = `<input type="time" class="item content exh-time" data-placeholder="시작시간" required></input>`
            let endTimeTem = `<input type="time" class="item content exh-time" data-placeholder="종료시간" required></input>`
            
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
            modiBtn.classList.replace('modify-btn', 'save-btn');  
            modiBtn.setAttribute('type', 'submit');

            
            if(e.tartget==modiBtn){
                console.log("저장버튼 클릭");
            }
        }
        
    }
    
    id[0].onclick = function(e){
        console.log("저장버튼 클릭");
    }
    // const saveBtn = this.document.querySelector(".save-btn");
    
    // saveBtn.onclick = function(e){
        //     console.log(e.target);
        //     console.log("저장하기 버튼 클릭");            
        //     let exhName = detailSection.querySelector(".exh-name").innerText;
        //     let exhArtist = detailSection.querySelector(".exh-artist").innerText;
        //     let muName = detailSection.querySelector(".museum-name").innerText;
        //     let localName = detailSection.querySelector(".local-name").innerText;
        //     let exhDate = detailSection.querySelector(".exh-date").innerText;
        //     let exhTime = detailSection.querySelector(".exh-time").innerText;
        //     let exhPrice = detailSection.querySelector(".exh-price").innerText;
        //     let corpName = detailSection.querySelector(".corp-name").innerText;
        //     let corpAddr = detailSection.querySelector(".corp-address").innerText;
        //     let corpPhone = detailSection.querySelector(".corp-phone").innerText;
        //     let exhStock = detailSection.querySelector(".exh-stock").innerText;
        //     let corpManager = detailSection.querySelector(".corp-manager").innerText;
        //     let exhContent = detailSection.querySelector(".feed-content").innerText;
    
        //         console.log(id[0].value);
        //     fetch("/corp/exh/update", {
        //             method: "POST",
        //             headers: {
        //                         "Content-Type": "application/json",
        //                     },
        //             body: JSON.stringify( 
        //                 { "exh": {
        //                     "id" : id[0].value,
        //                     "name": exhName,
        //                     "artist": exhArtist,
        //                     "startDate": exhDate,
        //                     "endDate": exhTime,
        //                     "ticketPrice": exhPrice,
        //                     "ticketStock" : exhStock,
        //                     "content" : exhContent
        //                     },
        //                     "corp":{
        //                         "id" : id[1].value,
        //                         "museumName" : muName,
        //                         "name" : corpName,
        //                         "address" : corpAddr,
        //                         "phone" : corpPhone,
        //                         "manager" : corpManager
        //                         },
        //                     "local":{
        //                         "id" : id[2].value,
        //                         "name" : localName
        //                     } 
        //                 }
        //             ),
        //         }).then((response) => console.log(response));
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