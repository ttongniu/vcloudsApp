package com.boco.app.service;

import com.boco.app.simbaWS.AppCenterWS;
import com.boco.app.simbaWS.AppCenterWSPortType;
import com.boco.app.util.Dom4jUtil;
public class SimbaService {

	private static AppCenterWS appCenterWS=new AppCenterWS();
	private static  AppCenterWSPortType  appCenterWSPortType = appCenterWS.getAppCenterWSHttpSoap11Endpoint();
	/**
	 * 用户登录【通过登录账户和密码进行登录】
	 * response中既有用户信息也有用户的单位信息
	 */
	//测试不通过，因为密码需要进行加密
	public static  String loginByAccountLogin(String appid,String userName,String password){
		String xml="<request type=\"login\" subtype=\"accountLogin\" msid=\"\">"+
				"<message>"+
				"<user account=\""+userName+"\" pwd=\""+password+"\" pwdtype=\"1\" enter_id=\"\"/>"+
				"</message>"+
				"</request>";
		String response=appCenterWSPortType.request(appid, xml);	
		return response;
	}
	
	/**
	 * 用户登录【通过有效的token进行登录】---成功
	 */
	public   static String loginByCheckedToken(String appid,String token){
		String xml="<request type=\"login\" subtype=\"checkedToken\" msid=\"\">"+
				"<message>"+
				"<user token=\""+token+"\" enter_id=\"\"/>"+
				"</message>"+
				"</request>";
		String response=appCenterWSPortType.request(appid, xml);
		System.out.println(response);
		String json=Dom4jUtil.jxXML(response);
		return json;
	}
	
	/**
	 * 获取用户状态---成功
	 * response中status表示用户状态， 1表示在线，0表示不在线
	 */
	public static  String getUserStatus(String appid,String acc_nbr,String token){
		String xml="<request type=\"user\" subtype=\"getStatus\" msid=\"\">"+
				"<token>"+token+"</token>"+
				"<message>"+
				"<user acc_nbr=\""+acc_nbr+"\"/>"+
				"</message>"+
				"</request>";
		String response=appCenterWSPortType.request(appid, xml);
		String json=Dom4jUtil.jxXML(response);
		System.out.println(json);
		return json;
	}
	
	/**
	 * 获取用户权限
	 * purv_code  权限代码
	 * obj_scope  权限范围：0无权限，1全部权限，2对象当前节点，3对象所在节点及其子节点，4自定义
	 */
	public  static String getUserPurvCode(String appid,String enter_id,String token){
		String xml="<request type=\"user\" subtype=\"getPurvCode\" msid=\"\">"+
				"<token>"+token+"</token>"+
				"<message>"+
				"<info enter_id=\""+enter_id+"\"/>"+
				"</message>"+
				"</request>";
		String response=appCenterWSPortType.request(appid, xml);
		return response;
	}
	
	/**
	 * 获取单位组织架构信息【通过管理员acc_Nbr来获取】
	 */
	public static String getOrgXmlByNbr(String appid,String acc_nbr,String enter_id){
		String xml="<request type=\"orgService\" subtype=\"getOrgXmlByNbr\" msid=\"\">"+
				"<message>"+
				"<info adminNbr=\""+acc_nbr+"\" enter_id=\""+enter_id+"\"/>"+
				"</message>"+
				"</request>";
		String response=appCenterWSPortType.request(appid, xml);
		String json=Dom4jUtil.jxXML(response);
		return json;
	}
	
	/**
	 * 获取单位组织架构信息【通过管理员token来获取】
	 */
	public static  String getOrgXmlByToken(String appid,String token,String enter_id){
		String xml="<request type=\"orgService\" subtype=\"getOrgXmlByToken\" msid=\"\">"+
				"<token>"+token+"</token>"+
				"<message>"+
				"<info enter_id=\""+enter_id+"\"/>"+
				"</message>"+
				"</request>";
		String response=appCenterWSPortType.request(appid, xml);
		String json=Dom4jUtil.jxXML(response);
		return json;
	}
	
	/**
	 * 获取组织架构的版本号---成功
	 */
	public  static String getOrgXmlVersion(String appid,String enter_id){
		String xml="<request type=\"orgService\" subtype=\"getOrgXmlVersion\" msid=\"\">"+
				"<message>"+
				"<info enter_id=\""+enter_id+"\"/>"+
				"</message>"+
				"</request>";
		String response=appCenterWSPortType.request(appid, xml);
		String json=Dom4jUtil.jxXML(response);
		return json;
	}
	
	/**
	 * 获取单位信息---成功
	 */
	public static String getEnterInfo(String appid,String enter_id){
		String xml="<request type=\"orgService\" subtype=\"getEnterInfo\" msid=\"\">"+
				"<message>"+
				"<info enter_id_list=\""+enter_id+"\"/>"+
				"</message>"+
				"</request>";
		String response=appCenterWSPortType.request(appid, xml);
		String json=Dom4jUtil.jxXML(response);
		return json;
	}
	
	/**
	 * 获取个人信息---成功
	 */
	public static String getCustNbrInfo(String appid,String acc_nbr,String token){
		String xml="<request type=\"user\" subtype=\"getCustNbrInfo\" msid=\"\">"+
				"<token>"+token+"</token>"+
				"<message>"+
				"<user acc_nbr=\""+acc_nbr+"\"/>"+
				"</message>"+
				"</request>";
		String response=appCenterWSPortType.request(appid, xml);
		String json=Dom4jUtil.jxXML(response);
		return json;
	}
	
	
	
}
