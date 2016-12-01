package com.billow.annotation.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.billow.annotation.validator.impl.CannotContainSpacesValidator;

/**
 * 不能包含空格(定义注解)
 * 
 * @author liuyongtao
 * 
 * @date 2016年12月1日 下午3:42:11
 */
@Documented
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
// 具体的实现
@Constraint(validatedBy = CannotContainSpacesValidator.class)
@Target({ java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD })
public @interface CannotContainSpaces {

	// 默认错误消息
	String message() default "不能包含空格";

	// 分组 下面这两个属性必须添加
	Class<?>[] groups() default {};

	// 负载
	Class<? extends Payload>[] payload() default {};

}
