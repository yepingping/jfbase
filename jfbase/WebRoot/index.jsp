<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="common/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<script type="text/javascript">
	var $webPath = "<%=basePath%>";
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>jframe:系统集成与应用开发平台</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<jsp:include page="common/js.inc"></jsp:include>
<script src="index.js" type="text/javascript"></script>
<!--
<style type="text/css">

	#header{height:85px}

	#leftside, #container, #splitBar, #splitBarProxy{top:90px}

</style>
-->
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="http://j-ui.com">标志</a>
				<ul class="nav">
					<li id="switchEnvBox"><a href="javascript:">（<span>北京</span>）切换城市</a>
						<ul>
							<li><a href="sidebar_1.html">北京</a>
							</li>
							<li><a href="sidebar_2.html">上海</a>
							</li>
							<li><a href="sidebar_2.html">南京</a>
							</li>
							<li><a href="sidebar_2.html">深圳</a>
							</li>
							<li><a href="sidebar_2.html">广州</a>
							</li>
							<li><a href="sidebar_2.html">天津</a>
							</li>
							<li><a href="sidebar_2.html">杭州</a>
							</li>
						</ul></li>
					</li>
					<li><a href="login.html">退出</a>
					</li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div>
					</li>
					<li theme="green"><div>绿色</div>
					</li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div>
					</li>
					<li theme="silver"><div>银色</div>
					</li>
					<li theme="azure"><div>天蓝</div>
					</li>
				</ul>
			</div>

			<!-- navMenu
			<div id="navMenu">
				<ul>
					<li class="selected"><a href="sidebar_1.html"><span>资讯管理</span></a></li>
					<li><a href="sidebar_2.html"><span>订单管理</span></a></li>
					<li><a href="sidebar_1.html"><span>产品管理</span></a></li>
					<li><a href="sidebar_2.html"><span>会员管理</span></a></li>
					<li><a href="sidebar_1.html"><span>服务管理</span></a></li>
					<li><a href="sidebar_2.html"><span>系统设置</span></a></li>
				</ul>
			</div>
		 -->
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse">
						<div></div>
					</div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse">
					<h2>主菜单</h2>
					<div>收缩</div>
				</div>

				<div id="syMenu" class="accordion" fillSpace="sidebar">
					
					
				
					
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent">
						<!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span
										class="home_icon">我的主页</span> </span> </a>
							</li>
						</ul>
					</div>
					<div class="tabsLeft">left</div>
					<!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div>
					<!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a>
					</li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo"></div>
						<div class="pageFormContent" layoutH="80"
							style="margin-right:230px"></div>


					</div>

				</div>
			</div>
		</div>

	</div>

	<div id="footer">
		Copyright &copy; 2013 <a href="www.newstar.com" target="dialog">新星工作室</a>
	</div>

</body>
</html>
