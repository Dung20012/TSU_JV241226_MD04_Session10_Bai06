<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Danh sách sinh viên</title>
</head>
<body>

<h2>Danh sách sinh viên</h2>

<!-- Nút thêm mới -->
<p><a href="/students/create">Thêm sinh viên mới</a></p>

<table border="1" cellpadding="5" cellspacing="0">
  <tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Email</th>
    <th>Điểm</th>
    <th>Đang học</th>
    <th>Hành động</th>
  </tr>
  <c:forEach var="s" items="${students}">
    <tr>
      <td>${s.id}</td>
      <td>${s.studentName}</td>
      <td>${s.email}</td>
      <td>${s.ageMark}</td>
      <td>${s.issStudying ? 'Có' : 'Không'}</td>
      <td>
        <!-- Nút sửa -->
        <a href="/students/edit?id=${s.id}">Sửa</a> |

        <!-- Nút xóa (chỉ khi không đang học) -->
        <c:if test="${!s.issStudying}">
          <a href="/students/delete?id=${s.id}" onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
        </c:if>
        <c:if test="${s.issStudying}">
          <span style="color: gray;">Không thể xóa</span>
        </c:if>
      </td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
