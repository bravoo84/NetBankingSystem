<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!Doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
</head>
<body>

	<h3>Success Page</h3>
	Welcome ${sessionScope.username }
	<br>
	<a href="${pageContext.request.contextPath }/logout">Logout</a>
	
	
	<table>
				<tr>
					<th>Account Number</th>
					<th>IFSC code</th>
					<th>Account type</th>
					<th>Current balance</th>
					<th>Currency</th>
					<th>Transfer</th>
					<th>MiniStatement</th>
				</tr>
				
				
				<c:forEach var="accountList" items="${accountList}">
				 
				 <c:url var="transferLink" value="/transfer">
				 	<c:param name="accountNo" value="${accountList.accountNo}">
				 		</c:param>
				 </c:url>
				 
				 <c:url var="miniStatementLink" value="/miniStatement">
				 	<c:param name="accountNo" value="${accountList.accountNo}">
				 		</c:param>
				 </c:url>
				 
				 	
					<tr>
						<td> ${accountList.accountNo} </td>
						<td> ${accountList.IFSC} </td>
						<td> ${accountList.type} </td>
						<td> ${accountList.balance} </td>
						<td> ${accountList.currency} </td>
						
						<td>
							<a href="${transferLink}">Proceed</a>
						</td>
						
						<td>
							<a href="${miniStatementLink}">Fetch</a>
						</td>
						 
					</tr>
					
				</c:forEach>
			</table>
	
	

</body>
</html>
