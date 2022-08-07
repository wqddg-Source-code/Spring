package com.wqddg;

import com.wqddg.bean.HelloWorld;
import com.wqddg.server.Autowired;
import com.wqddg.server.UserController;
import com.wqddg.server.UserServer;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ToStringBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author: wqddg
 * @ClassName go
 * @DateTime: 2022/8/6 19:46
 * @remarks : #
 */
public class go {


	/**
	 * 反射原理  set
	 * @throws Exception
	 */
	@Test
	public void testField() throws Exception{
		UserController userController=new UserController();
		Class<? extends UserController> aClass = userController.getClass();
//		Field[] declaredFields = aClass.getDeclaredFields();
//		Arrays.asList(declaredFields).stream().forEach(System.out::println);

		Field userServerField = aClass.getDeclaredField("userServer");
		String fieldName = userServerField.getName();
		fieldName="set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1,fieldName.length());
		userServerField.setAccessible(true);
		UserServer userServer1=new UserServer();
		//通过属性注入
//		userServerField.set(userController,userServer1);
		//通过set方法注入
		Method method = aClass.getMethod(fieldName, UserServer.class);

		method.invoke(userController,userServer1);
		System.out.println(userController.getUserServer());
	}

	@Test
	public void testAu() throws Exception{
		UserController userController=new UserController();
		Class<? extends UserController> aClass = userController.getClass();
		Field[] declaredFields = aClass.getDeclaredFields();
		for (Field field : Arrays.asList(declaredFields)) {
			String fieldName = field.getName();
			Autowired annotation = field.getAnnotation(Autowired.class);
			if (annotation!=null){
				String value = annotation.value();
				System.out.println(value);
				field.setAccessible(true);
				Class<?> type = field.getType();
				Object o = type.getDeclaredConstructor().newInstance();
				field.set(userController,o);
			}
		}
		System.out.println(userController.getUserServer());
	}







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
