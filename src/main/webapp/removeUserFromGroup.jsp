<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
        <script src="frozenui/zepto.min.js"></script>
        <script src="frozenui/frozen.js"></script>
    </head>
    
    <body ontouchstart>
        <header class="ui-header ui-header-positive ui-border-b">
          <!--   <i class="ui-icon-return" onclick="history.back()"></i> -->
			<h1>移除成员</h1>
			<button class="ui-btn" id="but">确定</button> 
        </header>
<section class="ui-container">
<section id="form">
    <div class="demo-item">
        <div class="demo-block">
            <div class="ui-form ui-border-t">
                <form  id="Form" action="${pageContext.request.contextPath }/removeUser.do" method="post">
				   <p class="demo-desc">会议组成员：</p>
				   <c:forEach items="${group.userList }" var="user">
				   <c:choose>
				   <c:when test="${user.id==activeUser.id }">
                    <div style="display: none;" class="ui-form-item ui-form-item-checkbox ui-border-b">
                        <label class="ui-checkbox">
                            <input type="checkbox" value="${user.id }" />
                        </label>&nbsp;&nbsp;&nbsp;  
                        <p>${user.nickname }</p>
                    </div>
                    </c:when>
                    <c:otherwise>
                     <div class="ui-form-item ui-form-item-checkbox ui-border-b">
                        <label class="ui-checkbox">
                            <input type="checkbox" value="${user.id }" />
                        </label>&nbsp;&nbsp;&nbsp;  
                        <p>${user.nickname }</p>
                    </div>
                    </c:otherwise>
                    </c:choose>
                   </c:forEach>
                       <div style="display: none;"  class="ui-form-item ui-form-item-pure ui-border-b">
                        <input type="text"  id="groupId" name="groupId" value="${group.id }">
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
               document.getElementById("Form").submit();
                }		
             );  
        
        </script>
    </body>
</html>