<%@ page import="com.rbac.studengrbac.model.Power" %>
<%@ page import="java.util.List" %>
    <title>欢迎登陆权限管理系统</title>
    <%
        List<Power> list=(List<Power>) request.getAttribute("listPower");
        int i=list.size();
    %>
<div style="height: 100%;width: 100%">
    <div style="height:auto;width: 100%;margin-top: 0px;">
        <ul style="list-style-type: none;">
            <%
                for (int j=0;j<i;j++){
                    Power power=list.get(j);
            %>
                <li style="float: left;margin-right: 10px;">
                <button onclick="queryUrl('<%=power.getUrl()%>')"><%=power.getFullName()%></button>
                </li>
            <%
                    }
            %>
        </ul>
    </div>
    <div>
        <iframe id="menu" style="margin-top: 20px;height:auto;width: 100%"></iframe>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        var personid=<%=request.getSession().getAttribute("personid")%>
        $("#menu").attr("src","<%=path%>/<%=list.get(0).getUrl()%>"+"&personid="+personid);
    });
    function queryUrl(url){
    var personid=<%=request.getSession().getAttribute("personid")%>
        alert('<%=path%>'+"/"+url+"&personid="+personid);
        //window.location.href='<%=path%>'+"/"+url+"&personid="+personid;
        $("#menu").attr("src",'<%=path%>'+"/"+url+"&personid="+personid);
    }
</script>
