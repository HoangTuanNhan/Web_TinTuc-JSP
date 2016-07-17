<%@page import="bean.Users"%>
<%@page import="bean.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">
 	<%
 	
 		
 		 
  %> 


	<div class="module">
		 <h2><span>Sửa Users</span></h2>
		<%
					Users objUser=(Users)request.getAttribute("objUser");
				%>
		 <div class="module-body">
			<form action="<%=request.getContextPath() %>/admin/editUsers?uid=<%=objUser.getIdUsers() %>" method="POST">
				<%
					if(objUser.getUsername().equals("admin")){
						
				%>
				<p>
					<label>Users name</label>
					<input type="text" name="ten" value="<%=objUser.getUsername() %>" class="input-medium"  readonly/>
				</p>
				<%}else{ %>
				<p>
					<label>Users name</label>
					<input type="text" name="ten" value="<%=objUser.getUsername() %>" class="input-medium"  />
				</p>
				<%} %>
				<p>
					<label>Password</label>
					<input type="password" name="password" value="" class="input-medium"  />
				</p>
				<p>
					<label>FullName</label>
					<input type="text" name="fullname" value="<%=objUser.getFullname() %>" class="input-medium" required pattern="^[a-zA-Z'-'\sáàảãạăâắằấầặẵẫậéèẻ ẽẹếềểễệóòỏõọôốồổỗộ ơớờởỡợíìỉĩịđùúủũụưứ�� �ửữựÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠ ƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼ� ��ỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞ ỠỢỤỨỪỬỮỰỲỴÝỶỸửữựỵ ỷỹ]*$" />
				</p>
				<fieldset>
					<input class="submit-green" name="sua" type="submit" value="Sửa" /> 
				</fieldset>
			</form>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 