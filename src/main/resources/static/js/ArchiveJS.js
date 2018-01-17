$(function(){
  var Archives;                             //文章
  var currentArchID=0;                      //当前显示文章
  //初始化
  init();
  function init(){
    getArchives(1);
  }
  //得到文章内容
  function getArchives(page){
    $.ajax({
      url:"/api/article/list/"+page,
      type:"Get",
      
      success:function(data){
        Archives=data.data;
        for(var i=0;i<Archives.length;i++){
          $("#Arc-list").append("<li><a>"+Archives[i].title+"</a></li>");
        }
        bind();
      }
    });
  }
  //绑定点击事件
  function bind(){
    $("#Arc-list li a").click(function(){
      var resT=findArch(this.innerHTML);
      currentArchID=resT;
      putArch(resT);
    });
    $("#Previous").click(function(){
      if(currentArchID>=0)putArch(--currentArchID);
    });
    $("#Next").click(function(){
      if(currentArchID<Archives.length-1)putArch(++currentArchID);
    });
  }
  //显示选定的文章
  function putArch(resT){
    $(".blog-post-title").text(Archives[resT].title);
    $(".blog-post-meta").text(Archives[resT].time);
    $(".blog-post-meta").append(" by <a>"+Archives[resT].author+"</a>");
    $(".blog-content").text(Archives[resT].content);
  }
  //查找文章
  function findArch(tempT){
    for(var i=0;i<Archives.length;i++){
      if(Archives[i].title==tempT){
        return i;
      }
    }
  }
})