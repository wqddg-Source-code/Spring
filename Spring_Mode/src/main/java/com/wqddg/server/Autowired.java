package com.wqddg.server;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: wqddg
 * @ClassName Autowired
 * @DateTime: 2022/8/7 16:11
 * @remarks : #
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {
	String value();
}
