package com.boco.app.util;

import java.io.IOException;  
import java.net.URI;  
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;  
import java.util.Map;  
  
import org.apache.http.NameValuePair;  
import org.apache.http.client.entity.UrlEncodedFormEntity;  
import org.apache.http.client.methods.CloseableHttpResponse;  
import org.apache.http.client.methods.HttpGet;  
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.client.utils.URIBuilder;  
import org.apache.http.entity.ContentType;  
import org.apache.http.entity.StringEntity;  
import org.apache.http.impl.client.CloseableHttpClient;  
import org.apache.http.impl.client.HttpClients;  
import org.apache.http.message.BasicNameValuePair;  
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.boco.app.model.AccessToken;

import net.sf.json.JSONObject;  
  
public class HttpClientUtil {  
     /**
      * http  GET方式请求  
      * @param url    请求url
      * @param param  参数
      * @param header (token)  参数
      * @return      返回结果JSonString
      */
    public static String doGet(String url, Map<String, String> param,Map<String,String> header) {  
  
        // 创建Httpclient对象  
        CloseableHttpClient httpclient = HttpClients.createDefault();  
  
        String resultString = "";  
        CloseableHttpResponse response = null;  
        try {  
            // 创建uri  
            URIBuilder builder = new URIBuilder(url);  
            if (param != null) {  
                for (String key : param.keySet()) {  
                    builder.addParameter(key, param.get(key));  
                }  
            }  
            URI uri = builder.build();  
  
            // 创建http GET请求  
            HttpGet httpGet = new HttpGet(uri); 
            if(header!=null){
            //添加header 进行认证
            httpGet.addHeader("Authorization", "Bearer "+header.get("token"));
            }
            // 执行请求  
            response = httpclient.execute(httpGet);  
            // 判断返回状态是否为200  
            if (response.getStatusLine().getStatusCode() == 200) {  
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (response != null) {  
                    response.close();  
                }  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return resultString;  
    }  
    /**
     * Get 请求方式  group组
     * @param url
     * @param param
     * @param header  (token,clientSession,appId)
     * @return
     */
    public static String doGetGroup(String url, Map<String, String> param,Map<String,String> header) {  
    	  
        // 创建Httpclient对象  
        CloseableHttpClient httpclient = HttpClients.createDefault();  
  
        String resultString = "";  
        CloseableHttpResponse response = null;  
        try {  
            // 创建uri  
            URIBuilder builder = new URIBuilder(url);  
            if (param != null) {  
                for (String key : param.keySet()) {  
                    builder.addParameter(key, param.get(key));  
                }  
            }  
            URI uri = builder.build();  
            // 创建http GET请求  
            HttpGet httpGet = new HttpGet(uri);  
            if(header!=null){
            //添加header 进行认证
            httpGet.addHeader("Authorization", "Bearer "+header.get("token"));
            httpGet.addHeader("client-session", header.get("clientSession"));
            httpGet.addHeader("app-id", header.get("appId"));
            }
            // 执行请求  
            response = httpclient.execute(httpGet);  
            // 判断返回状态是否为200  
            if (response.getStatusLine().getStatusCode() == 200) {  
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (response != null) {  
                    response.close();  
                }  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return resultString;  
    }  
    
    /**
     * http  GET请求   无参数
     * @param url
     * @return
     */
    public static String doGet(String url) {  
        return doGet(url, null,null);  
    }  
    
    /**
     * http  GET请求   无header
     * @param url
     * @return
     */
    public static String doGet(String url,Map<String,String> param) {  
        return doGet(url, param,null);  
    } 
    /**
     * http  post请求方式  
     * @param url
     * @param param   参数
     * @param header (token)
     * @return
     */
    public static String doPost(String url, Map<String, String> param ,Map<String,String> header) {  
        // 创建Httpclient对象  
        CloseableHttpClient httpClient = HttpClients.createDefault();  
        CloseableHttpResponse response = null;  
        String resultString = "";  
        try {  
            // 创建Http Post请求  
            HttpPost httpPost = new HttpPost(url);
            if(header!=null){
            //添加header 进行认证
            httpPost.addHeader("Authorization", "Bearer "+header.get("token"));
            }
            // 创建参数列表  
            if (param != null) {  
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();  
                for (String key : param.keySet()) {  
                    paramList.add(new BasicNameValuePair(key, param.get(key)));  
                }  
                // 模拟表单  
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);  
                httpPost.setEntity(entity);  
            }  
            // 执行http请求  
            response = httpClient.execute(httpPost);  
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                response.close();  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
  
        return resultString;  
    }  
  /**
   * http   post请求  无参数
   * @param url
   * @return
   */
    public static String doPost(String url) {  
        return doPost(url, null,null);  
    } 
    
    /**
     * http   post请求  无header
     * @param url
     * @return
     */
      public static String doPost(String url,Map<String,String> param) {  
          return doPost(url, param,null);  
      } 
    
    
   /**
    * http  post请求   json格式参数
    * @param url
    * @param json
    * @return
    */
    public static String doPostJson(String url, String json) {  
        // 创建Httpclient对象  
        CloseableHttpClient httpClient = HttpClients.createDefault();  
        CloseableHttpResponse response = null;  
        String resultString = "";  
        try {  
            // 创建Http Post请求  
            HttpPost httpPost = new HttpPost(url);  
            // 创建请求内容  
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);  
            httpPost.setEntity(entity);  
            // 执行http请求  
            response = httpClient.execute(httpPost);  
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                response.close();  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
  
        return resultString;  
    }  
    
    /**
     * http  post请求方式  
     * @param url
     * @param param   参数
     * @param header (token,clientSession,appId)
     * @return
     */
    public static String doPostGroup(String url, Map<String,String> param,Map<String,String> header) {  
        // 创建Httpclient对象  
        CloseableHttpClient httpClient = HttpClients.createDefault();  
        CloseableHttpResponse response = null;  
        String resultString = "";  
        try {  
            // 创建Http Post请求  
            HttpPost httpPost = new HttpPost(url);
            if(header!=null){
            //添加header 进行认证
            httpPost.addHeader("Authorization", "Bearer "+header.get("token"));
            httpPost.addHeader("client-session", header.get("clientSession"));
            httpPost.addHeader("app-id", header.get("appId"));
            }
            // 创建参数列表  
            if (param != null) {  
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();  
                for (String key : param.keySet()) {  
                    paramList.add(new BasicNameValuePair(key, param.get(key)));  
                }  
                // 模拟表单  
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);  
                httpPost.setEntity(entity);  
            }  
            // 执行http请求  
            response = httpClient.execute(httpPost);  
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                response.close();  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
  
        return resultString;  
    }  
     
    
    public static void main(String[] args) {
    	String url="";
    	url="http://www.baidu.com";
    	String resultString="";
        resultString=HttpClientUtil.doGet(url);
    	System.out.println("返回结果："+resultString);
    	//获取token
    	url="http://cloudcn.v5.cn/oauth/token";
    	Map<String, String> param=null;  
    	Map<String, String> header=null; 
    	param  =new HashMap<String, String>();
    	param.put("client_id", "216917");
    	param.put("client_secret", "0d9592765e40674ab43a833b85ccdd8d");
    	param.put("grant_type", "client_credentials");
      	resultString=HttpClientUtil.doPost(url, param);
    	System.out.println("post返回结果："+resultString);
    	/*AccessToken token=JSON.parseObject(resultString, AccessToken.class);
    	System.out.println("access"+token.getAccess_token());*/
    	com.alibaba.fastjson.JSONObject token=JSON.parseObject(resultString);
    	System.out.println("access"+token.getString("access_token"));
    	//创建用户
    	/*url="http://cloudcn.v5.cn/open/api/user/auth";
    	param  =new HashMap<String, String>();  	
    	param.put("app_user_id", "21402345");
    	param.put("app_user_nick_name", "四毛");
    	header=new HashMap<String, String>(); 
    	header.put("token", "56914919-e326-44cc-b29a-d1c19fc0db66");
    	resultString=HttpClientUtil.doGet(url, param,header);
    	System.out.println("get返回结果："+resultString);*/
    	//更新用户
    	/*url="http://cloudcn.v5.cn/open/api/user/update";
    	param  =new HashMap<String, String>();  	
    	param.put("app_user_id", "21402345");
    	param.put("app_user_nick_name", "三毛");
    	header  =new HashMap<String, String>(); 
    	header.put("token", "56914919-e326-44cc-b29a-d1c19fc0db66");
    	resultString=HttpClientUtil.doPost(url, param,header);
    	System.out.println("post返回结果："+resultString);*/
    	/*//创建群组
    	url="http://cloudcn.v5.cn/open/api/group/create";
    	param  =new HashMap<String, String>();  	
    	param.put("member", "21402344，21402345");
    	param.put("name", "三毛的群组");
    	param.put("desc", "三毛的群组 欢迎光临");
    	resultString=HttpClientUtil.doPostGroup(url, param);
    	System.out.println("post返回结果："+resultString);*/	
	}
}  