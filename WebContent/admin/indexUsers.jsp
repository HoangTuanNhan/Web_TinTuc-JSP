<%@page import="javax.jws.soap.SOAPBinding.Use"%>
<%@page import="bean.Users"%>
<%@page import="bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<div class="bottom-spacing">
	  <!-- Button -->
	  <%
	  	if("1".equals(request.getParameter("err"))){
			out.print("<p style='color:red; font-weight:bold'>Chỉ có admin mới có thể sửa !</p>");
		}
	  %>  
	   <%
	  	if("0".equals(request.getParameter("err"))){
			out.print("<p style='color:red; font-weight:bold'>Chỉ có admin mới có thể xóa !</p>");
		}
	  %>
	  <div class="float-left">
		  <a href="<%=request.getContextPath() %>/admin/addUsers" class="button">
			<span>Thêm người dùng <img src="<%=request.getContextPath() %>/templates/admin/images/plus-small.gif" alt="Thêm tin"></span>
		  </a>
		  <form  class="navbar-form navbar-right">
		  		<%-- <%
		  			Users search=(Users)request.getAttribute("search");
		  				
		  		%> --%>
           		<input style="margin-top: 5px;margin-left: 840px" type="text" class="form-control " placeholder="Search..." value="" name="search">
          </form>
	  </div>
	  <div class="clear"></div>
</div>

<div class="grid_12">
	<!-- Example table -->
	<div class="module">
		<h2><span>Danh sách người dùng</span></h2>
		 
		<div class="module-table-body">
			<form action="<%= request.getContextPath()%>/admin/indexUsers" method="post">
			<table id="myTable" class="tablesorter">
				<thead>
					<tr>
						<th style="width:4%; text-align: center;">ID</th>
						<th >Users name</th>
						<th >FullName</th>
						<th style="width:11%; text-align: center;">Chức năng</th>
					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<Users> alUsers=(ArrayList<Users>)request.getAttribute("alUsers");
							if(alUsers!=null){
								for(Users objItem:alUsers){
					%>
					<tr>
						<td class="align-center"><%=objItem.getIdUsers() %></td>
						<td align="center" ><a href="<%=request.getContextPath()%>/admin/editUsers?uid=<%=objItem.getIdUsers()%>"><%=objItem.getUsername() %></a></td>
						<td align="center"><a href="<%=request.getContextPath()%>/admin/editUsers?uid=<%=objItem.getPassword()%>"><%=objItem.getFullname() %></a></td>
						<%
							if(!"admin".equals(objItem.getUsername())){
						%>
						
						<td align="center">
							
							<a href="<%=request.getContextPath() %>/admin/editUsers?uid=<%=objItem.getIdUsers()%>">Sửa <img src="<%=request.getContextPath() %>/templates/admin/images/pencil.gif" alt="edit" /></a>
							<a href="<%=request.getContextPath() %>/admin/delUsers?uid=<%=objItem.getIdUsers()%> "onclick="return confirm('Are you sure?')">Xóa <img src="<%=request.getContextPath() %>/templates/admin/images/bin.gif" width="16" height="16" alt="delete" /></a>
						</td>
						<%}else{ %>
							<td align="center" >
								
									<a href="<%=request.getContextPath() %>/admin/editUsers?uid=<%=objItem.getIdUsers()%>">Sửa <img src="<%=request.getContextPath() %>/templates/admin/images/pencil.gif" alt="edit" /></a>
								
							</td>
						<%} %>
						
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
				<a href="<%=request.getContextPath()%>/admin/indexUsers?page=<%=i%>"<%=active %>><%=i %></a> 
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