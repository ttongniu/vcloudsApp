package com.boco.app.service;

import java.util.HashMap;
import java.util.Map;

import com.boco.app.util.HttpClientUtil;
/**
 * 
 * @author ntt
 * 露脸云 服务器端接口
 */
public class VCloudService {
	/**
	 * 获取token
	 * @param url
	 * @return
	 */
	public static String   token(String url,String client_id,String client_secret,String grant_type){
		Map<String, String>	param  =new HashMap<String, String>();
		param.put("client_id", client_id);
		param.put("client_secret", client_secret);
		param.put("grant_type",grant_type);
		return HttpClientUtil.doGet(url,param);
	}
	/**
	 * 创建用户
	 * @param url
	 * @param app_user_id
	 * @param app_user_nick_name
	 * @param avatar
	 * @return
	 */
	public static String userAuth(String url,String app_user_id,String app_user_nick_name, String avatar,String token){
		Map<String, String>	param  =new HashMap<String, String>();
		param.put("app_user_id", app_user_id);
		param.put("app_user_nick_name", app_user_nick_name);
		param.put("avatar",avatar);
		Map<String, String>	header  =new HashMap<String, String>();
		header.put("token", token);
		return HttpClientUtil.doGet(url, param,header);
	}
	
	public static String userAuth(String url,String app_user_id,String app_user_nick_name, String token){
		 return   userAuth(url, app_user_id, app_user_nick_name, null, token);
	}
	
	
	/**
	 * 创建用户(session_id 不变)
	 * @param url
	 * @param app_user_id
	 * @param app_user_nick_name
	 * @param avatar
	 * @return
	 */
	public static String create_if_absent(String url,String app_user_id,String app_user_nick_name, String avatar,String token){
		Map<String, String>	param  =new HashMap<String, String>();
		param.put("app_user_id", app_user_id);
		param.put("app_user_nick_name", app_user_nick_name);
		param.put("avatar",avatar);
		Map<String, String>	header  =new HashMap<String, String>();
		header.put("token", token);
		return HttpClientUtil.doGet(url, param,header);
	}
	
	public static String create_if_absent(String url,String app_user_id,String app_user_nick_name, String token){
	   return  create_if_absent(url, app_user_id, app_user_nick_name, null, token);
	}
	/**
	 * 更新用户
	 * @param url
	 * @param app_user_id
	 * @param app_user_nick_name
	 * @param avatar
	 * @return
	 */
	public static String userUpdate(String url,String app_user_id,String app_user_nick_name, String avatar,String token){
		Map<String, String>	param  =new HashMap<String, String>();
		param.put("app_user_id", app_user_id);
		param.put("app_user_nick_name", app_user_nick_name);
		param.put("avatar",avatar);
		Map<String, String>	header  =new HashMap<String, String>();
		header.put("token", token);
		return HttpClientUtil.doPost(url, param,header);
	}
	public static String userUpdate(String url,String app_user_id,String app_user_nick_name, String token){
		
		return userUpdate(url, app_user_id, app_user_nick_name, null, token);
	}
	
	/**
	 * 创建群组
	 * @param url
	 * @param member
	 * @param name
	 * @param desc
	 * @return
	 */
	public static  String createGroup(String url,String member,String name,String desc,String token,String clientSession,String appId){
		Map<String, String>	param  =new HashMap<String, String>();
		param.put("member", member);
		param.put("name", name);
		param.put("desc",desc);
		Map<String, String>	header  =new HashMap<String, String>();
		header.put("token",token);
		header.put("clientSession",clientSession);
		header.put("appId",appId);
		return HttpClientUtil.doPostGroup(url, param,header);
	}
	
	
	public static  String createGroup(String url,String member,String name,String token,String clientSession,String appId){
		return createGroup(url, member, name, null, token, clientSession, appId);
	}
	
	
	/**
	 * 更新群组
	 * @param url
	 * @param group_id
	 * @param name
	 * @param desc
	 * @return
	 */
	public static String updateGroup(String url,String group_id,String name,String desc,String token,String clientSession,String appId){
		Map<String, String>	param  =new HashMap<String, String>();
		param.put("group_id", group_id);
		param.put("name", name);
		param.put("desc",desc);
		Map<String, String>	header  =new HashMap<String, String>();
		header.put("token",token);
		header.put("clientSession",clientSession);
		header.put("appId",appId);
		return HttpClientUtil.doPostGroup(url, param,header);
	}
    /**
     * 获取群组信息
     * @param url
     * @param group_id
     * @param detail  默认返回群成员信息，如果为0则不返回群成员,1为返回群成员
     * @return
     */
	public  static String  getGroup(String url, String group_id ,String detail,String token,String clientSession,String appId){
		Map<String, String>	param  =new HashMap<String, String>();
		param.put("group_id",group_id);
		param.put("detail", detail);
		Map<String, String>	header  =new HashMap<String, String>();
		header.put("token",token);
		header.put("clientSession",clientSession);
		header.put("appId",appId);
		return HttpClientUtil.doGetGroup(url, param,header);
	}
	/**
	 * 加入群组
	 * @param url
	 * @param group_id
	 * @param member
	 * @return
	 */
	public  static  String joinGroup(String url,String group_id,String member,String token,String clientSession,String appId){
		Map<String, String>	param  =new HashMap<String, String>();
		param.put("group_id",group_id);
		param.put("member", member);
		Map<String, String>	header  =new HashMap<String, String>();
		header.put("token",token);
		header.put("clientSession",clientSession);
		header.put("appId",appId);
		return HttpClientUtil.doPostGroup(url, param,header);		
	}
	/**
	 * 将用户从群组中移除
	 * @param url
	 * @param group_id
	 * @param member
	 * @return
	 */
	public  static String removeGroup(String url,String group_id,String member,String token,String clientSession,String appId){
		Map<String, String>	param  =new HashMap<String, String>();
		param.put("group_id",group_id);
		param.put("member", member);
		Map<String, String>	header  =new HashMap<String, String>();
		header.put("token",token);
		header.put("clientSession",clientSession);
		header.put("appId",appId);
		return HttpClientUtil.doPostGroup(url, param,header);
	}
	/**
	 * 解散或退出群组
	 * @param url
	 * @param group_id
	 * @return
	 */
	public static  String exitGroup(String url,String group_id,String token,String clientSession,String appId){
		Map<String, String>	param  =new HashMap<String, String>();
		param.put("group_id",group_id);
		Map<String, String>	header  =new HashMap<String, String>();
		header.put("token",token);
		header.put("clientSession",clientSession);
		header.put("appId",appId);
		return HttpClientUtil.doPostGroup(url, param,header);
	}
}
