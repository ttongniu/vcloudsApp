<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=380,target-densitydpi=320,maximum-scale=1,maximum-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black"> 
<title>我的会议</title>
<!-- <link href="jquery-mobile/jquery.mobile-1.3.2.min.css" rel="stylesheet" type="text/css"/>
<script src="jquery-mobile/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="jquery-mobile/jquery.mobile-1.3.2.min.js" type="text/javascript"></script> -->
<link href="jquery-mobile/jquery.mobile-1.4.5.min.css" rel="stylesheet" type="text/css"/>
<script src="jquery-mobile/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="jquery-mobile/jquery.mobile-1.4.5.min.js" type="text/javascript"></script>

</head> 
<body> 
<!-- 表单的练习 -->

<div data-role="page" id="pageone" >
  <div data-role="header">
  <a href="javascript:history.back();" data-role="button"  data-icon="back">返回</a> 
  <h1>添加成员</h1>
  <a href="${pageContext.request.contextPath }/addMeetingGroup.do"     data-role="button" data-icon="check">完成</a>
  </div>
  
    <div data-role="content">
    <div data-role="controlgroup">
    
          <label for="red">张三</label>
          <input type="checkbox" name="favcolor" id="red" value="red">
          
          <label for="green">李四</label>
          <input type="checkbox" name="favcolor" id="green" value="green">
          <label for="blue">王五</label>
          <input type="checkbox" name="favcolor" id="blue" value="blue">
        </div>	
  </div>
  </div>
</body>
</html>
