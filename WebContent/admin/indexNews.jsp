
<%@page import="bean.Category"%>
<%@page import="model.ModelCategory"%>
<%@page import="bean.News"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp"%>
<div class="bottom-spacing">
	<!-- Button -->
	<div class="float-left">
		<%
			if ("1".equals(request.getParameter("msg"))) {
		%>
		<p style="color: green; font-weight: bold">Thêm thành công</p>
		<%
			}
		%>
		<%
			if ("1".equals(request.getParameter("emsg"))) {
		%>
		<p style="color: green; font-weight: bold">Sửa thành công</p>
		<%
			}
		%>
		<%
			if (request.getAttribute("msg") != null) {
				String msg = (String) request.getAttribute("msg");
				System.out.print(msg);
				if (msg.equals("1")) {
		%>
		<p style="color: green; font-weight: bold">Xóa thành công</p>
		<%
			} else {
		%>
		<p style="color: red; font-weight: bold">Xóa thất bại</p>
		<%
			}
			}
		%>
		<a href="<%=request.getContextPath()%>/admin/addNews?type=load" class="button">
			<span>Thêm tin <img
				src="<%=request.getContextPath()%>/templates/admin/images/plus-small.gif"
				alt="Thêm tin"></span>
		</a>
	</div>
	<div class="clear"></div>
</div>
<%
	ArrayList<News> alNews = (ArrayList<News>) request.getAttribute("alNews");
%>
<div class="grid_12">
	<!-- Example table -->
	<div class="module">
		<h2>
			<span>Danh sách tin</span>
		</h2>

		<div class="module-table-body">
			<form action="">
				<table id="myTable" class="tablesorter">
					<thead>
						<tr>
							<th style="width: 4%; text-align: center;">ID</th>
							<th style="width: 15%">Tên tin</th>
							<th style="width: 20%">Mô tả</th>
							<th style="width: 25%">Nội dung tin</th>
							<th>Danh mục tin</th>
							<th style="width: 13%; text-align: center;">Hình ảnh</th>
							<th style="width: 10%; text-align: center;">Chức năng</th>
						</tr>
					</thead>
					<tbody>
						<%
							ModelCategory mc = new ModelCategory();
							Category cat;
							for (News objNews : alNews) {
								//cat = mc.getItemByID(objNews.getIdCat());
								cat=mc.getListByItem(objNews.getIdCat());
						%>
						<tr>
							<td class="align-center"><%=objNews.getIdNews()%></td>
							<td><a
								href="<%=request.getContextPath()%>/admin/editNews?nid=<%=objNews.getIdNews()%>"><%=objNews.getName()%></a></td>
							<td><%=objNews.getPreview_text()%></td>
							<td><%=objNews.getDetail_text()%></td>
							<td><%=cat.getName()%></td>
							<td align="center"><img
								src="<%=request.getContextPath()%>/files/<%=objNews.getPicture()%>"
								class="hoa" /></td>
							<td align="center"><a
								href="<%=request.getContextPath()%>/admin/editNews?nid=<%=objNews.getIdNews()%>&type=load">Sửa
									<img
									src="<%=request.getContextPath()%>/templates/admin/images/pencil.gif"
									alt="edit" />
							</a> <a
								href="<%=request.getContextPath()%>/admin/delNews?nid=<%=objNews.getIdNews()%>"
								onclick="return confirm('Bạn có thật sự muốn xóa?')">Xóa <img
									src="<%=request.getContextPath()%>/templates/admin/images/bin.gif"
									width="16" height="16" alt="delete" /></a></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</form>
		</div>
		<!-- End .module-table-body -->
	</div>
	<!-- End .module -->
	<div class="pagination">
		<div class="numbers">
			<%
				int numberOfPage = (Integer) request.getAttribute("numberOfPage");
				int currentPage = (Integer) request.getAttribute("currentPage");
			%>
			<span>Trang:</span>
			<%
				for (int i = 1; i <= numberOfPage; i++) {
					if(i!=currentPage){
			%>
			<a href="<%=request.getContextPath()%>/admin/indexNews?page=<%=i%>"><%=i%></a> 
				<%if(i!=numberOfPage){ %>
				<span>|</span>
				<%} %>
			<%
				} else {
			%>
			<a href="<%=request.getContextPath()%>/admin/indexNews?page=<%=i%>" class="current"><%=i%></a> <span>|</span>
			<%}} %>
		</div>
		<div style="clear: both;"></div>
	</div>

</div>
<!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp"%>
