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
	var initMenu = function(){
		$.nsAjax({
		url: $webPath+'syMenu.json',
		dataType : "json",
		cache : false,
		async : true,
		success:function(data){
			var $menuTree = data;
			$.each($menuTree,function(i,row){
				var _d = $("<div class='accordionHeader'><h2><span>Folder</span>"+ row.attributes.title + "</h2></div>");
				var _s = $("<div class='accordionContent'></div>");
				if(row.children.length>0){
					var data = row.children;
					_s.append(tree(data));	
				}	
				$("#syMenu").append(_d).append(_s);
			});
		}
	});
	};
	
	var tree =function(data){ 
		var $menuTree = data, _ul, _li;
		 _ul = $("<ul class='tree treeFolder'></ul>");
		$.each($menuTree,function(i,row){
				_li = $("<li><a href="+row.attributes.href+"  target="+row.attributes.target+">"+row.attributes.title+"</a></li>");
				if(row.children.length!=0){
					_li.append(tree(row.children));
				}else{
					 _ul = $("<ul></ul>");
				}
				_ul.append(_li);
			});
		return _ul;
	}
	initMenu();
	
});