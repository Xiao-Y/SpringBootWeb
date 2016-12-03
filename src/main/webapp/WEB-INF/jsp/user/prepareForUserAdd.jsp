<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/static/taglib.jsp"%> 
<html>
<head>
<jsp:include page="/static/public.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15"><span style="cursor:pointer" onclick="history.go(-1)">&lt;&nbsp;返回&nbsp;&nbsp;</span>编辑问题信息</b></div>
            <div class="box_center">
            	<sf:form id="userForm" class="jqtransform" action="/user/updateUserInfo" method="post" modelAttribute="user">
					<input type="hidden" id="userId" name="userId" value="${user.userId }"> 
	               	<table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
	                 	<tr>
	                  		<td class="td_right">用户名：</td>
							<td>
								<input class="input-text lh30" type="text" name="userName" value="${user.userName }">
								<span id="questionEx"><span style="color: red;">*必填项</span><sf:errors path="userName"/></span>
							</td>
	                	</tr>
	                 	<tr>
	                  		<td class="td_right">年龄：</td>
							<td>
								<input class="input-text lh30" type="text" name="age" value="${user.age }">
								<span id="questionEx"><span style="color: red;">*必填项</span><sf:errors path="age"/></span>
							</td>
	                	</tr>
	                 	<tr>
	                  		<td class="td_right">联系方式：</td>
							<td>
								<input class="input-text lh30" type="text" name="phoneNumber" value="${user.phoneNumber }">
								<span id="questionEx"><span style="color: red;">*必填项</span><sf:errors path="phoneNumber"/></span>
							</td>
	                	</tr>
	                 	<tr>
	                   		<td class="td_right">&nbsp;</td>
	                   		<td class="">
		                    	<input type="button" id="saveButton" name="button" class="btn btn82 btn_save2" value="保存"> 
		                     	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                    	<input type="reset" name="button" class="btn btn82 btn_res" value="重置"> 
	                   		</td>
	                 	</tr>
	               </table>
               </sf:form>
            </div>
          </div>
        </div>
     </div>
</body>
<script type="text/javascript">
$("#saveButton").click(function(){
	var url;
	var userId = $("#userId").val();
	if(userId != ''){
		url = "/user/updateUserInfo";
	}else{
		url = "/user/submitUserInfo";
	}
	$("#userForm").attr("action",url);
	$("#userForm").submit();
});
</script>
</html>