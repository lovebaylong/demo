<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>添加用户</title>
    </head>
    <body>
        ${message}
        <br />
        <br />
        <form action="/user/save" method="post">
            <div>
                <label for="name">姓名</label>
                <div>
                    <input type="text" name="name" id="name" value="${user.name}" maxlength="20" autocomplete="off">
                </div>
            </div>
            <div>
                <label for="type">类型</label>
                <div>
                    <input type="text" name="type" id="type" value="${user.type}" maxlength="1" autocomplete="off">
                </div>
            </div>
            <div>
                <label for="idCardNo">身份证号</label>
                <div>
                    <input type="text" name="idCardNo" id="idCardNo" value="${user.idCardNo}" maxlength="18" autocomplete="off">
                </div>
            </div>
            <div>
                <label for="phone">电话</label>
                <div>
                    <input type="text" name="phone" id="phone" value="${user.phone}" maxlength="11" autocomplete="off">
                </div>
            </div>
            <div>
                <label for="email">邮箱</label>
                <div>
                    <input type="text" name="email" id="email" value="${user.email}" maxlength="100" autocomplete="off">
                </div>
            </div>
            <div>
                <label for="address">地址</label>
                <div>
                    <input type="text" name="address" id="address" value="${user.address}" maxlength="100" autocomplete="off">
                </div>
            </div>
            <div>
                <label for="age">年龄</label>
                <div>
                    <input type="text" name="age" id="age" value="${user.age}" maxlength="3" autocomplete="off">
                </div>
            </div>
            <div>
                <label for="isLive">是否在世</label>
                <div>
                    <select name="isLive" id="isLive">
                        <option value="true" <c:if test="${user.isLive}">selected</c:if>>在世</option>
                        <option value="false" <c:if test="${!user.isLive}">selected</c:if>>逝世</option>
                    </select>
                </div>
            </div>
            <br />
            <div>
                <button type="submit">保存</button>
            </div>
        </form>
    </body>
</html>
