<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="portlet box green">
	<div class="portlet-title">
		<div class="caption">
			<i class="fa fa-gift"></i>通用cms
		</div>
  </div>
  <div class="portlet-body form">
  	<form id="tCmsForm" class="form-horizontal form-bordered" action="/tCms/save" method="post">
  		<div class="form-group">
        <label class="col-md-3 control-label">cms标题:</label>
        <div class="col-md-4">
	          <input type="text" name="title" class="form-control" value="${tCms.title}"  maxlength="200"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">内容:</label>
        <div class="col-md-4">
	        <div class="input-icon right">
	        	<i class="fa"></i>
	        	<textarea name="content" rows="5" class="form-control" maxlength="500" >${tCms.content}</textarea>
	        </div>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">作者:</label>
        <div class="col-md-4">
	          <input type="text" name="author" class="form-control" value="${tCms.author}"  maxlength="100"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">图片集合:</label>
        <div class="col-md-4">
	          <input type="text" name="imgs" class="form-control" value="${tCms.imgs}"  maxlength="255"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">链接:</label>
        <div class="col-md-4">
	          <input type="text" name="links" class="form-control" value="${tCms.links}"  maxlength="255"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">附件:</label>
        <div class="col-md-4">
	          <input type="text" name="attachment" class="form-control" value="${tCms.attachment}"  maxlength="255"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">排序:</label>
        <div class="col-md-4">
	          <input type="text" name="sort" class="form-control" value="${tCms.sort}"  maxlength="10"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">栏目ID:</label>
        <div class="col-md-4">
	          <input type="text" name="columnId" class="form-control" value="${tCms.columnId}"  maxlength="32"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">创建人:</label>
        <div class="col-md-4">
	          <input type="text" name="createUser" class="form-control" value="${tCms.createUser}"  maxlength="32"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">创建日期:</label>
        <div class="col-md-4">
	          <input type="text" name="createDate" class="form-control" value="${tCms.createDate}"  maxlength=""/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">修改人:</label>
        <div class="col-md-4">
	          <input type="text" name="updateUser" class="form-control" value="${tCms.updateUser}"  maxlength="32"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">修改日期:</label>
        <div class="col-md-4">
	          <input type="text" name="updateDate" class="form-control" value="${tCms.updateDate}"  maxlength=""/>
        </div>
      </div>
      <div class="form-actions">
        <div class="col-md-9 col-md-offset-3">
          <button type="button" class="btn btn-primary" onclick="save(this)">
          	<spring:message code="btn.save"></spring:message>
          </button>
          <button type="reset" class="btn btn-default" onclick="cancel()">
          	<spring:message code="btn.return"></spring:message>
          </button>
        </div>
      </div>
      <input type="hidden" name="id" value="${tCms.id}">
  	</form>
  </div>
</div>
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript">
	$(function(){
		$('#tCmsForm').validate();
	});
</script>