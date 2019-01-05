<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="table-scrollable">
	<table class="table table-striped table-hover table-success">
		<thead>
			<tr>
				<th>#</th>
								<th>创建时间</th>
				<th>门店名</th>
				<th>门店详细地址</th>
				<th>经度</th>
				<th>纬度</th>
				<th>门店描叙</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.result}" var="yShop" varStatus="vs">
			<tr>
				<td>${vs.count + page.offset}</td>
					<td><fmt:formatDate value="${yShop.createDate}" pattern="yyyy-MM-dd"/></td>
					<td>${yShop.name}</td>
					<td>${yShop.address}</td>
					<td>${yShop.longitude}</td>
					<td>${yShop.latitude}</td>
					<td>${yShop.description}</td>
				<td>
					<a href="javascript:;" class="btn btn-sm blue" onclick="update('/yShop/yShop?id=${yShop.id}')">
						<i class="fa fa-edit"></i>编辑
					</a>
					<a href="javascript:;" class="btn btn-sm red" onclick="del('/yShop/delete?id=${yShop.id}')">
						<i class="fa fa-trash"></i>删除
					</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="pageination-panel">${page}</div>