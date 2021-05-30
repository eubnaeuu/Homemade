<%@page import="kr.or.ddit.member.vo.MemberVO"%>
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
<title>공지글목록</title>
</head>
<style>
</style>
<body>
	<div class="wrapper" style="width: 100%;">
			<div class="content-header">
				<div class="container-fluid">
					<div class="row">
						<div class="col-sm-12">
							<h1 class="m-0">공지글목록</h1>
						</div>
					</div>
				</div>
			</div>
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">공지글목록</h3>
								</div>
								<!-- /.card-header -->
								<div class="card-body">
									<table id="example1" class="table table-bordered table-striped">
										<thead>
											<tr role="row">
												<th>글번호</th>
												<th>제목</th>      
												<th>작성자</th>      
												<th>작성일</th>      
												<th>조회수</th>      
												<th>POINT?</th>      
											</tr>                      
										</thead>                       
										<tbody>                        
											<c:forEach var="noticeVo" items="${list }" varStatus="status">
													<tr>
														<td>${noticeVo.nno }</td>
														<td><a href="<c:url value='/view?nNo=' />${noticeVo.title }"></a></td>
														<td>${noticeVo.writer }</td>
														<td>${noticeVo.regdate }</td>
														<td>${noticeVo.viewCnt }</td>
														<td>${noticeVo.point }</td>
														<td>
															<form action="delete" method="post" id="fm${status.count }" onsubmit="return totalCheck()">
																<input type="hidden" value="${noticeVo.nno}" name="nno">
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

// function selectMember(){
	
// 	var str = "";
// 	var selectval = $("#searchSelect").val();
// 	var inputval = $("#searchInput").val();
	
// 	if(selectval==1){
// 		var id = inputval
// 		str = "?id="+id;
// 	}else if(selectval==2){
// 		var hp = inputval
// 		str = "?hp="+hp;
// 	}else if(selectval==3){
// 		var birth = inputval
// 		str = "?birth="+birth;
// 	}
	
<%-- 	location.href="<%=request.getContextPath()%>/select" + str; --%>
// 	}
</script>
</html>
