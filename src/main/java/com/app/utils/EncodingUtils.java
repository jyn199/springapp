package com.app.utils;

public class EncodingUtils {
	public static String getEncoding(String str) {
		String result = "Unknown";
		String[] encodings = { "iso8859_1", "gb2312", "utf-8", "GBK" };
		try {
			for (int i = 0; i < encodings.length; i++) {
				if (str.equals(new String(str.getBytes(), encodings[i])))
					result = encodings[i];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
