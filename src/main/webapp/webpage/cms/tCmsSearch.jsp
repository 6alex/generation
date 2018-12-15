<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="col-md-12">
	<div class="panel-search">
	  <form class="form-inline" action="/tCms/list">
      <div class="form-group">
          <label for="id" class="control-label">内容ID：</label>
          <input type="text" name="id" class="form-control" />
      </div>
      <div class="form-group">
          <label for="title" class="control-label">cms标题：</label>
          <input type="text" name="title" class="form-control" />
      </div>
      <div class="form-group">
          <label for="content" class="control-label">内容：</label>
          <input type="text" name="content" class="form-control" />
      </div>
      <div class="form-group">
          <label for="author" class="control-label">作者：</label>
          <input type="text" name="author" class="form-control" />
      </div>
      <div class="form-group">
          <label for="imgs" class="control-label">图片集合：</label>
          <input type="text" name="imgs" class="form-control" />
      </div>
      <div class="form-group">
          <label for="links" class="control-label">链接：</label>
          <input type="text" name="links" class="form-control" />
      </div>
      <div class="form-group">
          <label for="attachment" class="control-label">附件：</label>
          <input type="text" name="attachment" class="form-control" />
      </div>
      <div class="form-group">
          <label for="sort" class="control-label">排序：</label>
          <input type="text" name="sort" class="form-control" />
      </div>
      <div class="form-group">
          <label for="columnId" class="control-label">栏目ID：</label>
          <input type="text" name="columnId" class="form-control" />
      </div>
      <div class="form-group">
          <label for="createUser" class="control-label">创建人：</label>
          <input type="text" name="createUser" class="form-control" />
      </div>
      <div class="form-group">
          <label for="createDate" class="control-label">创建日期：</label>
          <input type="text" name="createDateStart" class="form-control" style="width:100px;"/> -
          <input type="text" name="createDateEnd" class="form-control" style="width:100px;"/>
      </div>
      <div class="form-group">
          <label for="updateUser" class="control-label">修改人：</label>
          <input type="text" name="updateUser" class="form-control" />
      </div>
      <div class="form-group">
          <label for="updateDate" class="control-label">修改日期：</label>
          <input type="text" name="updateDateStart" class="form-control" style="width:100px;"/> -
          <input type="text" name="updateDateEnd" class="form-control" style="width:100px;"/>
      </div>
	  </form>
	  <div class="btn-div">
			<div class="div-left">
				<button type="button" class="btn btn-warning" onclick="add('/tCms/tCms')">
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