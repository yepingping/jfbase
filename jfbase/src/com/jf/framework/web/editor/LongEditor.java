package com.jf.framework.web.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

/**
 * @描述:<p> </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-7 下午11:17:33
 */
public class LongEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text == null || text.equals(""))
			text = "0";
		if (!StringUtils.hasText(text)) {
			setValue(null);
		} else {
			setValue(Long.parseLong(text));// 这句话是最重要的，他的目的是通过传入参数的类型来匹配相应的databind
		}
	}

	@Override
	public String getAsText() {

		return getValue().toString();
	}
}
