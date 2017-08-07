<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
  </head>
  
  <body>
	<!--头部-->
	<div class="header">
		<div class="wrap clearfix">
			<div class="">
				<h1 class="logo" style="margin:0;">
					<span></span>
				</h1>
			</div>
			<div class="client_side fl">
				<ul class="main_nav clearfix">
					<li class="fl"><a href="index.do">首页</a></li>
					<li class="fl" id="xmdj"><a href="javascript:void(0);">项目对接</a></li>
					<li class="fl" id="irp"><a href="javascript:void(0);">知识产权</a></li>
					<li class="fl"><a href="javascript:void(0);">培训实训</a></li>
					<li class="fl" id="zcxc"><a href="javascript:void(0);">政策宣传</a></li>
				</ul>
			</div>


			<div class="client_login fl">
			<c:choose>
			<c:when test="${empty sessionScope.users }">
			    <span class="ueser_box fl"><i class="photo"></i><img
					class="header_img" src="upimg/head-default-img.png" width="32"
					height="32">
				</span>
			</c:when>
			<c:otherwise>
			   <span class="ueser_box fl"><i class="photo"></i><img
					class="header_img" src="upimg/${sessionScope.users.userImg }" width="32"
					height="32">
				</span>
			</c:otherwise>
			</c:choose>
				
				
				<c:choose>
					<c:when test="${empty sessionScope.users }">
						<p class="fl ueser_cnt">
							<a href="login.do;">登录</a><span>|</span><a
							href="register.jsp">注册</a>
						</p>
					</c:when>
					<c:otherwise>
						<p class="fl ueser_cnt">
							<a href="javascript:void(0);">
							${sessionScope.users.userName }&nbsp;&nbsp;&nbsp;</a>
							<a href="exit.do">退出</a>
						</p>
					</c:otherwise>
				</c:choose>
			</div>
			
			<div class="client_search fl">
				<a href="search.do" class="search_btn">搜索</a>
			</div>
		</div>  
	</div>
	<!--end 头部-->

  </body>
</html>
