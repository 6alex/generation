<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="col-md-12">
	<div class="panel-search">
	  <form class="form-inline" action="/weixin/list">
      <div class="form-group">
          <label for="id" class="control-label">id：</label>
          <input type="text" name="id" class="form-control" />
      </div>
      <div class="form-group">
          <label for="createUser" class="control-label">创建人员：</label>
          <input type="text" name="createUser" class="form-control" />
      </div>
      <div class="form-group">
          <label for="createDate" class="control-label">创建时间：</label>
          <input type="text" name="createDate" class="form-control" />
      </div>
      <div class="form-group">
          <label for="updateUser" class="control-label">修改人员：</label>
          <input type="text" name="updateUser" class="form-control" />
      </div>
      <div class="form-group">
          <label for="updateDate" class="control-label">修改日期：</label>
          <input type="text" name="updateDate" class="form-control" />
      </div>
      <div class="form-group">
          <label for="header" class="control-label">标题：</label>
          <input type="text" name="header" class="form-control" />
      </div>
      <div class="form-group">
          <label for="content" class="control-label">内容：</label>
          <input type="text" name="content" class="form-control" />
      </div>
	  </form>
	  <div class="btn-div">
			<div class="div-left">
				<button type="button" class="btn btn-warning" onclick="add('/weixin/weixin')">
					<i class="fa fa-plus"></i> <spring:message code="btn.add"></spring:message>
				</button>
			</div>
			<div class="div-right">
				<button type="button" class="btn btn-primary" onclick="search()">
					<i class="fa fa-search"></i> <spring:message code="btn.search"></spring:message>
				</button>
		    <button type="button" class="btn btn-default" onclick="reset()">
		    	<i class="fa fa-repeat"></i> <spring:message code="btn.reset"></spring:message>	
		    </button>
			</div>
		</div>
	</div>
	<div class="panel-content"></div>
</div>
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript">
	$(function(){
		search();
	});
</script>