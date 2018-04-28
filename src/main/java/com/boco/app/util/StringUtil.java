package com.boco.app.util;

import java.util.ArrayList;
import java.util.List;

/**
 * String 工具类 截取字符串
 * @author ntt
 *
 */
public class StringUtil {
          
	public static  String getTokenString(String url){	
		int begin=url.indexOf("&")+7;
		int end=url.lastIndexOf("&");
		String token= url.substring(begin, end);
		return token;
	}  
	
	public static List<String> splitString(String str){
		List<String> StrList=new ArrayList<String>();
		String[] arr=str.split(",");
		for(int i=0;i<arr.length;i++){
			StrList.add(arr[i]);
		}
		return StrList;
		
	}
	
	public static void main(String[] args) {
		System.out.println("safsdf");
		String strs="333,222,444,555";
		List<String> StrList=splitString(strs);
		System.out.println(StrList);
		for(String str:StrList){
			System.out.println(str);
			System.err.println("****");
		}
		
	}
	
}
