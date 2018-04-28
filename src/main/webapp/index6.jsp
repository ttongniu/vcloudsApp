<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
  <%String path = request.getContextPath(); %>  
<!DOCTYPE html> 
<html>
<head>
<meta charset="utf-8">
<meta content=”width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no;” name=”viewport” /> 
<!-- <meta content=”yes” name=”apple-mobile-web-app-capable” />   
<meta content=”black” name=”apple-mobile-web-app-status-bar-style” /> 	  
<meta content=”telephone=no” name=”format-detection” />  -->
<title>我的会议</title>
<link href="jquery-mobile/jquery.mobile-1.3.2.min.css" rel="stylesheet" type="text/css"/>
<script src="jquery-mobile/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="jquery-mobile/jquery.mobile-1.3.2.min.js" type="text/javascript"></script>

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

<div data-role="page" id="pageone" data-theme="e">
  <div data-role="header">
  <a href="#pageone" data-role="button"  data-icon="back">返回</a>
  <h1>我的会议</h1>
  <a href="./app-2.html"  data-transition="slide" data-role="button" data-icon="plus">创建</a>
  </div>
    <div data-role="content">
    <ul data-role="listview">
      <li><a href="#">会议一</a></li>
      <li><a href="#">会议二</a></li>
      <li><a href="#">会议三</a></li>
      <li><a href="#">会议四</a></li>  
      <li><a href="#">会议五</a></li>
    </ul>
  </div>
  </div>
</body>
</html>
