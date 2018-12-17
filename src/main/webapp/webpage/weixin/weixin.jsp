<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="portlet box green">
	<div class="portlet-title">
		<div class="caption">
			<i class="fa fa-gift"></i>微信爬虫
		</div>
  </div>
  <div class="portlet-body form">
  	<form id="weixinForm" class="form-horizontal form-bordered" action="/weixin/save" method="post">
  		<div class="form-group">
        <label class="col-md-3 control-label">创建人员:</label>
        <div class="col-md-4">
	          <input type="text" name="createUser" class="form-control" value="${weixin.createUser}"  maxlength="32"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">创建时间:</label>
        <div class="col-md-4">
	          <input type="text" name="createDate" class="form-control" value="${weixin.createDate}"  maxlength=""/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">修改人员:</label>
        <div class="col-md-4">
	          <input type="text" name="updateUser" class="form-control" value="${weixin.updateUser}"  maxlength="32"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">修改日期:</label>
        <div class="col-md-4">
	          <input type="text" name="updateDate" class="form-control" value="${weixin.updateDate}"  maxlength=""/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">标题:</label>
        <div class="col-md-4">
	          <input type="text" name="header" class="form-control" value="${weixin.header}"  maxlength="255"/>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">内容:</label>
        <div class="col-md-4">
	          <input type="text" name="content" class="form-control" value="${weixin.content}"  maxlength="16,777,215"/>
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
      <input type="hidden" name="id" value="${weixin.id}">
  	</form>
  </div>
</div>
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<script type="text/javascript">
	$(function(){
		$('#weixinForm').validate();
	});
</script>