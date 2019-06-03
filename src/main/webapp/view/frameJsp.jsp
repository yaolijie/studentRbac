<%--
  Created by IntelliJ IDEA.
  User: lj
  Date: 2019/6/3
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<style type="text/css">
    div{
        margin:0 0 0 0;
    }
    #headdiv{
        margin-top: -1px;
        float: left;
    }
</style>
<div>
    <div id="headdiv">
        <label>
            <span>用户： </span><span id="username">${user.username}</span>
        </label>
        <label>
            <button id="signout">推出</button>
        </label>
    </div>
</div>
