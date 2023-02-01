window.addEventListener("load", function(e){
	const exhBox = document.querySelector(".exhibition-list");
    const optionMenuList = document.querySelector(".exh-menu-list");

    const selectBtnOne = document.querySelector(".select-btn-1");
    const selectBtnTwo = document.querySelector(".select-btn-2");
    const selectBtnThree = document.querySelector(".select-btn-3");

    const selectBtnTextOne = document.querySelector(".select-btn-1-text");
    const selectBtnTextTwo = document.querySelector(".select-btn-2-text");
    const selectBtnTextThree = document.querySelector(".select-btn-3-text");

    const optionsOne = document.querySelectorAll(".option-1");
    const optionsTwo = document.querySelectorAll(".option-2");
    const optionsThree = document.querySelectorAll(".option-3");

    let current = document.querySelector(".active");
    let queryString;
    let page = 2;
 	let isEndPage = true;
 	
    const exhSection = document.querySelector(".exhibition-section");

// ------------ 좋아요 누르기 --------------------------------------------
    exhSection.onclick = function(e){
		
		console.log("click")
        if(e.target.classList.contains("exhibition-heart") && !e.target.classList.contains("icon-heart-red")){
            e.preventDefault();

			e.target.classList.add("icon-heart-red");
            let el = null;

            for(el=e.target; el.tagName!="SECTION"; el=el.parentElement);
            
            let id = el.dataset.id;
            
            console.log(id);
			
			fetch(`/api/like/${id}`,{
				method:"PUT"
			})
			.then(response => response.json())
			.then(data => {
				console.log(data.status)
				if(data.status == '405'){
					window.alert("일반회원만 가능합니다.")
					location.reload();		
				}
				if(data.status == '500'){
					window.alert("로그인을 해주세요.")
					location.replace("/user/login")	
				}
				
			})
            


        }
	    else if(e.target.classList.contains("exhibition-heart") && e.target.classList.contains("icon-heart-red")){
				e.preventDefault();
				
				e.target.classList.remove("icon-heart-red");
	            
				console.log("삭제")
				
	            let el = null;

	            for(el=e.target; el.tagName!="SECTION"; el=el.parentElement);
	            
	            let id = el.dataset.id;
	            
	            console.log(id);
				
				fetch(`/api/like/${id}`,{
					method:"DELETE"
				})
				.then(response => response.json())
				.then(data => {
					if(data.status == '500')
						window.alert("로그인하소")
					console.log(data.status);
				})
			
			}
    }

// ------------ 무한 스크롤 누르기 --------------------------------------------
	window.addEventListener("scroll", function(){
        //scrollHeight : 전체 스크롤
        //scrollTop : 스크롤 윗부분
        //clientHeight : 컨텐츠가 보이는 높이

      	let paddingOfBottom = 100;
        let scrollHeight = document.documentElement.scrollHeight
        let scrollTop = document.documentElement.scrollTop;
        let scrollClientHeight = document.documentElement.clientHeight;

       
        
        if (scrollHeight - scrollTop - paddingOfBottom <= scrollClientHeight && isEndPage){
            queryString = `?p=${page}&l=${selectBtnOne.dataset.id}&s=${selectBtnTwo.dataset.id}&c=${selectBtnThree.dataset.id}`;
            if(queryString == 0)
                queryString="";
            console.log(queryString);
            fetch(`/api/lists${queryString}`)
            .then((response)=>response.json())
            .then((list)=>{
                if(list.length == 0){
                	isEndPage = false;
					return;					
				}
                isEndPage = true;
                for(let e of list){

					if(e.memberId == 0){
                    var template = `
                        <section data-id="${e.id}" class="exhibition">
                            <form action="">
                                <h1>${e.name}</h1>
                                <div class="exhibition-img-box">
                                    <a href="${e.id}"><img class="exhibition-img" src="/image/poster/${e.poster}" alt=""></a>
                                    <a class="icon icon-heart exhibition-heart" href=""></a>
                                </div>
                                <div class="exhibititon-date">${e.startDate} ~ ${e.endDate}</div>
                                <div class="exhibition-place">${e.artist}</div>
                            </form>
                        </section>
                    `
						
					}
					else {
	                    var template = `
	                        <section data-id="${e.id}" class="exhibition">
	                            <form action="">
	                                <h1>${e.name}</h1>
	                                <div class="exhibition-img-box">
	                                    <a href="${e.id}"><img class="exhibition-img" src="/image/poster/${e.poster}" alt=""></a>
	                                    <a class="icon icon-heart exhibition-heart icon-heart-red" href=""></a>
	                                </div>
	                                <div class="exhibititon-date">${e.startDate} ~ ${e.endDate}</div>
	                                <div class="exhibition-place">${e.artist}</div>
	                            </form>
	                        </section>
	                    `
						
					}
					
                    
                    let el = new DOMParser()
                                .parseFromString(template, "text/html")
                                .body
                                .firstElementChild;
                                
                    exhBox.append(el);		
                }
            });    
            page++;
            isEndPage = false;
        }
        
    })


  // ------------ 카테고리메뉴 선택하기 --------------------------------------------  
    optionMenuList.onclick = function(e){
        e.preventDefault();
        e.stopPropagation();
        current = document.querySelector(".active");
        const el = e.target;

        if(el.tagName !='DIV' && el.tagName !='SPAN')
            return;
        
        let div = el;
        if(el.tagName =='SPAN')
            div = el.parentElement;
        
        div.classList.add('active');
        
        if(current != null)
            current.classList.remove('active');
            

        current = div;

        optionsOne.forEach(option => {
            option.addEventListener("click", function(e){
                e.preventDefault();
                let selectedOption = option.innerText;
                selectBtnOne.dataset.id = option.dataset.id;
                selectBtnTextOne.innerText = selectedOption;
                div.classList.remove("active");
				page = 2;
                query(1);
            })
        })

        optionsTwo.forEach(option => {
            option.addEventListener("click", function(e){
                e.preventDefault();
                let selectedOption = option.innerText;
                selectBtnTwo.dataset.id = option.dataset.id;
                selectBtnTextTwo.innerText = selectedOption;
                div.classList.remove("active");
				page = 2;
                query(1);
            })
        })

        optionsThree.forEach(option => {
            option.addEventListener("click", function(e){
                e.preventDefault();
                let selectedOption = option.innerText;
                selectBtnThree.dataset.id = option.dataset.id;
                selectBtnTextThree.innerText = selectedOption;
                div.classList.remove("active");
				page = 2;
                query(1);


            })
        })


    }
// ------ 쿼리용 함수-----------------------
    function query(page){
       	queryString = `?p=${page}&l=${selectBtnOne.dataset.id}&s=${selectBtnTwo.dataset.id}&c=${selectBtnThree.dataset.id}`;
        if(queryString == 0)
            queryString="";
        console.log(queryString);
	    fetch(`/api/lists${queryString}`)
	    .then((response)=>response.json())
	    .then((list)=>{

	        exhBox.innerHTML="";
	        for(let e of list){
				if(e.memberId == 0){
                    var template = `
                        <section data-id="${e.id}" class="exhibition">
                            <form action="">
                                <h1>${e.name}</h1>
                                <div class="exhibition-img-box">
                                    <a href="${e.id}"><img class="exhibition-img" src="/image/poster/${e.poster}" alt=""></a>
                                    <a class="icon icon-heart exhibition-heart" href=""></a>
                                </div>
                                <div class="exhibititon-date">${e.startDate} ~ ${e.endDate}</div>
                                <div class="exhibition-place">${e.artist}</div>
                            </form>
                        </section>
                    `
						
					}
					else {
	                    var template = `
	                        <section data-id="${e.id}" class="exhibition">
	                            <form action="">
	                                <h1>${e.name}</h1>
	                                <div class="exhibition-img-box">
	                                    <a href="${e.id}"><img class="exhibition-img" src="/image/poster/${e.poster}" alt=""></a>
	                                    <a class="icon icon-heart exhibition-heart icon-heart-red" href=""></a>
	                                </div>
	                                <div class="exhibititon-date">${e.startDate} ~ ${e.endDate}</div>
	                                <div class="exhibition-place">${e.artist}</div>
	                            </form>
	                        </section>
	                    `
						
					}
	            
	            let el = new DOMParser()
	                        .parseFromString(template, "text/html")
	                        .body
	                        .firstElementChild;
	                        
	            exhBox.append(el);		
	        }
	    });    
    }


})