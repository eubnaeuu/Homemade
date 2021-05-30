<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <!-- url안바뀌고 내용만 loginform으로  (1) : forward비슷-->
<%-- <jsp:include page="/WEB-INF/views/common/loginForm.do" ></jsp:include> --%>
<!-- <!-- url안바뀌고 내용만 loginform으로  (2) : forward비슷-->
<!-- @include file="/WEB-INF/views/common/loginForm.jsp" -->

<c:if test="${!empty loginUser }">
	<script>
		location.href="index.do";
	</script>
</c:if>
<c:if test="${empty loginUser }">
		<jsp:forward page="/WEB-INF/views/common/loginForm.jsp" ></jsp:forward>
</c:if>

<script>
// 		<c:import url="/WEB-INF/views/common/loginForm.jsp"/>
// <jsp:include page="/WEB-INF/views/common/loginForm.jsp" ></jsp:include>
// 	location.href="loginForm.do";
</script>