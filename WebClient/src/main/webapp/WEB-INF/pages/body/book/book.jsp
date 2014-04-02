<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../jsp-header.jsp" %>

<table>

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
        <td>${book.id}</td>
        <td>${book.name}</td>
        <td>${book.author}</td>
        <td>${book.description}</td>
        <td>${book.pictureOfCover}</td>
    </tr>
    ${contextPath}
</table>