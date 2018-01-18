$(function(){
  var Archives;                             //文章
  var currentPages=1;                       //当前文章页面

  init();
  function init(){
    getArchives(currentPages);
  }

  //得到文章内容
  function getArchives(page){
    $.ajax({
      url:"/api/article/list/"+page,
      type:"Get",
      success:function(data){
        Archives=data.data;
        // console.log(Archives);
        putArchives();
      }
    });
  }

  //将文章列表显示
  function putArchives(){
    for(var i=0;i<Archives.length;i++){
      console.log(Archives[i].id,Archives[i].title,Archives[i].content);
      $(".list-group").append('<a href="/Archive/'+Archives[i].id+'" class="list-group-item"></a>');
      $(".list-group a:eq("+i+")").append('<h4 class="list-group-item-heading">'+Archives[i].title+'</h4>');
      $(".list-group a:eq("+i+")").append('<p class="list-group-item-text">'+marked(Archives[i].content)+'</p>');
    }
  }
})