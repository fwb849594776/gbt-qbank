package com.fitt.gbt.qbank.common.utils;

import sun.misc.BASE64Encoder;

public class EncodeUtil {
	public static String encodeStr(String plainText) {
		byte[] b = plainText.getBytes();
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(b);
	}
}
