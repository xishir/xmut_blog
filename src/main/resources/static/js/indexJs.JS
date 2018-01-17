$(function(){
  //初始化
  init();
  function init(){
    getArchives(1);
  }
  $("#Arc-list li a").click(function(){
    // datas={id:1};
    $.ajax({
      url: "/api/article/info/",
      type: "Get",
      // data: JSON.stringify(datas),
      success: function (data) {
        
      },
    });
  });
  function getArchives(page){
    $.ajax({
      url:"/api/article/list/"+page,
      type:"Get",
      success:function(data){
        console.log(data);
      }
    });
  }
})