<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transfer Money</title>
</head>
<body>

	
	<h3>Transfer Money</h3>
	<form method="post"
		action="${pageContext.request.contextPath }/transaction">
		<table>
			<tr>
				<td>Account No.</td>
				<td><input type="text" name="accountNoCred"></td>
			</tr>
			<tr>
				<td>Amount</td>
				<td><input type="number" name="amount"></td>
			</tr>
			
			<tr>
				<td>Message</td>
				<td><input type="text" name="details"></td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Transfer"></td>
			</tr>
		</table>
		
		${error }
		
	</form>
	

</body>
</html>