<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">
<%
	  	if("0".equals(request.getParameter("msg"))){
	  		out.print("<p style='color:green; font-weight:bold'>Thực hiện không thành công !</p>");
	  	}
	  if("1".equals(request.getParameter("msg"))){
	  		out.print("<p style='color:green; font-weight:bold'>Thực hiện  thành công !</p>");
	  	}
	  
	  %> 
	<div class="module">
		 <h2><span>Thêm danh mục tin</span></h2>
			
		 <div class="module-body">
			<form action="<%=request.getContextPath() %>/admin/addCat"  method="post">
				<p>
					<label>Tên tin</label>
					<input type="text" name="tentin" value="" class="input-medium" />
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