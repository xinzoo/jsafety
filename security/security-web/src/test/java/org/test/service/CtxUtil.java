package org.test.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CtxUtil {
	
	private static ApplicationContext getCtx() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		return ctx;
	}
	
	public static Object getCtxBean(String beanName){
		return getCtx().getBean(beanName);
	}
	
	
	public static Object getCtxBean(Class clazz){
		String name=clazz.getSimpleName().substring(1);
		String s_0=name.substring(0, 1);
		String s_sub=name.substring(1);
		String newName=s_0.toLowerCase()+s_sub;
		
		System.out.println("Service:"+newName);
		return getCtx().getBean(newName);
	}
	
	public static Object getCtxBean2(Class clazz){
		return getCtx().getBean(clazz);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		
	}

}
