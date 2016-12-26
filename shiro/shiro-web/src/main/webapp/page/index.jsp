<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>


<%@ include file="/page/util/common.jsp"%>

<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>广东省公共资源交易中心</title>
    	
        
        <!-- 引入样式,js文件 begin. -->
        <%@ include file="/page/util/Common/commonReference.jsp"%>
        <!-- 引入样式,js文件 end. -->
        
</head>
<body class="bg">


<div class="" style="">

	
	<!-- 头部信息.begin -->
		<c:if test="${ empty noHeadAndFoot }">
			<c:set var="targetItem" value="Index" ></c:set>
			<%@ include file="/page/util/Common/Head.jsp"%>
		</c:if>
	<!-- 头部信息.end -->
	
	
	
	
	
	
	
	<!-- 中间 页面详细内容 begin. -->
	
	
	
	<div class="content" style="border: 0px solid red;">
        <div class="main index_loc_main">
            <div class=" clearfix" style="border: 0px solid red;">
                
                
                <!-- 中心事务.begin. -->
                <iframe class="dataIframe" 
                 	src="${ctx }/TradeCenterBusiness/MainView.do?noHeadAndFoot=YES" 
                 	frameborder="0" style="height: 465px;width: 1280px;border: 0px solid yellow;">
                </iframe>
                <!-- 中心事务.end. -->
                
                <!-- 网上办事.begin. -->
                <img src="${ctx }/images/title01.jpg" width="1260" height="70">
                <iframe class="dataIframe" 
                 	src="${ctx }/OnlineBusiness/MainView.do?noHeadAndFoot=YES" 
                 	frameborder="0" style="height: 285px;width: 1280px;">
                </iframe>
                <!-- 网上办事.end. -->
                
                
                <!-- 政务信息.begin. -->
                	<!-- noHeadAnFoot未为改参数 -->
                	<img src="${ctx }/images/title05.jpg" width="1260" height="70">
                <iframe class="dataIframe" 
                 	src="${ctx }/GovernmentInformation/MainView.do?noHeadAndFoot=YES" 
                 	frameborder="0" style="height: 450px;width: 1280px;">
                </iframe>	
                	
                	
                <!-- 政务信息.end. -->
                
                <!-- 交易服务.begin. -->
                	<!-- 缺少noHeadAnFoot参数 -->
                	<img src="${ctx }/images/title02.jpg" width="1260" height="70">
                <iframe class="dataIframe" 
                 	src="${ctx }/TradeService/MainView.do?noHeadAndFoot=YES&isIndex=1" 
                 	frameborder="0" style="height: 620px;width: 1280px;border: 0px solid red;">
                </iframe>	
                <!-- 交易服务.end. -->
                
                
                <!-- 数据统计.beign. -->
                <img src="${ctx }/images/title03.jpg" width="1260" height="70">
                <iframe class="dataIframe" 
                 	src="${ctx }/DataStatistics/MainView.do?noHeadAndFoot=YES" 
                 	frameborder="0" style="height: 730px;width: 1280px;">
                </iframe>
                <!-- 数据统计.end. -->
                
                
                <!-- 其它事务.begin. -->
                <!--
                <iframe class="dataIframe" 
                 	src="${ctx }/OtherDataService/MainView.do?noHeadAndFoot=YES" 
                 	frameborder="0" style="height: 430px;width: 1280px;border: 0px solid yellow;">
                </iframe>
                -->
                <!-- 其它事务.end. -->
                
                <!-- 互动交流.begin. -->
                <img src="${ctx }/images/title04.jpg" width="1260" height="70">
                <iframe class="dataIframe" 
                 	src="${ctx }/Feedback/MainView.do?noHeadAndFoot=YES" 
                 	frameborder="0" style="height: 454px;width: 1280px;border: 0px solid yellow;">
                </iframe>
                <!-- 互动交流.end. -->
                
            </div>
        </div>

        
    </div>
    
    
    
    <!-- 中间 页面详细内容 end. -->
    
    
    
    
    
    <!-- 尾部信息.begin -->
		<c:if test="${ empty noHeadAndFoot }">
			<%@ include file="/page/util/Common/Footer.jsp"%>
		</c:if>
	<!-- 尾部信息.end -->	
    
    
    
    
</div>
</body>
</html>