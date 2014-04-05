<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../jsp-header.jsp" %>

<div id="main">

    <input type="text" id="book-id" width="150px"/>

    <button type="button" id="find-book">Find book</button>

    </br>
    </br>

    <table border="1" style="width:300px; visibility: hidden" id="table">

        <tr>
            <td id="id"></td>
            <td id="name"></td>
            <td id="author"></td>
            <td id="description"></td>
            <td id="pictureOfCover"></td>
        </tr>

    </table>

</div>

