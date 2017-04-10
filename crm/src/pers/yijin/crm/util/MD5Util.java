package pers.yijin.crm.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	/**
	 * MD5���ܲ���
	 * 
	 * @param str
	 * @return
	 */
	public static String getMD5(String str) {
		try {
			// ���JDK�ṩ���㷨������
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			// ���ܵĽ��λ10����
			byte[] MD5ValueByteArray = messageDigest.digest(str.getBytes());
			// ��10����ת��Ϊ16���ƣ�����1��������
			BigInteger bigInteger = new BigInteger(1, MD5ValueByteArray);
			return bigInteger.toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException();
		}
	}
	
/*		@Test
	public void test(){
		System.out.println(MD5Util.getMD5("1111"));
		
	}*/
}
