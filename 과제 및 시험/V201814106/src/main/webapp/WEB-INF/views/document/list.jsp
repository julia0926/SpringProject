<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
      td:nth-child(1), td:nth-child(4) { text-align: center; }
      td:nth-child(3) { text-align: right; }
      form { margin-bottom: 5px; }
      a.btn { float: right; }
  </style>
</head>
<body>
<div class="container">
  <h1>문서 목록</h1>
  <form:form method="get" modelAttribute="pagination">
    <form:hidden path="pg" value="1" />
    <form:hidden path="sz" />
    <span>폴더 :</span>
    <form:select path="fi" class="form-control">
      <form:option value="0">전체</form:option>
      <form:options itemValue="id" itemLabel="title" items="${ folders }" />
    </form:select>    
    <button type="submit" class="btn">검색</button>
    <a href="create?${pagination.queryString}" class="btn">문서 등록</a>
  </form:form>
  
  <table class="list">
    <thead>
      <tr>
        <th>ID</th>
        <th>파일명</th>
        <th>크기</th>
        <th>수정일</th>
        <th>폴더</th>
        <th>상태</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="document" items="${ documents }">
        <tr data-url="edit?id=${document.id}&${pagination.queryString}">
          <td>${ document.id }</td>
          <td>${ document.fileName }</td>
          <td><fmt:formatNumber value="${ document.size }" pattern="#,###,###"/></td>
          <td><fmt:formatDate pattern="yyyy-MM-dd" value="${ document.modifiedDate }" /></td>
          <td>${ document.folder.title }</td>
          <td>${ document.state }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <my:pagination pageSize="${ pagination.sz }" recordCount="${ pagination.recordCount }" 
                 queryStringName="pg" />
</div>
</body>
</html>

