<%@page import="bean.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">
	<%
		if("0".equals(request.getParameter("msg"))){
			out.print("<p style='color:red';font-weight:'bold'>Có lổi trong qua trình sửa</p>");
		}
		/* else{
			out.print("<p style='color:green';font-weight:'bold'>Thêm thành công</p>");
		} */
	%>
	<div class="module">
		 <h2><span>Sửa danh mục tin</span></h2>
			<%
					Category alCat=(Category)request.getAttribute("alCat");
				%>
		 <div class="module-body">
			<form action="<%=request.getContextPath() %>/admin/editCat?cid=<%=alCat.getIdCat() %>"  method="post">
				
				<p>
					<label>Tên tin</label>
					<input type="text" name="tentin" value="<%=alCat.getName() %>" class="input-medium" required="required"/>
				</p>
				
				<fieldset>
					<input class="submit-green" name="sua" type="submit" value="Sửa" /> 
					<input class="submit-gray" name="reset" type="reset" value="Nhập lại" />
				</fieldset>
			
			</form>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 