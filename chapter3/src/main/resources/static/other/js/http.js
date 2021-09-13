var container = document.getElementById('jsoneditor');

  var options = {
    mode: 'code',
//modes: ['code', 'form', 'text', 'tree', 'view'], // allowed modes
onError: function (err) {
  alert(err.toString());
},
onModeChange: function (newMode, oldMode) {
  console.log('Mode switched from', oldMode, 'to', newMode);
    },
  };

var editor = new JSONEditor(container, options,null);

var param_cnt = 0;
$("#add_url_parameter").click(function() {
	var input_len = $("#params_table input").size();
	param_cnt++;
	add_parameter(param_cnt, "", "")
});

$('#add_raw_url_parameter').click(function() {
    $('body').dialogbox({type:"text",title:"批量添加Body参数",message:"输入Raw参数，例如：id=123&sale=yes&deleted=0"}, function($btn, $ans) {
        if($btn == "close") {
            return;
        }
        else if($btn == "ok") {
            var raw = $ans;
		  	if (raw == null || raw == "") {
		  		return;
		    }
		    var params = str_2_params(raw);
		    if (params) {
		    	for (var i = 0; i < params.length; i++) {
		    		param_cnt++;
		    		add_parameter(param_cnt, params[i]['name'], params[i]['value']);
		    	};
		    }
        }
    });
});

var header_cnt = 0;
$("#add_api_headers").click(function() {
	var input_len = $("#headers_table input").size();
	header_cnt++;
	add_header(header_cnt, "", "")
});

$("#http_test").click(function() {
	var http_url = $("#http_url_input").val();
	var method = $("#api_method").val();
	var params = get_all_parameter();
	var headers = get_all_header();
	$.cookie("http_url", http_url);
	$.cookie("method", method);
	$.cookie("params", params_2_str(params));
	$.cookie("headers", params_2_str(headers));
	if (is_empty(http_url)) {
		alert("接口链接为空，请填写后再请求！");
		return
	}
	if (params === false) {
		alert("参数填写为空，请填写完整之后再试！");
		return
	}
	if (headers === false) {
		alert("Header填写为空，请填写完整之后再试！");
		return
	}
	$(this).text("正在请求");
	$("#output").val("");
	var _token = $("#_token").val();
	$.post("/api/apiTest", {
		url: http_url,
		params: params,
		method: method,
		headers: headers,
		_token : _token
	}, function(data) {
		/*if (data.success == 1) {*/
			var result_text = data.message;
			if (typeof(result_text) == "object") {
			
				result_text = JSON.stringify(result_text);
			}
			var json = null;
			try {
				json = JSON.parse(result_text)
			} catch (e) {
				json = null
			}

			if (json == null) {
				editor.set(result_text);
			} else {
				editor.set(json);
			}
			$("#http_test").text("发送请求");
			/*$("#response_header").html("执行时间：" + data.time);
			$("#response_header").append("<pre></pre>");
			$("#response_header pre").text(data.header)*/
		/*} else {
			// $("#output").append("<pre></pre>");
			$("#output").val(data.message);
			$("#response_header").html("<span class='red'>执行失败</span>");
		}*/
	}, "json")
});


function get_all_parameter() {
	var params = new Array();
	$(".params_p").each(function() {
		var cnt = $(this).attr("cnt");
		var name = $(this).find("input[name=p_name_" + cnt + "]").val();
		var value = $(this).find("input[name=p_value_" + cnt + "]").val();
		if (is_empty(name) || is_empty(value)) {
			return false
		}
		params.push({
			name: name,
			value: value
		})
	});
	return params
}

function get_all_header() {
	var headers = new Array();
	$(".headers_p").each(function() {
		var cnt = $(this).attr("cnt");
		var name = $(this).find("input[name=h_name_" + cnt + "]").val();
		var value = $(this).find("input[name=h_value_" + cnt + "]").val();
		if (is_empty(name) || is_empty(value)) {
			return false
		}
		headers.push({
			name: name,
			value: value
		})
	});
	return headers
}

function params_2_str(params) {
	var str = "";
	for (var i = 0; i < params.length; i++) {
		var p = params[i];
		if (p.name) {
			str = str + "&" + p.name + "=" + p.value
		}
	}
	if (str.length > 1) {
		str = str.substring(1)
	}
	return str
}

function is_empty(str) {
	if (str == null || str == "" || str == "undefined") {
		return true
	}
	return false
};



function add_parameter(cnt, name, value) {
	if (name == "undefined" || name == null) {
		name = ""
	}
	if (value == "undefined" || value == null) {
		value = ""
	}
	$("#params_end").before('<tr class="params_p" cnt="' + cnt + '"><td><input class="form-control" type="text" name="p_name_' + cnt + '" title="参数名称" alt="参数名称" value="' + name + '" maxlength="100"/></td><td><input class="form-control value-http pull-left" type="text" name="p_value_' + cnt + '" title="参数数值" alt="参数数值" value="' + value + '" maxlength="5000"/><button class="btn btn-danger pull-left del-http" onclick="javascript:del_param(this);" type="button">删除参数</button>							</td>						</tr>					')
}

function del_param(obj) {
	$(obj).parent().parent().remove()
}

function str_2_params(str) {
	try {
		var params = new Array();
		var ps = str.split("&");
	var pv = null;
	for (var i = 0; i < ps.length; i++) {
		pv = ps[i].split("=");
	params.push({
		name: pv[0],
		value: pv[1],
		method: "post"
				})
			}
			return params
		} catch (e) {
			return false
		}
}

function add_header(cnt, name, value) {
	if (name == "undefined" || name == null) {
		name = ""
	}
	if (value == "undefined" || value == null) {
		value = ""
	}
	$("#headers_end").before('<tr class="headers_p" cnt="' + cnt + '"><td><input class="form-control" type="text" name="h_name_' + cnt + '" title="header名称" alt="header名称" value="' + name + '" maxlength="100"/></td><td><input class="form-control pull-left value-http" type="text" name="h_value_' + cnt + '" title="header数值" alt="header数值" value="' + value + '" maxlength="5000"/><button class="btn btn-danger del-http" onclick="javascript:del_param(this);" type="button">删除参数</button>							</td>						</tr>					')
}




