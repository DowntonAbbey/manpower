package com.qf.metting.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;


public class UserInfoUtils {
	/**
	 * @throws UnsupportedEncodingException 获取base64编码 @Title:
	 * getBase64 @Description: TODO(这里用一句话描述这个方法的作用) @param @param
	 * data @param @return 设定文件 @return String 返回类型 @throws
	 */
	public static String getBase64(String data) throws UnsupportedEncodingException {
		return new String(Base64.encodeBase64(data.getBytes("UTF-8")));
	}

	public static String parseBase64(String data) {
		byte[] b = data.getBytes();
		Base64 base64 = new Base64();
		b = base64.decode(b);
		String s = new String(b);
		return s;
	}
}
