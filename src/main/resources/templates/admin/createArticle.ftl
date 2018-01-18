
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<#include "../header.ftl"> 
    <link href="/css/blog.css" rel="stylesheet">
    <link href="/css/main.css" rel="stylesheet">
    <link rel="stylesheet" href="/editormd/style.css" />
    <link rel="stylesheet" href="/editormd/css/editormd.css" />
    
  </head>
  <body>

    <div class="blog-masthead">
      <div class="container">
        <nav class="blog-nav">
          <ul style="margin-left:0px;">
            <li><a class="blog-nav-item" href="#">Admin</a></li>
            <li><a class="blog-nav-item active" href="#">Create</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle blog-nav-item" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Manage<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Article</a></li>
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
      <h3 class="blog-post-title">Create Article</h3>
	  <div class="form-group">
	    <input type="text" class="form-control" id="title" placeholder="文章标题">
	  	<input type="text" class="form-control" id="tags" placeholder="标签,用英文逗号隔开">
	  </div>
      <div id="test-editormd">
                <textarea style="display:none;">[TOC]

#### Disabled options

- TeX (Based on KaTeX);
- Emoji;
- Task lists;
- HTML tags decode;
- Flowchart and Sequence Diagram;

#### Editor.md directory

    editor.md/
            lib/
            css/
            scss/
            tests/
            fonts/
            images/
            plugins/
            examples/
            languages/     
            editormd.js
            ...

```html
&lt;!-- English --&gt;
&lt;script src="../dist/js/languages/en.js"&gt;&lt;/script&gt;

&lt;!-- 繁體中文 --&gt;
&lt;script src="../dist/js/languages/zh-tw.js"&gt;&lt;/script&gt;
```
</textarea>
            </div>
      

    </div><!-- /.container -->

    <#include "../footer.ftl"> 
    <script src="/editormd/editormd.min.js"></script>
        <script type="text/javascript">
			var testEditor;

            $(function() {
                testEditor = editormd("test-editormd", {
                    width   : "100%",
                    height  : 640,
                    syncScrolling : "single",
                    path    : "/editormd/lib/",
                    imageUpload : true,
				    imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
				    imageUploadURL : "/api/admin/uploadfile",
				    saveHTMLToTextarea : true
                });
                
                /*
                // or
                testEditor = editormd({
                    id      : "test-editormd",
                    width   : "90%",
                    height  : 640,
                    path    : "/editormd/lib/"
                });
                */
            });
        </script>
    <script src="/js/mainjs.js"></script>
    
  </body>
</html>
