package com.wqddg;

import org.springframework.validation.annotation.Validated;

/**
 * @Author: wqddg
 * @ClassName ${NAME}
 * @DateTime: ${DATE} ${TIME}
 * @remarks : #
 */
public class Main {

	private String name;

	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public static void main(String[] args) {
		Main main=new Main();
		main.setAge(2);
		main.setName("你好");
		System.out.println(main.getName()+"   "+main.getAge());
	}
}