<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="portlet box green">
	<div class="portlet-title">
		<div class="caption">
			<i class="fa fa-gift"></i>
			云圣商铺
		</div>
	</div>
	<div class="portlet-body form">
		<form id="yShopForm" class="form-horizontal form-bordered" action="/yShop/save" method="post">
			<div class="form-group">
				<label class="col-md-3 control-label">创建人员:</label>
				<div class="col-md-4">
					<input type="text" name="createUser" class="form-control" value="${yShop.createUser}" maxlength="32" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">创建时间:</label>
				<div class="col-md-4">
					<div class="input-icon right">
						<i class="fa"></i>
						<div class="input-group date date-picker" data-date-format="yyyy-mm-dd">
							<input type="text" class="form-control" name="createDate" readonly value="<fmt:formatDate value="${yShop.createDate}" pattern="yyyy-MM-dd"/>" maxlength="11" />
							<span class="input-group-btn">
								<button class="btn default" type="button">
									<i class="fa fa-calendar"></i>
								</button>
							</span>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">修改人员:</label>
				<div class="col-md-4">
					<input type="text" name="updateUser" class="form-control" value="${yShop.updateUser}" maxlength="32" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">修改日期:</label>
				<div class="col-md-4">
					<div class="input-icon right">
						<i class="fa"></i>
						<div class="input-group date date-picker" data-date-format="yyyy-mm-dd">
							<input type="text" class="form-control" name="updateDate" readonly value="<fmt:formatDate value="${yShop.updateDate}" pattern="yyyy-MM-dd"/>" maxlength="11" />
							<span class="input-group-btn">
								<button class="btn default" type="button">
									<i class="fa fa-calendar"></i>
								</button>
							</span>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">门店名:</label>
				<div class="col-md-4">
					<input type="text" name="name" class="form-control" value="${yShop.name}" maxlength="32" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">门店详细地址:</label>
				<div class="col-md-4">
					<input type="text" readonly="readonly" id="address" name="address" class="form-control" value="${yShop.address}" maxlength="255" placeholder="请在地图上搜索详细地址" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">经度:</label>
				<div class="col-md-4">
					<input type="text" readonly="readonly" id="lng" name="longitude" class="form-control" value="${yShop.longitude}" maxlength="11" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">纬度:</label>
				<div class="col-md-4">
					<input type="text" readonly="readonly" id="lat" name="latitude" class="form-control" value="${yShop.latitude}" maxlength="11" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">地图:</label>
				<div id="map" class="col-md-14">
					<div id="mapTip">
						<input type="text" id="keyword" name="keyword" value="请输入关键字：(选定后搜索)" onfocus='this.value=""' />
					</div>
				</div>


			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">门店描叙:</label>
				<div class="col-md-4">
					<textarea name="description" rows="20" class="form-control" value="${yShop.description}" maxlength="16,777,215"></textarea>
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
			<input type="hidden" name="id" value="${yShop.id}">
		</form>
	</div>
</div>
<script type="text/javascript" src="<c:url value="/static/custom/datepicker-util.js"></c:url>"></script>
<!-- 高德地图  -->
<script type="text/javascript">
    var map = new AMap.Map('map', {
	/* center:[117.000923,36.675807],
	zoom:11 */
	zoom : 11,
	resizeEnable : true
    //默认定位当前位置
    });
    var marker;

    // 同时引入工具条插件，比例尺插件和鹰眼插件
    AMap.plugin([ 'AMap.ToolBar', 'AMap.Scale', 'AMap.OverView', 'AMap.Geolocation', ], function() {
	// 在图面添加工具条控件，工具条控件集成了缩放、平移、定位等功能按钮在内的组合控件
	map.addControl(new AMap.ToolBar());
	// 在图面添加比例尺控件，展示地图在当前层级和纬度下的比例尺
	map.addControl(new AMap.Scale());
	// 在图面添加鹰眼控件，在地图右下角显示地图的缩略图
	map.addControl(new AMap.OverView({
	    isOpen : true
	}));
	// 在图面添加定位控件，用来获取和展示用户主机所在的经纬度位置
	map.addControl(new AMap.Geolocation());
    });

    AMap.plugin('AMap.Geolocation', function() {
	var geolocation = new AMap.Geolocation({
	    // 是否使用高精度定位，默认：true
	    enableHighAccuracy : true,
	    // 设置定位超时时间，默认：无穷大
	    timeout : 10000,
	    // 定位按钮的停靠位置的偏移量，默认：Pixel(10, 20)
	    buttonOffset : new AMap.Pixel(10, 20),
	    //  定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
	    zoomToAccuracy : true,
	    //  定位按钮的排放位置,  RB表示右下
	    buttonPosition : 'RB'
	})

	geolocation.getCurrentPosition()
	AMap.event.addListener(geolocation, 'complete', onComplete)
	AMap.event.addListener(geolocation, 'error', onError)

	function onComplete(data) {
	    alert("高经度定位");
	    console.log(data);
	    // data是具体的定位信息
	    // 创建一个 Marker 实例：
	    marker = new AMap.Marker({
		draggable : true, //点标记可拖拽
		cursor : 'move', //鼠标悬停点标记时的鼠标样式
		raiseOnDrag : true,//鼠标拖拽点标记时开启点标记离开地图的效果
		position : new AMap.LngLat(data.position.lng, data.position.lat), // 经纬度对象，也可以是经纬度构成的一维数组[116.39, 39.9]
		title : data.formattedAddress
	    });
	    // 将创建的点标记添加到已有的地图实例：
	    map.add(marker);
	    AMap.event.addListener(marker, "dragend", function(e) {
		alert("监听移动！");
		console.log(e);
	    });
	}

	function onError(data) {
	    // 定位出错
	    alert("定位出错！");
	}
    })

    AMap.plugin([ 'AMap.Autocomplete' ], function() {
	var autoOptions = {
	    city : "全国", //城市，默认全国
	    input : "keyword"//使用联想输入的input的id
	};
	autocomplete = new AMap.Autocomplete(autoOptions);
	AMap.event.addListener(autocomplete, "select", function(e) {
	    console.log(e);
	    alert("地区搜索");
	    map.remove(marker);
	    //TODO 针对选中的poi实现自己的功能
	    marker = new AMap.Marker({
		position : new AMap.LngLat(e.poi.location.lng, e.poi.location.lat), // 经纬度对象，也可以是经纬度构成的一维数组[116.39, 39.9]
		title : e.poi.address
	    });
	    // 将创建的点标记添加到已有的地图实例：
	    map.setCenter(marker.getPosition());
	    map.add(marker);
	});
    });
</script>


<script type="text/javascript">
    $(function() {
	$('#yShopForm').validate();
    });
</script>
<style type="text/css">
#mapTip {
	z-index: 1;
	background-color: #ddf;
	color: #333;
	border: 1px solid silver;
	box-shadow: 3px 4px 3px 0px silver;
	position: absolute;
	top: 10px;
	right: 10px;
	border-radius: 5px;
	overflow: hidden;
	line-height: 20px;
}

#mapTip input[type="text"] {
	height: 25px;
	border: 0;
	padding-left: 5px;
	width: 280px;
	border-radius: 3px;
	outline: none;
}

#map {
	width: 1000px;
	height: 800px;
}
</style>