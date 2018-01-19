$(function(){
  var Archives;                             //文章
  var currentPages=1;                       //当前文章页面
  var PageNum;                              //页数
  var Tags;                                 //标签
  init();
  function init(){
    getPages();
    getArchives(currentPages);
    getTags();
  }

  //得到文章内容
  function getArchives(page){
    $.ajax({
      url:"/api/article/list/"+page,
      type:"Get",
      success:function(data){
        Archives=data.data;
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

  //得到标签
  function getTags(){
    $.ajax({
      url:"api/tag/list",
      type:"GET",
      success:function(data){
        Tags=data.data;
        for(var i=0;i<Tags.length;i++){
          $("#Tag-list").append('<a href="#" class="tagc'+i%5+'">'+Tags[i].tag+'</a>');
        }
        qcloud();
      }

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
      $(".list-group").append('<a href="/Archive/'+Archives[i].id+'" class="list-group-item bod"></a>');
      $(".list-group a:eq("+i+")").append('<h3 class="list-group-item-heading"><b>'+Archives[i].title+'</b></h3>');
      $(".list-group a:eq("+i+")").append('<p class="list-group-item-text">'+marked(Archives[i].content)+'</p>');
    }
  }

})