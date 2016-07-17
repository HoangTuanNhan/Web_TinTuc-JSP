<%@page import="bean.News"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp" %>
<div class="leftpanel">
	<%@include file="/templates/public/inc/left_bar.jsp" %>  
</div>
<div class="rightpanel">
	<div class="rightbody">
		<h1 class="title">Tin tức</h1>
		<div class="items-new">
				<%
				ArrayList<News> alTinTuc=(ArrayList<News>)request.getAttribute("alTinTuc");
				if(alTinTuc!=null){
					for(News objNews: alTinTuc){
				
			%>
			<ul>
			
				<li>
					<h2>
						<a href="<%=request.getContextPath() %>/tin-tuc/<%=LibraryString.createSlug(objNews.getName()) %>-<%=objNews.getIdNews() %>.html" title=""><%=objNews.getDetail_text()%></a>
					</h2>
					<div class="item">
						<a href="<%=request.getContextPath() %>/tin-tuc/<%=LibraryString.createSlug(objNews.getName()) %>-<%=objNews.getIdNews() %>.html" title=""><img src="<%=request.getContextPath() %>/files/<%=objNews.getPicture() %>" alt="" /></a>
						<p><%=objNews.getDetail_text() %></p>
						<div class="clr"></div>
					</div>
				</li>
				
				
			</ul>
			<%}} %>
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
				<a href="<%=request.getContextPath()%>/news?page=<%=i%>"<%=active %>><%=i %></a> 
				<%
					if(i!=sotrang){
				%>
				<span>|</span> 
				<%} %>
				<%} %>
				
			</div> 
			<div style="clear: both;"></div> 
		 </div>
	
		</div>
	</div>
</div>
<div class="clr"></div>
<%@include file="/templates/public/inc/footer.jsp" %>  		
			
