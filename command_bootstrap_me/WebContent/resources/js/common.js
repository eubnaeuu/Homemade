/**
 * 
pagenation 함수
page  : 페이지 번호 url : 주소

 */

function list_go(page, url){
	
	if(!url) url ="list.do";
	
	var jobForm = $("#jobForm"); 
// 	$('input[name="perPageNum"]').val($("select[name='perPageNum']").val());
	jobForm.find("[name='page']").val(page);
	jobForm.find("[name='perPageNum']").val($("select[name='perPageNum']").val());
	jobForm.find("[name='searchType']").val($("select[name='searchType']").val());
	jobForm.find("[name='keyword']").val($("div.input-group>input[name='keyword']").val());

	
	$('form#jobForm').attr({
		action : url,
		method:'get'
	}).submit();
}


function OpenWindow(UrlStr, WinTitle, WinWidth, WinHeight){
	winLeft = (screen.width - WinWidth) / 2;
	winTop = (screen.height - WinHeight) / 2;
	var win = window.open(UrlStr, WinTitle, "scrollbars=yes, width="+WinWidth +","
			+ "height="+WinHeight + ", top=" + winTop + ", left="
			+ winLeft + ", resizable=yes, status=yes");
	win.focus();
}


function CloseWindow(){
	window.opener.location.reload(true);
	window.close();
}
function CloseWindow(parentURL){
	window.opener.parent.location.href=parentURL;
	window.close();
}