window.addEventListener("load", function(){ 
    var date = new Date();
    var utc = date.getTime() + (date.getTimezoneOffset()*60*1000);
    var kstGap = 9 * 60 * 60 * 1000;
    var today = new Date(utc + kstGap);

      // 날짜 앞에 0 붙이기
    function addZero(date) {
        if (date < 10) {
            const zeroDate = ('00' + date).slice(-2);
            return zeroDate;
        }
            return date;
    }

    var thisMonth = new Date(today.getFullYear(), today.getMonth(), today.getDate());
    

    var currentYear = thisMonth.getFullYear(); // 달력에서 표기하는 연
    var currentMonth = addZero(thisMonth.getMonth()+1); // 달력에서 표기하는 월
    var currentDate = addZero(thisMonth.getDate()); // 달력에서 표기하는 일

    renderCalender(thisMonth);
    
    function renderCalender(thisMonth){

        currentYear = thisMonth.getFullYear();
        currentMonth = thisMonth.getMonth();
        currentDate = thisMonth.getDate();
    
        // 이전 달의 마지막 날 날짜와 요일 구하기
        var startDay = new Date(currentYear, currentMonth, 0);
        var prevDate = startDay.getDate();
        var prevDay = startDay.getDay();
        
        // 이번 달의 마지막 날 날짜와 요일 구하기
        var endDay = new Date(currentYear, currentMonth + 1, 0);
        var nextDate = endDay.getDate();
        var nextDay = endDay.getDay();
    
        // 현재 월 표기
        var yearMonth = document.querySelector(".year-month")
        yearMonth.innerHTML = currentYear + '.' + (addZero(thisMonth.getMonth()+1));
        
        // 렌더링 html 요소 생성
        calendar = document.querySelector(".dates");
        calendar.innerHTML = '';
        
        // 지난달
        for (var i = prevDate - prevDay + 1; i <=prevDate; i++){
            calendar.innerHTML = calendar.innerHTML + '<div class="day prev disable">' + i + '</div>'
        }
        
        // 이번달
        for (var i = 1; i <= nextDate; i++){
            calendar.innerHTML = calendar.innerHTML + '<span class="day current">' + i + '<span>'
        }
        
        // 다음달
        for (var i = 1; i <= (7 - nextDay == 7 ? 0 : 7 - nextDay); i++) {
            calendar.innerHTML = calendar.innerHTML + '<div class="day next disable">' + i + '</div>'
        }
    
        // 오늘 날짜 표기
        if (today.getMonth() == currentMonth) {
            todayDate = today.getDate();
            var currentMonthDate = document.querySelectorAll('.dates .current');
            currentMonthDate[todayDate -1].classList.add('today');
        }

    }

    // 이전달로 이동
    var prevBtn = document.querySelector(".go-prev");
    prevBtn.onclick = function(e){
        e.preventDefault();
        thisMonth = new Date(currentYear, currentMonth - 1, 1);
        renderCalender(thisMonth);
    }

    // 다음달로 이동
    var nextBtn = document.querySelector(".go-next");
    nextBtn.onclick = function(e){
        e.preventDefault();
        thisMonth = new Date(currentYear, currentMonth + 1, 1);
        renderCalender(thisMonth); 

    }

    const textBox = document.querySelector(".text-box")
    let exhDate = document.querySelector(".exh-date")

    let currentEl = document.querySelector("active")

    const cNumBox = document.querySelector(".client-number");
    const cInfoBox = document.querySelector(".client-info");
    const incOrdec = document.querySelector(".plus");
    const choiceDate = document.querySelector(".choice-date");
    const bookingBtn = document.querySelector(".booking-btn");
    const msgBox = document.querySelector(".msg-box");

    // 선택한 날짜 색 바뀜, 날짜 바뀜
    calendar.onclick = function(e){
        e.preventDefault();

        let el = e.target;

        if(el.tagName != "SPAN")
            return;
        
        // 선택한 날짜에 회색배경 주기
        el.classList.add("active");


        if(currentEl != null)
            currentEl.classList.remove("active");

        currentEl = el;

        // 상단 날짜추가
        let template = 
            `<span class="select-year">${thisMonth.getFullYear()}년</span>
            <span class="select-month">${addZero(thisMonth.getMonth()+1)}월</span>
            <span class="select-day">${addZero(el.innerText)}일</span>`
        //날짜 바뀌게
        exhDate.innerHTML = template;
		choiceDate.classList.add("d-none");
        cNumBox.classList.remove("d-none");
        bookingBtn.classList.remove("d-none");
        msgBox.classList.remove("d-none");
    }

    incOrdec.onclick = function(e){
		e.preventDefault();
		cInfoBox.classList.remove("d-none");
		console.log("msgBox==> " + msgBox);
	}

})

