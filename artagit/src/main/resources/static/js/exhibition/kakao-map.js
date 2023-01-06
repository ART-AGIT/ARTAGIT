//////////////////////// 지도 설정 ////////////////////////
const mapContainer = document.getElementById('map'), // 지도를 표시할 div 가져오기
	mapOption = { 
	    center: new kakao.maps.LatLng(36.5,127.5),	// 지도의 중심 좌표(임의 설정)
	    level: 6 // 지도의 확대 레벨(임의 설정)
	};
    

const mapBtn = document.querySelector('.deco-map');
// const mapBtn = document.querySelector('input[id="popup"]');
const address = document.querySelector('.address');
const place = document.querySelector('.place').innerText;
console.log(mapBtn);

// mapBtn.click(function(){
    //설정한 지도 생성
    const map = new kakao.maps.Map(mapContainer, mapOption);
    // 주소-좌표 변환 객체 생성
    var geocoder = new kakao.maps.services.Geocoder();
    // 주소로 좌표를 검색
    geocoder.addressSearch(address.innerText, function(result, status) {
    // geocoder.addressSearch('서울시 용산구 서빙고로 137', function(result, status) {

        // 정상적으로 검색이 완료됐으면 
        if (status === kakao.maps.services.Status.OK) {

            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

            // 결과값으로 받은 위치를 마커로 표시합니다
            var marker = new kakao.maps.Marker({
                map: map,
                position: coords
            });

            // 인포윈도우로 장소에 대한 설명을 표시합니다
            var infowindow = new kakao.maps.InfoWindow({
                content: `<div style="width:150px;text-align:center;padding:6px 0;">${place}</div>`
            });
            infowindow.open(map, marker);

            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            map.setCenter(coords);
        } 
    })
// })


window.addEventListener("scroll", function() {
    const modal = this.document.querySelector("#popup + label + div");
//    const close = this.document.querySelector(".modal");
    const checkBox = this.document.querySelector("#popup");
    var scrollValue = document.documentElement.scrollTop;
    // console.log(scrollValue);
    console.log(modal);
    console.log(window.scrollY); // 900

    if(this.window.scrollY >= 900)
        checkBox.checked = false;

})