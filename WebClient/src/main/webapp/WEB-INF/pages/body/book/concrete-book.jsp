<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../jsp-header.jsp" %>

<div id="main">

    <input type="text" id="book-id" width="150px" placeholder="Please input id of book"/>

    <button type="button" id="find-book">Find book</button>

    </br>
    </br>

    <table border="1" style="width:300px; <c:if test="${empty book}">visibility: hidden</c:if>" id="table">

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
            <td>
                update
            </td>
        </tr>

        <tr>
            <td id="id"><input id = "book-id" type="text" value="${book.entity.id}"/></td>
            <td id="name"><input id ="book-name" type="text" value="${book.entity.name}"/></td>
            <td id="author"><input id = "book-author" type="text" value="${book.entity.author}"/></td>
            <td id="description"><input id = "book-description" type="text" value="${book.entity.description}"/></td>
            <td id="pictureOfCover"><input id = "book-pictureOfCover" type="text" value="${book.entity.pictureOfCover}"/></td>
            <td>
                <button type="button" id="update-book">Update book</button>
            </td>
        </tr>

    </table>

</div>

