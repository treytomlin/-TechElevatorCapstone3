<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>

<c:set var="pageTitle" value="Home Page" />

</head>
<body>
<%@include file="common/header.jspf"%>
<img class ="logoImage" src="${logoImgSrc}" alt="National Park Geek"> <!-- Resize -->



<div class="detailPageContainer">

	<div class="detailPagePhotoSection">
		<img src="img/weather/parks/${parkDetails.parkCode.toLowerCase()}.jpg" />
		<br /> <strong><q>${parkDetails.inspirationalQuote}</q></strong><br />
		<p>${parkDetails.inspirationalQuoteSource}</p>
	</div>

	
		<div class="detailPageParkTitle">
			<h2>${parkDetails.name}</h2>
				<h4>${parkDetails.state}</h4>
				<h6>Entry Fee: $${parkDetails.entryFee} | # of campsites:
					${parkDetails.numberOfCampsites} | Miles of Trails:
					${parkDetails.milesOfTrail} |</h6>
		
			<p>Acres: ${parkDetails.acreage} | Elevation(ft):
				${parkDetails.elevationInFeet} | Climate: ${parkDetails.climate} |
				Number of different animal species:
				${parkDetails.numberOfAnimalSpecies} | Year Founded:
				${parkDetails.yearFounded} | Visitors per year:
				${parkDetails.annualVisitorCount} |
			</p>
			<br />
	<p>${parkDetails.parkDescription}
	</p>
	<c:url var="conversionButton" value="/parkDetailPage"/>
			<form class="conversionForm" method="GET" action="${conversionButton}">
			<label for="convert">Choose Your Desired Temperature Scale</label> <select name="convert"
			id="convert">
			<option value="1">Celsius</option>
			<option value="2">Fahrenheit</option>
			</select>
			<input type="submit" value="temperatureConvert" />
			<input name="parkcode" type="hidden" value="${parkDetails.parkCode}" />
			</form>
</div>
</div>
	<c:forEach var="forecast" items="${forecast}">
	<div class="forecast">
		<div>
			<img class="weatherImage" src="img/weather/${forecast.forecast}.png" />
		</div>
		<div >
	<!--     <p>${sessionScope.tempClass}</p> did not lose any functionality without this line. -->	
			<c:choose>
			<c:when test="${tempClass.equals('1')}">
			<c:set var="highTemp" value="${(forecast.highTemp - 32) * 5/9}"/>
			<c:out value ="High:" /> <fmt:formatNumber type="number" pattern = "#" value="${highTemp}" /><c:out value=" ºC" />
			<c:set var="lowTemp" value="${(forecast.lowTemp - 32) * 5/9}"/>
			<c:out value="Low:" /> <fmt:formatNumber type="number" pattern ="#" value ="${lowTemp}" /><c:out value=" ºC" />
			</c:when>			
			<c:otherwise>
			<c:out value="High: ${forecast.highTemp} ºF"/>
			<c:out value="Low: ${forecast.lowTemp} ºF"/> 
			</c:otherwise>
			</c:choose>
			<br />
		</div>
		<div >
			<div class="weathermessage">
			<c:out value="${forecast.weatherMessage}"/>
			</div>	
		</div>
		</div>	
	</c:forEach>







<div>
<footer>
<%@include file="common/loveFooter.jspf"%>
</footer>
</div>
</body>
</html>