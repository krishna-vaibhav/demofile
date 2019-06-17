<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="view/includeResources.jsp" %>
</head>
<body>
 <!-- CREATE / UPDATE PROJECT TASK FORM STARTS HERE -->
<%@ include file="view/include/header.jsp" %>

    <div class="add-PBI">
        <div class="container">
            <div class="row">
                <div class="col-md-8 m-auto">
                    <a href="projectBoard.jsp" class="btn btn-light">
                        Back to Project Board
                    </a>
                    <h4 class="display-4 text-center">Add /Update Project Task</h4>
                    <p class="lead text-center">Project Name + Project Code</p>
                    <form action="AddProjectTaskController?project_identifier=${param.project_identifier }" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control form-control-lg" name="summary" placeholder="Project Task summary" />
                        </div>
                        <div class="form-group">
                            <textarea class="form-control form-control-lg" placeholder="Acceptance Criteria" name="acceptance_criteria"></textarea>
                        </div>
                        <h6>Due Date</h6>
                        <div class="form-group">
                            <input type="date" class="form-control form-control-lg" name="due_date" />
                        </div>
                        <div class="form-group">
                            <select class="form-control form-control-lg" name="priority">
                                <option value="Select Priority">Select Priority</option>
                                <option value="High">High</option>
                                <option value="Medium">Medium</option>
                                <option value="Low">Low</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <select class="form-control form-control-lg" name="status">
                                <option value="">Select Status</option>
                                <option value="TO_DO">TO DO</option>
                                <option value="IN_PROGRESS">IN PROGRESS</option>
                                <option value="DONE">DONE</option>
                            </select>
                        </div>

                        <input type="submit" class="btn btn-primary btn-block mt-4" />
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- CREATE / UPDATE PROJECT TASK FORM ENDS HERE -->
</body>
</html>