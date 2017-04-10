<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
<s:form namespace="/" action="staffAction_edit">
	<s:hidden name="staffId" value="%{staffId}"/>
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td>
	    	<s:textfield name="loginName"/>
		</td>
	    <td>密码：</td>
	    <td>
	    	<s:password name="loginPwd" showPassword="true"/>
	    </td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td>
	    	<s:textfield name="staffName"/>
	    </td>
	    <td>性别：</td>
	    <td>
	    	<s:radio list="{'男','女'}" name="gender"/>
	    </td>
	  </tr>
	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%">
	    	<s:select list="findAllDepartment" name="post.department.depId" onchange="showPost(this)" 
	    	listKey="depId" listValue="depName" headerKey="" headerValue="----请--选--择----">
	    	</s:select>
	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">
	    	<%-- 如果职工表中的数据没有职务，则会报异常，所以要进行判断 --%>
	    	<s:select list="post != null ? post.department.postSet : {}" name="post.postId" id="selectPostId"
	    	listKey="postId" listValue="postName" headerKey="" headerValue="----请--选--择----">
	    	</s:select>
	    </td>
	  </tr>
	  <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
	    	<%-- 显示日期，先用date标签修饰格式，在调用var属性存入ActionContext中 --%>
	    	<s:date name="onDutyDate" format="yyyy-MM-dd" var="dutyDate"/>
	    	<s:textfield name="onDutyDate" readonly="true" value="%{#dutyDate}" onfocus="c.showMoreDay=true; c.show(this);"/>
	    </td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
	</table>
</s:form>	
	<script type="text/javascript">
		function showPost(obj){
			//选中部门
			var depId = obj.value
			//发送ajax通过部门查询职务
			//1.获得引擎
			var xmlhttp;
			if (window.XMLHttpRequest){
				// code for IE7+, Firefox, Chrome, Opera, Safari
			 	 xmlhttp=new XMLHttpRequest();
			}
			else{
				// code for IE6, IE5
			 	 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			//2.设置回调函数
			xmlhttp.onreadystatechange = function(){
				if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
					//获得返回的数据
					var text = xmlhttp.responseText;
					//把数据装换成数组
					var jsonData = eval("("+text+")");
					//获得select标签
					var postSelectElement = document.getElementById("selectPostId"); 
					postSelectElement.innerHTML = "<option value=''>----请--选--择----</option>";
					//进行遍历
					for(i = 0; i < jsonData.length; i++){
						var post = jsonData[i];
						//获得Id
						var postId = post.postId;
						//获得名称
						var postName = post.postName;
						//修改html标签内容
						postSelectElement.innerHTML += "<option value='"+postId+"'>"+postName+"</option>";
					}
				}
			};
			//3.创建链接
			var url = "${pageContext.request.contextPath}/postAction_findAllWithDepartment?department.depId="+depId;
			xmlhttp.open("GET", url);
			//4.发送请求
			xmlhttp.send(null);
		}
	</script>

</body>
</html>
