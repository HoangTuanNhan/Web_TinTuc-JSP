<%@page import="library.LibraryString"%>
<%@page import="bean.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp" %>
				<div class="leftpanel">
					<%@include file="/templates/public/inc/left_bar.jsp" %>  
				</div>
				<div class="rightpanel">
					<div class="rightbody">
					<%
						Category cat=(Category)request.getAttribute("cat");
						ArrayList<News> alNews=(ArrayList<News>)request.getAttribute("alNews");
						String alName=(String)request.getAttribute("alName");
						
					%>
						<h1 class="title">Tin tức >><%= alName%></h1>
						<div class="items-new">
						<%
						if(alNews!=null){
							for(News objNews:alNews){
						%>
							<ul>
								<li>
									<h2>
										<a href="<%=request.getContextPath() %>/tin-tuc/<%=LibraryString.createSlug(objNews.getName()) %>-<%=objNews.getIdNews() %>.html" title=""><%=objNews.getPreview_text() %></a>
									</h2>
									<div class="item">
										<a href="<%=request.getContextPath() %>/tin-tuc/<%=LibraryString.createSlug(objNews.getName()) %>-<%=objNews.getIdNews() %>.html" title=""><img src="<%=request.getContextPath() %>/files/<%=objNews.getPicture() %>" alt="" /></a>
										<p><%=objNews.getDetail_text() %></p>
										<div class="clr"></div>
									</div>
								</li>
								
								
							</ul>
							<%}} %>
							<div class="paginator">
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
					<a href="<%=request.getContextPath()%>/danh-muc/<%=LibraryString.createSlug(cat.getName()) %>-<%=i %>-<%=cat.getIdCat()%>.html"<%=active %>><%=i %></a> 
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
				</div>
				<div class="clr"></div>
<%@include file="/templates/public/inc/footer.jsp" %>  	