<%@page import="domain.LunchDomain"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	LunchDomain ld = (LunchDomain)request.getAttribute("LunchDomain");
	pageContext.setAttribute("ld", ld);
%>
<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>점심 뭐먹지</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/blog/">

    <!-- Bootstrap core CSS -->
		<link href="http://localhost:8080/LunchSelector/Resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=556561d449900c23e674c88c88f33ce6&libraries=services"></script>
		<script>
			$(function() {
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				    mapOption = {
			        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			        level: 2 // 지도의 확대 레벨
				    };  
				
				// 지도를 생성합니다    
				var map = new daum.maps.Map(mapContainer, mapOption); 
				
				// 주소-좌표 변환 객체를 생성합니다
				var geocoder = new daum.maps.services.Geocoder();
				
				// 주소로 좌표를 검색합니다
				geocoder.addressSearch('${ ld.addr }', function(result, status) {
				
			    // 정상적으로 검색이 완료됐으면 
			     if (status === daum.maps.services.Status.OK) {
			
		        var coords = new daum.maps.LatLng(result[0].y, result[0].x);
		
		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new daum.maps.Marker({
		            map: map,
		            position: coords
		        });
		
		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new daum.maps.InfoWindow({
		            content: '<div style="width:150px;text-align:center;padding:6px 0;">${ ld.name }</div>'
		        });
		        infowindow.open(map, marker);
		
		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
			    } 
				});    
			});
		</script>    
  </head>
  <body>
  <div class="container">
  <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
	  <h1 class="display-4">점심 뭐먹지..</h1>
	  <p class="lead">🍚고민말고 가즈아!</p>
	</div>
  <div class="row">
    <div class="col-12">
      <div class="row no-gutters border rounded flex-md-row position-relative" style="height:500px;">
        <div class="col-6 p-4 d-flex flex-column position-static">
          <strong class="d-inline-block mb-2 text-primary">오늘의 메뉴</strong>
          <h3 class="mb-0"><c:out value="${ ld.name }"/></h3>
          <div class="mb-1 text-muted">평균 가격대 : <c:out value="${ ld.avgPrice }"/>원</div>
          <p class="card-text mb-auto">
          	<c:out value="${ ld.someDesc }" escapeXml="false"/>
          </p>
          <a href="main.do" class="stretched-link">이건 어제도 먹었잖어!</a>
        </div>
        <div class="col-6 d-none d-lg-block">
					<div id="map" style="width:100%;height:100%;"></div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
