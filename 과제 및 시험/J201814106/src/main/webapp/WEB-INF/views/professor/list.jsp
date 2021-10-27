<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="/common.css" />
  <style>
    td:nth-child(1) { text-align: center; }
  </style>
</head>
<body>
<div class="container">
  <h1>교수목록 </h1>
  <table class="list">
    <thead>
      <tr>
        <th>id</th>
        <th>교수번호 </th>
        <th>교수명 이름 </th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="professor" items="${ professors }">
        <tr>
          <td>${ professor.id }</td>
          <td>${ professor.professorNo }</td>
          <td>${ professor.name }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>

