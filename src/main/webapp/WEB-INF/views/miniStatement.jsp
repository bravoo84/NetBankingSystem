<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MiniStatement</title>
</head>
<body>

	<h3>MiniStatement</h3>
	<br>
	Transactions of accountNo: ${accountNo }
	<table>
	
		<tr>
			<th>Date and Time</th>
			<th>Cr/Db<th>
			<th>Amount</th>
			<th>details</th>
			<th>Closing Balance</th>
		</tr>
		
		
		<c:forEach var="transaction" items="${transactionList}">
		
			<tr>
			
				<td>${transaction.date}</td>
				<td>${transaction.crDb}</td>
				<td>${transaction.amount}</td>
				<td>${transaction.details}</td>
				<td>${transaction.closingBalance}</td>
				
				
			
			</tr>
		
		
		</c:forEach>
		
		
		
		
		
	
	
	</table>


</body>
</html>