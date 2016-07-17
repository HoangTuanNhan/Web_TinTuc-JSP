<%-- <%@page import="bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">
	<%
	  	if("0".equals(request.getParameter("msg"))){
	  		out.print("<p style='color:green; font-weight:bold'>thực hiện không thành công !</p>");
	  	}
	 	 if("1".equals(request.getParameter("msg"))){
	  		out.print("<p style='color:green; font-weight:bold'>thực hiện  thành công !</p>");
	  	}
	  
	  %> 
	<div class="module">
		 <h2><span>Thêm tin tức</span></h2>
			<%
				News alNews=(News)request.getAttribute("alNews");
			%>
		 <div class="module-body">
			<form id="frmLogin" action="<%=request.getContextPath() %>/admin/addNews?them=1" enctype="multipart/form-data" method="POST">
				<p>
					<label>Tên tin</label>
					<input type="text" name="tentin" value="" class="input-medium" required="required" />
				</p>
				<p>
					
					<label>Danh mục tin</label>
					<select name="danhmuc" class="input-short">
						<%
						ArrayList<Category> alCat=(ArrayList<Category>)request.getAttribute("alCat");
							if(alCat!=null){
								for(Category objCat: alCat){
						%>
						<option value="<%=objCat.getIdCat()%>"><%=objCat.getName() %></option>
						<%}} %>
					</select>
				</p>
				<p>
					<label>Hình ảnh</label>
					<input type="file"  name="hinhanh" value=""  required="required"/>
				</p>
				<p>
					<label>Mô tả</label>
					<textarea name="mota"   class="ckeditor" rows="7" cols="90" class="input-medium" required="required"></textarea>
				</p>
				<p>
					<label>Chi tiết</label>
					<textarea name="chitiet" class="ckeditor"  rows="7" cols="90" class="input-long"></textarea>
				</p>
				<fieldset>
					<input class="submit-green" name="them" type="submit" value="Thêm" /> 
					<input class="submit-gray" name="reset" type="reset" value="Nhập lại" />
				</fieldset>
			</form>
 			<script>
 			$(document).ready(function(){
 				$('#‎frmLogin').validate({
 				ignore: [],
 				rules: { 
	 				chitiet: {
	 					required: function(textarea) {
	 						CKEDITOR.instances.chitiet.updateElement();
	 					},
	 					minlength: 10
	 				}
 				},
 				messages:{
 	 				chitiet: {
 	 					required: "Please enter Text",
 	 					minlength: "Please enter 10 characters"
 	 				}
 				}
 			});
 		});
	 
		</script>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %>  --%>
<%@page import="bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/templates/admin/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/templates/admin/js/jquery.validate.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/templates/admin/js/ckeditor/ckeditor.js"></script>
<!-- Form elements -->
<div class="grid_12">

	<div class="module">
		<h2>
			<span>Thêm tin tức</span>
		</h2>

		<div class="module-body">
			<form action="<%=request.getContextPath()%>/admin/addNews" enctype="multipart/form-data" method="post" id="frm">
				<p>
					<label>Tên tin</label> <input type="text" name="name" value=""
						class="input-medium" />
				</p>
				<p>
					<label>Danh mục tin</label> <select name="id_cat"
						class="input-short">
						<%
							ArrayList<Category> alCat = (ArrayList<Category>) request.getAttribute("alCat");
							for (Category objCat : alCat) {
						%>
						<option value="<%=objCat.getIdCat()%>"><%=objCat.getName()%></option>
						<%
							}
						%>
					</select>
				</p>
				
				<div id="divPreviewImg">
					<img id="previewImg" src="#" alt="img" height="108" width="180"  hidden="hidden"/>
				</div>
				<p>
					<label>Hình ảnh</label> <input type="file" name="picture" value="" id="imgInp" style="margin-bottom: 5px"/>
					<label id="unselectButton"></label>
				</p>
				<br/>
				<p>
					<label>Mô tả</label>
					<textarea name="preview_text" rows="7" cols="90" class="ckeditor"></textarea>
				</p>
				<p>
					<label>Chi tiết</label>
					<textarea name="detail_text" rows="7" cols="90" class="ckeditor"></textarea>
				</p>
				<fieldset>
					<input class="submit-green" name="submit" type="submit"
						value="Thêm" /> <input class="submit-gray" name="reset"
						type="reset" value="Nhập lại" />
				</fieldset>
			</form>
		</div>
		<!-- End .module-body -->
	</div>
	<!-- End .module -->
	<div style="clear: both;"></div>
</div>
<!-- End .grid_12 -->
<script>
	$(document).ready(function() {
		$("#frm").validate({
			ignore: [],
			debug: false, 
			rules: {
				name : {
					required : true,
				},
				preview_text : {
					required : function(){
						CKEDITOR.instances.preview_text.updateElement();
					},
					minlength : 10,
				},
				detail_text : {
					required : function() {
						CKEDITOR.instances.detail_text.updateElement();
					},
					minlength : 50,
				}
			},
			messages : {
				name : {
					required : "<span style=\"color: red; font-weight: bold;\">Vui lòng nhập tên tin</span>",
				},
				preview_text : {
					required : "<span style=\"color: red; font-weight: bold;\">Vui lòng nhập mô tả</span>",
					minlength : "<span style=\"color: red; font-weight: bold;\">Độ dài ít nhất 10</span>"
				},
				detail_text : {
					required : "<span style=\"color: red; font-weight: bold;\">Vui lòng nhập chi tiết</span>",
					minlength : "<span style=\"color: red; font-weight: bold;\">Độ dài ít nhất 50</span>"
				}
			}
		});
	});
	
	function readURL(input) {

		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#previewImg').attr('src', e.target.result);
			}

			reader.readAsDataURL(input.files[0]);
		}
	}
	function unSelect(){
		document.getElementById("divPreviewImg").innerHTML = "";
		document.getElementById("unselectButton").innerHTML = " ";
		document.getElementById("imgInp").value = "";
	}
	$("#imgInp").change(function() {
		document.getElementById("divPreviewImg").innerHTML = "<img id=\"previewImg\" src=\"#\" alt=\"img\" height=\"108\" width=\"180\"/>";
		document.getElementById("unselectButton").innerHTML = "<a href=\"#\" class=\"button\" onclick=\"unSelect()\"> <span>Bỏ chọn <img src=\"<%=request.getContextPath()%>/templates/admin/images/plus-small.gif\" alt=\"Bỏ chọn\"></span> </a>";
		readURL(this);
	});
	
</script>
<%@include file="/templates/admin/inc/footer.jsp"%>
