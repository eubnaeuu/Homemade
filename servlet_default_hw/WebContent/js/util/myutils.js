/**
 * 
 */

function isEmpty(val) {
	if(val == undefined) return true;
	else if(val == null) return true;
	else if(val == "null") return true;
	else if(val == "") return true;
	else if(jQuery.trim(val).length == 0) return true;
	else return false; 
}

function chkId(){
	var id = $("#id").val();
	var param = {
			"id" : id
			,"flag" : "chkId"
			}
	$.ajax({
		url : "/servlet_default/insert"
			,data : param
			,type : "post"
			,dataType : "json"
			,success : function(data){
				if(data==null){
					return false;
				}else {
					return true;
				}
			}
			,error : function(xhr){
				console.error(xhr);
			}
	})
}

function deleteConfirm() {
	return confirm("정말 삭제하시겠습니까?");
}
function updateConfirm() {
	return confirm("수정을 완료하시겠습니까?");
}