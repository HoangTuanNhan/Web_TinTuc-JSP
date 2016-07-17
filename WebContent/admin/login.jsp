<%@page import="java.util.ArrayList"%>
<%@page import="bean.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp"%>
<!-- Form elements -->
<%
	if ("0".equals(request.getParameter("msg"))) {
		out.print("<p style='color:green; font-weight:bold'>thực hiện không thành công !</p>");
	}
	/* if ("1".equals(request.getParameter("msg"))) {
		out.print("<p style='color:green; font-weight:bold'>thực hiện  thành công !</p>");
	} */
%>
<div class="grid_12">

	<div class="module">
		<h2>
			<span>Login</span>
		</h2>

		<%
			if ("0".equals(request.getParameter("msg"))) {
				out.print("<p style ='color:red;font-weight:bold'>Bạn sai user hoặc password</p>");
			}
		%>
		<div class="module-body">
			<form action="" method="post">
				<p>
					<label>username</label> <input type="text" name="username" value=""
						class="input-medium" />
				</p>
				<p>
					<label>password</label> <input type="password" name="password"
						value="" class="input-medium" />
				</p>
				<fieldset>
					<input class="submit-green" name="login" type="submit"
						value="Đăng Nhập" />

				</fieldset>
			</form>
		</div>
		<!-- End .module-body -->

	</div>
	<!-- End .module -->
	<div style="clear: both;"></div>
</div>
<!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp"%>
