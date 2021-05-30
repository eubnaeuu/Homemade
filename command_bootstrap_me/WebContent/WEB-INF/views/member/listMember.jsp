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
</style>
<body>
	<div class="wrapper" style="width: 100%;">
		<!-- Content Wrapper. Contains page content -->
<!-- 		<div class="content-wrapper"> -->
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row">
						<div class="col-sm-12">
							<h1 class="m-0">회원목록</h1>
						</div>
					</div>
				</div>
			</div>
			<!-- /.content-header -->
			<!-- ★  -->
			<!-- Main content -->
			<div class="content">
				<div class="container-fluid">
<!-- 					<div class="row"> -->
<!-- 						<div class="col-12"> -->
<!-- 							<div class="card"> -->
<!-- 								<div class="card-header">card-header</div> -->
<!-- 								<div class="card-body">card-body</div> -->
<!-- 								<div class="card-footer">card-footer</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">일반회원</h3>
								</div>
								<!-- /.card-header -->
								<div class="card-body">
									<table id="example1" class="table table-bordered table-striped">
										<thead>
											<tr role="row">
												<th>아이디</th>
												<th>이메일</th>      
												<th>사진</th>      
												<th>0퇴사 1재직 2휴직</th>      
												<th>전화번호</th>      
												<th>이름</th>      
												<th>주소</th>     
												<th>권한</th>      
												<th></th>              
												<th></th>              
											</tr>                      
										</thead>                       
										<tbody>                        
											<c:forEach var="memberVo" items="${list }" varStatus="status">
													<tr>
														<td>${memberVo.id }</td>
														<td>${memberVo.email }</td>
														<td>${memberVo.picture }</td>
														<td>${memberVo.enabled }</td>
														<td>${memberVo.phone }</td>
														<td>${memberVo.name }</td>
														<td>${memberVo.address }</td>
														<td>${memberVo.authority }</td>
														<td><a href="<c:url value='/member/view.do?id=' />${memberVo.id }"><button type="button" class="btn btn-block btn-default">상세보기</button></a></td>
														<td>
															<form action="delete" method="post" id="fm${status.count }" onsubmit="return totalCheck()">
																<input type="hidden" value="${memberVo.id}" name="id">
																<button type="submit" class="btn btn-block btn-default">삭제</button>
															</form>
														</td>
													</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<!-- /.card-body -->
							</div>
							<!-- /.card -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content -->
<!-- 		</div> -->
		<!-- /.content-wrapper -->
	</div>
	<!-- ./wrapper -->
	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/util/myutils.js"></script>
	<!-- Bootstrap 4 -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- DataTables  & Plugins -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jszip/jszip.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/pdfmake/pdfmake.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/pdfmake/vfs_fonts.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/datatables-buttons/js/buttons.print.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
	<!-- AdminLTE App -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/demo.js"></script>
	<!-- Page specific script -->
</body>
<script type="text/javascript">

$(function () {
    $("#example1").DataTable({
      "responsive": true, "lengthChange": false, "autoWidth": false
    }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
  });

function totalCheck() {
	if(!deleteConfirm()){
		return false;
	}
}

function selectMember(){
	
	var str = "";
	var selectval = $("#searchSelect").val();
	var inputval = $("#searchInput").val();
	
	if(selectval==1){
		var id = inputval
		str = "?id="+id;
	}else if(selectval==2){
		var hp = inputval
		str = "?hp="+hp;
	}else if(selectval==3){
		var birth = inputval
		str = "?birth="+birth;
	}
	
	location.href="<%=request.getContextPath()%>/select" + str;
	}
</script>
</html>
