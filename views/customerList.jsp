
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Danh sách khách hàng</title>
</head>
<body>
<h2>Danh sách khách hàng</h2>

<a href="/customers/create">Thêm khách hàng</a>
<table border="1" cellpadding="5">
  <tr>
    <th>ID</th>
    <th>Username</th>
    <th>Email</th>
    <th>Phone</th>
    <th>Status</th>
    <th>Role</th>
    <th>Hành động</th>
  </tr>
  <c:forEach var="c" items="${customers}">
    <tr>
      <td>${c.id}</td>
      <td>${c.username}</td>
      <td>${c.email}</td>
      <td>${c.phone}</td>
      <td><c:out value="${c.status ? 'Đang hoạt động' : 'Ngừng'}"/></td>
      <td>${c.role}</td>
      <td>
        <a href="/customers/edit?id=${c.id}">Sửa</a> |
        <a href="/customers/delete?id=${c.id}" onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>

