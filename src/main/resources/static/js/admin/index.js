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
	            	var result='';
	            	var Archives=msg.data;
	            	var leng=Archives.length;
	            	for(var i=0;i<leng;i++){
	            		result+=
	            		'<li>'+Archives[i].time.substring(0,10)+'&nbsp;&nbsp;<a href="/Archive/'+Archives[i].id+'">'+Archives[i].title+'</a></li>';
	            	}
	            	$("#newArticle").html('');
	                $("#newArticle").append(result);
	            } else {
	            // console.log(msg);
	            }
	        },
	    });
	}
	
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
	            		'<li>'+Comments[i].time.substring(0,10)+'&nbsp;&nbsp;<a href="/Archive/'+Comments[i].article_id+'">'+Comments[i].nickname+":&nbsp;"+Comments[i].content+'</a></li>';
	            	}
	            	$("#newComment").html('');
	                $("#newComment").append(result);
	            } else {//登录失败
	            // console.log(msg);
	            }
	        },
	    });
	}
	
	function getNum()
	{
		$.ajax({
	        url: "/api/admin/num",
	        type: "GET",
	        contentType: 'application/json; charset=UTF-8',
	        dataType: "json",
	        success: function(msg) {
	        	console.log(msg);
	            if (msg.code == "200") {
	            	$("#articleNum").html(msg.data.articleNum);
	            	$("#commentNum").html(msg.data.commentNum);
	            	$("#tagNum").html(msg.data.tagNum);
	            } else {//登录失败
	            // console.log(msg);
	            }
	        },
	    });
	}
	getArticle(1);
	getComment(1);
	getNum();
	

})