<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>직원 등록 실패</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>	
<div class="container">
	<div class="row main col-sm-12">
		<h1 class="text-danger text-center">직원 등록에 실패하였습니다</h1>
		<p class="text-center">직원 번호가 중복되지 않는지 확인해주세요</p>	
		<form action="${pageContext.request.contextPath }/member/list" style="text-align: -webkit-center;">
		<button type="submit" class="btn btn-danger" >목록으로</button>
		</form>
	</div>
</div>
</body>
</html>