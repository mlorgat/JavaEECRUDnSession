<%
		if (session != null) {
			if (session.getAttribute("name") != null) {
				pageContext.forward("/UserController?action=listUser");
			} else {
				response.sendRedirect("login.jsp");
			}
		}
	%>