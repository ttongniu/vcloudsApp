<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=380,maximum-scale=1,maximum-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<title>创建会议组</title>
<!-- <link href="jquery-mobile/jquery.mobile-1.3.2.min.css" rel="stylesheet" type="text/css"/>
<script src="jquery-mobile/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="jquery-mobile/jquery.mobile-1.3.2.min.js" type="text/javascript"></script> -->
<script src="jquery-mobile/jquery-1.8.3.min.js" type="text/javascript"></script>
<link href="jquery-mobile/jquery.mobile-1.4.5.min.css" rel="stylesheet" type="text/css"/>
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
 /* function next() {
	 if(!$("#name").val()) {
	        alert("姓名为空");
	        return false;
	        }
	 $("#form1").submit();
}  */
</script>

</head> 
<body> 
<!-- 表单的练习 -->

<div data-role="page" id="pageone" >
  <div data-role="header">
  <a href="javascript:history.back();" data-role="button"  data-icon="back">返回</a> 
  <h1>创建会议组</h1>
  <%-- <a href="${pageContext.request.contextPath }/toAddUserPage.do" data-role="button" data-icon="forward">下一步</a>  --%>
  </div>
    <div data-role="content">
    <div data-role="fieldcontain">
     <form  id="form1" action="${pageContext.request.contextPath }/toAddUserPage.do" method="post">
     <input type="text" name="name" id="name" placeholder="会议组名称">
     <input type="submit"     value="下一步" >
     </form>
    </div>
  </div>
  </div>
</body>
</html>
