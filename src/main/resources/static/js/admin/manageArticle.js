$(function () {
	var pageNum=0;
	function getPageNum()
	{
		$.ajax({
	        url: "/api/article/pageNum",
	        type: "GET",
	        async: false,
	        success: function(msg) {
	            if (msg.code == "200") {
	            	pageNum=msg.data;
	            } else {

	            }
	        },
	    });
	}
	getPageNum();
	
	function getArticle(page)
	{
		$.ajax({
	        url: "/api/article/list/"+page,
	        type: "GET",
	        contentType: 'application/json; charset=UTF-8',
	        dataType: "json",
	        success: function(msg) {
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
				          <td>'+Archives[i].time.substring(0,10)+'</td>\
				          <td>\
				          <a href="/Archive/'+Archives[i].id+'"><button type="button" class="btn btn-success">预览</button></a>\
				          <a href="/admin/editArticle/'+Archives[i].id+'"<button type="button" class="btn btn-warning">编辑</button></a>\
				          <button type="button" class="btn btn-danger delArticle" data="'+Archives[i].id+'">删除</button>\
				          </td>\
				        </tr>';		
	            	}
	            	$("#articleBody").html('');
	                $("#articleBody").append(result);
	                setPageCtrl(page,pageNum);
	                $(".delArticle").click(function() {
	                	delArticle($(this).attr('data'));
	        		});
	            } else {//登录失败
	            }
	        },
	    });
	}
	
	function delArticle(id)
	{
		$('#modalTextTitle').text('提示');
		$('#modalTextContent').text('确定删除本篇文章？');
		$('#modalText').modal('toggle');	
		$('#modalTextOk').click(function() {
			$('#modalText').modal('hide');
			$.ajax({
		        url: "/api/admin/article/del/"+id,
		        type: "GET",
		        async: false,
		        success: function(msg) {
		            if (msg.code == "200") {
		            	//alert('删除成功！');
		            	history.go(0);
		            } else {

		            }
		        },
		    });
		});
	}
	
	
	function setPageCtrl(nowPage,num)
	{
		var result='<li>\
				      <a class="pages" href="#" aria-label="Previous" data="'+(nowPage>1?nowPage-1:nowPage)+'">\
				        <span aria-hidden="true">&laquo;</span>\
				      </a>\
				    </li>';
		for(var i=1;i<=num;i++){
			result+=
			'<li><a href="#" class="pages" data="'+i+'">'+i+'</a></li>';		
		}
		result+='<li>\
			      <a href="#" class="pages" data="'+(nowPage<num?nowPage+1:nowPage)+'" aria-label="Next">\
			        <span aria-hidden="true">&raquo;</span>\
			      </a>\
			    </li>';
		$("#pageCtrl").html('');
		$("#pageCtrl").append(result);
		$(".pages").click(function() {
			getArticle($(this).attr('data'));
		});
	}
	getArticle(1);
	


$("#noCreateArticle").click(function() {
	window.history.back();
});

})