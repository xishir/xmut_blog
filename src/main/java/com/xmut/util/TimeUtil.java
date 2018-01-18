package com.xmut.util;

import java.util.Date;
import java.text.SimpleDateFormat;

public class TimeUtil {
	public static String getTime() { 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return df.format(new Date());
	}
}