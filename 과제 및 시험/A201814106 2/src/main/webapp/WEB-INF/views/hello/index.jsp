<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <style>
    table { border-collapse: collapse; }
    td { width: 120; padding: 8px; border: 1px solid gray; }
  </style>
</head>
<body>
  <table>
    <tr>
      <td>학번</td>
      <td>${ student.number }</td>
    </tr>
    <tr>
      <td>이름</td>
      <td>${ student.name }</td>
    </tr>
    <tr>
      <td>시각</td>
      <td><fmt:formatDate pattern="HH:mm:ss" value="${ date }" /></td>   
    </tr>
  </table>
</body>
</html>

