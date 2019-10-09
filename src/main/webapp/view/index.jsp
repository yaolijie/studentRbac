
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆系统</title>
    <%
        String error=(String)request.getAttribute("error");
    %>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            if('<%=error%>'!='null'&&'<%=error%>'.length>1) {
                alert('<%=error%>');
            }
            $("#register").click(function () {
                window.location.href="view/insert/insertPerson.jsp"
            });
        });
        function jsp(){
            window.location.href="view/Intal.jsp"
        }
    </script>
</head>
<body>
<div class="Container">
    <form action='<%=path%>/lendServlet?t=lend' method="post" style="align-items: center;">
        <table>
            <tr>
                <td>用户名 ：</td>
                <td>

                    <input type="text" name="username" id="username">
                </td>
            </tr>
            <tr>
                <td>密码： </td>
                <td>
                    <input type="password" name="passworld" id="passworld" >
                </td>
            </tr>
            <%--<tr>--%>
                <%--<td>验证码 ： </td>--%>
                <%--<td>--%>
                    <%--<input type="text" name="code" id="code"/>--%>
                    <%--<img id="validationCode_img"  src="view/code.jsp"><br>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <tr>
                <td>
                    <input type="submit" value="登陆">
                </td>
                <td>
                    <input type="button" value="注册" id="register">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="button" value="初始化数据库" onclick="jsp();">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
