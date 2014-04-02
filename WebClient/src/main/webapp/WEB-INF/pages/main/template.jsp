<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../jsp-header.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Default tiles template</title>
</head>
<body>
    <tiles:insertAttribute name="header"/>
    <tiles:insertAttribute name="menu"/>
    <tiles:insertAttribute name="body"/>
    <tiles:insertAttribute name="footer"/>
</body>
</html>
