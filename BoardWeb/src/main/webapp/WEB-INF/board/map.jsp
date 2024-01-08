<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>마커에 인포윈도우 표시하기</title>
    
</head>
<body>
<div id="map" style="width:100%;height:800px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c01bbaa78f08b85301d5bf165c9bffde"></script>
<script>

let x = '${param.x}';
let y = '${param.y}';
let facilityName = '${param.facilityName}';
console.log(facilityName);

// encodeURI(한글%08%dk%~)
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(x, y), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption);

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(x, y); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

// 20240108 숙제
// map.jsp에서 Hello World 있는 부분
// covid19.jsp의 facilityName 속성으로 표현하기 => 파라미터 받기
var iwContent = '<div style="padding:5px;">' + facilityName + ' <br><a href="https://map.kakao.com/link/map/' + facilityName + ',' + x + ',' + y + '" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/' + facilityName + ',' + x + ',' + y + '" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    iwPosition = new kakao.maps.LatLng(33.450701, 126.570667); //인포윈도우 표시 위치입니다

// 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
    position : iwPosition, 
    content : iwContent 
});
  
// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
infowindow.open(map, marker); 
</script>
</body>
</html>