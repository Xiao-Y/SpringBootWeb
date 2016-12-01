package com.billow.annotation.validator.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import utils.StringUtils;

import com.billow.annotation.validator.PhoneNumber;

public class PhoneNumberValidator implements ConstraintValidator<com.billow.annotation.validator.PhoneNumber, String> {

	private String message;

	@Override
	public void initialize(PhoneNumber constraintAnnotation) {
		this.message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

		if (StringUtils.isNotEmpty(value)) {
			if (!isMobile(value) && !isPhone(value)) {
				// 禁用默认的message的值
				constraintValidatorContext.disableDefaultConstraintViolation();
				// 重新添加错误提示语句
				constraintValidatorContext.buildConstraintViolationWithTemplate(message).addConstraintViolation();
				return false;
			}
		}
		return true;
	}

	/**
	 * 手机号验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isMobile(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

	/**
	 * 电话号码验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isPhone(String str) {
		Pattern p1 = null, p2 = null;
		Matcher m = null;
		boolean b = false;
		p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$"); // 验证带区号的
		p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$"); // 验证没有区号的
		if (str.length() > 9) {
			m = p1.matcher(str);
			b = m.matches();
		} else {
			m = p2.matcher(str);
			b = m.matches();
		}
		return b;
	}
}
