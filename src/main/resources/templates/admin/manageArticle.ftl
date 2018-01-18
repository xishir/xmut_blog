
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<#include "../header.ftl"> 
    <link href="/css/blog.css" rel="stylesheet">
    <link href="/css/admin/main.css" rel="stylesheet">
    <link href="/css/admin/manageArticle.css" rel="stylesheet">
    
  </head>
  <body>

    <div class="blog-masthead">
      <div class="container" style="width:90%;">
        <nav class="blog-nav">
          <ul style="margin-left:0px;">
            <li><a class="blog-nav-item" href="#">Admin</a></li>
            <li><a class="blog-nav-item" href="/creatArticle">Create</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle blog-nav-item active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Manage<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="/manageArticle">Article</a></li>
                <li><a href="#">Comment</a></li>
                <li><a href="#">TagCtrl</a></li>
              </ul>
            </li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle blog-nav-item" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Setting<span class="caret"></span></a>
              <ul class="dropdown-menu">
              	<li><a href="#">Base</a></li>
                <li><a href="#">User</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">Other</li>
                <li><a href="#">Hello</a></li>
                <li><a href="#">World</a></li>
              </ul>
            </li>
          </ul>
          <a class="blog-nav-item" id="logout" href="#" style="float:right;">Logout</a>
       	  <a class="blog-nav-item" href="/" style="float:right;">Home</a>
        </nav>
      </div>
    </div>

    <div class="container" style="width:90%;padding:0px;margin-top:10px;">
    <div class="blog-post-title"><h3>Manage Article</h3>
    <a href="/admin/createArticle"><button type="button" class="btn"  style="color: #fff;background-color: #337ab7;border-color: #2e6da4;" id="createArticle">Create</button></a>
      <!-- Standard button -->
		<button type="button" class="btn" style="color: #fff;background-color: #337ab7;border-color: #2e6da4;" id="search">提交</button>
      <input type="text" class="form-control" id="searchContent" placeholder="请输入关键字" >
      </div>
	  
      <table class="table table-hover">
      <thead>
        <tr id="blog-table-tr">
          <th></th>
          <th>标题</th>
          <th>作者</th>
          <th>日期</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody id="articleBody">
        
      </tbody>
    </table>
    <center>
	  <nav aria-label="Page navigation" >
		  <ul class="pagination">
		    <li>
		      <a href="#" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <li><a href="#">1</a></li>
		    <li><a href="#">2</a></li>
		    <li><a href="#">3</a></li>
		    <li><a href="#">4</a></li>
		    <li><a href="#">5</a></li>
		    <li>
		      <a href="#" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
	</center>

    </div><!-- /.container -->

    <#include "../footer.ftl"> 

    <script src="/js/admin/manageArticle.js"></script>
    <script src="/js/admin/mainjs.js"></script>
  </body>
</html>
