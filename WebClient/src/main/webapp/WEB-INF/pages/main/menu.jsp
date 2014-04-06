<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../jsp-header.jsp" %>
<div class="container">
    <ul id="nav">
        <li><a href="#s1">Book</a>
            <span id="s1"></span>
            <ul class="subs">
                <li><a href="#">Book panel</a>
                    <ul>
                        <li><a href="${contextPath}/book/concrete">Find book</a></li>
                        <li><a href="${contextPath}/book/create-book">Create a new book</a></li>
                    </ul>
                </li>
                <li><a href="#">Book panel</a>
                    <ul>
                        <li><a href="${contextPath}/book/list">Book's list</a></li>
                    </ul>
                </li>
            </ul>
        </li>
        <li><a href="${contextPath}/about">About
            <author></author>
        </a></li>
        <li><a href="<c:url value="j_spring_security_logout" />">Logout</a></li>
    </ul>
</div>