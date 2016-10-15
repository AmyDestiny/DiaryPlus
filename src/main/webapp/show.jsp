<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>人不如旧，衣不如新</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<link rel="shortcut icon"  type="image/x-icon" href="images/favicon.ico" />

<style>
	body{
		
	}
	#imgBox{
		width:100%;
		height:100%;
		background:rgba(0,0,0,0.6);
		display:none;
		position:fixed;
		z-index:101;
		text-align:center;
	}
	#imgBox img{
		border:10px #1bf2bc solid;
		z-index:102;
		margin:200px auto 0 auto;
		position: relative;
		border-radius:10px;
	}
	.showBig{
		width:100%;
		height:100%;
	}
	.showBig:hover{
		cursor:pointer;
	}
</style>
  </head>
  
  <body>
  	<div id="imgBox">
	<img id="showImg"  height="70%" src="images/alisa/meinv.jpg"></img>
</div>
<div class="content">
  <div class="wrapper">
    <div class="light"><i></i></div>
    <hr class="line-left">
    <hr class="line-right">
    <div class="main">
      <h1 class="title">生活中的点点滴滴</h1>
      
      
      <c:forEach items="${records}" var="record">
      		<div class="year">
	      		<h2><a href="#">${record.year + 1900}年<i></i></a></h2>
	      		 <div class="list">
		          <ul>
		          	<c:forEach items="${record.list}" var="details">
		          		<c:choose>
		          			<c:when test="${details.isHighLight == 1}">
		          				<li class="cls highlight">
		          			</c:when>
		          			<c:otherwise>
		          				<li class="cls">
		          			</c:otherwise>
		          		</c:choose>
			              	<p class="date"><fmt:formatDate value="${details.date}" pattern="MM月dd日"/></p>
			              	<p class="intro">${details.intro}</p>
			              	<p class="version">
			              		<c:choose>
			              			<c:when test="${details.version == null || details.version == ''}">
			              				&nbsp;
			              			</c:when>
			              			<c:otherwise>
			              				${details.version}
			              			</c:otherwise>
			              		</c:choose>
			              	</p>
			              	<div class="more">
			                	<p>${details.more}</p>
			                	<c:if test="${details.imgpath != null}">
			                		<img src="${details.imgpath}" class="showBig"></img>
			                	</c:if>
			              	</div>
		           		 </li>
		          	</c:forEach>
		            
		          </ul>
		        </div>
	        </div>
      </c:forEach>
      
    </div>
  </div>
</div>
<div class="footer">
  <div class="footer-content clearfix">
    <div class="copyright"> Copyright © 2015-2016 HCC All Rights Reserved </div>
  </div>
</div>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="js/showBigImg.js"></script>

<script type="text/javascript">
	$("document").ready(function(){
		$(".more img").css({width:"100%",height:""});
		$(".main .year .list").each(function (e, target) {
		    var $target=  $(target),
		        $ul = $target.find("ul");
		    $target.height($ul.outerHeight()), $ul.css("position", "absolute");
		}); 
		$(".main .year>h2>a").click(function (e) {
		    e.preventDefault();
		    $(this).parents(".year").toggleClass("close");
		});
		
	});
</script>
  </body>
</html>
