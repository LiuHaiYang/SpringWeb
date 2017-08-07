<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="Description" content="">
<meta name="Keywords" content="">
<title>搜索功能</title>

<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="js/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.enplaceholder.js" type="text/javascript" charset="utf-8"></script>
<script src="js/base.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/sea.js"></script>
<script type="text/javascript" src="js/base(1).js"></script>
<script src="js/MD5.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery-validate-1.12.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/validate-common.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/check_reg.js"></script>
<script src="js/jquery.pagination.js" type="text/javascript"></script>
<script type="text/javascript">

$(
			function() {
				//初始化时设置样式-项目领域
				var industryId = $("#industryId").val();
				if ($("#industryUL li a[value='" + industryId + "']").size() > 0) {
					$("#industryUL li a").removeClass("active");
					$("#industryUL li a[value='" + industryId + "']").addClass(
							"active");
				}
				;
				//初始化时设置样式-融资阶段
				var stageId = $("#stageId").val();
				if ($("#stageUL li a[value='" + stageId + "']").size() > 0) {
					$("#stageUL li a").removeClass("active");
					$("#stageUL li a[value='" + stageId + "']").addClass(
							"active");
				}
				;
				//初始化时设置样式-项目类型
				var typeId = $("#typeId").val();
				if ($("#typeUL li a[value='" + typeId + "']").size() > 0) {
					$("#typeUL li a").removeClass("active");
					$("#typeUL li a[value='" + typeId + "']").addClass(
							"active");
				}
				;

				//注册事件-项目领域
				$("#industryUL li a").click(
						function() {
							var industryId = $(this).attr("value");
							if ($("#industryUL li a[value='" + industryId + "']").size() > 0) {
								$("#industryUL li a").removeClass("active");
								$("#industryUL li a[value='" + industryId + "']").addClass("active");
								$("#industryId").val(industryId);
								$("#searchform").submit();
							}
						});
				//注册事件-融资阶段
				$("#stageUL li a").click(
						function() {
							var stageId = $(this).attr("value");
							if ($("#stageUL li a[value='" + stageId + "']").size() > 0) {
								$("#stageUL li a").removeClass("active");
								$("#stageUL li a[value='" + stageId + "']").addClass("active");
								$("#stageId").val(stageId);
								$("#searchform").submit();
							}
						});
				//注册事件-项目类型
				$("#typeUL li a").click(
						function() {
							var typeId = $(this).attr("value");
							if ($("#typeUL li a[value='" + typeId + "']").size() > 0) {
								$("#typeUL li a").removeClass("active");
								$("#typeUL li a[value='" + typeId + "']").addClass("active");
								$("#typeId").val(typeId);
								$("#searchform").submit();
							}
						});

			})
</script>

</head>

<body>

	
<!--头部-->
<c:import url="header.jsp"/>
<!--end 头部-->
	<div class="content">
		<!--内容区-->
		<div class="srh-wp-box">
			<div class="wrap">
				<form action="search.do" id="searchform" method="post">
					<input type="hidden" id="page" name="page" value="1">
					<div class="screen-box">
						<div class="sl-wrap clearfix">
							<div class="sl-key">所属领域：</div>
							<div class="sl-value">
								<div class="sl-v-list">
									<ul class="valueList" id="industryUL">
										<input id="industryId" type="hidden" name="industryId" value="${empty param.industryId?-1:param.industryId}">
										<li><a value="-1" title="不限" class="active" href="javascript:void(0);">不限</a></li>
                                        <c:forEach items="${requestScope.industryList }" var="industry">
										<li><a value="${industry.industryId}" title="${industry.industryTitle }" href="javascript:void(0);">${industry.industryTitle }</a></li>
                                        </c:forEach>
									</ul>
								</div>
							</div>
							<div class="sl-ext">
								<span><em>更多</em><i class="icon"></i></span>
							</div>
						</div>
						<div class="sl-wrap clearfix">
							<div class="sl-key">融资阶段：</div>
							<div class="sl-value">
								<div class="sl-v-list">
									<ul class="valueList" id="stageUL">
										<input type="hidden" name="stageId" id="stageId" value="${empty param.stageId?-1:param.stageId}">
										<li><a value="-1" title="不限" class="active" href="javascript:void(0);">不限</a></li>
										<c:forEach items="${requestScope.stageList }" var="stage">
										<li><a value="${stage.stageId }" title="${stage.stageTitle }" href="javascript:void(0);">${stage.stageTitle }</a></li>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
						<div class="sl-wrap clearfix">
							<div class="sl-key">产品类别：</div>
							<div class="sl-value">
								<div class="sl-v-list">
									<ul class="valueList" id="typeUL">
										<input type="hidden" name="typeId" id="typeId" value="${empty param.typeId?-1:param.typeId}">
										<li><a value="-1" title="不限" class="active" href="javascript:void(0);">不限</a></li>
										<c:forEach items="${requestScope.itemTypeList }" var="itemtype">
										<li><a value="${itemtype.typeId }" title="${itemtype.typeName }" href="javascript:void(0);">${itemtype.typeName }</a></li>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
						<div class="sl-wrap clearfix">
							<div class="sl-key">
								地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区：</div>
							<div class="sl-value">
								<div class="sl-v-list">
									<ul class="valueList" id="locationUL">
										<!-- <input type="hidden" name="locationid" id="locationid"> -->
										<li><a class="active" href="javascript:void(0);">不限</a></li>
										<li><a value="110000" title="北京市"
											href="javascript:void(0);">北京市</a></li>
										<li><a value="120000" title="天津市"
											href="javascript:void(0);">天津市</a></li>
										<li><a value="130000" title="河北省"
											href="javascript:void(0);">河北省</a></li>
										<li><a value="140000" title="山西省"
											href="javascript:void(0);">山西省</a></li>
										<li><a value="150000" title="内蒙古自治区"
											href="javascript:void(0);">内蒙古自治区</a></li>
										<li><a value="210000" title="辽宁省"
											href="javascript:void(0);">辽宁省</a></li>
										<li><a value="220000" title="吉林省"
											href="javascript:void(0);">吉林省</a></li>
										<li><a value="230000" title="黑龙江省"
											href="javascript:void(0);">黑龙江省</a></li>
										<li><a value="310000" title="上海市"
											href="javascript:void(0);">上海市</a></li>
										<li><a value="320000" title="江苏省"
											href="javascript:void(0);">江苏省</a></li>
										<li><a value="330000" title="浙江省"
											href="javascript:void(0);">浙江省</a></li>
										<li><a value="340000" title="安徽省"
											href="javascript:void(0);">安徽省</a></li>
										<li><a value="350000" title="福建省"
											href="javascript:void(0);">福建省</a></li>
										<li><a value="360000" title="江西省"
											href="javascript:void(0);">江西省</a></li>
										<li><a value="370000" title="山东省"
											href="javascript:void(0);">山东省</a></li>
										<li><a value="410000" title="河南省"
											href="javascript:void(0);">河南省</a></li>
										<li><a value="420000" title="湖北省"
											href="javascript:void(0);">湖北省</a></li>
										<li><a value="430000" title="湖南省"
											href="javascript:void(0);">湖南省</a></li>
										<li><a value="440000" title="广东省"
											href="javascript:void(0);">广东省</a></li>
										<li><a value="450000" title="广西壮族自治区"
											href="javascript:void(0);">广西壮族自治区</a></li>
										<li><a value="460000" title="海南省"
											href="javascript:void(0);">海南省</a></li>
										<li><a value="500000" title="重庆市"
											href="javascript:void(0);">重庆市</a></li>
										<li><a value="510000" title="四川省"
											href="javascript:void(0);">四川省</a></li>
										<li><a value="520000" title="贵州省"
											href="javascript:void(0);">贵州省</a></li>
										<li><a value="530000" title="云南省"
											href="javascript:void(0);">云南省</a></li>
										<li><a value="540000" title="西藏自治区"
											href="javascript:void(0);">西藏自治区</a></li>
										<li><a value="610000" title="陕西省"
											href="javascript:void(0);">陕西省</a></li>
										<li><a value="620000" title="甘肃省"
											href="javascript:void(0);">甘肃省</a></li>
										<li><a value="630000" title="青海省"
											href="javascript:void(0);">青海省</a></li>
										<li><a value="640000" title="宁夏回族自治区"
											href="javascript:void(0);">宁夏回族自治区</a></li>
										<li><a value="650000" title="新疆维吾尔自治区"
											href="javascript:void(0);">新疆维吾尔自治区</a></li>
										<li><a value="710000" title="台湾省"
											href="javascript:void(0);">台湾省</a></li>
										<li><a value="810000" title="香港特别行政区"
											href="javascript:void(0);">香港特别行政区</a></li>
										<li><a value="820000" title="澳门特别行政区"
											href="javascript:void(0);">澳门特别行政区</a></li>
										<li><a value="659000" title="新疆生产建设兵团"
											href="javascript:void(0);">新疆生产建设兵团</a></li>
									</ul>
								</div>
							</div>
							<div class="sl-ext">
								<span><em>更多</em><i class="icon"></i></span>
							</div>
						</div>
						<div class="sl-wrap clearfix no-border">
							<div class="sl-key">
								搜&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;索：</div>
							<div class="sl-value">
								<div class="sl-v-list">
									<div class="sl-search">
										<!-- <input class="ipt-txt" type="text" name="itemname"> -->
										<button class="sl-search-btn" onclick="return false;" ></button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
				<div class="tab">
				<c:choose >
				<c:when test="${empty requestScope.itemList  }">
				<center><h1 ><font style="font-size:24px">当前项目查询无结果...</font></h1></center>
				</c:when>
				<c:otherwise>
				
					<ul class="tabs-list clearfix">
					<c:forEach items="${requestScope.itemList }" var="itemlist">
						<li>
							<div class="hd">
								<p class="phot">
									<img src="images/${itemlist.itemImg }" width="375" height="200">
								</p>
							</div>
							<div class="bd">
								<p class="name">
									<a href="javascript:void(0);">${itemlist.itemTitle }</a>
									<c:if test="${itemlist.itemInvest eq 0}">
									<i class="invest_ico_gray"></i>
									</c:if>
								</p>
								<p class="tits">${itemlist.itemUnit }</p>
								<p class="weal">
								<c:forEach items="${itemlist.typeList }" var="stype">
									<a javascript:void(0);="" class="one">${stype.typeName }</a>
								</c:forEach>
					
								</p>
								<p class="link">
									<a javascript:void(0);="">
									${itemlist.itemMessage } </a>
								</p>
							</div>
						</li>
					  </c:forEach>

					 </ul>
				    </c:otherwise>
				</c:choose>
				</div>
				<div class="paging">
				<div class="paging-box">
					<script type="text/javascript">
						function topage(page){
							$("#page").val(page);
							$("#searchform").submit();
						}
					</script>
					<ul>
						<c:choose>
							<c:when test="${requestScope.page eq 1 }">
								<li><a title="上一页" href="javascript:void(0);">&lt;&lt;</a></li>
							</c:when>
							<c:otherwise>
								<li><a title="上一页" href="javascript:topage(${requestScope.page-1});">&lt;&lt;</a></li>
							</c:otherwise>
						</c:choose>
						<c:forEach var="index" begin="1" end="${requestScope.pageCount}">
							<c:choose>
								<c:when test="${index eq requestScope.page }">
									<li><a class="active" href="javascript:void(0);">${index}</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="javascript:topage(${index});">${index}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${requestScope.page eq requestScope.pageCount }">
								<li><a title="下一页" href="javascript:void(0);">&gt;&gt;</a></li>
							</c:when>
							<c:otherwise>
								<li><a title="下一页" href="javascript:topage(${requestScope.page+1});">&gt;&gt;</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
				<!--end 分页-->

			</div>
		</div>
		<!--srh-wp-box End-->
		<!--end 内容区-->
	</div>

	<!--底部-->
	<c:import url="/footer.jsp"/>
</body>
</html>
