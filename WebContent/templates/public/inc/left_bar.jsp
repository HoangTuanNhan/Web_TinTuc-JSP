<%@page import="library.LibraryString"%>
<%@page import="model.ModelCategory"%>
<%@page import="bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>Danh mục tin</h2>
	<%
		ModelCategory mCat=new ModelCategory();
		ArrayList<Category> alCat=(ArrayList<Category>)mCat.getListCat();
			if(alCat!=null){
				for(Category objCat: alCat){
	
	%>
<ul>
	<li><a href="<%=request.getContextPath()%>/danh-muc/-<%=LibraryString.createSlug(objCat.getName())%>-<%=objCat.getIdCat()%>.html"><%=objCat.getName() %></a></li>
</ul>
<%}} %>
