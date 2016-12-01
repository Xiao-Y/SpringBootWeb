package com.billow.annotation.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.billow.annotation.validator.impl.PhoneNumberValidator;

/**
 * 校验电话号码
 * 
 * @author liuyongtao
 * 
 * @date 2016年12月1日 下午5:36:41
 */
@Documented
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
// 具体的实现
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD })
public @interface PhoneNumber {
	// 默认错误消息
	String message() default "电话号码格式不正确";

	// 分组 下面这两个属性必须添加
	Class<?>[] groups() default {};

	// 负载
	Class<? extends Payload>[] payload() default {};
}
