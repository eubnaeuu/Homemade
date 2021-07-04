
function subMenu(mcode){
	if(mcode!="M000000"){
		$.getJSON("subMenu.do?mCode="+mcode,function(data){	
			//console.log(data);		
			printData(data,$('.subMenuList'),$('#subMenu-list-template'),'.subMenu');
		});
	}else{
		$('.subMenuList').html("");		
	}
}

//handelbars printElement (args : data Array, appent target, handlebar template, remove class)
function printData(dataArr,target,templateObject,removeClass){
	
	var template=Handlebars.compile(templateObject.html());
	
	var html = template(dataArr);
	
	$(removeClass).remove();
	target.append(html);
}
/**
 * contextPath 구하는 기능
 * 참고링크 : https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=mk1126sj&logNo=221019411361
 * @returns contextPath
 */
function getContextPath(){
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	var contextPath = location.href.substring(hostIndex, location.href.indexOf('/',hostIndex+1));
	return contextPath;
}

function goPage(url,mCode){
	  // HTML5 지원브라우저에서 사용 가능
	if (typeof(history.pushState) == 'function') {
	    //현재 주소를 가져온다.
	    var renewURL = location.href;
	    //현재 주소 중 .do 뒤 부분이 있다면 날려버린다.
	    renewURL = renewURL.substring(0, renewURL.indexOf(".do")+3);
	    
	    if (mCode != 'M000000') {
	        renewURL += "?mCode="+mCode;
	    }
	    //페이지를 리로드하지 않고 페이지 주소만 변경할 때 사용
	    history.pushState(mCode, null, renewURL);
	 
	} else {
	    location.hash = "#"+mCode;
	}
	$('iframe[name="ifr"]').attr("src",getContextPath()+url);
}
