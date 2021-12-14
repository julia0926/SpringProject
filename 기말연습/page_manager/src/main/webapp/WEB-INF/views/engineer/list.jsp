<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link rel="stylesheet" type="text/css" href="${R}common.css">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="${R}common.js"></script>
  <style>
      form { margin-bottom: 5px; }
      a.btn { float: right; }
  </style>
</head>
<body>
<div class="container">
  <h1>엔지니어 목록</h1>
  <form:form method="get" modelAttribute="pagination">
    <form:hidden path="pg" value="1" />
    <form:hidden path="sz" />
    <span>역할 :</span>
    <form:select path="di" class="form-control">
      <form:option value="0">전체</form:option>
      <form:options itemValue="id" itemLabel="title" items="${ roles }" />
    </form:select>    
    <button type="submit" class="btn">검색</button>
    <a href="create?${pagination.queryString}" class="btn">엔지니어 등록</a>
  </form:form>
  
  <table class="list">
    <thead>
      <tr>
        <th>ID</th>
        <th>고유번호 </th>
        <th>이름</th>
        <th>역할 </th>
        <th>휴대번호 </th>
        <th>성별 </th>
        <th>이메일 </th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="engineer" items="${ engineers }">
        <tr data-url="edit?id=${engineer.id}&${pagination.queryString}">
          <td>${ engineer.id }</td>
          <td>${ engineer.employeeNo }</td>
          <td>${ engineer.name }</td>
          <td>${ engineer.role.title }</td>
          <td>${ engineer.phone }</td>
          <td>${ engineer.sex }</td>
          <td>${ engineer.email }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <my:pagination pageSize="${ pagination.sz }" recordCount="${ pagination.recordCount }" 
                 queryStringName="pg" />
</div>
</body>
</html>

