<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../jsp-header.jsp" %>

<%--<script>--%>
<%--$( document ).ready(function() {--%>
<%--$.ajax({--%>
<%--url: "test.html",--%>
<%--cache: false,--%>
<%--success: function(html){--%>
<%--$("#results").append(html);--%>
<%--}--%>
<%--});--%>

<%--$( "#delete-book" ).click(function() {--%>
<%--alert( this.attribute("book-id"));--%>
<%--});--%>
<%--});--%>
<%--</script>--%>

<div id="main">

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
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.description}</td>
                <td><a href="${book.pictureOfCover}" target="_blank">${book.pictureOfCover}</a></td>
                <td><a id="delete-book" book-id="${book.id}" href="javascrip:void(null)">delete</a></td>
            </tr>
        </c:forEach>

    </table>

</div>

