package com.xiaojun.yiliaoxitong.utils;

public class StringUtil {
	
	
	    //根据长度转换 ICCID
		public static String hex2iccid(byte[] hexs) {

			String ret = new String(hexs);
			return ret;
		}
	
	//根据长度转换 hex2str
	public static String hex2str(byte[] hexs, int len) {

		String ret = "";
		int tmp = 0;
		int iLen = len;
		if(iLen > hexs.length)
			iLen = hexs.length;
		
		for (int k = 0; k < iLen; k++) {
			if (hexs[k] < 0)
				tmp = 256 + hexs[k];
			else
				tmp = hexs[k];
			ret += String.valueOf(tmp >> 4) + String.valueOf(tmp & 0x0f);
		}
		return ret;
	}
	
	public static String hex2str(byte[] hexs) {

		String ret = "HEX: ";
		int tmp = 0;
		for (int k = 0; k < hexs.length; k++) {
			if (hexs[k] < 0)
				tmp = 256 + hexs[k];
			else
				tmp = hexs[k];
			ret += String.valueOf(tmp >> 4) + String.valueOf(tmp & 0x0f);
		}
		return ret;
	}

	public static String myhex2str(byte[] hexs, int len) {

		String ret = "HEX: ";
		if (len <= hexs.length && len >= 0) {
			int tmp = 0;
			for (int k = 0; k < hexs.length; k++) {
				if (hexs[k] < 0)
					tmp = 256 + hexs[k];
				else
					tmp = hexs[k];
				ret += String.valueOf(tmp >> 4) + String.valueOf(tmp & 0x0f);
			}
		}
		return ret;
	}
}
