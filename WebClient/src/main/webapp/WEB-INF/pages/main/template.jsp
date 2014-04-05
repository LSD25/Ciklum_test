<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../jsp-header.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html;charset=iso-8859-1"/>
    <title>Cicklum test</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/css/main.css"/>
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script src="${contextPath}/js/book.js" type="text/javascript"></script>
</head>

<header>
    <tiles:insertAttribute name="header"/>
</header>

<menu>

    <tiles:insertAttribute name="menu"/>

</menu>

<body>

<tiles:insertAttribute name="body"/>

</body>

<footer>

    <tiles:insertAttribute name="footer"/>

</footer>

</html>
