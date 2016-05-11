<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>

<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery.js"></script>

<tiles:insertAttribute name="includes"></tiles:insertAttribute>

</head>
<body>
	<table border="1" cellspacing="0" cellpadding="0"
		style="width: 99%; height: 100%">
		<tr>
			<td colspan="2">
				<div class="header">
					<tiles:insertAttribute name="header"></tiles:insertAttribute>
				</div>
			</td>
		</tr>

		<tr>
			<td>
				<div class="toolbar">
					<tiles:insertAttribute name="toolbar"></tiles:insertAttribute>
				</div>
			</td>
		</tr>

		<tr>
			<td>
				<div class="content">
					<tiles:insertAttribute name="content"></tiles:insertAttribute>
				</div>
			</td>
			
			<td>
				<div class="content">
					<tiles:insertAttribute name="rightads"></tiles:insertAttribute>
				</div>
			</td>
		</tr>


		<tr>
			<td colspan="2">
				<div class="footer">
					<tiles:insertAttribute name="footer"></tiles:insertAttribute>
				</div>
			</td>
		</tr>
		</table>
</body>
</html>