package org.test.myservice;

import java.util.List;

import org.test.service.CtxUtil;

import com.eshore.prip.portal.service.bean.PageableBean;
import com.eshore.prip.portal.service.web.IPortalNewsService;
import com.eshore.prip.portal.service.web.bean.TestDataBean;

public class TestA01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		IPortalNewsService s = (IPortalNewsService)CtxUtil.getCtxBean(IPortalNewsService.class);
		
		TestDataBean paramBean = new TestDataBean();
		PageableBean pageBean = new PageableBean();
		
		//List<String> datasList = s.getTestDataList(paramBean, pageBean);
		
		//System.out.println(datasList);
	
	}

}
