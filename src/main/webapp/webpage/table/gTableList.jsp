<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="table-scrollable">
	<table class="table table-striped table-hover table-success">
		<thead>
			<tr>
				<th>#</th>
				<th>表中文名</th>
				<th>表名</th>
				<th>表注释</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.result}" var="gTable" varStatus="vs">
			<tr>
				<td>${vs.count + page.offset}</td>
					<td>${gTable.name}</td>
					<td>${gTable.code}</td>
					<td>${gTable.comment}</td>
				<td>
					<a href="javascript:;" class="btn btn-sm blue" onclick="update('/gTable/gTable?id=${gTable.id}')">
						<i class="fa fa-edit"></i>编辑
					</a>
					<a href="javascript:;" class="btn btn-sm red" onclick="del('/gTable/delete?id=${gTable.id}')">
						<i class="fa fa-trash"></i>删除
					</a>
					<a href="javascript:;" class="btn btn-sm purple" onclick="generation('gTable/generation?id=${gTable.id}')">
						<i class="fa fa-external-link"></i>自动建表(UUID)
					</a>
					<a href="javascript:;" class="btn btn-sm purple" onclick="generation('gTable/generation?id=${gTable.id}&auto=1')">
						<i class="fa fa-external-link"></i>自动建表(bigint)
					</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="pageination-panel">${page}</div>
<script type="text/javascript">
	function generation(url){
		$.ajax({
			type: 'post',
			url: url,
			data:null,
			dataType: 'json',
			success: function(data){
				if(data.code=='0'){
					alert("生成成功！"+data.data.tableName);
				}else{
					alert("生成失败！"+data.msg);
				}
			},
			error:function(data){
				alert("服务异常！");
			}
		});
		
	}






</script>