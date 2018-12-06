<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="table-scrollable">
	<table class="table table-striped table-hover table-success">
		<thead>
			<tr>
				<th>#</th>
								<th>字段名称</th>
				<th>数据类型编码</th>
				<th>默认值</th>
				<th>是否为空  1空，0不为空</th>
				<th>注释</th>
				<th>分组id</th>
				<th>排序</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.result}" var="gTable" varStatus="vs">
			<tr>
				<td>${vs.count + page.offset}</td>
					<td>${gTable.name}</td>
					<td>${gTable.code}</td>
					<td>${gTable.defaultValue}</td>
					<td>${gTable.isNull}</td>
					<td>${gTable.comment}</td>
					<td>${gTable.groupId}</td>
					<td>${gTable.sort}</td>
				<td>
					<a href="javascript:;" class="btn btn-sm blue" onclick="update('/gTable/gTable?id=${gTable.id}')">
						<i class="fa fa-edit"></i>编辑
					</a>
					<a href="javascript:;" class="btn btn-sm red" onclick="del('/gTable/delete?id=${gTable.id}')">
						<i class="fa fa-trash"></i>删除
					</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="pageination-panel">${page}</div>