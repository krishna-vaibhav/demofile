<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="view/includeResources.jsp" %>
<title>Insert title here</title>
</head>

<body>
<%@ include file="view/include/header.jsp" %>
    <!-- Dashboard Component (Project Item included) -->
	<jsp:useBean id="id" class="com.yash.ppmtoolweb.serviceimpl.ProjectServiceImpl" scope="session"></jsp:useBean>
	<c:set var="prjservice" value="${id.listProject()}" ></c:set>
	<div class="projects">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="display-4 text-center">Projects</h1>
                    <br />
                    <a href="projectForm.jsp" class="btn btn-lg btn-info">
                        Create a Project
                    </a>
                    <br />
                    <hr />
					
                    <!-- Project Item Component -->
                    <div class="container">
                    	<c:forEach  var="prj"  items="${prjservice}">
                        <div class="card card-body bg-light mb-3">
                            <div class="row">
                                <div class="col-2">
                                    <span class="mx-auto">
                                    </span>
                                </div>
                                <div class="col-lg-6 col-md-4 col-8">
                                    <h3>${prj.project_name}</h3>
                                    <p>${prj.description}</p>
                                </div>
                                <div class="col-md-4 d-none d-lg-block">
                                    <ul class="list-group">
                                        <a href="projectBoard.jsp?project_identifier=${prj.project_identifier}">
                                            <li class="list-group-item board">
                                                <i class="fa fa-flag-checkered pr-1">Project Board </i>
                                            </li>
                                        </a>
                                        <a href="GetInfoOfProjectController?project_identifier=${prj.project_identifier}">
                                            <li class="list-group-item update">
                                                <i class="fa fa-edit pr-1">Update Project Info</i>
                                            </li>
                                        </a>
                                        <a href="DeleteProjectController?project_identifier=${prj.project_identifier}">
                                            <li class="list-group-item delete">
                                                <i class="fa fa-minus-circle pr-1">Delete Project</i>
                                            </li>
                                        </a>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                    <!-- End of Project Item Component -->

                </div>
            </div>
        </div>
    </div>

    <!-- End of Dashboard Component -->
</body>
</html>