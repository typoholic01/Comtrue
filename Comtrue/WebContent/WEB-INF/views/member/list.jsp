<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>직원 목록</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<!-- list-style -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/list.css" />
<!-- FIX URL -->
<script type="text/javascript">
window.history.replaceState(null, '', "${pageContext.request.contextPath}/member/list");
</script>
<!-- CSV Ajax -->
<script type="text/javascript">
function getCSV() {	
	$.ajax({
		type: 'GET',
		url: '${pageContext.request.contextPath }/member/list/csv',
		data: {
		},		
		async: true, 
		success: function(data) {
			console.log(data);
			window.location.assign('${pageContext.request.contextPath }/upload/csv/'+data);
		}	
	});	
}
function getXLS() {	
	$.ajax({
		type: 'GET',
		url: '${pageContext.request.contextPath }/member/list/xls',
		data: {
		},		
		async: true, 
		success: function(data) {
			console.log(data);
			window.location.assign('${pageContext.request.contextPath }/upload/xls/'+data);
		}	
	});	
}
function setMemberHtml(member) {
	var html = '<tr>'
					+'<td>'+fixDigit(member.memberNo)+'</td>'
					+'<td>'+member.rank+'</td>'
					+'<td><a href="./update?memberNo='+member.memberNo+'">'+member.name+'</a></td>'
					+'<td>'+member.phone+'</td>'
					+'<td>'+member.email+'</td>'
					+'<td><button type="button" class="btn btn-danger btn-xs" onclick="location.href=\'${pageContext.request.contextPath }/member/delete?memberNo='+member.memberNo+'\'"><i class="fa fa-comments"></i>삭제</button></td>'
				+'</tr>';
	
	return html;
}
</script>
<!-- Ajax -->
<script type="text/javascript">
function getMemberList() {
	//페이지 초기화
	var column = '${param.column}';
	var scending = '${param.scending}';
	var query = '${param.query}';
	
	$.ajax({
		type: 'GET',
		url: '${pageContext.request.contextPath }/member/list/json',
		data: {
			'column': column,
			'scending': scending,
			'query': query
		},		
		async: true, 
		success: function(data) {
			console.log(data);
			
 			$.each(data, function(index, item) {
 				console.log(data[index]);
  				//글 만들기
 				$('#postList > tbody').append(setMemberHtml(data[index]));
			}); 
		}	
	});
	
}
function setMemberHtml(member) {
	var html = '<tr>'
					+'<td>'+fixDigit(member.memberNo)+'</td>'
					+'<td>'+member.rank+'</td>'
					+'<td><a href="./update?memberNo='+member.memberNo+'">'+member.name+'</a></td>'
					+'<td>'+member.phone+'</td>'
					+'<td>'+member.email+'</td>'
					+'<td><button type="button" class="btn btn-danger btn-xs" onclick="location.href=\'${pageContext.request.contextPath }/member/delete?memberNo='+member.memberNo+'\'"><i class="fa fa-comments"></i>삭제</button></td>'
				+'</tr>';
	
	return html;
}
function fixDigit(prefix) {		
	prefix = "" + prefix;
	
	if (prefix.length == 1) {
		prefix = '00'+ prefix;
	} else if (prefix.length == 2) {
		prefix = '0' + prefix;
	}
	
	return prefix;
}
</script>
</head>
<body>
<!-- body -->
<h2 class="category-title">직원 목록</h2>

<div class="row">
<div class="col-sm-12">
<div class="table-responsive">          
  <table id="postList" class="table table-hover table-bordered">
  	<colgroup>
  		<col class="col-sm-1" />
  		<col class="col-sm-2" />
  		<col class="col-sm-4" />
  		<col class="col-sm-2" />
  		<col class="col-sm-2" />
  		<col class="col-sm-1" />
  	</colgroup>
    <thead>
      <tr class="active">
        <th>직원 번호</th>
        <th>직급</th>
        <th>이름</th>
        <th>전화번호</th>
        <th>이메일</th>
        <th>삭제</th>
      </tr>
    </thead>
    <tbody>
 	<!-- 				게시물 불러오기				 -->   
 	<script type="text/javascript">
		getMemberList();
	</script>
    </tbody>
  </table>
  </div>
</div>
</div>

	<div class="search-group col-sm-12">
		<form action="./list" id="search" method="get">
		<div class="search">
			<div class="form-group col-sm-2">
			  <select class="form-control" id="sel1" name="column">
			    <option value="member_no">직원번호</option>
			    <option value="rank">직급</option>
			    <option value="name">이름</option>
			    <option value="phone">전화번호</option>
			    <option value="email">이메일</option>
			  </select>
			</div>
			<div class="form-group col-sm-7">
				<input type="text" class="form-control" name="query" id="query" placeholder="검색어를 입력해주세요">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary"><i class="fa fa-comments"></i> 검색</button>	
			</div>
		</div>
		</form>
	</div>

    <!-- 버튼 목록 -->
	<div class="button-group col-sm-12" style="text-align: -webkit-right;">
		<div class="arc-comment">
			<button type="button" class="btn btn-primary" onclick="getXLS();"><i class="fa fa-comments"></i> XLS 받기</button>	
			<button type="button" class="btn btn-primary" onclick="getCSV();"><i class="fa fa-comments"></i> CSV 받기</button>	
			<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath }/member/account'"><i class="fa fa-comments"></i> 직원 등록</button>			
		</div>
	</div>
    
</body>
</html>