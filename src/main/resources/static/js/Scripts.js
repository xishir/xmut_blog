$(function(){
  $("#Sign").click(function(){
	var datas={"username":$("#inputUsername").val(),"password":$("#inputPassword").val()};
    $.ajax({
      url:"/api/user/logincheck",
      type:"POST",
      data:JSON.stringify(datas),
      contentType: 'application/json; charset=UTF-8',
      dataType: "json",
      success:function(data){
        alert("成功");
        console.log("msg:"+data.data);
      },
      error:function(data){
        console.log(data);
        alert("异常");
      }
    });
  });
})