package com.oracle.md5;

public class testMd5 {
   public static void main(String[] args) {
			MD5_Encoding md5 = new MD5_Encoding();
			String pass = "000000";//明文
			String password = md5.getMD5ofStr(pass);//加密后
             System.out.println(password);
   }
}
