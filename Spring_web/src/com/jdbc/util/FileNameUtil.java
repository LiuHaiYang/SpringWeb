package com.jdbc.util;

public class FileNameUtil {

	//获得真是上传的文件名
	public  static String getRealFileName(String head){
		return head.substring(head.lastIndexOf("=")+2,head.length()-1);
		
	}
	//获得上传文件的类型
	public static String getFileType(String filename){
		return filename.substring(filename.lastIndexOf("."));
	}
}
