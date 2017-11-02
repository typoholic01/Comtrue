<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>직원 등록</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<!-- 공백체크 -->
<script type="text/javascript">
function checkValues() {
	var memberNo, rank, name, email, phone;
	
	memberNo = $('#memberNo').val();
	rank = $('#rank').val();
	name = $('#name').val();
	phone = $('#phone').val();
	email = $('#email').val();
	
	if (check(memberNo) && check(rank) && check(name) && check(phone) && check(email)) {
		$( "#account" ).submit();
	}
}

function check(str) {	
	console.log(str);
	
	str = str.trim();
	console.log(str);	
	
	if( str == '' || str == null ){
	    alert( '값을 입력해주세요' );
	    return false;
	} else {
		return true;
	}
}

function checkLength() {
	memberNo = $('#memberNo').val();
	
	memberNo = "" + memberNo;
	
	if( memberNo.length > 3){
		memberNo = memberNo.substring(0,3);
		$('#memberNo').val(memberNo);
	}
}


</script>
</head>
<body>
	<div class="container">
	<div class="row main col-sm-4 col-sm-offset-4">
		<div class="panel-heading">
              <div class="panel-title text-center">
              		<h1 class="title">활자중독</h1>
              		<hr />
              	</div>
           </div> 
		<div class="main-login main-center">
			<form class="form-horizontal" method="post" action="./update">
			<input type="hidden" name="originalMemberNo" value="${member.memberNo }" />
			
				<!-- 사번 -->
				<div class="form-group">
					<label for="name" class="cols-sm-2 control-label">사번</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon" style="    padding: 6px 13.5px;"><i class="fa fa-user fa" aria-hidden="true"></i></span>
							<input max="999" type="number" class="form-control" name="memberNo" id="memberNo" placeholder="사번을 입력해주세요" value="${member.memberNo }" onblur="checkLength();" />
						</div>
					</div>
				</div>
				
				<!-- 이름 -->
				<div class="form-group">
					<label for="name" class="cols-sm-2 control-label">이름</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon" style="    padding: 6px 13.5px;"><i class="fa fa-user fa" aria-hidden="true"></i></span>
							<input type="text" class="form-control" name="name" id="name" placeholder="이름을 입력해주세요" value="${member.name }"/>
						</div>
					</div>
				</div>

				<!-- 직급 -->
				<div class="form-group">
					<label for="rank" class="cols-sm-2 control-label">직급</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
							<input type="text" class="form-control" name="rank" id="rank" placeholder="직급을 입력해주세요" value="${member.rank }"/>
							<span class="glyphicon glyphicon-ok form-control-feedback" style="display: none;"></span>
						</div>
					</div>
				</div>

				<!-- 전화번호 -->
				<div class="form-group">
					<label for="phone" class="cols-sm-2 control-label">전화번호</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
							<input type="text" class="form-control" name="phone" id="phone" placeholder="전화번호를 입력해주세요" value="${member.phone }"/>
							<span class="glyphicon glyphicon-ok form-control-feedback" style="display: none;"></span>
						</div>
					</div>
				</div>
				
				<!-- 이메일 -->
				<div class="form-group">
					<label for="email" class="cols-sm-2 control-label">이메일</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
							<input type="text" class="form-control" name="email" id="email" placeholder="이메일을 입력해주세요" value="${member.email }"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-lg btn-block login-button">등록</button>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>