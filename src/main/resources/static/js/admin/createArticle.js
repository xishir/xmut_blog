$(function () {
	function getNowFormatDate() {
	    var date = new Date();
	    var seperator1 = "-";
	    var seperator2 = ":";
	    var month = date.getMonth() + 1;
	    var strDate = date.getDate();
	    var strHours = date.getHours();
	    var strSeconds = date.getSeconds();
	    var strMinutes = date.getMinutes();
	    if (month >= 1 && month <= 9) {
	        month = "0" + month;
	    }
	    if (strDate >= 0 && strDate <= 9) {
	        strDate = "0" + strDate;
	    }
	    if (strHours >= 0 && strHours <= 9) {
	    	strHours = "0" + strHours;
	    }
	    if (strMinutes >= 0 && strMinutes <= 9) {
	    	strMinutes = "0" + strMinutes;
	    }
	    if (strSeconds >= 0 && strSeconds <= 9) {
	    	strSeconds = "0" + strSeconds;
	    }
	    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
	            + " " + strHours + seperator2 + strMinutes
	            + seperator2 + date.getSeconds();
	    return currentdate;
	}
	var times=getNowFormatDate();
	$("#times").val(times);
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
	var $btn = $(this).button('loading');
    // business logic...
    
	if($("#title").val()==''||$("#tags").val()==''||$("#times").val()=='')
	{
		alert('请填写完整！');
		$btn.button('reset');
		return;
	}

    //添加文章
    var datas = {
        "title": $("#title").val(),
        "author": "admin",
        "sort": $("#tags").val(),
        "time": $("#times").val(),
        "content": testEditor.getMarkdown()
    };
    $.ajax({
        url: "/api/admin/article/create",
        type: "POST",
        data: JSON.stringify(datas),
        contentType: 'application/json; charset=UTF-8',
        dataType: "json",
        success: function(msg) {
            if (msg.code == "200") {
            	alert('添加成功！');
                $btn.button('reset');
                window.location.href="/admin/manageArticle"; 
            } else {
            	$btn.button('reset');
            }
        },
    });
});

$("#noCreateArticle").click(function() {
	window.history.back();
});

})