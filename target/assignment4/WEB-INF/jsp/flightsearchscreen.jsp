 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@ page import="java.util.List" %>      
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>

<form:form commandName="inputfromuser">
	
	<table>
		<tr>
			<td>Enter Departure Location:</td>
			<td><form:input path="departureLocation"/></td>
		</tr>
		
		<tr>
			<td>Enter Arrival Location:</td>
			<td><form:input path="arrivalLocation"/></td>
		</tr>
	
		<tr>
			<td>Enter Flight Date:</td>
			<td><form:input path="flightDate"/></td>
		</tr>
		
		<tr>
			<td>Enter Flight Class:</td>
			<td><form:input path="flightClass"/></td>
		</tr>
	
		<tr>
			<td>Enter Output Preference:</td>
			<td><form:input path="outputPreference"/></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="SUBMIT"/></td>
		</tr>
	
	</table>
	

</form:form>
<h1>${errormessage}</h1>


<c:if test="${not empty lists}">

<table>
	<tr>
		<td>NAME</td>
		<td>SEAT_AVAILABILITY</td>
		<td>FARE</td>
	
	
	</tr>
		<ul>
			<c:forEach var="secondVar" items="${lists}">
			 	<tr>
        			
	     					<td><c:out value="${secondVar.name}"/></td>
	       					<td><c:out value="${secondVar.seatAvailability}"/></td>
	       					<td><c:out value="${secondVar.fare}"/></td>
	       					<td><c:out value="${secondVar.flightDuration}"/></td>
       				
       			</tr>
        	
			</c:forEach>
		</ul>

	</c:if>
</table>
	
</body>
</html>