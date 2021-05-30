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
<body class="hold-transition">
	<div class="wrapper">
		<!-- Horizontal Form -->
		<div class="card card-info">
			<div class="card-header">
				<h3 class="card-title">Horizontal Form</h3>
			</div>
			<!-- /.card-header -->
			<!-- form start -->
			<form action="insert" class="form-horizontal" method="post" id="fm" onsubmit="return check()">
				<div class="card-body">
					<div class="form-group row">
						<label for="inputTitle" class="col-sm-2 col-form-label">제목</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputTitle" >
						</div>
					</div>
				<!-- /.card -->
					<div class="row">
						<div class="col-md-12">
							<div class="card card-outline card-info">
								<div class="card-header">
									<h3 class="card-title">Summernote</h3>
								</div>
				<!-- /.card-header -->
								<div class="card-body">
									<textarea id="summernote">
			                Place <em>some</em> <u>text</u> <strong>here</strong>
			              </textarea>
								</div>
								<div class="card-footer">
									Visit <a href="https://github.com/summernote/summernote/">Summernote</a>
									documentation for more examples and information about the plugin.
								</div>
							</div>
						</div>
				<!-- /.col-->
					</div>
				</div>
				<!-- /.card-body -->
				<div class="card-footer">
					<button type="submit" class="btn btn-info">등록</button>
					<button type="submit" class="btn btn-default float-right">취소</button>
				</div>
				<!-- /.card-footer -->
			</form>
		</div>
	</div>
	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/adminlte.min.js"></script>
	<script type="text/javascript" src="/servlet_default/js/util/myutils.js"></script>
</body>
</html>