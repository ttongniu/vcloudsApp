<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <script src="frozenui/zepto.min.js"></script>
        <script src="frozenui/frozen.js"></script>
        
    </head>
    
    <body ontouchstart>
        <header class="ui-header ui-header-positive ui-border-b">
           <!--  <i class="ui-icon-return" onclick="history.back()"></i> -->
            <h1>添加成员</h1>
          <button class="ui-btn"  id="but" >完成</button>
        </header>
<section class="ui-container">
<section id="form">
    <div class="demo-item">
        <p class="demo-desc">集团>信通>信息服务中心</p>
        <div class="demo-block">
            <div class="ui-form ui-border-t">
                <form id="Form"  action="${pageContext.request.contextPath }/addMeetingGroup.do" method="post">
                 <c:forEach  items="${userList }" var="user" >
                   <c:choose>
                    <c:when test="${user.id==activeUser.id }">
                         <div style="display: none;" class="ui-form-item ui-form-item-checkbox ui-border-b">
                        <label class="ui-checkbox">
                            <input type="checkbox" id="id" name="id"  value="${user.id }" />
                        </label>&nbsp;&nbsp;&nbsp;  
                        <p>${user.nickname }</p>
                    </div>
                    </c:when>
                        
                    <c:otherwise>
                    <div class="ui-form-item ui-form-item-checkbox ui-border-b">
                        <label class="ui-checkbox">
                            <input type="checkbox" id="id" name="id"  value="${user.id }"/>
                        </label>&nbsp;&nbsp;&nbsp;  
                        <p>${user.nickname }</p>
                    </div>
                   </c:otherwise>
                    </c:choose>
                  </c:forEach>
                  <div style="display: none;"  class="ui-form-item ui-form-item-pure ui-border-b">
                        <input type="text"  id="name" name="name" value="${meetingGroup.name }">
                  </div>
                    
                </form>
                
            </div>
        </div>
    </div>
</section>

        </section><!-- /.ui-container-->
        <script>
        $('.ui-list li,.ui-tiled li').click(function(){
            if($(this).data('href')){
                location.href= $(this).data('href');
            }
        });
        $('.ui-header .ui-btn').click(function(){
            location.href= 'index.html';
        });
        $('#but').click(
                function(){
                	var flag; 
                	var checks = document.getElementsByName("id"); 
                	for(var i=0;i<checks.length;i++){ 
                	if(checks[i].checked==true){ 
                	flag = true; 
                	document.getElementById("Form").submit();
                	break; 
                	} 
                	} 
                	if(!flag){ 
                	alert("请至少选择一项"); 
                	return history.go(0) ;
                	} 
                }		
             );  
        </script>
    </body>
</html>
