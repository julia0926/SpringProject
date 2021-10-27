<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="/common.js"></script>
  <link rel="stylesheet" type="text/css" href="/common.css" />
  <style>
    h3 { margin-bottom: 2px; }
    td { text-align: center; }
  </style>
</head>
<body>
<div class="container">
  <h1>학과별 소속학생 </h1>
  <c:forEach var="department" items="${ departments }">
    <h3>${ department.id } - ${ department.departmentName }</h3>
    <table class="list">
      <thead>
        <tr>
          <th>id</th>
          <th>학번 </th>
          <th>이름 </th>
          <th>학년 </th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="student" items="${ department.students }">
          <tr>
            <td>${ student.id }</td>
            <td>${ student.studentNumber }</td>
            <td>${ student.name }</td>
            <td>${ student.year }</td>            
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </c:forEach>
</div>
</body>
</html>

