<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css">
<title>회원리스트</title>
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
</style>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		
<!-- 		<div class="content-wrapper"> -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row">
						<div class="col-sm-12">
							<h1 class="m-0">회원 세부 정보</h1>
						</div>
					</div>
				</div>
			</div>
			<!-- /.card-header -->
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-sm-12">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">회원 세부 정보</h3>
								</div>
								<div class="card-body">
									<div class="row">
										<div class="col-sm-12">
											<table id="example2"
												class="table table-bordered">
												<tr>
													<td><b>아이디</b></td>
													<td>${memberVo.id}</td>
												</tr>
												<tr>
													<td><b>이메일</b></td>
													<td>${memberVo.email}</td>
												</tr>
												<tr>
													<td><b>사진</b></td>
													<td>${memberVo.picture}</td>
												</tr>
												<tr>
													<td><b>0퇴사1재직2휴직</b></td>
													<td>${memberVo.enabled}</td>
												</tr>
												<tr>
													<td><b>입사일</b></td>
													<td>${memberVo.regDate}</td>
												</tr>
												<tr>
													<td><b>휴대전화번호</b></td>
													<td>${memberVo.phone}</td>
												</tr>
												<tr>
													<td><b>이름</b></td>
													<td>${memberVo.name}</td>
												</tr>
												<tr>
													<td><b>등록자</b></td>
													<td>${memberVo.register}</td>
												</tr>
												<tr>
													<td><b>주소</b></td>
													<td>${memberVo.address}</td>
												</tr>
												<tr>
													<td><b>권한</b></td>
													<td>${memberVo.authority}</td>
												</tr>
												<c:if test="${memberVo == null }">
													<tr>
														<td>회원정보가 존재하지 않습니다</td>
													</tr>
												</c:if>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.card-body -->
			<form action="delete" method="post" id="fm" onsubmit="return totalCheck()">
				<input type="hidden" value="${memberVo.id}" id="id" name="id">
				<a href="<c:url value='/' />member/update.do?id=${memberVo.id}"><button
						type="button" class="btn btn-default" id="updatebtn">수정</button></a>
				<button type="submit" class="btn btn-default" id="deleteAllbtn">삭제</button>
				<a href="<c:url value='/' />member/list.do"><button type="button"
						class="btn btn-default">목록</button></a>
			</form>
<!-- 		</div> -->
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/util/myutils.js"></script>
</body>
<script type="text/javascript">
function totalCheck() {
	if(!deleteConfirm()){
		return false;
	}
}
</script>
</html>