<%@ page import="java.util.List" %>
<%@ page import="com.rbac.studengrbac.model.Power" %>
<%@ page import="java.nio.file.Path" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎进入系统</title>
    <%
        List<Power> list=(List<Power>) request.getAttribute("listPower");
        int i=list.size();
    %>
</head>
<body>
<div style="height: 120px;width: auto" >

</div>
<div style="height: 20px;width: auto">
    <ul>
        <%
            for (int j=0;j<i;j++){
                Power power=list.get(j);
        %>
        <li style="float: left;margin-right: 10px;">
            <button onclick="query(<%=power.getUrl()%>)"><%=power.getName()%></button>
        </li>
        <%
            }
        %>
    </ul>
</div>
</body>
<script type="text/javascript">
    function query(id){
        window.href=<%=path%>/id;
    }
</script>
</html>
