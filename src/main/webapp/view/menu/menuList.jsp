<%@ page import="com.rbac.studengrbac.model.Power" %>
<%@ page import="java.util.List" %>
    <title>欢迎登陆权限管理系统</title>
    <%
        List<Power> list=(List<Power>) request.getAttribute("listPower");
        int i=list.size();
    %>
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
<div>
    <iframe id="menu"></iframe>
</div>
<script type="text/javascript">
    function query(id){
       $("#menu").src=<%=path%>+id;
    }
</script>
