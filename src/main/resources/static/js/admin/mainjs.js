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

})