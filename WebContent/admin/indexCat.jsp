<%@page import="bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<div class="bottom-spacing">
	  <!-- Button -->
	  <div class="float-left">
		  <a href="<%=request.getContextPath() %>/admin/addCat" class="button">
			<span>Thêm tin <img src="<%=request.getContextPath() %>/templates/admin/images/plus-small.gif" alt="Thêm tin"></span>
		  </a>
	  </div>
	  <div class="clear"></div>
</div>

<div class="grid_12">
	<!-- Example table -->
	<div class="module">
		<h2><span>Danh sách tin</span></h2>
		
		<div class="module-table-body">
			<form action="">
			<table id="myTable" class="tablesorter">
				<thead>
					<tr>
						<th style="width:4%; text-align: center;">ID</th>
						<th>Tên</th>
						<th style="width:11%; text-align: center;">Chức năng</th>
					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<Category> alCat=(ArrayList<Category>)request.getAttribute("alCat");
							if(alCat!=null){
								for(Category objCat:alCat){
					%>
					<tr>
						<td class="align-center"><%=objCat.getIdCat() %></td>
						<td ><a href="<%=request.getContextPath()%>/admin/editCat?cid=<%=objCat.getIdCat()%>"><%=objCat.getName() %></a></td>
						<td align="center">
							<a href="<%=request.getContextPath() %>/admin/editCat?cid=<%=objCat.getIdCat()%>">Sửa <img src="<%=request.getContextPath() %>/templates/admin/images/pencil.gif" alt="edit" /></a>
							<a href="<%=request.getContextPath() %>/admin/delCat?cid=<%=objCat.getIdCat()%> "onclick="return confirm('Are you sure?')">Xóa <img src="<%=request.getContextPath() %>/templates/admin/images/bin.gif" width="16" height="16" alt="delete" /></a>
						</td>
					</tr>
					<%}} %>
				</tbody>
			</table>
			</form>
		 </div> <!-- End .module-table-body -->
	</div> <!-- End .module -->
		 		 <div class="pagination">           
			<div class="numbers">
				
				<%	
					String active="";
					int sotrang=(Integer)(request.getAttribute("sotrang"));
					int current_page=(Integer)(request.getAttribute("current_page"));
					for(int i=1;i<=sotrang;i++){
						if(current_page==i){
							active=" class= 'current'";
						}else{
							active="";
						}
				%>
				
				<span>Trang:</span> 
				<a href="<%=request.getContextPath()%>/admin/indexCat?page=<%=i%>"<%=active %>><%=i %></a> 
				<%
					if(i!=sotrang){
				%>
				<span>|</span> 
				<%} %>
				<%} %>
				
			</div> 
			<div style="clear: both;"></div> 
		 </div>
	
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 