<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="col-md-12">
	<div class="panel-search">
	  <form class="form-inline" action="/yShop/list">
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
          <div class="input-group date date-picker" data-date-format="yyyy-mm-dd">
						<input type="text" name="createDate" class="form-control" readonly style="width:100px;"/>
						<span class="input-group-btn">
							<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
						</span>
					</div>
      </div>
      <div class="form-group">
          <label for="updateUser" class="control-label">修改人员：</label>
          <input type="text" name="updateUser" class="form-control" />
      </div>
      <div class="form-group">
          <label for="updateDate" class="control-label">修改日期：</label>
          <div class="input-group date date-picker" data-date-format="yyyy-mm-dd">
						<input type="text" name="updateDate" class="form-control" readonly style="width:100px;"/>
						<span class="input-group-btn">
							<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
						</span>
					</div>
      </div>
      <div class="form-group">
          <label for="name" class="control-label">门店名：</label>
          <input type="text" name="name" class="form-control" />
      </div>
      <div class="form-group">
          <label for="address" class="control-label">门店详细地址：</label>
          <input type="text" name="address" class="form-control" />
      </div>
      <div class="form-group">
          <label for="longitude" class="control-label">经度：</label>
          <input type="text" name="longitude" class="form-control" />
      </div>
      <div class="form-group">
          <label for="latitude" class="control-label">纬度：</label>
          <input type="text" name="latitude" class="form-control" />
      </div>
      <div class="form-group">
          <label for="description" class="control-label">门店描叙：</label>
          <input type="text" name="description" class="form-control" />
      </div>
	  </form>
	  <div class="btn-div">
			<div class="div-left">
				<button type="button" class="btn btn-warning" onclick="add('/yShop/yShop')">
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