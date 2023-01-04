window.addEventListener("load", function(){
    const deleteBtn = this.document.querySelector(".delete-btn");
    const modal = this.document.querySelector(".modal");
    const yesBtn = document.querySelector(".yes-btn");
    const detailSection = this.document.querySelector(".exh-detail-section");

    deleteBtn.onclick = function(e){

        e.preventDefault();

        if(e.target.classList.contains("delete-btn")){
                // return;

        console.log("삭제버튼 클릭");
        
        modal.classList.remove("d-none");
        document.body.classList.add("stop-scroll");
    }
};


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
                .then();
            // } 
            // else if (e.target.classList.contains("no-btn")){
            //     // modal.remove();
            //     modal.classList.add("d-none");				
			// }

        };
});