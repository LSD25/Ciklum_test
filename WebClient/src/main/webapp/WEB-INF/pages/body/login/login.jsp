<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../jsp-header.jsp" %>
<form name='login-form' action="<c:url value='j_spring_security_check' />"
      method='POST'>

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
            <td colspan='2'>
                <input name="submit" type="submit" value="submit"/>
            </td>
        </tr>
        <tr>
            <td colspan='2'>
                <input name="reset" type="reset"/>
            </td>
        </tr>
    </table>

</form>
</body>