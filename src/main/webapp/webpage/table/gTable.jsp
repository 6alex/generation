<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="portlet box green">
	<div class="portlet-title">
		<div class="caption">
			<i class="fa fa-gift"></i>自动建表
		</div>
  </div>
  <div class="portlet-body form">
  	<form id="gTableForm" class="form-horizontal form-bordered" action="/gTable/save" method="post">
  		<div class="form-group">
        <label class="col-md-3 control-label">table_name:</label>
        <div class="col-md-4">
        	<div class="input-icon right">
	        	<i class="fa"></i>
	          <input type="text" class="form-control" name="code" value="${gTable.code}"  maxlength="50" required/>
	        </div>
        </div>
      </div>
  		<div class="form-group">
        <label class="col-md-3 control-label">表名:</label>
        <div class="col-md-4">
        	<div class="input-icon right">
	        	<i class="fa"></i>
	          <input type="text" class="form-control" name="name" value="${gTable.name}"  maxlength="50" required/>
	        </div>
        </div>
      </div>
      <div style="padding: 10px;">
      	<button type="button" class="btn btn-warning" onclick="addItem()">
					<i class="fa fa-plus"></i> 添加子项
				</button>
      </div>
      <div class="table-scrollable">
      <table id="childrenTable" class="table table-striped table-hover">
      	<thead>
      		<tr style="background-color: #ddd;">
      			<th></th>
	      		<th>编码</th>
	      		<th>名称</th>
	      		<th>排序</th>
      		</tr>
      	</thead>
      	<tbody>
      		<c:forEach items="${gTable.children}" var="child" varStatus="vs">
      			<tr>
      				<td class="text-center">
      					<a class="btn btn-icon-only red" href="javascript:;" onclick="removeItem(this)">
      						<i class="fa fa-trash"></i>
      					</a>
      				</td>
      				<td>
      					<div class="input-icon right">
      						<i class="fa"></i>
      						<input type="text" name="children[${vs.index}].code" class="form-control" value="${child.code}" required/>
      					</div>
      				</td>
      				<td>
      					<div class="input-icon right">
      						<i class="fa"></i>
      						<input type="text" name="children[${vs.index}].name" class="form-control" value="${child.name}" required/>
      					</div>
      				</td>
      				<td>
      					<div class="input-icon right">
      						<i class="fa"></i>
      						<input type="text" name="children[${vs.index}].sort" class="form-control" value="${child.sort}"/>
      					</div>
      				</td>
      			</tr>
      		</c:forEach>
      	</tbody>
      </table>
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
      <input type="hidden" name="id" value="${gTable.id}">
  	</form>
  	<div style="display: none;">
  		<table id="trTemplate">
  			<tr>
  				<td class="text-center">
   					<a class="btn btn-icon-only red" href="javascript:;" onclick="removeItem(this)">
   						<i class="fa fa-trash"></i>
   					</a>
   				</td>
  				<td>
  					<div class="input-icon right">
  						<i class="fa"></i>
  						<input type="text" name="children[#index#].code" class="form-control" required/>
  					</div>
  				</td>
  				<td>
  					<div class="input-icon right">
  						<i class="fa"></i>
  						<input type="text" name="children[#index#].name" class="form-control" required/>
  					</div>
  				</td>
  				<td>
  					<div class="input-icon right">
  						<i class="fa"></i>
  						<input type="text" name="children[#index#].sort" class="form-control"/>
  					</div>
  				</td>
  			</tr>
  		</table>
  	</div>
  </div>
</div>
<script type="text/javascript">
	$(function(){
		$('#gTableForm').validate();
	});
	// 新增
	function addItem(){
		
		$('#childrenTable').append($('#trTemplate').html());
		
		resetTrNum('childrenTable');
	}
	// 删除
	function removeItem(item){
		
		$(item).parent().parent().remove();
		
		resetTrNum('childrenTable');
	}
	
</script>