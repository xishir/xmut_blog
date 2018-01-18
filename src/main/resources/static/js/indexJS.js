$(function(){
  var Archives;                             //文章
  var currentPages=1;                       //当前文章页面
  var PageNum;
  init();
  function init(){
    getPages();
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
  
  //得到页数
  function getPages(){
		$.ajax({
      url: "/api/article/pageNum",
      type: "GET",
      async: false,
      success: function(msg) {
        if (msg.code == "200") {
          PageNum=msg.data;
          for(var i=0,j=1;i<PageNum;i++,j++){
            $(".pagination li:eq("+i+")").after('<li><a href="#" class="pagesIndex">'+j+'</a></li>');
          }
          bind();
        }
      },
    });
  }
  //绑定事件
  function bind(){
    $(".pagesIndex").click(function(){
      currentPages=this.innerHTML;
      getArchives(currentPages);
      // return false;
    });
    $(".pagination li:first").click(function(){
      if(currentPages>1)getArchives(--currentPages);
    })
    $(".pagination li:last").click(function(){
      if(currentPages<PageNum)getArchives(++currentPages);
    })
  }
  //将文章列表显示
  function putArchives(){
    $(".list-group").text("");
    for(var i=0;i<Archives.length;i++){
      $(".list-group").append('<a href="/Archive/'+Archives[i].id+'" class="list-group-item"></a>');
      $(".list-group a:eq("+i+")").append('<h4 class="list-group-item-heading">'+Archives[i].title+'</h4>');
      $(".list-group a:eq("+i+")").append('<p class="list-group-item-text">'+marked(Archives[i].content)+'</p>');
    }
  }
})