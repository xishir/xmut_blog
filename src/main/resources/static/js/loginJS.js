$(function () {
  //登录功能
  $(".form-signin").submit(function () {
    //输入成功 判断登录
    var datas = { "user_name": $("#inputUsername").val(), "user_password": $("#inputPassword").val() };
    $.ajax({
      url: "/api/user/logincheck",
      type: "POST",
      data: JSON.stringify(datas),
      contentType: 'application/json; charset=UTF-8',
      dataType: "json",
      success: function (msg) {
        if (msg.code == "200") {
          //登录成功
          window.location.href="/admin"; 
        }
        else {
          //登录失败
          // console.log(msg);
        }
      },
    });
    return false;
  });
})