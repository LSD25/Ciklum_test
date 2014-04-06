<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../jsp-header.jsp" %>
<!DOCTYPE html>
<html>

<head lang="en">
    <meta http-equiv="Content-Type" content="text/html;UTF-8"/>
    <title>Cicklum test</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/css/main.css"/>
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script src="${contextPath}/js/book.js" type="text/javascript"></script>
</head>

    <header>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>Welcome : ${pageContext.request.userPrincipal.name}
        </c:if>

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
