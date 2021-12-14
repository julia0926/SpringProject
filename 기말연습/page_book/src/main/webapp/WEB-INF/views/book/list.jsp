<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link rel="stylesheet" type="text/css" href="${R}common.css">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="${R}common.js"></script>
  <style>
      a.btn { float: right; margin: -20px 0 5px 0; }
  </style>
</head>
<body>
<div class="container">
  <h1>책 목록</h1>
  <form:form method="get" modelAttribute="pagination">
    <form:hidden path="pg" value="1" />
    <form:hidden path="sz" />
    <span>카테고리 :</span>
    <form:select path="di" class="form-control">
      <form:option value="0">전체</form:option>
      <form:options itemValue="id" itemLabel="name" items="${ categorys }" />
    </form:select>    
    <button type="submit" class="btn">검색</button>
  <a href="create?${pagination.queryString}" class="btn">책 등록</a>
  </form:form>
  
  <table class="list">
    <thead>
      <tr>
        <th>ID</th>
        <th>제목 </th>
        <th>저자 </th>
        <th>카테고리 </th>
        <th>가격 </th>
        <th>출판사 </th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="book" items="${ books }">
        <tr data-url="edit?id=${book.id}&${pagination.queryString}">
          <td>${ book.id }</td>
          <td>${ book.title }</td>
          <td>${ book.author }</td>
          <td>${ book.category.name }</td>
          <td>${ book.price }</td>
          <td>${ book.publisher }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <my:pagination pageSize="${ pagination.sz }" recordCount="${ pagination.recordCount }" 
                 queryStringName="pg" />
</div>
</body>
</html>

