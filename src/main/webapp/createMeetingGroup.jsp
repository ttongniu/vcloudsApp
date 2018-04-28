<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
        <script type="text/javascript">
           
        </script>
    </head>
    
    <body ontouchstart>
        <header class="ui-header ui-header-positive ui-border-b">
           <!--  <i class="ui-icon-return" onclick="history.back()"> -->
            </i><h1>创建会议组</h1>
        </header>  
		<section class="ui-container">
<section id="form">

    <div class="demo-item">
     
        <div class="demo-block">
            <div class="ui-form ui-border-t">
                <form  id="Form" action="${pageContext.request.contextPath }/toAddUserPage.do" method="post">
                    <div class="ui-form-item ui-form-item-pure ui-border-b">
                        <input type="text"  id="name" name="name" placeholder="会议组名称">
                        <a href="#" class="ui-icon-close"></a>
                    </div>
                    
                   <div class="ui-btn-wrap">
                      <button  id="but" class="ui-btn-lg ui-btn-primary" >
                                                                          下一步
                       </button>
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
             	    //alert("ok  成功了！！");
             	    var name=document.getElementById("name").value;
             	    if(name==""){
             	     alert("名称为空！！");
             	     return  false;
             	    }
             	   document.getElementById("Form").submit();  
                }		
             );  
        
        </script>
    </body>
</html>