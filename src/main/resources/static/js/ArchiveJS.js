$(function(){
  var Archives;                             //文章
  var currentArchID=$("#hide").text();      //当前显示文章的ID
  var index;                                //当前显示文章的索引
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
        index=findArchbyID(currentArchID);
        var i;
        if(index<5){
          i=0;
          for(;i<index+10&&i<Archives.length;i++){
            $("#Arc-list").append("<li><a>"+Archives[i].title+"</a></li>");
          }
        }
        else {
          i=index-5;
          for(;i<index+5&&i<Archives.length;i++){
            $("#Arc-list").append("<li><a>"+Archives[i].title+"</a></li>");
          }
        }
        bind();
        getTargetArchives();
      }
    });
  }
  //跳转目标文章
  function getTargetArchives(){
    putArch(index);
  }
  //绑定点击事件
  function bind(){
    $("#Arc-list li a").click(function(){
      var resT=findArchbyTitle(this.innerHTML);
      window.location.href="/Archive/"+Archives[resT].id;
    });
    $("#Previous").click(function(){
      if(index>=0)window.location.href="/Archive/"+Archives[--index].id;
    });
    $("#Next").click(function(){
      if(index<Archives.length-1)window.location.href="/Archive/"+Archives[++index].id;
    });
  }
  //显示选定的文章
  function putArch(resT){
    $(".blog-post-title").text(Archives[resT].title);
    $(".blog-post-meta").text(Archives[resT].time);
    $(".blog-post-meta").append(" by <a>"+Archives[resT].author+"</a>");
    $(".blog-content").text(Archives[resT].content);
  }
  //根据标题查找文章
  function findArchbyTitle(tempT){
    for(var i=0;i<Archives.length;i++){
      if(Archives[i].title==tempT){
        return i;
      }
    }
  }
  //根据ID查找文章
  function findArchbyID(tempT){
    for(var i=0;i<Archives.length;i++){
      if(Archives[i].id==tempT){
        return i;
      }
    }
  }
})