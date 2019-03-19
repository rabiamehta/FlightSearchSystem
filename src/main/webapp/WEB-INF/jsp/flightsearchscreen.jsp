<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Search</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
.btn {
	background-color: black;
	border: none;
	color: white;
	padding: 12px 16px;
	font-size: 16px;
	cursor: pointer;
}

/* Darker background on mouse-over */
.btn:hover {
	background-color: grey;
}

.browser {
	height: 50%;
}
</style>
</head>
<body>
	<div class="jumbotron text-center">
		<!-- form -->
		<h1>Search The Flight</h1>
		<form:form commandName="inputfromuser">

			<table class="table">
				<thead class="thead-dark">
					<tr>
						<td>Departure Location:</td>
						<td><form:input required="required" path="departureLocation"
								placeholder="Enter Departure Location" pattern="[A-Z]{3}"
								title="Three letter departure code" /></td>
					</tr>

					<tr>
						<td>Arrival Location:</td>
						<td><form:input required="required" path="arrivalLocation"
								pattern="[A-Z]{3}" title="Three letter arrival code"
								placeholder="Enter Arrival Location" /></td>
					</tr>

					<tr>
						<td>Flight Date:</td>
						<td><form:input required="required" type="date"
								path="flightDate" placeholder="Enter Date" /></td>

					</tr>

					<tr>
						<td>Flight Class:</td>
						<td><form:select path="flightClass" required="required">
								<form:option value="" label="----" />
								<form:option value="E" label="E" />
								<form:option value="EB" label="EB" />
							</form:select></td>
					</tr>

					<tr>
						<td>Output Preference:</td>
						<td><form:select path="outputPreference" required="required">
								<form:option value="" label="----" />
								<form:option value="FARE" label="FARE" />
								<form:option value="BOTH" label="FARE_AND_FLIGHT_DURATION" />
							</form:select></td>
					</tr>

					<tr>
						<td><input type="submit" value="SUBMIT" /></td>
					</tr>
				</thead>
			</table>


		</form:form>


		<h1>${errormessage}</h1>


		<c:if test="${not empty lists}">
			<h1>Searched Results</h1>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<td scope="col"><B>NAME</B></td>
						<td scope="col"><B>SEAT AVAILABILITY</B></td>
						<td scope="col"><B>FARE</B></td>
						<td scope="col"><B>FLIGHT DURATION</B></td>
						<td scope="col"><B>FLIGHT CLASS</B></td>
					</tr>
				</thead>
				<tbody>
					<ul>
						<c:forEach var="secondVar" items="${lists}">
							<tr>
								<td><c:out value="${secondVar.name}" /></td>
								<td><c:out value="${secondVar.seatAvailability}" /></td>
								<td><c:out value="${secondVar.actualFare}" /></td>
								<td><c:out value="${secondVar.flightDuration}" /></td>
								<td><c:out value="${secondVar.flightClass}" /></td>
							</tr>
						</c:forEach>
					</ul>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>