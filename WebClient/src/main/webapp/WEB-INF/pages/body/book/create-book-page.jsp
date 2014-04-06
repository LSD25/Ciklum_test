<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../jsp-header.jsp" %>

<div id="main">

    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" id="book-name" width="150px" placeholder="Name of book" required="required"/></td>
        </tr>
        <tr>
            <td>Author:</td>
            <td><input type="text" id="book-author" width="150px" placeholder="Author" required="required"/></td>
        </tr>
        <tr>
            <td>description:</td>
            <td><input type="text" id="book-description" width="150px" placeholder="Description" required="required"/>
            </td>
        </tr>
        <tr>
            <td>Picture of cover:</td>
            <td><input type="text" id="book-pict-of-cover" width="150px" placeholder="Picture of cover"
                       required="required"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="button" id="create-book">Create book</button>
            </td>
        </tr>
    </table>

</div>
