<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../jsp-header.jsp" %>

<div id="main">

    <c:if test="${not empty deleteMessage}">
        <script>
            $(document).ready(function () {
                alert('${deleteMessage}');
            });
        </script>
    </c:if>

    <table border="1" style="width:300px">

        <tr>
            <th>
                id
            </th>
            <th>
                name
            </th>
            <th>
                author
            </th>
            <th>
                description
            </th>
            <th>
                pictureOfCover
            </th>
            <th>
                delete
            </th>
        </tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td><a href="${contextPath}/book/concrete?id=${book.id}">${book.id}</a></td>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.description}</td>
                <td><a href="${book.pictureOfCover}" target="_blank">${book.pictureOfCover}</a></td>
                <td><a href="${contextPath}/book/${book.id}/delete">delete</a></td>
            </tr>
        </c:forEach>

    </table>

</div>

