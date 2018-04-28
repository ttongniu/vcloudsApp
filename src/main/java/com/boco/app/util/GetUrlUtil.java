package com.boco.app.util;

import javax.servlet.http.HttpServletRequest;

public class GetUrlUtil {
          public static String getUrl(HttpServletRequest request ){
        	  String url = "";
      		url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
      				+ request.getServletPath();
      		if (request.getQueryString() != null) {
      			url += "?" + request.getQueryString();
      		}
        	  return url;
          }
}
