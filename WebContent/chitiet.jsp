<%@page import="bean.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp" %>
<div class="leftpanel">
	<%@include file="/templates/public/inc/left_bar.jsp" %>  
</div>
	<%
	System.out.println("444");
		News objNews=(News) request.getAttribute("objNews");
		
	
	%>
<div class="rightpanel">
	<div class="rightbody">
		<h1 class="title"><%=objNews.getName() %></h1>
		<div class="items-new">
			<div class="new-detail">
				<p><%=objNews.getDetail_text() %></p>
				
			</div>
		
		</div>
		
		<h2 class="title" style="margin-top:30px;color:#BBB">Tin tức liên quan</h2>
		<div class="items-new">
						<%
				ArrayList<News> alNews=(ArrayList<News>)request.getAttribute("alNews");
				if(alNews!=null){
					for(News itemNews: alNews){
				
			%>
			<ul>
			
				<li>
					<h2>
						<a href="<%=request.getContextPath() %>/tin-tuc/<%=LibraryString.createSlug(objNews.getName()) %>-<%=objNews.getIdNews() %>.html" title=""><%=itemNews.getDetail_text()%></a>
					</h2>
					<div class="item">
						<a href="<%=request.getContextPath() %>/tin-tuc/<%=LibraryString.createSlug(objNews.getName()) %>-<%=objNews.getIdNews() %>.html" title=""><img src="<%=request.getContextPath() %>/files/<%=itemNews.getPicture() %>" alt="" /></a>
						<p><%=objNews.getDetail_text() %></p>
						<div class="clr"></div>
					</div>
				</li>
				
				
			</ul>
			<%}} %>
			
		</div>
	</div>
</div>
<div class="clr"></div>
<%@include file="/templates/public/inc/footer.jsp" %>  