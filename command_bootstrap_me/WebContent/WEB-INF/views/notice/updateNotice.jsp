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

<title>회원수정</title>
<style type="text/css">
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
</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		
<!-- 		<div class="content-wrapper"> -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row">
						<div class="col-sm-12">
							<h1 class="m-0">회원 정보 변경</h1>
						</div>
					</div>
				</div>
			</div>
			<!-- /.card-header -->
			<div class="content">
				<div class="container-fluid">
					<div class="card">
						<div class="card-header">
							<h3 class="card-title">회원 정보 변경</h3>
						</div>
						<div class="card-body">
							<div id="example2_wrapper"
								class="dataTables_wrapper dt-bootstrap4">
								<div class="row">
									<div class="col-sm-12">
										<form action="update" method="post" id="fm"
											onsubmit="return totalCheck()">
											<table id="example2"
												class="table table-bordered table-hover dataTable dtr-inline"
												role="grid" aria-describedby="example2_info">

												<tr>
													<td><label for="id">아이디</td>
													<td><input type="text" name="id" id="id"
														value="${memberVo.id}" readonly="readonly"></label></td>

												</tr>
												<tr>
													<td><label for="pwd">비밀번호</td>
													<td><input type="password" name="pwd" id="pwd"
														value=""></label>
													</div></td>
												</tr>
												<tr>
													<td><label for="pwdChk">비밀번호 확인</td>
													<td><input type="password" name="pwdChk"
														id="pwdChk" value=""></label></td>
												</tr>
												<tr>
													<td><label for="email">이메일</td>
													<td><input type="text" name="email" id="email"
														value="${memberVo.email}"></label></td>
												</tr>
												<tr>
													<td><label for="picture">사진</td>
													<td><input type="text" name="picture" id="picture"
														value="${memberVo.picture}"></label></td>
												</tr>
												<tr>
													<td><label for="enabled">0퇴사1재직2휴직</td>
													<td><input type="text" name="enabled" id="enabled"
														value="${memberVo.enabled}"></label></td>
												</tr>
												<tr>
													<td><label for="regdate">입사일</td>
													<td><input type="text" name="regdate" id="regdate"
														value="${memberVo.regdate}"></label></td>
												</tr>
												<tr>
													<td><label for="phone">휴대전화번호</td>
													<td><input type="text" name="phone" id="phone"
														value="${memberVo.phone}"></label></td>
												</tr>
												<tr>
													<td><label for="name">이름</td>
													<td><input type="text" name="name" id="name"
														value="${memberVo.name}"></label></td>
												</tr>
												<tr>
													<td><label for="register">등록자</td>
													<td><input type="text" name="register" id="register"
														value="${memberVo.register}"></label></td>
												</tr>
												<tr>
													<td><label for="address">주소</td>
													<td><input type="text" name="address" id="address"
														value="${memberVo.address}"></label></td>
												</tr>
												<tr>
													<td><label for="authority">권한</td>
													<td><input type="text" name="authority" id="authority"
														value="${memberVo.authority}"></label></td>
												</tr>

											</table>
											<button type="submit" class="btn btn-default">확인</button>
											<a href="<c:url value='/' />view?id=${memberVo.id}"><button
													type="button" class="btn btn-default">취소</button></a> <input
												type="hidden" name="flag" value="after">
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
<!-- 		</div> -->
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="/servlet_default/js/util/myutils.js"></script>
</body>
<script type="text/javascript">
	function pwdCheck() {
		if (newpwd != "") {
			var newpwd = $("#pwd").val()
			var newpwdChk = $("#pwdChk").val()

			if (newpwd == newpwdChk) {
				return true;
			} else
				return false;
		}
	}
	function totalCheck() {
		if (!pwdCheck()) {
			alert("비밀번호를 확인해주세요")
			return false;
		}

		if (!updateConfirm()) {
			return false;
		}
	}
</script>
</html>