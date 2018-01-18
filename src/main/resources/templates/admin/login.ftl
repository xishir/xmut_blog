<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <#include "../header.ftl">
    <link href="/css/login.css" rel="stylesheet">
</head>

<body>
  <div class="container">

    <form class="form-signin">
      <h2 class="form-signin-heading">Please sign in</h2>
      <label for="inputUsername" class="sr-only">Email address</label>
      <input type="text" id="inputUsername" class="form-control" style="margin-bottom:5px;" placeholder="Username" required="required" autofocus="">
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="required">
      <div class="checkbox">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit" id="Sign">Sign in</button>
    </form>
  </div>
  <!-- 模态框（Modal） -->
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
          <h4 class="modal-title" id="myModalLabel">登录失败！</h4>
        </div>
        <div class="modal-body">账号或密码错误,请重新输入</div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        </div>
      </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  </div>
  <!-- /.modal -->
</body>
<#include "../footer.ftl">
<script src="/js/loginJS.js"></script>
</html>