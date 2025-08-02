
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
  <title>Thêm / Sửa Sinh Viên</title>
</head>
<body>
<h2>${studentDTO.id == null ? 'Thêm mới' : 'Cập nhật'} sinh viên</h2>
<form:form method="post" action="/students/save" modelAttribute="studentDTO">
  <form:hidden path="id"/>

  <label>Tên:</label>
  <form:input path="studentName"/>
  <form:errors path="studentName" cssClass="text-danger"/><br/>

  <label>Email:</label>
  <form:input path="email"/>
  <form:errors path="email" cssClass="text-danger"/><br/>

  <label>Điểm:</label>
  <form:input path="ageMark" type="number" step="0.01"/>
  <form:errors path="ageMark" cssClass="text-danger"/><br/>

  <label>Hành động:</label>
  <form:radiobutton path="issStudying" value="true" label="Đang học"/>
  <form:radiobutton path="issStudying" value="false" label="Đã nghỉ"/>
  <form:errors path="issStudying" cssClass="text-danger"/><br/>

  <button type="submit">Lưu</button>
</form:form>
<a href="/students">Quay lại danh sách</a>
</body>
</html>

