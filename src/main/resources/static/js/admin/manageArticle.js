$(function () {
	function getArticle(page)
	{
		console.log("/api/article/list/"+page);
		$.ajax({
	        url: "/api/article/list/"+page,
	        type: "GET",
	        contentType: 'application/json; charset=UTF-8',
	        dataType: "json",
	        success: function(msg) {
	        	console.log(msg);
	            if (msg.code == "200") {
	                //登录成功
	            	var result='';
	            	var Archives=msg.data;
	            	var leng=Archives.length;
	            	for(var i=0;i<leng;i++){
	            		result+=
	            		'<tr>\
				          <th scope="row">'+(i+1)+'</th>\
				          <td>'+Archives[i].title+'</td>\
				          <td>'+Archives[i].author+'</td>\
				          <td>'+Archives[i].time+'</td>\
				          <td>\
				          <a href="/admin/editArticle/'+Archives[i].id+'"<button type="button" class="btn btn-warning">编辑</button></a>\
				          <button type="button" class="btn btn-danger">删除</button>\
				          </td>\
				        </tr>';		
	            	}
	            	$("#articleBody").html('');
	                $("#articleBody").append(result);
	            } else {//登录失败
	            // console.log(msg);
	            }
	        },
	    });
	}
	getArticle(1);


$("#noCreateArticle").click(function() {
	window.history.back();
});

})