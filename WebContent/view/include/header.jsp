<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- NavBar Component Code -->
    <nav class="navbar navbar-expand-sm navbar-dark bg-primary mb-4">
        <div class="container">
            <a class="navbar-brand" href="dashboard.jsp">
                Personal Kanban Tool
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mobile-nav">
                <span class="navbar-toggler-icon" />
            </button>

            <div class="collapse navbar-collapse" id="mobile-nav">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="dashboard.jsp">
                            Dashboard
                        </a>
                    </li>
                </ul>

                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link " href="register.html">
                            Sign Up
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.html">
                            Login
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</body>
</html>