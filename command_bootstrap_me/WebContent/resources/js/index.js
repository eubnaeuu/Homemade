/**
 * 
 */
function subMenu(mcode){
		if(mcode!="M000000"){
			$.getJSON("/subMenu.do?mcode="+mcode,function(data){
				// console.log(data);
				printData(data, $('.subMenuList'),$('#subMenu-list-template'),'.subMenu');
			});
		}else {
			$('.subMenuList').html("");				
		}
	}
	
	function printData(dataArr, target, templateObject, removeClass){
		
		var template = Handlebars.compile(templateObject.html());
		
		var html = template(dataArr);
		
		$(removeClass).remove();
		target.append(html);
	}
	
	
	// 기존 url주소에 mcode파람과 mocde값 추가(load X)
	function goPage(url, mcode){
		// HTML5 지원브라우저에서 사용 가능
		if (typeof(history.pushState) == 'function'){
			// 현재 주소를 가져온다
			var renewURL = location.href;
			// 현재 주소 중 .do 뒤 부분이 있다면 날려버린다
			renewURL = renewURL.substring(0, renewURL.indexOf(".do")+3);
			
			if(mcode != "M000000"){
				renewURL += "?mcode="+mcode;
			}
			
			// 페이지를 리로드하지 않고 페이지 주소만 변경할 때 사용
			history.pushState(mcode, url, renewURL);
			
		} else {
			location.hash = "#"+mcode;
		}
		
		$('iframe[name="ifr"]').attr("src",url);
		

	}
