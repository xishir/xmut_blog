$(function () {
	var articleId=$("#articleId").val();
	$.ajax({
        url: "/api/article/info/"+articleId,
        type: "GET",
        synx:false,
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
	
	
	
	
var testEditor;

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

    /*
                // or
                testEditor = editormd({
                    id      : "test-editormd",
                    width   : "90%",
                    height  : 640,
                    path    : "/editormd/lib/"
                });
                */
$("#createArticle").click(function() {
	if($("#title").val()==''||$("#tags").val()==''||$("#times").val()=='')
	{
		alert('请填写完整！');
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
        url: "/api/admin/article/create",
        type: "POST",
        data: JSON.stringify(datas),
        contentType: 'application/json; charset=UTF-8',
        dataType: "json",
        success: function(msg) {
            if (msg.code == "200") {
                //登录成功
                alert("ok");
            } else {//登录失败
            // console.log(msg);
            }
        },
    });
});

$("#noCreateArticle").click(function() {
	window.history.back();
});

})