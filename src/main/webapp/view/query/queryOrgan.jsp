<%@ page import="com.rbac.studengrbac.model.Organ" %>
<%@ page import="com.rbac.studengrbac.model.Person" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Organ> list=(List<Organ>)request.getAttribute("orglist");
    int length=list.size();
%>
<div >
    <table id="queryOr" border="2">
        <thead>
        <tr>
            <td>编号</td>
            <td>机构名</td>
            <td>机构编码</td>
            <td>联系电话</td>
            <td>机构地址</td>
            <td>备注</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <%
            int i=0;
            for(;i<length;i++){
                Organ organ=list.get(i);
        %>
        <tr>
            <td><%=i+1%></td>
            <td><%=organ.getOrganName()%></td>
            <td><%=organ.getCode()%></td>
            <td><%=organ.getAddress()%></td>
            <td><%=organ.getPhone()%></td>
            <td><%=organ.getRemark()%></td>
            <td>
                <button onclick="queryObjectOrgan('<%=organ.getId()%>')">查看</button>
                <button onclick="updateOr('<%=organ.getId()%>')">修改</button>
                <button onclick="deleteOr('<%=organ.getId()%>')">删除</button>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
<script type="text/javascript">
    function deleteOr(deleteid){
        $.ajax({
            url:'<%=path%>/DeleteServlet?t=deleteOrgan&deleteid='+deleteid,
            method:'get'
        });
    }

    function updateOr(updateid){
        $.ajax({
            url:'<%=path%>/UpdateServlet?t=updateOrgan&updateid='+updateid,
            method:'get'
        });
    }

    function queryObjectOrgan(queryid){
        $.ajax({
            url:'<%=path%>/QueryObjectServlet?t=queryOrgan&queryid='+queryid,
            method:'get'
        });
    }
</script>
