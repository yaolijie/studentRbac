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
                <button onclick="queryUrl('<%=power.getUrl()%>')"><%=power.getFullName()%>+<%=j%></button>
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
       // $("#menu").attr("src","<%=path%>/QueryServlet?t=queryPerson");
    });
    function querymenu(id){
        alert("aaa  "+id );
       $("#menu").attr("src","<%=path%>"+id);//.src="<%=path%>"+id;
    }
    function queryUrl(url){
        var personid=<%=request.getSession().getAttribute("personid")%>
    //$("#menu").attr("src",url+"&personid="+personid);
        alert('<%=path%>'+"/"+url+"&personid="+personid);
        window.location.href='<%=path%>'+"/"+url+"&personid="+personid;
    }
</script>
