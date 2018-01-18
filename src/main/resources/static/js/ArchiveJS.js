$(function(){
  var currentArchive;                       //当前文章
  var PopArchives;                          //热门文章
  var currentArchID=$("#hide").text();      //当前显示文章的ID
  var index;                                //当前显示文章的索引
  var comments;                              //评论
  //初始化
  init();
  function init(){
    getCurrentArchives();
    getPopArchives(1);
    getComments();
  }
  //得到当前文章内容
  function getCurrentArchives(){
    $.ajax({
      url:"/api/article/info/"+currentArchID,
      type:"GET",
      success:function(data){
        currentArchive=data.data;
        putArch();
        feelArchGood();
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
        for(var i=0;i<PopArchives.length;i++){
          $("#Arc-list").append("<li><a>"+PopArchives[i].title+"</a></li>");
        }
        bind();
      }
    });
  }
  //绑定点击事件
  function bind(){
    $("#Arc-list li a").click(function(){
      var resT=findArchbyTitle(this.innerHTML);
      window.location.href="/Archive/"+PopArchives[resT].id;
    });
    $("#Previous").click(function(){
      window.location.href="/Archive/"+currentArchive.frontid;
    });
    $("#Next").click(function(){
      window.location.href="/Archive/"+currentArchive.behindid;
    });
    $("#comment-post-btn").click(function(){
      if($("#comment-content").val()&&$("#Nickname").val()){
        var datas={article_id:currentArchID,nickname:$("#Nickname").val(),content:$("#comment-content").val()};
        $.ajax({
          url:"/api/comment/create",
          type:"POST",
          data: JSON.stringify(datas),
          contentType: 'application/json; charset=UTF-8',
          dataType: "json",
          success:function(data){
            $("#myModalLabel").text("评论成功！");
            $(".modal-body").text("感谢您的评论!");
            $("#myModal").modal("toggle");
            $("#myModal").on("hide.bs.modal",function(){
              window.location.href="/Archive/"+currentArchive.id;
            });
          }
        });
      }
      else {
        $("#myModalLabel").text("评论失败！");
        $(".modal-body").text("评论或昵称不能为空！");
    	  $("#myModal").modal("toggle");
      }
    });

  }
  //显示选定的文章
  function putArch(){
    $(".blog-post-title").text(currentArchive.title);
    $(".blog-post-meta").append(currentArchive.time.substring(0,10));
    $(".blog-post-meta").append(" by <a>"+currentArchive.author+"</a>");
    $(".blog-post-meta").append('<span class="glyphicon glyphicon-eye-open" aria-hidden="true">:'+currentArchive.visit+'</span>');
    $(".blog-post-meta").append('<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true">:'+currentArchive.star+'</span>');
    $(".blog-post-meta").append('<span class="glyphicon glyphicon-comment" aria-hidden="true">:'+currentArchive.comment+'</span>');
    $(".blog-content").append(marked(currentArchive.content));
  }
  //根据标题查找文章
  function findArchbyTitle(tempT){
    for(var i=0;i<PopArchives.length;i++){
      if(PopArchives[i].title==tempT){
        return i;
      }
    }
  }
  //得到评论
  function getComments(){
    $.ajax({
      url:"/api/comment/list/"+currentArchID,
      type:"Get",
      success:function(data){
        comments=data.data;
        if(comments.length>0){
          $(".comment-show").text("");
          for(var i=0;i<comments.length;i++){
            $(".comment-show").append('<div class="comments"><h4>'+comments[i].nickname+':</h4><p>'+
            comments[i].content+'</p>'+comments[i].time.substring(0,10)+
            '<span class="glyphicon glyphicon-thumbs-up" num='+i+' CommentId='+comments[i].id+' aria-hidden="true">:'+comments[i].star+'</span></div>');
          }
          feelComGood();
        }
      }
    });
  }
  //文章点赞
  function feelArchGood(){
    $(".blog-post-meta .glyphicon-thumbs-up").click(function(){
      $.ajax({
        url:"/api/article/star/"+currentArchID,
        type:"Get",
        success:function(){
          currentArchive.star++;
          $(".blog-post-meta .glyphicon-thumbs-up").text(":"+currentArchive.star);
        }
      });
    });
  }
  //评论点赞
  function feelComGood(){
    $(".comment-show .glyphicon-thumbs-up").click(function(){
      var DOM=this;
      var num=$(DOM).attr("num");
      $.ajax({
        url:"/api/comment/star/"+$(DOM).attr("CommentId"),
        type:"Get",
        success:function(){
          comments[num].star++;
          $(DOM).text(":"+comments[num].star);
        }
      });
    });
  }
})