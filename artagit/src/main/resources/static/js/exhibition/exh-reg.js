window.addEventListener("load", function() {
	
	const btnNextP1 = document.querySelector("#first-page-next .exh-reg-button-box a");
 	const btnBeforeP2 =	document.querySelector(".exh-reg-button-box .x a");
 	const btnNextP2 =	document.querySelector(".exh-reg-button-box .y a");
 	const btnBeforeP3 = document.querySelector(".exh-reg-button-box .z a");
 	const reg = document.querySelector(".exh-reg-button-box button");
 
 btnNextP1.onclick = function(e){
	 e.preventDefault();
	 const nextP1 = e.target;
 }

 btnBeforeP2.onclick = function(e){
	 e.preventDefault();
	 const beforeP2 = e.target;
 }
 btnNextP2.onclick = function(e){
	 e.preventDefault();
	 const nextP2 = e.target;
 }
 btnBeforeP3.onclick = function(e){
	 e.preventDefault();
	 const beforeP3 = e.target;
 }
  reg.onclick = function(e){
	 e.preventDefault();
	 const nextP3 = e.target;
 }
 	
 	
 let li =nextP1;
	if (nextP1.tagName == "A")
		li = nextP1.parentElement;

	li.classList.add("menu-selected");
	//console.log(e.target.tagName);
	currentLi.classList.remove("menu-selected");
 
 
 let template =`
<div class="info d-none">
            <div class="step">

                <div class="circle">
                    <div class="circle1">1</div>
                    <div>기본정보</div>
                </div>

                <div class="circle">
                    <div class="circle1 circle-off">2</div>
                    <div>상세정보</div>
                </div>

                <div class="circle">
                    <div class="circle1 circle-off">3</div>
                    <div>전시설명</div>
                </div>

            </div>

            <section class="reg-list">

                <div class="reg-list-input-box">
                    <label for="">전시명</label>
                    <input name="name" type="text" class="input input-lg">
                </div>
                <div class="reg-list-input-box">
                    <label for="">작가</label>
                    <input name="artist" type="text" class="input input-lg">
                </div>
                <div class="reg-list-input-box">
                    <label for="">전시장소</label>
                    <input name="" type="text" class="input input-lg">
                </div>
                <div class="reg-list-input-box">
                    <label for="">지역상세</label>
                    <input name="address" type="search" class="input input-lg">
                </div>
                <div class="reg-list-input-box">
                    <label for="">전시기간</label>
                    <div>
                        <div class="exhibition-input-date">
                            <input name="startDate" type="date" class="input input-sm">
                            <!-- <a class="icon icon-calendar" href="">달력</a> -->
                        </div>
                        <span>~</span>
                        <div class="exhibition-input-date">
                            <input name="endDate" type="date" class="input input-sm">
                            <!-- <a class="icon icon-calendar" href="">달력</a> -->
                        </div>
                    </div>
                </div>
                <div class="reg-list-input-box">
                    <label for="">관람시간</label>
                    <div>
                        <input name="startTime" type="time" class="input input-sm">
                        <span>~</span>
                        <input name="endTime" type="time" class="input input-sm">
                    </div>
                </div>
                <div class="price-count">
                    <div class="reg-list-input-box">
                        <label for="">관람료</label>
                        <div>
                            <input name="ticketPrice" type="number" class="input input-md-3">
                            <span>(단위: 원)</span>
                        </div>
                    </div>
                    <div class="reg-list-input-box">
                        <label for="">재고</label>
                        <div>
                            <input name="ticketStock" type="number" class="input input-md-3" placeholder="(무제한: 9999장)">
                            <span>(단위: 장)</span>
                        </div>
                    </div>
                </div>
            </section>

            <span id="first-page-next">
                <div class="exh-reg-button-box">
                    <a type="submit" class="btn-next" href="../../corporator/mypage/exh-reg.html"></a>
                </div>
            </span>

	</div>`
	}
	