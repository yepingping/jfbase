$(function(){
	//初始化DWZ
	DWZ.init("common/jsFile/dwz/dwz.frag.xml", {
			loginUrl : "login_dialog.html",
			loginTitle : "登录", // 弹出登录对话框
			//		loginUrl:"login.html",	// 跳到登录页面
			statusCode : {
				ok : 200,
				error : 300,
				timeout : 301
			}, //【可选】
			pageInfo : {
				pageNum : "pageNum",
				numPerPage : "numPerPage",
				orderField : "orderField",
				orderDirection : "orderDirection"
			}, //【可选】
			debug : true, // 调试模式 【true|false】
			callback : function() {
				initEnv();
				$("#themeList").theme({
					themeBase : "common/themes"
				}); // themeBase 相对于index页面的主题base路径
			}
	});
	$.nsAjax({
		url: $webPath+'syMenu.json',
		success:function(data){
			console.info(data);
			$("#syMenu").html("");
		}
	});
	
});