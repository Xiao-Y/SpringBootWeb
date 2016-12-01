package com.billow.annotation.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.billow.annotation.validator.CannotContainSpaces;

/**
 * 验证数据不能有空格（具体的实现）
 * 
 * @author liuyongtao
 * 
 * @date 2016年12月1日 下午3:41:43
 */
public class CannotContainSpacesValidator implements ConstraintValidator<CannotContainSpaces, String> {

	private String message;

	@Override
	public void initialize(CannotContainSpaces arg) {
		this.message = arg.message();
	}

	@Override
	public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
		if (str != null) {
			if (str.indexOf(" ") < 0) {
				return true;
			} else {
				// 禁用默认的message的值
				constraintValidatorContext.disableDefaultConstraintViolation();
				// 重新添加错误提示语句
				constraintValidatorContext.buildConstraintViolationWithTemplate(message).addConstraintViolation();
			}
		}
		return false;
	}
}
