window.addEventListener("load", function(){
    const modiBtn = this.document.querySelector(".update-btn");
    const deleteBtn = this.document.querySelector(".delete-btn");
    const modal = this.document.querySelector(".modal");
    const yesBtn = document.querySelector(".yes-btn");
    // const modiPart = this.document.querySelector(".exh-detail-table");
    const detailSection = this.document.querySelector(".exh-detail-section");
    const modiLine = detailSection.querySelectorAll(".content");

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
        // e.preventDefault();

    //     console.log("수정버튼 클릭");
    // if(modiLine[0].getAttribute('contenteditable') == null){
    //     console.log("hihi");
        for(let i = 0; i<modiLine.length; i++){
            modiLine[i].setAttribute('contenteditable', 'true');
            modiLine[i].classList.add('mody-on');
        }
        modiBtn.innerText = '저장';

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
        let exhContent = detailSection.querySelector(".exh-content").innerText;
        console.log(exhName);
        console.log(muName);
        console.log(localName);
        console.log(exhDate);
        console.log(exhTime);
        console.log(exhPrice);
        console.log(corpName);
        console.log(corpAddr);
        console.log(corpPhone);
        console.log(exhStock);
        console.log(corpManager);
        console.log(exhContent);

        {
            // // exhibition
            // "name": exhName,
            // "artist": exhArtist,
            // "startDate": exhDate,
            // "endDate": exhDate,
            // "ticketPrice": exhPrice,
            // "ticketStock" : exhStock,
            // "content" : exhContent,

            // // corporate
            // "museumName" : muName,
            // "name" : corpName,
            // "address" : corpAddr,
            // "phone" : corpPhone,
            // "manager" : corpManager
            
            // // local
            // "name" : localName,

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

    if(e.target.classList.contains())

	yesBtn.onclick = function(e){
	    let id = e.target.dataset.id;
	    console.log("id========>" + id);
	    console.log(e.target);

            // if(e.target.classList.contains(".yes-btn")){
                e.preventDefault();
                // console.log(e.target);

                fetch(`/api/delete/${id}`, {
                    method: "DELETE" // delete 라는 메서드를 보낸다.
                })
                .then(resp => resp.json())
                .then(data => {
                    console.log(data.resultObject);
                    let result = data.resultObject;

					console.log(result);
                    if(result == 1){
							
							modal.classList.add("d-none");
							
                            let modal2 = `
                                        <div class="modal">
                                            <div class="modal-header">
                                                <h1 class="header-title">정상적으로 삭제되었습니다.</h1>
                                            </div>
                                            <div class="modal-actions">
                                                <a class="modal-action" href="">확인</a>
                                            </div>
                                        </div>
                                        `
                        detailSection.insertAdjacentHTML("beforeend", modal2);
                        // document.body.classList.add("stop-scroll");
                    }
                })
                .then(location.href="/corp/exh/list");

            // } 
            // else if (e.target.classList.contains("no-btn")){
            //     // modal.remove();
            //     modal.classList.add("d-none");				
			// }

        };


    
});