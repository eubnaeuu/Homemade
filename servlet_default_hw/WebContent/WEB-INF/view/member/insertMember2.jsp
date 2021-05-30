<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- icheck bootstrap -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css">
</head>
<style>
body {
	text-align: center;
}

table td {
	text-align: center;
}

a {
	text-decoration-line: none;
	color: black;
}

input {
	width: 140px;
}
</style>
<body class="hold-transition register-page">
	<div class="register-box">
		<div class="register-logo">
			<a href="../../index2.html"><b>DDit</b></a>
		</div>

		<div class="card">
			<div class="card-body register-card-body">
				<p class="login-box-msg">회원가입</p>

				<form action="insert" method="post" id="fm"
					onsubmit="return check()">
					<div class="input-group mb-3 col-sm-15">
						<input type="text" class="form-control" name="memId" id="id"
							placeholder="아이디">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-user"></span>
							</div>
						</div>
						<div>
							<button type="button" class="btn btn-default"
								onclick="chkId_insert()">중복검사</button>
							<br>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="password" class="form-control" name="memPass"
							id="pwd" placeholder="비밀번호">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="password" class="form-control" placeholder="비밀번호 확인">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-check"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
<!-- 						<input type="date" class="form-control" name="memBirth" id="birth" placeholder="생일"> -->
						<input type="text" class="form-control" name="memBirth" id="birth" data-inputmask-alias="datetime" data-inputmask-inputformat="yyyy/mm/dd" placeholder="19920901">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-calendar"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="text" class="form-control" name="memHp" id="hp"
							placeholder="연락처">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-phone"></span>
							</div>
							<input type="hidden" value="" id="chekedId">
						</div>
					</div>
					<div class="row">
						<!-- /.col -->
						<div class="col-6">
							<button type="submit" class="btn btn-default btn-block">등록</button>
						</div>
						<div class="col-6">
							<a href="<c:url value='/'/>login"><button type="button"
									class="btn btn-default btn-block">취소</button></a>
						</div>
						<!-- /.col -->
					</div>
				</form>
			</div>
			<!-- /.form-box -->
		</div>
		<!-- /.card -->
	</div>
	<!-- /.register-box -->
	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/adminlte.min.js"></script>
	<script type="text/javascript"
		src="/servlet_default/js/util/myutils.js"></script>
</body>
<script>
	function doublecheckedId() {
		if (($("#chekedId").val() != $("#id").val())
				|| ($("#chekedId").val() == "")) {
			return false;
		} else {
			return true;
		}
	}

	function check() {

		if (isEmpty($("#id").val())) {
			alert("ID를 입력해주세요");
			return false;
		}

		if (!doublecheckedId()) {
			alert("ID중복체크를 해주시기 바랍니다");
			return false;
		}

		// ID 정규화 체크

		if (isEmpty($("#pwd").val())) {
			alert("비밀번호를 입력해주세요");
			return false;
		}

		if (isEmpty($("#hp").val())) {
			alert("전화번호를 입력해주세요");
			return false;
		}

		if (isEmpty($("#birth").val())) {
			alert("생일을 입력해주세요");
			return false;
		}

		return true;
	}

	function chkId_insert() {

		if (isEmpty($("#id").val())) {
			alert("ID를 입력해주세요");
			return;
		}

		var id = $("#id").val();
		var param = {
			"id" : id,
			"flag" : "chkId"
		}
		$.ajax({
			url : "/servlet_default/insert",
			data : param,
			type : "post",
			dataType : "json",
			success : function(data) {
				if (data == null) {
					alert("사용이 가능합니다");
					$("#chekedId").val(id);
				} else {
					alert("중복된 ID입니다")
					$("#chekedId").val("");
				}
			},
			error : function(xhr) {
				console.error(xhr);
			}
		})
	}
</script>
</html>