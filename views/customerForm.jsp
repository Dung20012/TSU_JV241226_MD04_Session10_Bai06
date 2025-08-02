<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Thêm / Sửa Khách hàng</title>
</head>
<body>
<h2>${customerDTO.id == null ? 'Thêm mới' : 'Chỉnh sửa'} khách hàng</h2>

<form:form method="post" action="/customers/save" modelAttribute="customerDTO">
  <form:hidden path="id"/>

  <label>Username:</label>
  <form:input path="username"/>
  <form:errors path="username" cssClass="error"/><br/>

  <label>Password:</label>
  <form:password path="password"/>
  <form:errors path="password" cssClass="error"/><br/>

  <label>Email:</label>
  <form:input path="email"/>
  <form:errors path="email" cssClass="error"/><br/>

  <label>Phone:</label>
  <form:input path="phone"/>
  <form:errors path="phone" cssClass="error"/><br/>

  <label>Status:</label>
  <form:checkbox path="status"/> <br/>

  <label>Role:</label>
  <form:select path="role">
    <form:option value="ADMIN" label="ADMIN"/>
    <form:option value="USER" label="USER"/>
  </form:select><br/><br/>

  <button type="submit">Lưu</button>
</form:form>

<br/>
<a href="/customers">Quay lại danh sách</a>
</body>
</html>
