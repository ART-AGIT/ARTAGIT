window.addEventListener("load", function(){

    const body = document.querySelector("body");
    const main = document.querySelector("main");
    let exhMenu = main.querySelector(".exh-menu-list");
    const menuSelected = main.querySelectorAll(".exh-menu-list>li>a");
    const exhBox = main.querySelector(".exhibition-list");
    var current = main.querySelector(".active");
    var exhHearts = main.querySelectorAll(".exhibition-heart");

    for(heart of exhHearts)
        heart.onclick = function(e){
            e.preventDefault();

            for(heart of exhHearts)
                heart.classList.add("icon-heart-red")
            // exhHeart.style.backgroundColor("red");
        }



    exhMenu.onclick = function(e){
        e.preventDefault();
        current = main.querySelector(".active");
        // console.log(`e.target: ${e.target.classList}`);
        // console.log(`current: ${current.classList}`);

        const el = e.target;

        if(el.tagName == 'DIV' && el.tagName=='A')
            return;

        let div = el;
        if(el.tagName = 'A')
            div = el.parentElement;

        div.classList.add('active');
        if(current != null)
            current.classList.remove('active');
    
        current = div;
        
        
        console.log(e.target.textContent);
    }

    // exhMenu.onclick = function(e){
    //     e.preventDefault();
    //     e.stopPropagation();

    //     if(!e.target.classList.contains(".exh-menu-select"))
    //         return;

    //     console.log("test");
		
    //     let queryString = `?m=${menuSelected[0].dataset.id}&s=${menuSelected[1].dataset.id}&c=${menuSelected[2].dataset.id}`;
    //     if(queryString == 0)
    //     	queryString="";

		
    //     fetch(`/api/lists${queryString}`)
    //     .then((response)=>response.json())
    //     .then((list)=>{
    //         exhBox.innerHTML="";
    //         for(let e of list){
    //             let template = `
    //             	<section class="exhibition">
	//                     <form action="">
	//                         <h1>${e.name}</h1>
	//                         <div class="exhibition-img-box">
	//                             <a href="detail.html"><img class="exhibition-img" src="/image/anonymousProject.png" alt=""></a>
	//                             <a class="icon icon-heart exhibition-heart" href="" style="background-color: #fff;"></a>
	//                         </div>
	//                         <div class="exhibititon-date">${e.startDate} ~ ${e.endDate}</div>
	//                         <div class="exhibition-place">${e.artist}</div>
	//                     </form>
    //             	</section>
    //             `
                
    //             let el = new DOMParser()
    //             			.parseFromString(template, "text/html")
	// 						.body
	// 						.firstElementChild;
							
	// 			exhBox.append(el);		
	// 		}
    //     });      
    // }


})