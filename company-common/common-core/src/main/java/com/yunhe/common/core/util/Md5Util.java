package com.yunhe.common.core.util;

import com.yunhe.common.core.constants.BusinessConstants;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Random;

/**
 * @Description: 加密工具
 *
 * update: 【类名改了大小写】 date: 2022-04-18
 * @author: jeecg-boot
 */
public class Md5Util {

    private static final String[] HEXDIGITS = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++){
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n += 256;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return HEXDIGITS[d1] + HEXDIGITS[d2];
	}

	public static String md5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = origin;
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname)) {
				resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
			} else {
				resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return resultString;
	}

	//生成“盐”和加盐后的MD5码，并将盐混入到MD5码中
	public static String generate(String password,String salt) {
		//生成一个16位的随机数，也就是所谓的“盐”
		/*Random r = new Random();
		StringBuilder sb = new StringBuilder(16);
		sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
		int len = sb.length();
		if (len < 16) {
			for (int i = 0; i < 16 - len; i++) {
				sb.append("0");
			}
		}*/
//		String salt=getMd5Salt(8);
//		String salt = sb.toString();
		//将“盐”加到明文中，并生成新的MD5码
		password = md5Encode(password + salt,"utf-8");
		//将“盐”混到新生成的MD5码中，之所以这样做是为了后期更方便的校验明文和秘文，也可以不用这么做，不过要将“盐”单独存下来，不推荐这种方式
//		char[] cs = new char[48];
//		for (int i = 0; i < 48; i += 3) {
//			cs[i] = password.charAt(i / 3 * 2);
//			char c = salt.charAt(i / 3);
//			cs[i + 1] = c;
//			cs[i + 2] = password.charAt(i / 3 * 2 + 1);
//		}
		return password;
	}
	/**
	 * @description: 获取指定长度的盐值
	 * @param:
	 * @return:
	 * @author xiaozuqin
	 * @date: 2022/8/1 10:22
	 */
	public static String getMd5Salt(int length){
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int nextInt = random.nextInt(BusinessConstants.BASE_CHECK_CODES.length());
			stringBuilder.append(BusinessConstants.BASE_CHECK_CODES.charAt(nextInt));
		}
		return stringBuilder.toString();
	}


	/**
	 * MD5加密,并把结果由字节数组转换成十六进制字符串
	 *
	 * @param str 要加密的内容
	 *
	 * @return String 返回加密后的十六进制字符串
	 */
	private static String md5Hex(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digest = md.digest(str.getBytes());
			return hex(digest);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return "";
		}
	}

	/**
	 * @description: byte[]字节数组 转换成 十六进制字符串
	 * @param:
	 * @return:
	 * @author xiaozuqin
	 * @date: 2022/8/1 22:58
	 */
	private static String hex(byte[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; ++i) {
			sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString();
	}



}
