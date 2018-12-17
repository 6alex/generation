<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="table-scrollable">
	<table class="table table-striped table-hover table-success">
		<thead>
			<tr>
				<th>#</th>
								<th>创建人员</th>
				<th>创建时间</th>
				<th>修改人员</th>
				<th>修改日期</th>
				<th>标题</th>
				<th>内容</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.result}" var="weixin" varStatus="vs">
			<tr>
				<td>${vs.count + page.offset}</td>
					<td>${weixin.createUser}</td>
					<td>${weixin.createDate}</td>
					<td>${weixin.updateUser}</td>
					<td>${weixin.updateDate}</td>
					<td>${weixin.header}</td>
					<td>${weixin.content}</td>
				<td>
					<a href="javascript:;" class="btn btn-sm blue" onclick="update('/weixin/weixin?id=${weixin.id}')">
						<i class="fa fa-edit"></i>编辑
					</a>
					<a href="javascript:;" class="btn btn-sm red" onclick="del('/weixin/delete?id=${weixin.id}')">
						<i class="fa fa-trash"></i>删除
					</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="pageination-panel">${page}</div>