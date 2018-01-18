$(function () {
	var pageNum=0;
	function getPageNum()
	{
		$.ajax({
	        url: "/api/comment/pageNum",
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
	
	function getComment(page)
	{
		console.log("/api/comment/lists/"+page);
		$.ajax({
	        url: "/api/comment/lists/"+page,
	        type: "GET",
	        contentType: 'application/json; charset=UTF-8',
	        dataType: "json",
	        success: function(msg) {
	        	console.log(msg);
	            if (msg.code == "200") {
	            	var result='';
	            	var Comments=msg.data;
	            	var leng=Comments.length;
	            	for(var i=0;i<leng;i++){
	            		result+=
	            		'<tr>\
				          <th scope="row" style="line-height:40px;height:40px;padding:0px;margin:0px;">'+(i+1)+'</th>\
				          <td style="line-height:40px;height:40px;padding:0px;margin:0px;">'+Comments[i].nickname+'</td>\
				          <td style="line-height:40px;height:40px;padding:0px;margin:0px;">在<a href="/Archive/'+Comments[i].article_id+'">'+Comments[i].title+'</a>中评论:&nbsp;&nbsp;'+Comments[i].content+'</td>\
				          <td style="line-height:40px;height:40px;padding:0px;margin:0px;">'+Comments[i].time.substring(0,10)+'</td>\
				          <td style="line-height:40px;height:40px;padding:0px;margin:0px;">\
				          <button type="button" class="btn btn-danger delComment" data="'+Comments[i].id+'">删除</button>\
				          </td>\
				        </tr>';		
	            	}
	            	$("#CommentBody").html('');
	                $("#CommentBody").append(result);
	                setPageCtrl(page,pageNum);
	                $(".delComment").click(function() {
	                	delComment($(this).attr('data'));
	        		});
	            } else {//登录失败
	            // console.log(msg);
	            }
	        },
	    });
	}
	
	function delComment(id)
	{
		$('#modalTextTitle').text('提示');
		$('#modalTextContent').text('确定删除本篇评论？');
		$('#modalText').modal('toggle');	
		$('#modalTextOk').click(function() {
			$('#modalText').modal('hide');
			$.ajax({
		        url: "/api/admin/comment/del/"+id,
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
		console.log(nowPage);
		console.log(num);
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
			getComment($(this).attr('data'));
		});
	}
	getComment(1);
	


$("#noCreateComment").click(function() {
	window.history.back();
});

})