<%@ page import="java.util.List" %>
<%@ page import="com.rbac.studengrbac.model.Role" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.rbac.studengrbac.model.Power" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Role> roles=(ArrayList)request.getAttribute("roleArrayList");
    List<Power> powers=(ArrayList)request.getAttribute("powerArrayList");

%>
<div style="height: 60%;" align="center">
    <div id="roleDiv" style="float: left;">
        <table id="tablerole">
            <thead>
            <tr>
                <th></th>
                <th>角色名</th>
                <th>角色简称</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (int i=0;i< roles.size();i++){
                    Role role=roles.get(i);

            %>
            <tr>
                <td>
                    <input type="radio" name="roleid" value="<%=role.getId()%>">
                </td>
                <td>
                    <input type="text" value="<%=role.getName()%>">
                </td>
                <td>
                    <input type="text" value="<%=role.getRoleName()%>">
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>

    <div id="button" >
        <button  onclick="allocationPower()">分配权限</button>
    </div>

    <div id="powerDiv" style="float: right">
        <table id="tablepower">
            <thead>
            <tr>
                <th></th>
                <th>权限名称</th>
                <th>权限简称</th>
                <th>权限url</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (int i=0;i<powers.size();i++){
                    Power power=powers.get(i);
            %>
            <tr>
                <td>
                    <input type="checkbox" name="powerid" value="<%=power.getId()%>">
                </td>
                <td>
                    <input type="text" value="<%=power.getFullName()%>">
                </td>
                <td>
                    <input type="text" value="<%=power.getName()%>">
                </td>
                <td>
                    <input type="text" value="<%=power.getName()%>">
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>
<script type="application/javascript">
    function allocationPower(){
        var roleid=$("input[name=roleid]:checked").val();//
        var powerid=[];
        $("input[name=powerid]:checked").each(function () {
            powerid.push($(this).val());
        });
        alert("roleid"+roleid+"\n"+"powerid"+powerid);

        $.ajax({
            url:'<%=path%>/AllocationServlet?t=alloctionPower',
            method:'post',
            data:{
                roleid:roleid.toString(),
                powerid:powerid
            },
            success:function (data) {
                alert(data);
            }
        });
    }
</script>
