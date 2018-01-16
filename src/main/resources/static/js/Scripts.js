$(function(){
  $("#Sign").click(function(){
    $.ajax({
      url:"/api/user/logincheck",
      type:"POST",
      data:{email:$("#inputEmail").val(),password:$("#inputPassword").val()},
      contentType: 'application/json',
      success:function(data){
        alert("成功");
        console.log("msg:"+data);
      },
      error:function(data){
        console.log(data);
        alert("异常");
      }
    });
  });
})