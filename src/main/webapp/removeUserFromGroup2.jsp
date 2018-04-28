<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=380,target-densitydpi=320,maximum-scale=1,maximum-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">   
<title>我的会议</title>
<link href="jquery-mobile/jquery.mobile-1.4.5.min.css" rel="stylesheet" type="text/css"/>
<script src="jquery-mobile/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="jquery-mobile/jquery.mobile-1.4.5.min.js" type="text/javascript"></script>
<script type="text/javascript">
/* $(document).load(function(){
	window.opener.location.reload();

}); */
/* function myrefresh()
{
   window.location.reload();
}
setTimeout('myrefresh()',1000); //指定1秒刷新一次 */
 function next() {
	
	 $("#form1").submit();
}  
</script>
</head> 
<body> 
<!-- 表单的练习 -->

<div data-role="page" id="pageone" >
  <div data-role="header">
 <a href="#pageone" data-role="button"  data-icon="back">返回</a> 
  <h1>移除成员</h1>
  <a href="javascript:next();"     data-role="button" data-icon="check">确定</a>
  </div>
    <div data-role="content">
    <form  id="form1" action="${pageContext.request.contextPath }/removeUser.do" method="post">
    <div data-role="controlgroup" >
        <c:forEach  items="${group.userList }"  var="user">
          <label for="id">${user.nickname }</label>
          <input type="checkbox" name="id" id="id" value="${user.id }">
        </c:forEach>
         <!--  <label for="id">李四</label>
          <input type="checkbox" name="id" id="id" value="12123"> -->
         <label for="wuwu">王五</label>
          <input type="checkbox" name="wuwu" id="wuwu" value="12233"> 
     </div>	
    </form>    
  </div>
  </div>
</body>
</html>