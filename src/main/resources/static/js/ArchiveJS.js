$(function(){
  var currentArchive;                       //当前文章
  var PopArchives;                          //热门文章
  var currentArchID=$("#hide").text();      //当前显示文章的ID
  var index;                                //当前显示文章的索引
  //初始化
  init();
  function init(){
    getCurrentArchives();
    getPopArchives(1);
  }
  //得到当前文章内容
  function getCurrentArchives(){
    $.ajax({
      url:"/api/article/info/"+currentArchID,
      type:"GET",
      success:function(data){
        currentArchive=data.data;
        putArch();
        getTargetArchives();
      }
    });
  }
  //得到热门文章内容
  function getPopArchives(page){
    $.ajax({
      url:"/api/article/list/"+page,
      type:"Get",
      
      success:function(data){
        PopArchives=data.data;
        console.log(PopArchives);
        for(var i=0;i<PopArchives.length;i++){
          $("#Arc-list").append("<li><a>"+PopArchives[i].title+"</a></li>");
        }
        bind();
      }
    });
  }
  //跳转目标文章
  function getTargetArchives(){
    putArch();
  }
  //绑定点击事件
  function bind(){
    $("#Arc-list li a").click(function(){
      var resT=findArchbyTitle(this.innerHTML);
      window.location.href="/Archive/"+PopArchives[resT].id;
    });
    $("#Previous").click(function(){
      window.location.href="/Archive/"+currentArchive.id;
    });
    $("#Next").click(function(){
      window.location.href="/Archive/"+currentArchive.id;
    });
  }
  //显示选定的文章
  function putArch(){
    $(".blog-post-title").text(currentArchive.title);
    $(".blog-post-meta").append(currentArchive.time.substring(0,10));
    $(".blog-post-meta").append(" by <a>"+currentArchive.author+"</a>");
    $(".blog-content").text(currentArchive.content);

  }
  //根据标题查找文章
  function findArchbyTitle(tempT){
    for(var i=0;i<PopArchives.length;i++){
      if(PopArchives[i].title==tempT){
        return i;
      }
    }
  }
})