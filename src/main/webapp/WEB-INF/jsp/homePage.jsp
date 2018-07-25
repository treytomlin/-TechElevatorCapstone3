<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<c:set var="pageTitle" value="Home Page"/>
<%@include file="common/header.jspf" %>

<body>
<img class ="logoImage" src="${logoImgSrc}" alt="National Park Geek"> 


	<c:url var="parkDetailUrl" value="/parkDetailPage">
	<c:param name="parkcode" value="${park.parkCode}" />
 	</c:url>
	<c:forEach var="park" items="${parks}">
	<div class="homeContainer">
			<div class="homeImage"><a href="${parkDetailUrl}${park.parkCode}"><img src="img/weather/parks/${park.parkCodeLowerCase}.jpg" /></a>
			</div>
			<div class="homeText">
			<h2><c:out value="${park.name}" /></h2><br>
			<c:out value="${park.parkDescription}" /> 
			</div>
	</div>
	</c:forEach>
		
	<footer>
		<%@include file="common/loveFooter.jspf" %>
		</footer>
		</body>
		</html>
		
	