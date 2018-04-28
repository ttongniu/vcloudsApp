<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
  <%String path = request.getContextPath(); %>  
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="format-detection" content="telephone=no">
        <title>视频会议</title>
        <link rel="stylesheet" href="frozenui/frozen.css">
        <link rel="stylesheet" href="frozenui/demo.css">
        <script src="jquery-mobile/jquery-1.8.3.min.js" type="text/javascript"></script>
        <script src="frozenui/frozen.js"></script>
        <script src="frozenui/zepto.min.js"></script>
        <script src="simba/controller/index.js"></script>
        <script src="simba/model/index.js"></script>
        <script src="simba/render/index.js"></script>
        <script src="simba/util/util.js"></script>
        <script src="simba/appInterfaces.js"></script>
        <script src="simba/layout.js"></script>
        <script src="simba/modernizr-2.8.3.min.js"></script>
        <script src="simba/plugins.js"></script>      
        <script src="jquery-mobile/VCloudClient.js"></script>
        <script type="text/javascript"> 
        function hello() {
			alert("hello");
		}
        </script>
    </head>   
    <body ontouchstart>
        <header class="ui-header ui-header-positive ui-border-b">
            <!-- <i class="ui-icon-return" onclick="history.back()"></i> -->
            <h1>我的会议</h1>
           <a href="${pageContext.request.contextPath }/toAddMeetingGroupPage.do"> <button class="ui-btn" onclick="">创建</button></a>
        </header>     
        <section class="ui-container">
<section id="list">
    <div class="demo-item">
        
        <div class="demo-block">
            <ul class="ui-list ui-list-link ui-border-tb  ui-list-active ui-list-cover">
            <c:forEach  items="${meetingGroupList }" var="meetingGroup" >
                
                   <li onclick="VCloudClient.getInstance().enterGroupChat('${appId }','${activeUser.id }','${activeUser.sessionid }','${meetingGroup.id }');">          
                    <div class="ui-list-info  ui-border-t" >
                    <h5 class="ui-nowrap">${meetingGroup.name }</h5> 
                    </div>              
                   </li>
                
             </c:forEach>                 
            </ul>
        </div>
    </div>
  
</section>
        </section><!-- /.ui-container-->
        <script>
        
        </script>
    </body>
</html>