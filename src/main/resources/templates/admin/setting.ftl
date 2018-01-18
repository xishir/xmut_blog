<div class="modal fade" tabindex="-1" role="dialog" id="modalEditAbout">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">编辑介绍</h4>
      </div>
      <div class="modal-body">
		  <div class="form-group">
		    <label for="exampleInputPassword1">About</label>
		    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
		  </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal fade" tabindex="-1" role="dialog" id="modalEditUser">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" style="float:left;">编辑用户</h4>
      </div>
      <div class="modal-body">
		  <div class="form-group">
		    <label for="newPassword" style="float:left;">Password</label>
		    <input type="password" class="form-control" id="newPassword" placeholder="请输入新密码">
		  	<textarea class="form-control" placeholder="请输入新的个人介绍" id="newAbout" style="margin-top:5px;"></textarea>
		  </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" style="color: #fff;background-color: #337ab7;border-color: #2e6da4;" id="modalEditPassOk">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->