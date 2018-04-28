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
        <script src="frozenui/zepto.min.js"></script>
        <script src="frozenui/frozen.js"></script>
    </head>
    <body ontouchstart>
        <header class="ui-header ui-header-positive ui-border-b">
          <!--   <i class="ui-icon-return" onclick="history.back()"></i> -->
			<h1>会议组信息</h1>
        </header>
      
        <section class="ui-container">
<section id="form">

    <div class="demo-item">
       <!--  <p class="demo-desc">表单展示项</p> -->
        <div class="demo-block">
            <div class="ui-form ui-border-t">
                <form action="#" >
                    <div class="ui-form-item ui-form-item-show  ui-border-b">
                        <label for="#">会议组名称</label>
                        <input type="text" value="${group.name }" readonly>
                    </div>
                    <div class="ui-form-item ui-form-item-show ui-border-b">
                        <label for="#">会议组ID</label>
                        <input type="text" value="${group.id }" readonly>
                    </div>
                     <p class="demo-desc">会议组成员：</p>
             <div class="ui-label-list">
             <c:forEach items="${group.userList }" var="user">
                <label class="ui-label">${user.nickname }</label>               
		    </c:forEach>
            </div>
                
                </form>
               <c:choose>
               <c:when test="${group.creator==activeUser.id }">
                <div class="ui-btn-wrap">
                 <a href="${pageContext.request.contextPath }/toAddUserPage.do">      <button class="ui-btn-lg ui-btn-primary">
                            添加成员
                       </button> </a>
                  </div>
                   <div class="ui-btn-wrap">
                   <a href="${pageContext.request.contextPath }/removeUserPage.do">      <button class="ui-btn-lg ui-btn-primary">
                             移除成员
                       </button></a>
                  </div>
			  </c:when>
                  <c:otherwise>
                        <div class="ui-btn-wrap">
                 <a href="${pageContext.request.contextPath }/toAddUserPage.do">      <button class="ui-btn-lg ui-btn-primary">
                            添加成员
                       </button> </a>
                  </div>
				 </c:otherwise>
          </c:choose>        
                  
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
        </script>
    </body>
</html>