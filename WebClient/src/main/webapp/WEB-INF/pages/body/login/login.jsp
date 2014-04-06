<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../jsp-header.jsp" %>
<form name='login-form' action="<c:url value='j_spring_security_check' />" method='POST'>

    <table>
        <tr>
            <td>User:</td>
            <td>
                <input type='text' name='j_username' value=''>
            </td>
        </tr>
        <tr>
            <td>Password:</td>
            <td>
                <input type='password' name='j_password'/>
            </td>
        </tr>
        <tr>
            <td>
            <td>
                <input name="submit" type="submit" value="Login"/>
                <input name="reset" type="reset" value="Reset"/>
            </td>
        </tr>
    </table>

</form>
</body>