package com.jf.framework.web.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

import com.jf.common.utils.date.DateUtil;

/**
 * @描述:<p> </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-7 下午11:17:19
 */
public class DateEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		if (!StringUtils.hasText(text)) {
			setValue(null);
		} else {
			setValue(DateUtil.string2Date(text, "yyyy-MM-dd"));
		}
	}

	@Override
	public String getAsText() {

		return getValue().toString();
	}
}
