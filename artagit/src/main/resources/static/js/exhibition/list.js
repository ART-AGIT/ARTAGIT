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
    let page = 1;

	window.addEventListener("scroll", function(){
        //scrollHeight : 전체 스크롤
        //scrollTop : 스크롤 윗부분
        //clientHeight : 컨텐츠가 보이는 높이

      	let paddingOfBottom = 100;
        let scrollHeight = document.documentElement.scrollHeight
        let scrollTop = document.documentElement.scrollTop;
        let scrollClientHeight = document.documentElement.clientHeight;

        let isEndPage = true;

        
        if (scrollHeight - scrollTop - paddingOfBottom <= scrollClientHeight && isEndPage){
            queryString = `?p=${page}&m=${selectBtnOne.dataset.id}&s=${selectBtnTwo.dataset.id}&c=${selectBtnThree.dataset.id}`;
            if(queryString == 0)
                queryString="";
            console.log(queryString);
            fetch(`/api/lists${queryString}`)
            .then((response)=>response.json())
            .then((list)=>{
                
                if(list.length == 0)
                	isEndPage = false;
                	

                for(let e of list){
                    let template = `
                        <section class="exhibition">
                            <form action="">
                                <h1>${e.name}</h1>
                                <div class="exhibition-img-box">
                                    <a href="${e.id}"><img class="exhibition-img" src="/image/anonymousProject.png" alt=""></a>
                                    <a class="icon icon-heart exhibition-heart" href="" style="background-color: #fff;"></a>
                                </div>
                                <div class="exhibititon-date">${e.startDate} ~ ${e.endDate}</div>
                                <div class="exhibition-place">${e.artist}</div>
                            </form>
                        </section>
                    `
                    
                    let el = new DOMParser()
                                .parseFromString(template, "text/html")
                                .body
                                .firstElementChild;
                                
                    exhBox.append(el);		
                }
            });    
            page++;
        }
        
    })


    
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

                query(1);


            })
        })


    }

    function query(page){
       	queryString = `?p=${page}&m=${selectBtnOne.dataset.id}&s=${selectBtnTwo.dataset.id}&c=${selectBtnThree.dataset.id}`;
        if(queryString == 0)
            queryString="";
        console.log(queryString);
	    fetch(`/api/lists${queryString}`)
	    .then((response)=>response.json())
	    .then((list)=>{
	        exhBox.innerHTML="";
	        for(let e of list){
	            let template = `
	                <section class="exhibition">
	                    <form action="">
	                        <h1>${e.name}</h1>
	                        <div class="exhibition-img-box">
	                            <a href="detail.html"><img class="exhibition-img" src="/image/anonymousProject.png" alt=""></a>
	                            <a class="icon icon-heart exhibition-heart" href="" style="background-color: #fff;"></a>
	                        </div>
	                        <div class="exhibititon-date">${e.startDate} ~ ${e.endDate}</div>
	                        <div class="exhibition-place">${e.artist}</div>
	                    </form>
	                </section>
	            `
	            
	            let el = new DOMParser()
	                        .parseFromString(template, "text/html")
	                        .body
	                        .firstElementChild;
	                        
	            exhBox.append(el);		
	        }
	    });    
    }




})
