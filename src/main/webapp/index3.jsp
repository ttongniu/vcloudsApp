<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="utf-8">
<meta content=”width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;” name=”viewport” /> 
<meta content=”yes” name=”apple-mobile-web-app-capable” />   
<meta content=”black” name=”apple-mobile-web-app-status-bar-style” /> 	  
<meta content=”telephone=no” name=”format-detection” /> 
<title>jQuery Mobile Web 应用程序</title>
<link href="jquery-mobile/jquery.mobile-1.0.min.css" rel="stylesheet" type="text/css"/>
<script src="jquery-mobile/jquery-1.6.4.min.js" type="text/javascript"></script>
<script src="jquery-mobile/jquery.mobile-1.0.min.js" type="text/javascript"></script>
</head> 
<body> 
<!--
<div data-role="page" id="page">
	<div data-role="header">
		<h1>第 1 页</h1>
	</div>
	<div data-role="content">	
		<ul data-role="listview">
			<li><a href="#page2">第 2 页</a></li>
            <li><a href="#page3">第 3 页</a></li>
			<li><a href="#page4">第 4 页</a></li>
		</ul>		
	</div>
	<div data-role="footer">
		<h4>页面脚注</h4>
	</div>
</div>

<div data-role="page" id="page2">
	<div data-role="header">
		<h1>第 2 页</h1>
	</div>
	<div data-role="content">	
		内容		
	</div>
	<div data-role="footer">
		<h4>页面脚注</h4>
	</div>
</div>

<div data-role="page" id="page3">
	<div data-role="header">
		<h1>第 3 页</h1>
	</div>
	<div data-role="content">	
		内容		
	</div>
	<div data-role="footer">
		<h4>页面脚注</h4>
	</div>
</div>

<div data-role="page" id="page4">
	<div data-role="header">
		<h1>第 4 页</h1>
	</div>
	<div data-role="content">	
		内容		
	</div>
	<div data-role="footer">
		<h4>页面脚注</h4>
	</div>
</div>  -->
<!-- 表单的练习 -->

<div data-role="page" id="pageone" data-theme="e">
  <div data-role="header">
  <a href="#pageone" data-role="button"  data-icon="home">首页</a>
  <h1>jQuery Mobile 表单</h1>
  <a href="#" data-role="button" data-icon="search">搜索</a>
  <div data-role="navbar">
      <ul>
        <li><a href="#pagetwo" data-icon='minus'>导航一</a></li>
        <li><a href="#pageone" data-icon='custom'>导航二</a></li>
        <li><a href="#pageone" data-icon='forward'>导航三</a></li>
      </ul>
    </div>
  </div>
  <div data-role="content">
<div data-role="fieldcontain">
    <label for="name">姓名：</label>
    <input type="text" name="text" id="name" value="" placeholder="您的尊姓大名？">
    </div>
    
    <div data-role="fieldcontain">
    <label for="search" > 查询条件：</label>
    <input type="search"  name="search" id="search" value="" placeholder="搜索内容？？">
    </div>
    
     <div data-role="fieldcontain">
     <label for="date">今天的日期：</label>
     <input type="date" name="date" id="date" value="" >
     </div>
          
<div data-role="fieldcontain">
      <label for="colors">喜爱的颜色：</label>
      <select name="colors" id="colors" >
           <option value="red" >红色</option>
           <option value="green" selected>绿色</option>
           <option value="biue">蓝色</option> 
      </select>
</div>
 <div data-role="fieldcontain" >
    <label for="switch">切换开关：</label>
    <select name="switch" id="switch" data-role="slider"  >
      <option value="on">开</option> 
      <option value="off">关</option>
    </select>
  </div>
  <div  data-role="controlgroup">
   <legend>喜爱的电影：</legend>
   <label for="mov1">蜘蛛侠</label>
   <input type="checkbox" name="mov1" id="mov1" />
   <label for="mov2">变形金刚</label>
   <input type="checkbox" name="mov2" id="mov2" />
   <label for="mov3">碟中谍</label>
   <input type="checkbox" name="mov3" id="mov3" />
  </div> 
  <div  data-role="collapsible">
     <h1>我的折叠王</h1>
     <p>我是折叠王的手下小弟</p>
  </div>
  </div>
  <div data-role="footer" class="ui-bar">
		<div data-role="controlgroup" data-type="horizontal">
            <a href="#" data-role="button"  data-icon="plus" >转到百度</a>
            <a href="#" data-role="button"  data-icon="plus" >转到新浪</a>    
            <a href="#" data-role="button"  data-icon="plus" >转到阿里</a>
        </div>     
   </div>
  </div>
  
  <div data-role="page" id="pagetwo" data-theme='a'>
  
   <div data-role="header">
  <a href="#pageone" data-role="button"  data-icon="home">首页</a>
  <h1>jQuery Mobile 表单</h1>
  <a href="#pageone" data-role="button" data-icon="search">搜索</a>
  <div data-role="navbar">
      <ul>
        <li><a href="#pagetwo" data-icon='minus'>导航一</a></li>
        <li><a href="#pageone" data-icon='custom'>导航二</a></li>
        <li><a href="#pageone" data-icon='forward'>导航三</a></li>
      </ul>
    </div>
  </div>
  <div data-role="content" >
      <h2>我的邮箱</h2>
    <ul data-role="listview" data-inset="true">
      <li><a href="#">收件箱<span class="ui-li-count">25</span></a></li>
      <li><a href="#">发件箱<span class="ui-li-count">432</span></a></li>
      <li><a href="#">垃圾箱<span class="ui-li-count">7</span></a></li>
    </ul>
    
      <fieldset data-role="fieldcontain">
        <label for="day">选择天</label>
        <select name="day" id="day">
		<optgroup label="工作日">
         <option value="mon">星期一</option>
         <option value="tue">星期二</option>
         <option value="wed">星期三</option>
         <option value="thu">星期四</option>
         <option value="fri">星期五</option>
		</optgroup>
		<optgroup label="周末">
         <option value="sat">星期六</option>
         <option value="sun">星期日</option>
		</optgroup>
        </select>
      </fieldset>
      
      <div data-role="fieldcontain">
        <label for="points">Points:</label>
        <input type="range" name="points" id="points" value="50" min="0" max="100">
      </div>
    
  </div>
   <div data-role="footer" class="ui-bar">
		<div data-role="controlgroup" data-type="horizontal">
            <a href="#" data-role="button"  data-icon="plus" >转到百度</a>
            <a href="#" data-role="button"  data-icon="plus" >转到新浪</a>    
            <a href="#" data-role="button"  data-icon="plus" >转到阿里</a>
        </div>     
   </div>
   
  </div>
  
  
</body>
</html>
