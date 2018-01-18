
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<#include "../header.ftl"> 
    <link href="/css/blog.css" rel="stylesheet">
    <link href="/css/admin/main.css" rel="stylesheet">
  </head>
<body>

    <div class="blog-masthead">
      <div class="container" style="width:90%;">
        <nav class="blog-nav">
          <ul style="margin-left:0px;">
            <li><a class="blog-nav-item active" href="/admin">Admin</a></li>
            <li><a class="blog-nav-item" href="/admin/createArticle">Create</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle blog-nav-item" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Manage<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="/admin/manageArticle">Article</a></li>
                <li><a href="/admin/manageComment">Comment</a></li>
                <!--li><a href="#">TagCtrl</a></li-->
              </ul>
            </li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle blog-nav-item" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Setting<span class="caret"></span></a>
              <ul class="dropdown-menu">
              	<!--li id="editAbout"><a href="#">Edit About</a></li>
                <li class="dropdown-header">User</li-->
                <li id="editPass"><a href="#">Edit User</a></li>
              </ul>
            </li>
          </ul>
          <a class="blog-nav-item" id="logout" href="#" style="float:right;">Logout</a>
       	  <a class="blog-nav-item" href="/" style="float:right;">Home</a>
        </nav>
      </div>
    </div>

    

    <div class="container" style="width:90%;margin-top:10px;padding-bottom:40px;">
    <div class="jumbotron">
      
        <h1>AYYOYYU's Blog</h1>
        <p>目前有 <span id="articleNum" style="color:#000;font-size:30px;"></span> 篇文章, 并有 <span id="commentNum" style="color:#000;font-size:30px;"></span> 条关于你的评论在 <span id="tagNum" style="color:#000;font-size:30px;"></span> 个分类中. </p>
		<div>
			<a href="/admin/createArticle">Create Article</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/admin/manageArticle">Manage Article</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/admin/manageComment">Manage Comment</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
    </div>
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h3>最近发布的文章</h3>
          <div>
          	<ul class="list-unstyled" id="newArticle"></ul>
          </div>
        </div>
        <div class="col-md-4">
          <h3>最近得到的回复</h3>
          <div>
            <ul class="list-unstyled" id="newComment"></ul>
          </div>
       </div>
        <div class="col-md-4">
          <h3>最近的访问日志</h3>
            <ul class="list-unstyled">
			  <li>2012-12-22&nbsp;&nbsp;<a href="x">/admin/xxxx</a></li>
			  <li>2012-12-22&nbsp;&nbsp;<a href="x">/admin/xxxx</a></li>
			  <li>2012-12-22&nbsp;&nbsp;<a href="x">/admin/xxxx</a></li>
			  <li>2012-12-22&nbsp;&nbsp;<a href="x">/admin/xxxx</a></li>
			  <li>2012-12-22&nbsp;&nbsp;<a href="x">/admin/xxxx</a></li>
			  <li>2012-12-22&nbsp;&nbsp;<a href="x">/admin/xxxx</a></li>
			  <li>2012-12-22&nbsp;&nbsp;<a href="x">/admin/xxxx</a></li>
			  <li>2012-12-22&nbsp;&nbsp;<a href="x">/admin/xxxx</a></li>
			  <li>2012-12-22&nbsp;&nbsp;<a href="x">/admin/xxxx</a></li>
			  <li>2012-12-22&nbsp;&nbsp;<a href="x">/admin/xxxx</a></li>
			</ul>
        </div>
      </div>


    </div> <!-- /container -->
	<#include "setting.ftl"> 
    <#include "../footer.ftl"> 
    <script src="/js/admin/mainjs.js"></script>
    <script src="/js/admin/index.js"></script>
  </body>
</html>
