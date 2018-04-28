<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
  <%String path = request.getContextPath(); %>  
<!DOCTYPE html> 
<html>
<head>
<meta charset="utf-8">
 <meta name="viewport" content="width=380,target-densitydpi=320,maximum-scale=1,maximum-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black"> 
<!--<meta content=”yes” name=”apple-mobile-web-app-capable” />   
<meta content=”black” name=”apple-mobile-web-app-status-bar-style” /> 	  
<meta content=”telephone=no” name=”format-detection” />   -->
<title>视频会议</title>
<link href="jquery-mobile/jquery.mobile-1.4.5.min.css" rel="stylesheet" type="text/css"/>
<script src="jquery-mobile/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="jquery-mobile/jquery.mobile-1.4.5.min.js" type="text/javascript"></script>
<script src="jquery-mobile/VCloudClient.js" type="text/javascript"></script>
<script>
$(document).on("pageinit","#pageone",function(){
  $("ul li").on("taphold",function(){
    //$(this).hide();
	if(confirm("是否继续")){
      $(this).hide();
   }
  });                       
});
</script>
</head> 
<body> 
<!-- 表单的练习 -->

<div data-role="page" id="pageone" >
  <div data-role="header">
    <a href="javascript:history.back();" data-role="button"    data-icon="back">返回</a> 
  <h1>我的会议</h1>
  <a href="${pageContext.request.contextPath }/toAddMeetingGroupPage.do"   data-role="button" data-icon="plus">创建</a>
  </div>
    <div data-role="content">
   
    <ul data-role="listview">
    <%--  <li><a href="#">${userInfo.nickname }</a></li>  --%>
      <c:forEach  items="${userInfo.meetingGroupList }" var="meetingGroup" >
      <li><a href="${pageContext.request.contextPath }/groupInfo.do?id=${meetingGroup.id }">${meetingGroup.name }</a></li>
      </c:forEach> 
      <li><a href="javascript:enterGroupChat();">会议一</a></li>
      <li><a href="#">会议二</a></li>
      <li><a href="#">会议三</a></li>
      <li><a href="#">会议四</a></li>  
      <li><a href="#">会议五</a></li>
    </ul>
    
  </div>
  </div>
</body>
</html>
