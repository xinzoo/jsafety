<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
	<script type="text/javascript">
	var footerPageIns = {};
	footerPageIns.friendsSiteChange = function(url){
		if(url != null && "" != url){
			window.open(url);
		}
	}
	</script>
	
	
	<div class="footer">
        <div class="">
            <table>
                <tr>
                    <td width="40%">
                        <div class="copyright">
                            <p>平台承办单位：广东省公共资源交易中心 <br/>
                                技术支持：广东亿迅科技有限公司</p>
                        </div>
                    </td>
                    <td width="10%">
                        <a href="http://bszs.conac.cn/sitename?method=show&id=0DD998E692763724E053012819ACEAEC"  target="_blank"><img src="${ctx }/images/footer_logo.png" alt="" class="footerlogo"></a>
                    </td>
                    <td width="40%">
                        <div class="links">
                            <ul>
                                <li><a href="${ctx }/main/Index.do?contact=true">联系我们</a>|</li>
                                <li><a href="${ctx }/main/Index.do?webMap=true">网站地图</a>|</li>
                                <!-- <li><a href="http://www.gdggzy.com/prtmwb/hall/login.action" target="_blank">网上办事窗口</a></li> -->
                                <li><a href="http://210.76.72.85:8080/osh-web/Main/main.do" target="_blank">网上办事窗口</a></li>
                            </ul>
                            <div class="yq">
                                <label>友情链接：</label>
                                <select onchange="footerPageIns.friendsSiteChange(this.value)">
                                	<option value="">省市网站</option>
                                    <option value="http://www.gd.gov.cn/">省政府门户网</option>
                                    <option value="http://www.legalinfo.gov.cn/">中国普法网</option>
                                    <option value="http://www.gdgpo.com/">广东省政府采购网</option>
                                    <option value="http://www.gdgpo.com/gdgpms/ums/homepage.action">广东省政府采购专家系统</option>
                                    <option value="http://www.gdcredit.gov.cn/IndexAction!getList.do">信用广东网</option>
                                    <option value="http://gcjs.gd.gov.cn/">广东省工程建设领域项目信息公开和信用信息公开共享专栏</option>
                                    <option value="http://www.gpcgd.com/gpcgd/portal/portal-news!index">广东省政府采购中心</option>
                                </select>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </div>