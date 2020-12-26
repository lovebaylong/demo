<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>用户列表</title>
    </head>
    <body>
        <a href="/user/add">添加</a>
        <form method="get" action="/user/list">
            <input name="name" value="${name}" placeholder="名称">
            <button type="submit">查询</button>
        </form>
        <table>
            <thead>
                <tr>
                    <th>编号</th>
                    <th>类型</th>
                    <th>名称</th>
                    <th>身份证号</th>
                    <th>电话</th>
                    <th>邮箱</th>
                    <th>地址</th>
                    <th>年龄</th>
                    <th>在世</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${empty userList }">
                        <tr>
                            <td colspan="10" style="text-align: center;">暂无用户</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${userList }" var="e">
                            <tr>
                                <td class="text-center">${e.id }</td>
                                <td class="text-center">${e.type }</td>
                                <td class="text-center">${e.name }</td>
                                <td class="text-center">${e.idCardNo }</td>
                                <td class="text-center">${e.phone }</td>
                                <td class="text-center">${e.email }</td>
                                <td class="text-center">${e.address }</td>
                                <td class="text-center">${e.age }</td>
                                <td class="text-center">${e.isLive }</td>
                                <td class="text-center">
                                    <a href="view/${e.id}">详情</a>
                                    <a href="edit/${e.id}">编辑</a>
                                    <a href="delete/${e.id}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
    </body>
</html>
