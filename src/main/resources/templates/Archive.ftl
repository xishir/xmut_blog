
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<#include "header.ftl"> 
    <link href="/css/blog.css" rel="stylesheet">
  </head>
  <body>

    <div class="blog-masthead">
      <div class="container">
        <nav class="blog-nav">
          <a class="blog-nav-item" href="/index">首页</a>
          <a class="blog-nav-item active" href="/Archives">文章</a>
          <a class="blog-nav-item" href="#">归档</a>
          <a class="blog-nav-item" href="#">友链</a>
          <a class="blog-nav-item" href="#">关于</a>
        </nav>
      </div>
    </div>

    <div class="container">
      <div id="hide">${ArchiveId}</div>
      <div class="blog-header">
        <h1 class="blog-title">AYYOYYU's Blog</h1>
        <p class="lead blog-description">A xmut_keshe Blog.</p>
      </div>

      <div class="row">

        <div class="col-sm-8 blog-main">

          <div class="blog-post">
            <h2 class="blog-post-title"></h2>
            <p class="blog-post-meta">
            </p>
            <div class="blog-content"></div>
            <div class="comment">
              <h2>Comment</h2>
              <div class="comment-show"> 
                No comments
              </div>
              <div class="comment-form">
                <h2>Post Comment</h2>
                <textarea id="comment-content" class="col-sm-12" placeholder="评论内容..."></textarea>
                <div class="input-group">
                  <input type="text" id="Nickname" class="form-control" placeholder="Nickname">
                  <span class="input-group-btn">
                    <button class="btn btn-default" id="comment-post-btn">Post</button>
                  </span>
                </div><!-- /input-group -->
                
              </div>
              
            </div>
          </div><!-- /.blog-post -->
          <nav>
            <ul class="pager">
              <li><a id="Previous">Previous</a></li>
              <li><a id="Next">Next</a></li>
            </ul>
          </nav>

        </div><!-- /.blog-main -->

        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
          <div class="sidebar-module sidebar-module-inset">
            <h4>About</h4>
            <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
          </div>
          <div class="sidebar-module">
            <h4>Archives</h4>
            <ol class="list-unstyled" id="Arc-list">
            <a href="#" class="tagc1"></a>
            </ol>
          </div>
          <div class="sidebar-module">
            <h4>Elsewhere</h4>
            <ol class="list-unstyled">
              <li><a href="https://github.com/xishir/xmut_keshe">GitHub</a></li>
            </ol>
          </div>
        </div><!-- /.blog-sidebar -->

      </div><!-- /.row -->
      <!-- 模态框（Modal） -->
      <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
              <h4 class="modal-title" id="myModalLabel">评论成功！</h4>
            </div>
            <div class="modal-body">感谢您的评论!</div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
          </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
      </div>
      <!-- /.modal -->
    </div><!-- /.container -->
    <#include "footer.ftl"> 
    <script src="/js/marked.js"></script>
    <script src="/js/ArchiveJS.js"></script>
  </body>
</html>
