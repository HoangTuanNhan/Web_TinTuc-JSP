<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">
	<%
	  	if("0".equals(request.getParameter("msg"))){
	  		out.print("<p style='color:green; font-weight:bold'>thực hiện không thành công !</p>");
	  	}
	  if("1".equals(request.getParameter("msg"))){
	  		out.print("<p style='color:green; font-weight:bold'>thực hiện  thành công !</p>");
	  	}
	  
	  %> 
	<div class="module">
		 <h2><span>Thêm người dùng</span></h2>
			
		 <div class="module-body">
			<form action="<%=request.getContextPath() %>/admin/addUsers"  method="post">
				<p>
					<label>User name</label>
					<input type="text" name="tentin" value="" class="input-medium" required="required"/>
				</p>
				<p>
					<label>Password</label>
					<input type="password" name="password" value="" class="input-medium" required="required"/>
				</p>
				<p>
					<label>Full name</label>
					<input type="text" name="fullname" value="" class="input-medium" required="required"/>
				</p>
				<fieldset>
					<input class="submit-green" name="them" type="submit" value="Thêm" /> 
					<input class="submit-gray" name="reset" type="reset" value="Nhập lại" />
				</fieldset>
			</form>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 