<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="table-scrollable">
	<table class="table table-striped table-hover table-success">
		<thead>
			<tr>
				<th>#</th>
								<th>cms标题</th>
				<th>内容</th>
				<th>作者</th>
				<th>图片集合</th>
				<th>链接</th>
				<th>附件</th>
				<th>排序</th>
				<th>栏目ID</th>
				<th>创建人</th>
				<th>创建日期</th>
				<th>修改人</th>
				<th>修改日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.result}" var="tCms" varStatus="vs">
			<tr>
				<td>${vs.count + page.offset}</td>
					<td>${tCms.title}</td>
					<td>${tCms.content}</td>
					<td>${tCms.author}</td>
					<td>${tCms.imgs}</td>
					<td>${tCms.links}</td>
					<td>${tCms.attachment}</td>
					<td>${tCms.sort}</td>
					<td>${tCms.columnId}</td>
					<td>${tCms.createUser}</td>
					<td>${tCms.createDate}</td>
					<td>${tCms.updateUser}</td>
					<td>${tCms.updateDate}</td>
				<td>
					<a href="javascript:;" class="btn btn-sm blue" onclick="update('/tCms/tCms?id=${tCms.id}')">
						<i class="fa fa-edit"></i>编辑
					</a>
					<a href="javascript:;" class="btn btn-sm red" onclick="del('/tCms/delete?id=${tCms.id}')">
						<i class="fa fa-trash"></i>删除
					</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="pageination-panel">${page}</div>