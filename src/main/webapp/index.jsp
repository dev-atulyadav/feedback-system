<%@page import="com.test.feedback_system.dao.TeacherDao"%>
<%@page import="com.test.feedback_system.dto.Teacher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Login Form</title>
    <link rel="shortcut icon" href="./assets/niet.svg" type="image/x-icon">
    <link rel="stylesheet" href="index.css">
   </head>
  <body>
  <%
	List<Teacher> teachers = new TeacherDao().getAllTeachers();
  %>
     <header>
      <img src="./assets/niet.svg" alt="" />
      <nav>
        <ul>
          <li>
            <button>admin</button>
          </li>
          <li>|</li>
          <li>
            <button>About</button>
          </li>
        </ul>
      </nav>
    </header>
    <section>
      <article>
        <main>
          <h2>Welcome To feedback portal...</h2>
          <p>Your feedback help us to give your future a better directions</p>
          <p>Feel free to give us feedback.</p>
          <button>Share Now</button>
        </main>
      </article>
    </section>
    <section class="forms-container">
      <article>
        <form action="sendFeedback" method="post">
          <button class="close-btn">X</button>
          <div>
            <label for="id">ERP ID</label>
            <input placeholder="Enter EPR ID" type="text" name="id" id="id" required />
          </div>
          <div>
            <label for="teachers">Teacher</label>
            <select name="teacher" id="teachers">
              <option>Select Teacher</option>
              <%for(Teacher teacher:teachers){ %>
              <option value="<%=teacher.getName()%>"><%=teacher.getName() %></option>
              <%} %>
              
          </select>
          </div>
          <div>
            <textarea name="feedback" id="" cols="" rows="2" placeholder="Write your feedback here..."></textarea>
          </div>
          <input type="submit" value="Send">
          <span>Login as <a>admin</a>?</span>
        </form>
      </article>
    </section>
    <section class="forms-container">
      <article>
        <form action="adminLogin" method="get">
          <button class="close-btn">X</button>
          <div>
            <label for="email">Email</label>
            <input placeholder="Enter email" type="email" name="email" id="email" required />
          </div>
          <div>
            <label for="password">Password</label>
            <input placeholder="Enter password" type="password" name="password" id="password" required />
          </div>
          <input type="submit" value="Login">
          <span>Send feedback as <a>student</a>?</span>
        </form>
      </article>
    </section>
  <script type="text/javascript" src="index.js"> </script>
  </body>
</html>