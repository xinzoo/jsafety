<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <header class="header">
 </header>
  <script type="text/javascript">
     $(document).ready(function(){
    	 var topType = '${topType}';
    	 var typeId = '${typeId}';
    	 var parentTypeId = '${parentTypeId}';
    	 
		if(topType){//详情页面判断
			 $(".cur").removeClass("cur");
			 $(".secondNav-btn[typeid=type_"+topType+"]").addClass("cur");
			 $("#contentFrame").attr("src", "${ctx}/PortalNews/detailPortalNews2.do?portalNewsId=${portalNews.id}");
		} 
		var ele = $("#menu_on_"+typeId);
		if(!ele.length){
			ele = $("#menu_on_"+parentTypeId);
		}
		 ele.addClass("classon");
    	 $(".secondNav-btn").click(function(){
    		 $(".classon").removeClass("classon");
    		 var urlPath = $(this).attr("url");
    		 if(urlPath){
 				 $("#contentFrame").attr("src", "${ctx}/"+urlPath+"?noHeadAndFoot=YES");
    			 $(".cur").removeClass("cur");
        		 $(this).addClass("cur");
    		 }
    	 });
    	 
    	 $(".secondNav-btn .menu_link").click(function(){
    		 $(".classon").removeClass("classon");
    		 $(this).addClass("classon");
    		 var typeid = $(this).attr("typeid");
    		 $(".cur").removeClass("cur");
    		 $(this).parents("li").addClass("cur");
    		 $("#contentFrame").attr("src", "${ctx}/main/list.do?typeId="+typeid);
    		 
    		 //$(".secondNav").hide();
    		// setTimeout("hideDiv()",300);
    		 return false;
    	 });
     });
    	function hideDiv(){
    		$(".secondNav").removeAttr("style");
    	}
    </script>
    <div class="nav">
        <ul class="firstNav firstNav2">
            <li class="secondNav-btn cur" id="Index">
                <a href="${ctx }/main/Index.do">首页</a>
                <!-- <div class="secondNav sbnav01">
                     <em></em>

                 </div>-->
            </li>
            <c:forEach var="menu" items="${ menus}" varStatus="st">
            	<li class="secondNav-btn ${st.last?'nav-last':'' }" typeid="type_${menu.codeId }"  url="${menu.urlPath }">
                	<a href="#">${menu.codeName }</a>
                	<c:if test="${not empty menu.newsTypes }">
	                	<div class="secondNav sbnav0${st.index+2 }b">
						<em></em>
	                	<c:forEach var="secondMenu" items="${menu.newsTypes }" varStatus="status">
	                	<c:if test="${secondMenu.menuState eq 1}">
	                	 	<dl class="${status.index%3 eq 1?'linelr':''}" >
		                        <dt>${secondMenu.codeName }</dt>
		                        <c:forEach var="thirdMenu" items="${secondMenu.newsTypes }">
		                        	<c:if test="${thirdMenu.menuState eq 1 and secondMenu.codeId != 9001}">
		                        		<dd><a href="javascript:void(0)"  class="menu_link" typeid="${thirdMenu.codeId }" id="menu_on_${thirdMenu.codeId }" title="${thirdMenu.codeName }"><font typeid="${thirdMenu.codeId } " class="">${fn:substring(thirdMenu.codeName, 0, 10)}</font></a></dd>
		                        	</c:if>
		                        	<c:if test="${thirdMenu.menuState eq 1 and secondMenu.codeId eq 9001}">
		                        		<dd><a href="http://gdggzy.org.cn/prtm/portal/party-news!list?portalNews.typeId=${thirdMenu.codeId}" typeid="${thirdMenu.codeId }" id="menu_on_${thirdMenu.codeId }" title="${thirdMenu.codeName }" target="_blank"><font typeid="${thirdMenu.codeId } " class="">${thirdMenu.codeName }</font></a></dd>
		                        	</c:if>
		                        </c:forEach>
		                    </dl>
		                 </c:if>
	                	</c:forEach>
	                	</div>
                	</c:if>
	              </li>
            </c:forEach>
        </ul>
    </div>



