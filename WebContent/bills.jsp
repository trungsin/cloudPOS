<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Bill</title>
<script type="text/javascript" src="js/angular.min.js"></script>

<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>
<s:form action="addBill">
	<s:textfield name="discount" label="Discount" />
	<s:textfield name="post" label="Post" />
	<s:submit />
</s:form>

<s:if test="billList.size() > 0">
	<div class="content">
	<table class="billTable" cellpadding="5px">
		<tr class="even">
			<th>Name User</th>
			<th>Create Date</th>
			<th>Update Date</th>
			<th>Discount</th>
			<th>Total</th>
		</tr>
		<s:iterator value="billList" status="bill">
			<tr class="<s:if test="#status.odd==true ">odd</s:if><s:else>even</s:else>">
				<td><s:property value="user_id" /></td>
				<td><s:property value="create_date" /></td>
				<td><s:property value="update_date" /></td>
				<td><s:property value="discount" /></td>
				<td><s:property value="total" /></td>
			</tr>
		</s:iterator>
	</table>
	</div>
</s:if>
</body>
</html>