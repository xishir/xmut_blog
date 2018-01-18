$(function () {
  //注销登陆
	$("#logout").click(function () {
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
	$("#editPass").click(function () {
		$("#modalEditUser").modal('toggle');

		$('#modalEditPassOk').click(function() {
			datas={"user_name":"admin","user_password":$('#newPassword').val(),"about":$('#newAbout').val()};
				$.ajax({
			        url: "/api/admin/updateUser",
			        type: "POST",
			        data: JSON.stringify(datas),
			        contentType: 'application/json; charset=UTF-8',
			        dataType: "json",
			        success: function (msg) {
			          if (msg.code == "200") {
			        	  $("#modalEditUser").modal('hide');
			          }
			          else {
			        	  $("#modalEditUser").modal('hide');
			          }
			        },
			    });
			});
	});
	
	$("#editAbout").click(function () {
		$("#modalEditAbout").modal('toggle');
	});

})