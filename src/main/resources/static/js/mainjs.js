$(function () {
  //注销登陆
	$("#Logout").click(function () {
	$.ajax({
		url: "/api/user/logout",
	    type: "GET",
	    dataType: "json",
	    success: function (msg) {
		    if (msg.code == "200") {
		      window.location.href="/admin"; 
		    }
		     else {
	
		    }
	    },
	});
	});
	
	
  $("#createArticle").click(function () {
	  alert(1);
    //添加文章
	//var datas = { "title": $("#inputUsername").val(), "user_password": $("#inputPassword").val() };
	var datas = { "title": "test", "author": "aaaa","sort":"sort","content":"content" };
	$.ajax({
      url: "/api/admin/article/create",
      type: "POST",
      data: JSON.stringify(datas),
      contentType: 'application/json; charset=UTF-8',
      dataType: "json",
      success: function (msg) {
        if (msg.code == "200") {
          //登录成功
          alert("ok");
        }
        else {
          //登录失败
          // console.log(msg);
        }
      },
    });
  });
})