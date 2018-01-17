
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
          <a class="blog-nav-item" href="#">首页</a>
          <a class="blog-nav-item active" href="#">文章</a>
          <a class="blog-nav-item" href="#">归档</a>
          <a class="blog-nav-item" href="#">友链</a>
          <a class="blog-nav-item" href="#">关于</a>
        </nav>
      </div>
    </div>

    <div class="container">

      <div class="blog-header">
        <h1 class="blog-title">The Bootstrap Blog</h1>
        <p class="lead blog-description">The official example template of creating a blog with Bootstrap.</p>
      </div>

      <div class="row">

        <div class="col-sm-8 blog-main">

          <div class="blog-post">
            <h2 class="blog-post-title">Sample blog post</h2>
            <p class="blog-post-meta">January 1, 2014 by <a href="#">Mark</a></p>
            <div class="blog-content"></div>
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
    <script src="/js/indexJS.js"></script>
  </body>
</html>
