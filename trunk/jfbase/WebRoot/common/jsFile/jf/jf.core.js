/**
 * @描述:<p> </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2012-3-19 上午12:36:17
 */
var NS = {
	//封装表单数据
	formParams : function(formId){
		if(formId == undefined){
			return ;
		}
		var data =new Array;
		
		$(formId).find(':input').each(function(i,n){
			var flag = 'false';
			if($(n).attr('param') == undefined){
				flag = 'true';
			}else{
				flag = $(n).attr('param');
			}
			if(flag == true || flag == 'true'){
				//jquery1.7 $(n).attr('checked')==true 不适用
				if (($(n).attr('type') == "checkbox" || $(n).attr('type') == "radio")&& $(n).attr('checked')) {
					putParam(n,data);	
				}else if($(n).attr('type') == "text" || $(n).attr('type') == "password" || $(n).attr('type') == "hidden" || $(n).attr('type') == "textarea"){
					putParam(n,data);
				}
			}
		});
		$(formId).find('select').each(function(i,n){
			var flag = 'false';
			if($(n).attr('param') == undefined){
				flag = 'true';
			}else{
				flag = $(n).attr('param');
			}
			if(flag == true || flag == 'true'){
				if($.trim($(n).attr('value')) != ''){
					putParam(n,data);
				}else{
					if($(n).attr('name') != ''){
						data.push({
							name : $(n).attr('name'),
							value : ''
						});
					}
				}
			}
		});
		return data;
	}
};
/**
 * 将表单数据放到数组中
 * */
function putParam(obj,dataList){
	if($(obj).attr('name') != ''){
		dataList.push({
			name : $(obj).attr('name'),
			value : $(obj).attr('value')
		});
	}
};

/**
 * 通用Ajax调用入口
 * async：缺省值为true，缺省所有的请求都是异步发送的。如果你需要同步的请求，可以使用这个参数
 * cache：缺省值为true，设置缺省的缓存机制，true的话就在服务器端缓存，否则，一个带有随机时间戳的参数将会添加到请求，类似$.getScript()方法，以此来保证浏览器不会缓存
 * dataType：返回的数据类型，包括：xml,json,script,html,jsonp,text等
 * error：指定请求失败后的回调函数
 * success：指定请求成功后的回调函数
 * timeout：等待ajax请求的时间，毫秒数
 * type：请求类型：POST或者GET
 * statusCode：返回状态HTTP代码
 */
$.nsAjax = function(config){
	config = $.extend({
		async : true,
		type : 'POST',
		dataType : 'json',
		cache : false
	},config);
	$.ajax({
		url : config.url,
		data : config.data,
		async : config.async,
		type :  config.type,
		dataType : config.dataType,
		cache : config.cache,
		success : function(data,textStatus){
			config.success(data);
		},
		error : function(errors,textStatus){
			if(config.error){
				config.error(errors);
			}
		}
	});
};

//用js接收html传递的参数
function getParameter(param)
{
var query = window.location.search;
var iLen = param.length;
var iStart = query.indexOf(param);
if (iStart == -1)
   return "";
iStart += iLen + 1;
var iEnd = query.indexOf("&", iStart);
if (iEnd == -1)
   return query.substring(iStart);

return query.substring(iStart, iEnd);
}


