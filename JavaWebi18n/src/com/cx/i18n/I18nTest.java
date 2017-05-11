package com.cx.i18n;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class I18nTest {
	@Test
	public void testDateFormat() {
		Date date = new Date();
		System.out.println(date);
		
		
		Locale locale = Locale.CHINA;
		//获取DateFormat对象
		
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM, locale);
		String str = dateFormat.format(date);
		System.out.println(str);
	}

	@Test
	public void testLocale() {
		Locale locale = Locale.CHINA;
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getLanguage());
	}

}
