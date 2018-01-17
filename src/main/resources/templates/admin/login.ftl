<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <#include "../header.ftl">
    <link href="/css/login.css" rel="stylesheet">
</head>

<body>
  <div class="container">

    <div class="form-signin">
      <h2 class="form-signin-heading">Please sign in</h2>
      <label for="inputUsername" class="sr-only">Email address</label>
      <input type="text" id="inputUsername" class="form-control" placeholder="Username" required="" autofocus="">
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
      <div class="checkbox">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit" id="Sign">Sign in</button>
    </div>

  </div>
</body>
<#include "../footer.ftl">

</html>