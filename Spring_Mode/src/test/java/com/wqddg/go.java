package com.wqddg;

import com.wqddg.bean.HelloWorld;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ToStringBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wqddg
 * @ClassName go
 * @DateTime: 2022/8/6 19:46
 * @remarks : #
 */
public class go {






	/**
	 * 基础项目  spring
	 */
	@Test
	public void test1(){
		ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld bean = (HelloWorld) context.getBean("helloWorld");
		System.out.println(bean);
	}





}
