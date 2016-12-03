<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/static/taglib.jsp"%> 
<html>
<head>
<jsp:include page="/static/public.jsp"/>
</head>
<body>
	<div class="container">
    <div id="search_bar" class="mt10">
       <div class="box">
       	<!-- 页面头区start -->
          <div class="box_border">
            <div class="box_top"><b class="pl15">功能区</b></div>
            <div class="box_center pt10 pb10">
              <table class="form_table" border="0" cellpadding="0" cellspacing="0">
                <tr>
					<form id="search_form" action="${ctx}/question/index"  method="post">
	                  <td>用户名：</td>
	                  <td>
	                  	<input type="text" id="userName" class="input-text lh25" name="userName" id="tags">
					  </td>
	                  <td>
						<input type="submit" name="button" class="btn btn82 btn_search" value="查询">   
						<input type="button" id="reset" name="button" class="btn btn82 btn_res" value="清除">   
                	 </td>
	               </form>
                </tr>
              </table>
            </div>
          </div>
        </div>
    </div>
    <!-- 页面头区end -->
    </br>
    <!-- 页面table start -->
	   <div id="table" class="mt10">
		<div class="box span10 oh">
	  		<div class="search_bar_btn" style="text-align:left;">
	  			<input type="button" name="addButton" class="btn btn82 btn_add" value="添加">
			</div>
		    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
		        <tr>
		           	<th width="10%">#</th>
		           	<th width="20%">序号</th>
					<th width="20%">用户名</th>
					<th width="20%">年龄</th>
					<th width="30%">联系方式</th>
		        </tr>
	               <c:if test="${empty users }">
						<tr class="tr">
							<td colspan="6" style="text-align: right;">没有更多数据....</td>
						</tr>
					</c:if>
					<c:if test="${!empty users }">
						<c:forEach var="user" items="${users }">
							<tr class="tr">
								<td class="td_center"><input type="checkbox" name="single" value="${user.userId }"></td>
								<td>${user.userId }</td>
								<td><a href="/user/prepareForUserUpdate/${user.userId }">${user.userName }</a>
								</td>
								<td>${user.age }</td>
								<td>${user.phoneNumber }</td>
							</tr>
						</c:forEach>
					</c:if>
	             </table>
	            <!-- 页面table end -->
	            <!-- 分页start -->
	            <x:pager pageSize="${userModel.pageSize }" pageNo="${userModel.pageNo }" recordCount="${userModel.recordCount }" url="/user/findUserList" />
	           	<!-- 分页end -->
	       </div>
	    </div>
   </div>
</body>
<script type="text/javascript">
$(function(){
	$("#userName").on("keyup",function(){
		var userName = $("#userName").val();
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/user/searchUser?userName=" + userName,
			data : {
				userName : userName
			},
			dataType : "json",
			success : function(msg) {
				if(msg != ''){
					var datas = eval('(' + msg + ')');
					console.info(datas);
					$("#userName").autocomplete(datas, {
						formatItem: function (row, i, max) {
							console.info(row);
							return "<table width='400px'><tr><td align='left'>" + row + "</td></tr></table>";
						},
						formatMatch: function(row, i, max){
							return row;
						}
					});
				}
			}
		});
	});
	
	//添加
	$("input[name='addButton']").bind("click", function() {
		window.location.href = '/user/prepareForUserAdd';
	});
});
</script>
</html>
