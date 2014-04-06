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
        </tr>

        <tr>
            <td id="id">${book.entity.id}</td>
            <td id="name">${book.entity.name}</td>
            <td id="author">${book.entity.author}</td>
            <td id="description">${book.entity.description}</td>
            <td id="pictureOfCover">${book.entity.pictureOfCover}</td>
        </tr>

    </table>

</div>

