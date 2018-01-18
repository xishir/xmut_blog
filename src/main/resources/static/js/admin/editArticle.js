$(function () {
	var articleId=$("#articleId").val();
	var testEditor;
	$.ajax({
        url: "/api/article/info/"+articleId,
        type: "GET",
        async: false,
        dataType: "json",
        success: function(msg) {
            if (msg.code == "200") {
            	console.log(msg);
            	$("#title").val(msg.data.title);
                $("#tags").val(msg.data.sort);
                $("#times").val(msg.data.time);
                $("#times").val(msg.data.time);
                $("#articleContent").text(msg.data.content);
            } else {//登录失败
            // console.log(msg);
            }
        },
    });
	testEditor = editormd("test-editormd", {
        width: "100%",
        height: 640,
        syncScrolling: "single",
        path: "/editormd/lib/",
        imageUpload: true,
        imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
        imageUploadURL: "/api/admin/uploadfile",
        saveHTMLToTextarea: true
    });

$("#createArticle").click(function() {
	var $btn = $(this).button('loading');
	if($("#title").val()==''||$("#tags").val()==''||$("#times").val()=='')
	{
		alert('请填写完整！');
		$btn.button('reset');
		return;
	}

    //添加文章
    var datas = {
    	"id": $("#articleId").val(),
        "title": $("#title").val(),
        "author": "admin",
        "sort": $("#tags").val(),
        "time": $("#times").val(),
        "content": testEditor.getMarkdown()
    };
    console.log(datas);
    $.ajax({
        url: "/api/admin/article/edit",
        type: "POST",
        data: JSON.stringify(datas),
        contentType: 'application/json; charset=UTF-8',
        dataType: "json",
        success: function(msg) {
            if (msg.code == "200") {
            	alert('编辑成功！');
                $btn.button('reset');
                window.location.href="/admin/manageArticle"; 
            } else {//登录失败
            // console.log(msg);
            	$btn.button('reset');
            }
        },
    });
});

$("#noCreateArticle").click(function() {
	window.history.back();
});

})