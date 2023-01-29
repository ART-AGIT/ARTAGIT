window.addEventListener("load", function () {
	//  예매내역리스트 보여주기 (더보기 기능)
	// const itemMore = document.querySelector(".item-more");
	// var page = 1;
	// let today = new Date();
	// var state = null;
	// itemMore.onclick = function () {
	// 	page += 1;

	// 	queryString = `?p=${page}`;

	// 	fetch(`/corpApi/exh/list${queryString}`)
	// 		.then((response) => response.json())
	// 		.then((lists) => {
	// 			for (list of lists) {
	// 				console.log(Object.keys(lists).length);
	// 				if (Object.keys(lists).length < 6)
	// 					itemMore.classList.add("d-none");

	// 				let date = new Date(list.endDate);

	// 				if (date < today)
	// 					state = "<p style='color:#545454;'>전시종료</p>";

	// 				else if (date >= today)
	// 					state = "<p style='color:#FF5171;'>전시중</p>";

	// 				var template = `

	// 					   <div class="exh-list">
	// 						   <form action="">

	// 							   <div class="exh-img-box">
	// 								   <a href="/corp/exh/${list.id}" ><img class="exh-img" src="/image/poster/${list.poster}" alt=""></a>
	// 							   </div>
	// 							   <div class="text exh-state exh-ing">${state}</div>
	// 							   <div class="text exh-title">${list.name}</div>
	// 							   <div class="text exh-author">author. ${list.artist}</div>
	// 							   <div class="text exh-date" >${list.startDate} ~ ${list.endDate}</div>

	// 							  </form>
	// 						  </div>
	// 						  <button class="text item-more"">
	// 						  <div>더보기</div>
	// 					   </button>
	// 					   `;


	// 				let el = new DOMParser()
	// 					.parseFromString(template, "text/html")
	// 					.body
	// 					.firstElementChild;

	// 				var list = document.querySelector(".exh-list-tong");
	// 				list.append(el);
	// 			}
	// 		});
	// }


	// ------ 전시진행 필터-----------------------





	// queryString = `?p=${page}&l=${selectBtnOne.dataset.id}&s=${selectBtnTwo.dataset.id}&c=${selectBtnThree.dataset.id}`;
	// if (queryString == 0)
	// 	queryString = "";
	// console.log(queryString);
	// fetch(`/api/lists${queryString}`)
	// 	.then((response) => response.json())
	// 	.then((list) => {

	// 		exhBox.innerHTML = "";
	// 		for (let e of list) {
	// 			if (e.memberId == 0) {
	// 				var template = `
	// 		 <section data-id="${e.id}" class="exhibition">
	// 			 <form action="">
	// 				 <h1>${e.name}</h1>
	// 				 <div class="exhibition-img-box">
	// 					 <a href="${e.id}"><img class="exhibition-img" src="/image/poster/${e.poster}" alt=""></a>
	// 					 <a class="icon icon-heart exhibition-heart" href=""></a>
	// 				 </div>
	// 				 <div class="exhibititon-date">${e.startDate} ~ ${e.endDate}</div>
	// 				 <div class="exhibition-place">${e.artist}</div>
	// 			 </form>
	// 		 </section>
	// 	 `

	// 			}
	// 			else {
	// 				var template = `
	// 			 <section data-id="${e.id}" class="exhibition">
	// 				 <form action="">
	// 					 <h1>${e.name}</h1>
	// 					 <div class="exhibition-img-box">
	// 						 <a href="${e.id}"><img class="exhibition-img" src="/image/poster/${e.poster}" alt=""></a>
	// 						 <a class="icon icon-heart exhibition-heart icon-heart-red" href=""></a>
	// 					 </div>
	// 					 <div class="exhibititon-date">${e.startDate} ~ ${e.endDate}</div>
	// 					 <div class="exhibition-place">${e.artist}</div>
	// 				 </form>
	// 			 </section>
	// 		 `

	// 			}

	// 			let el = new DOMParser()
	// 				.parseFromString(template, "text/html")
	// 				.body
	// 				.firstElementChild;

	// 			exhBox.append(el);
	// 		}
	// 	});



})

function selectexh() {
	const selectList = document.querySelector("#selectexhibition");
	const selectBtnTwo = document.querySelector(".select-btn");
	const optionsTwo = document.querySelectorAll(".option-2");
	var page = 1;
	let current = document.querySelector(".active");
	let isEndPage = true;
	let queryString;
	const listTong = document.querySelector(".exh-list-tong");


	console.log(selectBtnTwo.dataset.id);
	if (selectList.options[selectList.selectedIndex].value == "exh-according") {

		queryString = `?p=${page}&s=${selectList.options[selectList.selectedIndex].dataset.id}`;
		console.log("전시예정");
		console.log(queryString);
		fetch(`/corpApi/exh/list/date${queryString}`)
			.then((response) => response.json())
			.then((lists) => {

				console.log(lists)
				listTong.innerHTML = '';
				for (list of lists) {

					console.log(Object.keys(lists).length);

					var template = `

					<div class="exh-list">
						<form action="">

							<div class="exh-img-box">
								<a href="/corp/exh/${list.id}" ><img class="exh-img" src="/image/poster/${list.poster}" alt=""></a>
							</div>
							<div class="text exh-state exh-ing">전시예정</div>
							<div class="text exh-title">${list.name}</div>
							<div class="text exh-author">author. ${list.artist}</div>
							<div class="text exh-date" >${list.startDate} ~ ${list.endDate}</div>

						</form>
					</div>
				`;

					let el = new DOMParser()
						.parseFromString(template, "text/html")
						.body
						.firstElementChild;
					console.log(el);


					listTong.append(el);
					console.log(listTong);
				}
			});
	}

	if (selectList.options[selectList.selectedIndex].value == "exh-ing") {
		console.log("전시중")
		queryString = `?p=${page}&s=${selectList.options[selectList.selectedIndex].dataset.id}`;
		fetch(`/corpApi/exh/list/date${queryString}`)
			.then((response) => response.json())
			.then((lists) => {

				console.log(lists)
				listTong.innerHTML = '';
				for (list of lists) {

					console.log(Object.keys(lists).length);

					var template = `

					<div class="exh-list">
						<form action="">

							<div class="exh-img-box">
								<a href="/corp/exh/${list.id}" ><img class="exh-img" src="/image/poster/${list.poster}" alt=""></a>
							</div>
							<div class="text exh-state exh-ing">전시중</div>
							<div class="text exh-title">${list.name}</div>
							<div class="text exh-author">author. ${list.artist}</div>
							<div class="text exh-date" >${list.startDate} ~ ${list.endDate}</div>

						</form>
					</div>
				`;

					let el = new DOMParser()
						.parseFromString(template, "text/html")
						.body
						.firstElementChild;
					console.log(el);


					listTong.append(el);
					console.log(listTong);
				}
			});
	}
	if (selectList.options[selectList.selectedIndex].value == "exh-end") {
		console.log("전시종료")
		queryString = `?p=${page}&s=${selectList.options[selectList.selectedIndex].dataset.id}`;
		fetch(`/corpApi/exh/list/date${queryString}`)
			.then((response) => response.json())
			.then((lists) => {

				console.log(lists)
				listTong.innerHTML = '';
				for (list of lists) {

					console.log(Object.keys(lists).length);

					var template = `

					<div class="exh-list">
						<form action="">

							<div class="exh-img-box">
								<a href="/corp/exh/${list.id}" ><img class="exh-img" src="/image/poster/${list.poster}" alt=""></a>
							</div>
							<div class="text exh-state exh-ing">전시종료</div>
							<div class="text exh-title">${list.name}</div>
							<div class="text exh-author">author. ${list.artist}</div>
							<div class="text exh-date" >${list.startDate} ~ ${list.endDate}</div>

						</form>
					</div>
				`;

					let el = new DOMParser()
						.parseFromString(template, "text/html")
						.body
						.firstElementChild;
					console.log(el);


					listTong.append(el);
					console.log(listTong);
				}
			});

	}

}






