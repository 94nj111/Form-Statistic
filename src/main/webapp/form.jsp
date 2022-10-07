<%@ page import="logic.Result" %>
<%@ page import="logic.Gender" %>
<%@ page import="logic.Course" %>
<%@ page import="logic.Drink" %>
<%@ page import="logic.Course" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Form</title>
</head>
<header>
    <p><a href="index.jsp">Login</a></p>
    <p><a href="stat">Statistic</a></p>
</header>
<%
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    String gender = request.getParameter("gender");
    String course = request.getParameter("course");
    String drink = request.getParameter("drink");
    Result result;
    String login = (String)session.getAttribute("user_login");
    if(login != null && !login.equals("")) result = new Result(login);
    else result = new Result();
    if(name != null && !"".equals(name)) result.setName(name);
    if(surname != null && !"".equals(surname))result.setSurmane(surname);
    if(gender != null && !"".equals(gender))result.setGender(Gender.valueOf(gender));
    if(course != null && !"".equals(course))result.setClas(Course.valueOf(course));
    if(drink != null && !"".equals(drink))result.setDrink(Drink.valueOf(drink));
%>
<body>
<h3>Please complete form</h3>
<form target="#" method="get">
    <div>
        <input type="text" name="name"> name
    </div>
    <div>
        <input type="text" name="surname"> surname
    </div>
    <div>
        <input type="tel" name="age"> age
    </div>
    <div>
        gender<br>
        <input type="radio" name="gender" value="male"> male<br>
        <input type="radio" name="gender" value="female"> female<br>
    </div>
    <div>
        course<br>
        <input type="radio" name="course" value="java"> java<br>
        <input type="radio" name="course" value="fullstack"> full-stack<br>
    </div>
    <div>
        drink<br>
        <input type="radio" name="drink" value="beer"> beer<br>
        <input type="radio" name="drink" value="vine"> vine<br>
    </div>
    <button type="submit">Submit</button>
</form>
</body>
</html>