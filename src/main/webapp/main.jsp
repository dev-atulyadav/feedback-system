<%@page import="com.test.feedback_system.dao.FeedbackDao"%>
<%@page import="com.test.feedback_system.dto.Feedback"%>
<%@page import="com.test.feedback_system.dao.TeacherDao"%>
<%@page import="com.test.feedback_system.dto.Teacher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="shortcut icon" href="./assets/niet.svg" type="image/x-icon">
<title>Home</title>
<link rel="stylesheet" href="main.css">
</head>
<body>
	<%
	List<Feedback> feedbacks = new FeedbackDao().getAllFeedbacks();
	%>
	<header>
		<img src="./assets/niet.svg" alt="" />
		<nav>
			<ul>
				<li><a href="adminLogout">
						<button>Logout</button>
				</a></li>
				<li>|</li>
				<li>
					<button>About</button>
				</li>
			</ul>
		</nav>
	</header>
	<section>
		<article>
			<h2>Here's the feedbacks provided by the students:-</h2>
			<table>
				<tr>
					<th>Teacher Name</th>
					<th>Feedback</th>
					<th>Student ID</th>
				</tr>
				<%
				for (Feedback feedback : feedbacks) {
				%>
				<tr>
					<td><%=feedback.getTeacher().getName()%></td>
					<td><%=feedback.getFeedback()%></td>
					<td><%=feedback.getStudent().getId()%></td>
				</tr>
				<%
				}
				%>
			</table>
		</article>
	</section>
</body>
</html>
