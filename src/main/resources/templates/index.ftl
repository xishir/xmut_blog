
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
          <a class="blog-nav-item active" href="/index">首页</a>
          <a class="blog-nav-item" href="/Archive/1001">文章</a>
          <a class="blog-nav-item" href="#">归档</a>
          <a class="blog-nav-item" href="#">友链</a>
          <a class="blog-nav-item" href="#">关于</a>
        </nav>
      </div>
    </div>

    <div class="container">

      <div class="blog-header">
        <h1 class="blog-title">AYYOYYU's Blog</h1>
        <p class="lead blog-description">A xmut_keshe Blog.</p>
      </div>

      <div class="row">

        <div class="col-sm-8 blog-main">

          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">New Archives</h3>
            </div>
            <div class="panel-body" id="new-Archives">
              <div class="list-group">
              </div>
            </div>
          </div>
          <nav aria-label="Page navigation">
            <ul class="pagination">
              <li>
                <a href="#" aria-label="Previous">
                  <span aria-hidden="true">&laquo;</span>
                </a>
              </li>
              <li><a href="#">1</a></li>
              <li>
                <a href="#" aria-label="Next">
                  <span aria-hidden="true">&raquo;</span>
                </a>
              </li>
            </ul>
          </nav>

        </div><!-- /.blog-main -->

        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
          <div class="sidebar-module sidebar-module-inset">
            <h4>About</h4>
            <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
          </div>
          <div class="sidebar-module">
            <h4>Tags</h4>
            <ol class="list-unstyled" id="Tag-list">
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

    </div><!-- /.container -->
    <#include "footer.ftl"> 
    <script src="/js/marked.js"></script>
    <script src="/js/indexJS.js"></script>
  </body>
</html>
